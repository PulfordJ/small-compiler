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

expr : left=expr op=('*'|'/') right=expr #MulDivAddSub
     | left=expr op=('+'|'-') right=expr #MulDivAddSub
     | FLOAT                               #float
     | INT                                 #int
     | '(' expr ')'                      #parens
     ;



MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
FLOATEXPONENT : 'e' ;
FLOAT : INT FLOATEXPONENT INT? ;
INT : [0-9]+ ;
WS : [ \t\r\n]+ -> skip ;