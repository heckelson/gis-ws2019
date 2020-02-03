%%% Fakten %%%
female(sabine).
female(sophie).
female(mia).
female(maria).
female(alexandra).
female(petra).

% my females
female(anja).
female(bettina).
female(christine).
female(dora).
female(emma).
female(franzi).
female(gisela).
female(helga).
female(isabella).
female(julia).


male(thomas).
male(oliver).
male(daniel).
male(rainer).
male(john).
male(max).

% my males
male(axel).
male(bernd).
male(chris).
male(dieter).
male(erich).
male(franz).
male(gustav).
male(heinrich).
male(ingo).
male(johann).


child(max,rainer).
child(petra,rainer).
child(alexandra,john).

child(rainer,oliver).
child(mia,sophie).
child(john,sophie).
child(daniel,maria).

child(oliver,thomas).
child(oliver,sabine).
child(sophie,thomas).
child(sophie,sabine).
child(maria,thomas).
child(maria,sabine).

% my child relationships
child(chris,julia).
child(chris,ingo).
child(dieter,julia).
child(dieter,ingo).
child(christine,johann).
child(christine,isabella).
child(dora,johann).
child(dora,isabella).

child(johann,anja).
child(johann,axel).
child(julia,anja).
child(julia,axel).
child(ingo,bettina).
child(ingo,bernd).
child(isabella,bettina).
child(isabella,bernd).

child(anja,helga).
child(anja,heinrich).
child(axel,gisela).
child(axel,gustav).
child(bettina,franzi).
child(bettina,franz).
child(bernd,emma).
child(bernd,erich).


%%% Regeln %%%
parent(X,Y) :- child(Y,X).
mother(X,Y) :- parent(X,Y) , female(X).
father(X,Y) :- parent(X,Y) , male(X).

% sorb = sister or brother
sorb(X,Y) :- mother(M,X) , mother(M,Y) , father(F,X) , father(F,Y), X \= Y.
sister(X,Y) :- sorb(X,Y) , female(X).
brother(X,Y) :- sorb(X,Y) , male(X).

aunt(X,Y) :- sister(X,Z) , child(Y,Z).
uncle(X,Y) :- brother(X,Z), child(Y,Z).

ancestor(X,Y) :- parent(X,Y).
ancestor(X,Z) :- parent(X,Y) , ancestor(Y,Z).


