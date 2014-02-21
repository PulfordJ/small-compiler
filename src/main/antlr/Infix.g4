//Name of grammar
grammar Infix;

//ANTLR4 needs this to process certain types of left recursive grammar.
/*
Note that this doesn't match my documentation, number signs are in the parse tree because ANTLR reports errors (although, sometimes, still managed to compile the code)
when space is removed and the next matching character could be either a sign token for an expr or a sign token for a terminal. Seems to be be traversing all parse tree options before
checking the terminals, likely because ANTLR4 rewrites left recursion...
*/
start : expr                             #printExpr
     ;

expr : left=expr op=(MUL|DIV) right=expr #MulDivAddSub
     | left=expr op=(ADD|SUB) right=expr #MulDivAddSub
     | FLOAT                               #float
     | ADD FLOAT                           #float
     | SUB FLOAT                           #subFloat
     | INT                 #optionallySignedInt
     | ADD INT                 #optionallySignedInt
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
Note the commented out terminal for OPTIONALLYSINGEDINT, if it was uncommented and factored out of
FLOAT ANTLR4 would fail to build the parse tree, likely because I'm handling ADD/SUB in the parse tree and ANTLR4 rewrites left recursion..
Explicitly stating the consumption of any spaces leads to "3 + 2" being interpreted as 3 = INT "+ 2" = OPTIONALLYSIGNEDINT; leading to an error...
*/

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
LEFTPAREN : '(' ;
RIGHTPAREN : ')' ;
FLOATEXPONENT : 'e' ;
FLOAT : INT FLOATEXPONENT (ADD|SUB)? INT ;
//OPTIONALLYSIGNEDINT : (ADD|SUB)? INT ;
INT : [0-9]+ ;
WS : [ \t\r\n]+ -> skip ;
