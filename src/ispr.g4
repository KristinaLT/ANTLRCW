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

type
    : 'char'
    | 'int'
    | 'float'
    ;
procedure
   : PROCEDURE ident ';' block ';'
   ;

statement
   : (assignstmt | callstmt | writestmt | bangstmt | beginstmt | ifstmt | whilestmt | breakstmt | continuestmt)?
   ;

assignstmt
   : ident ':=' expression
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

beginstmt
   : BEGIN statement (';' statement)* END
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
   :condition (opp = ('AND'|'OR')condition)*
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



BREAK
   : 'BREAK'
   ;


CONTINUE
   : 'CONTINUE'
   ;


WRITE
   : 'WRITE'
   ;


WHILE
   : 'WHILE'
   ;


DO
   : 'DO'
   ;


IF
   : 'IF'
   ;


THEN
   : 'THEN'
   ;

BEGIN
   : 'BEGIN'
   ;


END
   : 'END'
   ;


CALL
   : 'CALL'
   ;

VAR
   : 'VAR'
   ;


PROCEDURE
   : 'PROCEDURE'
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
