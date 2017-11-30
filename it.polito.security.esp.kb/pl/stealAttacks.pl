% This file contains the clauses regarding the steal attacks.

% The attacker can deploy a server to do something evil.
attackStep(setup(attackerServer(stealServer)), [], [isAvailable(attackerServer(stealServer))]).
	
% The attacker can get a victim's datum if he modifies a victim's function to send all the used variables to a server via
% some code injection.
attackStep(injectCode(Code, sendTo(attackerServer(stealServer), Datum)),
		[isAvailable(attackerServer(stealServer)), contentRetrieved(Code)],
		[received(Datum, attackerServer(stealServer)), dynamicallyChanged(Code)]) :-
	code(Code),
	arg(1, Code, victim),
	datum(Datum),
	arg(1, Datum, victim),
	accesses(Code, Datum),
	functor(Code,_,_),
	functor(Datum,_,_).
	
% If some code receives a datum from a server as plaintext, the attacker can find its value sniffing the traffic while executing the code. 
attackStep(sniffTraffic(Code, Datum),
		[codeExecuted(Code)],
		[sniffed(Datum)]) :-
	code(Code),
	datum(Datum),
	arg(1, Code, attacker),
	arg(1, Datum, attacker),
	receivesFromServerAsPlainText(Code,Datum),
	functor(Code,_,_),
	functor(Datum,_,_).
	
% The attacker can deploy a fake server that resembles the original server.
attackStep(setup(attackerServer(fakeServer)), [], [isAvailable(attackerServer(fakeServer))]).

% If some code receives a datum from a server, the attacker can send a fake (but valid) datum to the application in order to locate the code.
attackStep(sendFakeDataToExecuteCode(Code, sendFrom(attackerServer(fakeServer)), Datum),
		[isAvailable(attackerServer(fakeServer))],
		[dynamicallyLocated(Code)]) :-
	code(Code),
	datum(Datum),
	arg(1, Code, attacker),
	arg(1, Datum, attacker),
	(receivesFromServerAsPlainText(Code,Datum); receivesFromServerAsCypherText(Code,Datum)),
	functor(Code,_,_),
	functor(Datum,_,_).
