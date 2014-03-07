//Name of grammar
grammar Infix;

//ANTLR4 needs this to process certain types of left recursive grammar.
start : sequence                             #boilerplate
     ;

sequence : (expr) sequence? #printExpr
         ;

bool : expr EQUALS expr
        | expr GREATERTHAN expr
        | expr LESSTHAN expr
        | expr NOTEQUALS expr
        ;

expr : left=expr op=(MUL|DIV) right=expr #MulDivAddSub
     | left=expr op=(ADD|SUB) right=expr #MulDivAddSub
     | VARIABLE ASSIGN expr              #assignVariable
     | ADD? FLOAT                           #float
     | SUB FLOAT                           #subFloat
     | ADD? INT                 #optionallySignedInt
     | SUB INT                 #subOptionallySignedInt
     | parenedexpr                         #nop
     | ADD parenedexpr           #parensWithAdd
     | SUB parenedexpr           #parensWithMinus
     ;

// Parenthised expression seperated out in this grammar for modularity.
parenedexpr : LEFTPAREN expr RIGHTPAREN           #parens
     ;


//The terminal values in my in-fix grammar
/*
Note the commented out terminal for OPTIONALLYSINGEDINT, if it was uncommented and factored out of the parser spacing tests would not pass...
and explicitly stating the consumption of any spaces leads to "3 + 2" being interpreted as 3 = INT "+ 2" = OPTIONALLYSIGNEDINT; leading to an error...
*/
ASSIGN : ':=' ;
EQUALS : '=' ;
GREATERTHAN : '>' ;
LESSTHAN : '<' ;
NOTEQUALS : '!=' ;
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
LEFTPAREN : '(' ;
RIGHTPAREN : ')' ;
FLOATEXPONENT : 'e' ;
FLOAT : INT FLOATEXPONENT (ADD|SUB)? INT ;
VARIABLE : [A-z]+ ;
//OPTIONALLYSIGNEDINT : (ADD|SUB)? INT ;
INT : [0-9]+ ;
WS : [ \t\r\n]+ -> skip ;
