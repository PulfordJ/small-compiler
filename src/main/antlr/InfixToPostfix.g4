/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar InfixToPostfix;

//expr : expr '+' term | expr '-' term | term ;
//term : term '*' factor| term '/' factor | factor ;
//factor : signedno | '('expr')' | expr ;
//signedno : digits ;
//digits : digit+ ;

//expr : factor | factor '+' expr ;
//factor : digit+;
//digit : '0'|'9' ;
//WS : [ \t\r\n]+ -> skip ;

start : expr                             #printExpr
     ;

expr : left=expr op=(MUL|DIV) right=expr #MulDivAddSub
     | left=expr op=(ADD|SUB) right=expr #MulDivAddSub
     | FLOAT                               #float
     | OPTIONALLYSIGNEDINT                 #optionallySignedInt
     | parenedexpr                         #nop
     | ADD parenedexpr           #parensWithAdd
     | SUB parenedexpr           #parensWithMinus
     ;
parenedexpr : LEFTPAREN expr RIGHTPAREN           #parens
            | LEFTPAREN expr RIGHTPAREN RIGHTPAREN     {notifyErrorListeners("Too many parentheses");} #parensnop
            | LEFTPAREN expr                           {notifyErrorListeners("Missing closing ')'");}  #parensnop
            ;



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
