package it.polito.security.esp.ui;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.AttackStep;

/**
 * A dot image writer.
 * @param T
 *            The type of the nodes.
 * @author Daniele Canavese
 **/
public class DotWriter<T>
{
	/** The edges. **/
	private Map<Entry<T, T>, String> edges;
	/** The nodes of the graph. **/
	private Collection<T> nodes;
	/** The ESP. **/
	private ESP esp;

	/**
	 * Creates the dot writer.
	 * @param esp
	 *            The ESP.
	 * @param nodes
	 *            The nodes of the graph.
	 * @param edges
	 *            The edges and their labels.
	 **/
	public DotWriter(ESP esp, Collection<T> nodes, Map<Entry<T, T>, String> edges)
	{
		this.esp = esp;
		this.nodes = nodes;
		this.edges = edges;
	}

	/**
	 * Retrieves the graph image for a graph.
	 * @return The image of the graph or an empty image if something goes wrong.
	 **/
	public Image toImage()
	{
		try
		{
			Process process = Runtime.getRuntime().exec(esp.getModel().getPreferences().getCommandDot() + " -Tpng ");
			process.getOutputStream().write(toDot().getBytes());
			process.getOutputStream().close();
			Image image = new Image(Display.getDefault(), process.getInputStream());
			process.destroy();

			return image;
		}
		catch (IOException e)
		{
			return new Image(Display.getDefault(), 0, 0);
		}
	}

	/**
	 * Returns the dot code of the graph.
	 * @return The dot file content.
	 **/
	private String toDot()
	{
		StringBuilder text = new StringBuilder();

		text.append("digraph\n");
		text.append("{\n");
		text.append("\trankdir = TD;\n");
		text.append("\tstart = 0;\n");
		text.append("\tgraph [bgcolor = transparent, ranksep = 0.2];\n");
		text.append(
				"\tnode [shape = box, style = \"filled, rounded\", color = \"#393939\", fillcolor = \"#F9FED6:#F7DCB4\", fontsize = 8, fontname = helvetica, gradientangle = 315, width = 0.2, height = 0.2, penwidth = 0.75, fontcolor = \"#000000\"];\n");
		text.append("\tedge [fontsize = 8, fontname = helvetica, arrowsize = 0.5, color = \"#393939\"];\n");
		text.append("\n");

		addNodes(text);
		addEdges(text);

		text.append("}\n");

		return text.toString();
	}

	/**
	 * Retrieves the name of an object.
	 * @param object
	 *            The object.
	 * @return The object name.
	 */
	private String getName(T object)
	{
		String name = "n" + object.hashCode();
		name = name.replace("-", "_");

		return name;
	}

	/**
	 * Adds a node to the graph.
	 * @param text
	 *            The string builder containing the dot code.
	 * @param node
	 *            The node.
	 **/
	private void addNodes(StringBuilder text)
	{
		for (T i : nodes)
		{
			String shape = "rounded";
			if (i instanceof AttackStep)
				shape = "#fed7d7:#f7b5b5";
			else if (i instanceof AppliedProtectionInstantiation)
				shape = "#d7ebfe:#b5d6f7";
			text.append("\t" + getName(i) + " [label = \"" + i.toString() + "\", fillcolor = \"" + shape + "\"];\n");
		}
	}

	/**
	 * Adds the out edges of a node to the graph.
	 * @param text
	 *            The string builder containing the dot code.
	 * @param node
	 *            The node.
	 **/
	private void addEdges(StringBuilder text)
	{
		for (Entry<Entry<T, T>, String> i : edges.entrySet())
			if (i.getValue() == null || i.getValue().isEmpty())
				text.append("\t" + getName(i.getKey().getKey()) + " -> " + getName(i.getKey().getValue()) + ";\n");
			else
				text.append("\t" + getName(i.getKey().getKey()) + " -> " + getName(i.getKey().getValue()) + " [label = \"" + i.getValue()
						+ "\"];\n");
	}
}
