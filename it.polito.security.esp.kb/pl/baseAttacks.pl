% This file contains the clauses regarding some base attacks.

% The attacker can execute his code, if the code has no limitations for its execution.
attackStep(executeCodeOutOfOrder(Code), [], [codeExecuted(Code)]) :-
	code(Code),
	arg(1,Code,attacker),
	functor(Code,_,_).

%attackStep(followExecutionFlow(CallerCode,Code), [codeExecuted(CallerCode)], [codeExecuted(Code)]) :-
%	code(Code),
%	code(CallerCode),
%	arg(1,Code,attacker),
%	arg(1,CallerCode,attacker),
%	( calls(CallerCode,Code,_) ; contains(CallerCode,Code) ),
%	functor(Code,_,_),
%	functor(CallerCode,_,_)	.

% The attacker can statically locate a hardcoded part in its code.
attackStep(staticallyLocate(Part), [], [staticallyLocated(Part)]) :-
	code(Part),
	arg(1,Part,attacker),
	functor(Part,_,_).
	
% The attacker can statically locate an hardcoded datum used by a code.
attackStep(staticallyLocate(Datum, Code), [staticallyLocated(Code)], [staticallyLocated(Datum)]) :-
	code(Code),
	datum(Datum),
	arg(1, Code, attacker),
	arg(1, Datum, attacker),
	(accesses(Code, Datum) ; contains(Code, Datum)),
	functor(Code,_,_),
	functor(Datum,_,_).
	
% The attacker can dynamically locate a part in its code, and therefore in the victim code.
attackStep(dynamicallyLocate(Code), [codeExecuted(Code)], [dynamicallyLocated(Code)]) :-
	code(Code),
	arg(1,Code,attacker),
	functor(Code,_,_).
	
% The attacker can dynamically locate a part in its code, and therefore in the victim code.
attackStep(dynamicallyLocate(ContainerCode, Code), [codeExecuted(ContainerCode)], [dynamicallyLocated(Code)]) :-
	code(Code),
	code(CallerCode),
	arg(1,Code,attacker),
	arg(1,CallerCode,attacker),
	contains(CallerCode,Code),
	functor(Code,_,_),
	functor(CallerCode,_,_).

% The attacker can dynamically locate a datum used by a code.
attackStep(dynamicallyLocate(Datum, Code), [dynamicallyLocated(Code)], [dynamicallyLocated(Datum)]) :-
	code(Code),
	datum(Datum),
	arg(1, Code, attacker),
	arg(1, Datum, attacker),
	(accesses(Code, Datum) ; contains(Code,Datum)),
	functor(Code,_,_),
	functor(Datum,_,_).
	
% The attacker can statically change an hardcoded part of his copy of the application (code is hardcoded by definition).
attackStep(staticallyChange(Part), [staticallyLocated(Part)], [staticallyChanged(Part)]) :-
	fact(asset(Part)),
	functor(Part,_,_).

% The attacker can dinamically change a part of his copy of the application.
attackStep(dynamicallyChange(Part), [dynamicallyLocated(Part)], [dynamicallyChanged(Part)]) :-
	fact(asset(Part)),
	functor(Part,_,_).