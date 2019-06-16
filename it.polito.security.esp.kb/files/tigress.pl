#!/usr/bin/perl

use strict;
use warnings;
use JSON;
use File::Slurp;
use File::Basename;
use Cwd "abs_path";

my $text = read_file($ARGV[0]);
$text =~ s/\/\/.*//g;

my $json = decode_json($text);
my $frontend = $json->{"tools"}->{"frontend"};
my @sources = @{ $json->{"src2src"}->{"SLP01"}->{"source"} };
my @preprocessFlags = @{ $json->{"src2bin"}->{"PREPROCESS"}->{"options"} };
my @compilationFlags = @{ $json->{"src2bin"}->{"COMPILE"}->{"options"} };
my @cCompilationFlags = @{ $json->{"src2bin"}->{"COMPILE"}->{"options_c"} };
my @cppCompilationFlags = @{ $json->{"src2bin"}->{"COMPILE"}->{"options_cpp"} };
my @linkFlags = @{ $json->{"src2bin"}->{"LINK"}->{"options"} };
my $name = $json->{"src2bin"}->{"LINK"}->{"binary"};

my @files = ();

print "frontend 1\n";
print ($frontend . "\n");

my $sourcesLength = @sources;
print "sourceFiles " . $sourcesLength . " \n";
foreach my $i (@sources)
{
	foreach my $j (glob($i))
	{
		print(abs_path($j) . "\n");
	}
}

my $preprocessFlagsLength = @preprocessFlags;
print "preprocessFlags " . $preprocessFlagsLength . " \n";
foreach (@preprocessFlags)
{
	print "$_\n";
}

my $compilationFlagsLength = @compilationFlags;
my $cCompilationFlagsLength = @cCompilationFlags;
my $cppCompilationFlagsLength = @cppCompilationFlags;
my $compLength = $compilationFlagsLength + $cCompilationFlagsLength + $cppCompilationFlagsLength;
print "compilationFlags " . $compLength . " \n";
foreach (@compilationFlags)
{
	print "$_\n";
}
foreach (@cCompilationFlags)
{
	print "$_\n";
}
foreach (@cppCompilationFlags)
{
	print "$_\n";
}

my $linkFlagsLength = @linkFlags;
print "linkFlags " . $linkFlagsLength . " \n";
foreach (@linkFlags)
{
	print "$_\n";
}
