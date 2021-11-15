//create a statement
//create a block
//create a function
//create a class
//create a variable
//create a type
//create a method
//create a parameter
//create a return
//create a if
//create a while
//create a for
//create a switch
//create a case
//create a break
//create a continue
//create a try
//create a catch
//create a throw
//create a finally
//create a import

grammar HAPL;

parse
 : MAIN_TAG_START block MAIN_TAG_END EOF
 ;


block
 : ( statement | functionDecl )* ( Return expression ';' )?
 ;


functionDecl
: '<' Identifier  functionParam? '>' block '<' '/' Identifier '>'
;

functionParam
: idList?
;

idList
: Identifier ( ',' Identifier )*
;

statement
 : assignment
 | functionCall
// | ifStatement
// | forStatement
// | whileStatement
 ;

assignment
 : '<' Identifier indexes? '=' expression '/' '>'
 ;


functionCall
 : '<' Identifier  exprList? '/' '>' #identifierFunctionCall
 | '<' OUT  expression  '/' '>'      #printFunctionCall
 | '<' Assert  expression  '/' '>'    #assertFunctionCall
 | '<' Size  expression '/' '>'       #sizeFunctionCall
 | '<' INPUT  expression '/' '>'       #takeInputFunctionCall
 ;



expression
 : '-' expression                                       #unaryMinusExpression
 | '!' expression                                       #notExpression
 | <assoc=right> expression '^' expression              #powerExpression
 | expression op=( '*' | '/' | '%' ) expression         #multExpression
 | expression op=( '+' | '-' ) expression               #addExpression
 | expression op=( '>=' | '<=' | '>' | '<' ) expression #compExpression
 | expression op=( '==' | '!=' ) expression             #eqExpression
 | expression '&&' expression                           #andExpression
 | expression '||' expression                           #orExpression
 | expression '?' expression ':' expression             #ternaryExpression
 | expression In expression                             #inExpression
 | Number                                               #numberExpression
 | Bool                                                 #boolExpression
 | Null                                                 #nullExpression
 | functionCall indexes?                                #functionCallExpression
 | list indexes?                                        #listExpression
 | Identifier indexes?                                  #identifierExpression
 | String indexes?                                      #stringExpression
 | '(' expression ')' indexes?                          #expressionExpression
 ;



indexes
 : ( '[' expression ']' )+
 ;

list
: '[' exprList? ']'
;

exprList
: expression ( ',' expression )*
;



MAIN_TAG_START : '<' 'main' '>';
MAIN_TAG_END : '<' '/' 'main' '>';
OUT: 'out';
INPUT : 'inp';
Null   : 'null';
Return : 'return';
Assert: 'assert';
Size: 'size';
In : 'in';

Or       : '||';
And      : '&&';
Equals   : '==';
NEquals  : '!=';
GTEquals : '>=';
LTEquals : '<=';
Pow      : '^';
Excl     : '!';
GT       : '>';
LT       : '<';
Add      : '+';
Subtract : '-';
Multiply : '*';
Divide   : '/';
Modulus  : '%';
OBrace   : '{';
CBrace   : '}';
OBracket : '[';
CBracket : ']';
OParen   : '(';
CParen   : ')';
SColon   : ';';
Assign   : '=';
Comma    : ',';
QMark    : '?';
Colon    : ':';

Bool
 : 'true'
 | 'false'
 ;

Number
 : Int ( '.' Digit* )?
 ;

Identifier
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

String
 : ["] ( ~["\r\n\\] | '\\' ~[\r\n] )* ["]
 | ['] ( ~['\r\n\\] | '\\' ~[\r\n] )* [']
 ;
Comment
 : ( '//' ~[\r\n]* | '/*' .*? '*/' ) -> skip
 ;
Space
 : [ \t\r\n\u000C] -> skip
 ;
fragment Int
 : [1-9] Digit*
 | '0'
 ;

fragment Digit
 : [0-9]
 ;



