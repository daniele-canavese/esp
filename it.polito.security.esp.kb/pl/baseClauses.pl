% This file contains some generic but useful clauses.

% An asset can be a code or a datum, and can belong to the attacker copy or to the victim copy.
fact(asset(Asset)) :-
	(code(Asset); datum(Asset)).

% To breach the integrity of an asset we must change it.
fact(breached(Asset, integrity)) :-
	hasProperty(Asset, integrity),
	fact(asset(Asset)),
	fact(changed(Asset)).
	
% To breach the confidentiality of an asset we must know its content from the victim.
fact(breached(Asset, confidentiality)) :-
	hasProperty(Asset, confidentiality),
	fact(asset(Asset)),
	fact(located(Asset)).
	
% If a part was statically or dynamically located, well, it was located.
fact(located(Part)) :-
	fact(asset(Part)),
	(fact(staticallyLocated(Part)); fact(dynamicallyLocated(Part))).

% If a part was statically or dynamically changed, well, it was changed.
fact(changed(Part)) :-
	fact(asset(Part)),
	(fact(staticallyChanged(Part)); fact(dynamicallyChanged(Part))).