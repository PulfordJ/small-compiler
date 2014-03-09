//Name of grammar
grammar Infix;

//ANTLR4 needs this to process certain types of left recursive grammar.
start : func* sequence func*                             #boilerplate
     ;

sequence : (declaration SEMICOLON?)* statement*
         ;

statement : loop #statementnop
          | conditional #statementConditional
          | assignment SEMICOLON #statementAssign
          | expr SEMICOLON #statementExpr
            ;


assignment : ID ASSIGN expr              #assignVariable
           ;


bool : expr op=(EQUALS|GREATERTHAN|LESSTHAN|NOTEQUALS) expr #boolExpr
     | TRUE #boolTrue
     | FALSE #boolFalse
     | leftBool=bool op=(OR|AND) rightBool=bool #boolLogic
     | LEFTPAREN bool RIGHTPAREN #boolParened
     ;


declaration : valueType ID      #declareIntVariable
             ;
valueType : INTTYPE
         ;

conditional : IF LEFTPAREN bool RIGHTPAREN LEFTCURLY sequence RIGHTCURLY  #ifStatement
             | IF LEFTPAREN bool RIGHTPAREN LEFTCURLY trueSequence=sequence RIGHTCURLY ELSE LEFTCURLY falseSequence=sequence RIGHTCURLY  #ifElseStatement
             ;

func : DEF funcName=ID LEFTPAREN funcArgs? RIGHTPAREN LEFTCURLY sequence RIGHTCURLY #function
     ;

funcArgs : funcArgDeclaration+
         ;
funcArgDeclaration : valueType ID      #declareFuncArg
                   ;

funcCall : ID LEFTPAREN expr(COMMA expr)* RIGHTPAREN #functionCall
        ;


loop: WHILE LEFTPAREN bool RIGHTPAREN LEFTCURLY sequence RIGHTCURLY   #whileLoop
    ;

expr : left=expr op=(MUL|DIV) right=expr #MulDivAddSub
     | left=expr op=(ADD|SUB) right=expr #MulDivAddSub
     | ADD? ID                           #variable
     | SUB ID                           #subVariable
     | ADD? FLOAT                           #float
     | SUB FLOAT                           #subFloat
     | ADD? INT                 #optionallySignedInt
     | SUB INT                 #subOptionallySignedInt
     | parenedexpr                         #parensnop
     | ADD parenedexpr           #parensWithAdd
     | SUB parenedexpr           #parensWithMinus
     | funcCall                  #exprnop
     ;

// Parenthised expression seperated out in this grammar for modularity.
parenedexpr : LEFTPAREN expr RIGHTPAREN           #parens
     ;


//The terminal values in my in-fix grammar
/*
Note the commented out terminal for OPTIONALLYSINGEDINT, if it was uncommented and factored out of the parser spacing tests would not pass...
and explicitly stating the consumption of any spaces leads to "3 + 2" being interpreted as 3 = INT "+ 2" = OPTIONALLYSIGNEDINT; leading to an error...
*/
SEMICOLON : ';' ;
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
INTTYPE : 'int' ;
//OPTIONALLYSIGNEDINT : (ADD|SUB)? INT ;
INT : [0-9]+ ;
WS : [ \t\r\n]+ -> skip ;
LEFTCURLY : '{';
RIGHTCURLY : '}';
IF : 'if';
TRUE : 'true';
FALSE : 'false';
OR : 'or';
AND : 'and';
ELSE : 'else';
WHILE : 'while';
DEF : 'def';
COMMA: ',';
ID : [A-z]+ ;
