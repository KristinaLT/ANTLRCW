grammar ispr;

    program
   : block '.'
   ;
block
   : (vars*)? (procedure*)? statement
   ;
vars
   :  VAR type ident ('=' expression)? ';'
   ;
beginstmt
   : BEGIN statement (';' statement)* END
   ;
statement
   : (assignstmt | callstmt | writestmt | bangstmt | beginstmt | ifstmt | whilestmt | breakstmt | continuestmt)?
   ;
assignstmt
   : ident ':=' expression
   ;
procedure
   : PROCEDURE ident ';' block ';'
   ;
callstmt
   : CALL ident
   ;
writestmt
   : WRITE '(' expressionunion ')'
   ;
bangstmt
   : '!' expression
   ;
ifstmt
   : IF conditionunion THEN BEGIN statement (';' statement)* END
   ;
whilestmt
   : WHILE conditionunion DO BEGIN statement (';' statement)* END
   ;
breakstmt
   : BREAK
   ;
continuestmt
   : CONTINUE;
conditionunion
   : condition (opp = ('AND'|'OR')condition)*
   ;
condition
   : expression # ExpCond
   | expression op = ('=' | '!=' | '<' | '<=' | '>' | '>=') expression # Comparison
   ;
expression
   :
    factor #FactorExp
   |expression op = ('+' | '-') expression # SummExpr
   |expression op = ('*' | '/') expression # MultExpr
   ;
expressionunion
   : (expression(',' expression)*)?
   ;
factor
   : ident
   | number
   | literal
   | '(' factor')'
   | assignstmt
   ;

VAR
   : 'VAR'
   ;
BEGIN
   : 'BEGIN'
   ;
END
   : 'END'
   ;
IF
   : 'IF'
   ;
THEN
   : 'THEN'
   ;
WHILE
   : 'WHILE'
   ;
DO
   : 'DO'
   ;
PROCEDURE
   : 'PROCEDURE'
   ;
CALL
   : 'CALL'
   ;
BREAK
   : 'BREAK'
   ;
CONTINUE
   : 'CONTINUE'
   ;
WRITE
   : 'WRITE'
   ;

   literal
   	:	integerLiteral
   	|	floatLiteral
   	|	charLiteral
   	;
   	integerLiteral
        :   NUMBER
        ;
    floatLiteral
        :  NUMBER '.' NUMBER*
        ;
    charLiteral
        :'\'' STRING '\''
        ;
type
    : 'char'
    | 'int'
    | 'float'
    ;
ident
   : STRING
   ;
number
   : NUMBER
   ;
STRING
   : [a-zA-Z] [a-zA-Z]*
   ;
NUMBER
   : [0-9] +
   ;
BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;
LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;
WS
   : [ \t\r\n] -> skip
   ;
