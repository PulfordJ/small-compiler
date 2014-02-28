//Name of grammar
grammar Infix;

//ANTLR4 needs this to process certain types of left recursive grammar.
start : expr                             #printExpr
     ;
sequence : (expr) sequence?
         ;

boolean : expr EQUALS expr
        | expr GREATERTHAN expr
        | expr LESSTHAN expr
        | expr NOTEQUALS expr
        ;

expr : left=expr op=(MUL|DIV) right=expr #MulDivAddSub
     | left=expr op=(ADD|SUB) right=expr #MulDivAddSub
     | FLOAT                               #float
     | OPTIONALLYSIGNEDINT                 #optionallySignedInt
     | parenedexpr                         #nop
     | ADD parenedexpr           #parensWithAdd
     | SUB parenedexpr           #parensWithMinus
     ;

// Parenthised expression seperated out in this grammar for modularity.
parenedexpr : LEFTPAREN expr RIGHTPAREN           #parens;


//The terminal values in my in-fix grammar
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
LEFTPAREN : '(' ;
RIGHTPAREN : ')' ;
FLOATEXPONENT : 'e' ;
FLOAT : OPTIONALLYSIGNEDINT FLOATEXPONENT OPTIONALLYSIGNEDINT? ;
OPTIONALLYSIGNEDINT : ('-'|'+')? INT ;
INT : [0-9]+ ;
WS : [ \t\r\n]+ -> skip ;
