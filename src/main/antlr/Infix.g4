//Name of grammar
grammar Infix;

//ANTLR4 needs this to process certain types of left recursive grammar.
/*
Note that this doesn't match my documentation, number signs are in the parse tree because ANTLR reports errors (although, sometimes, still managed to compile the code)
When space is removed and the next matching character could be either a sign token for an expr or a sign token for a terminal. Seems to be be traversing all parse tree options before
*/
start : expr                             #printExpr
     ;

expr : left=expr op=(MUL|DIV) right=expr #MulDivAddSub
     | left=expr op=(ADD|SUB) right=expr #MulDivAddSub
     | FLOAT                               #float
     | ADD FLOAT                           #float
     | SUB FLOAT                           #subFloat
     | OPTIONALLYSIGNEDINT                 #optionallySignedInt
     | ADD OPTIONALLYSIGNEDINT                 #optionallySignedInt
     | SUB OPTIONALLYSIGNEDINT                 #subOptionallySignedInt
     | parenedexpr                         #nop
     | ADD parenedexpr           #parensWithAdd
     | SUB parenedexpr           #parensWithMinus
     ;

// Parenthised expression seperated out in this grammar for modularity.
parenedexpr : LEFTPAREN expr RIGHTPAREN           #parens
     ;


//The terminal values in my in-fix grammar
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
LEFTPAREN : '(' ;
RIGHTPAREN : ')' ;
FLOATEXPONENT : 'e' ;
FLOAT : INT FLOATEXPONENT OPTIONALLYSIGNEDINT? ;
OPTIONALLYSIGNEDINT : INT ;
INT : [0-9]+ ;
WS : [ \t\r\n]+ -> skip ;
