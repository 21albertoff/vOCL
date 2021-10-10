package lexicoOCL;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
ESPACIO=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

{ESPACIO} {/*Ignore*/}
("=") {return new Symbol(sym.IGUAL, yychar, yyline, yytext());}
("<>") {return new Symbol(sym.DISTINTO, yychar, yyline, yytext());}
("<=") {return new Symbol(sym.MENOR_IGUAL, yychar, yyline, yytext());}
(">=") {return new Symbol(sym.MAYOR_IGUAL, yychar, yyline, yytext());}
("<") {return new Symbol(sym.MENOR, yychar, yyline, yytext());}
(">") {return new Symbol(sym.MAYOR, yychar, yyline, yytext());}
("OR") {return new Symbol(sym.OR, yychar, yyline, yytext());}
("AND") {return new Symbol(sym.AND, yychar, yyline, yytext());}
("XOR") {return new Symbol(sym.XOR, yychar, yyline, yytext());}
("NOT") {return new Symbol(sym.NOT, yychar, yyline, yytext());}
("+") {return new Symbol(sym.MAS, yychar, yyline, yytext());}
("-") {return new Symbol(sym.MENOS, yychar, yyline, yytext());}
("*") {return new Symbol(sym.MULTIPLICACION, yychar, yyline, yytext());}
(".MOD" | ".mod" | ".Mod") {return new Symbol(sym.MODULO, yychar, yyline, yytext());}
(".DIV" | ".div" | ".Div" | "/") {return new Symbol(sym.DIVISION, yychar, yyline, yytext());}
(".ABS" | ".abs" | ".ABS") {return new Symbol(sym.VALOR_ABSOLUTO, yychar, yyline, yytext());}
(".MAX" | ".max" | ".Max") {return new Symbol(sym.MAXIMO, yychar, yyline, yytext());}
(".MIN" | ".min" | ".Min") {return new Symbol(sym.MINIMO, yychar, yyline, yytext());}
(".ROUND" | ".round" | ".Round") {return new Symbol(sym.REDONDEO, yychar, yyline, yytext());}
(".SIZE" | ".size" | ".Size") {return new Symbol(sym.SIZE, yychar, yyline, yytext());}
(".FLOOR" | ".floor" | ".Floor") {return new Symbol(sym.TRUNCADO, yychar, yyline, yytext());}
(".CONCAT" | ".concat" | ".Concat") {return new Symbol(sym.CONCATENACION, yychar, yyline, yytext());}
(".TOLOWER" | ".ToLower" | ".tolower" | ".Tolower") {return new Symbol(sym.MINUSCULA, yychar, yyline, yytext());}
(".TOUPPER" | ".ToUpper" | ".toupper" | ".Toupper") {return new Symbol(sym.MAYUSCULA, yychar, yyline, yytext());}
(".SUBSTRING" | ".Substring" | ".substring") {return new Symbol(sym.SUBSTRING, yychar, yyline, yytext());}
("CONTEXT" |"Context" | "context") {return new Symbol(sym.CONTEXT, yychar, yyline, yytext());}
("PRE" | "Pre" | "pre") {return new Symbol(sym.PRECONDICION, yychar, yyline, yytext());}
("POST" | "Post" | "post") {return new Symbol(sym.POSTCONDICION, yychar, yyline, yytext());}
("SELF" | "Sel" | "self") {return new Symbol(sym.SELF, yychar, yyline, yytext());}
("INV" | "Inv" | "inv") {return new Symbol(sym.INVARIANTE, yychar, yyline, yytext());}
("INTEGER" | "Integer" | "integer") {return new Symbol(sym.INTEGER, yychar, yyline, yytext());}
("BOOLEAN" | "Boolean" | "boolean") {return new Symbol(sym.BOOLEAN, yychar, yyline, yytext());}
("."{L}({L}|{D})*) {return new Symbol(sym.ATRIBUTO, yychar, yyline, yytext());}
("::") {return new Symbol(sym.DOBLEPUNTOS, yychar, yyline, yytext());}
(":") {return new Symbol(sym.DOSPUNTOS, yychar, yyline, yytext());}
("->") {return new Symbol(sym.FLECHA, yychar, yyline, yytext());}
("(") {return new Symbol(sym.PARENTESIS_IZQ, yychar, yyline, yytext());}
(")") {return new Symbol(sym.PARENTESIS_DER, yychar, yyline, yytext());}
("|") {return new Symbol(sym.O, yychar, yyline, yytext());}
("@PRE" | "@Pre" | "@pre") {return new Symbol(sym.VALORPROPIEDAD, yychar, yyline, yytext());}
("INIT" | "Init" | "init") {return new Symbol(sym.VALORINICIAL, yychar, yyline, yytext());}
("DEF" | "Def" | "def") {return new Symbol(sym.DEFINICION, yychar, yyline, yytext());}
("LET" | "Let" | "let") {return new Symbol(sym.LET, yychar, yyline, yytext());}
({L}({L}|{D})*)  {return new Symbol(sym.IDENTIFICADOR, yychar, yyline, yytext());}
(("(-"{D}+")")|{D}+)  {return new Symbol(sym.NUMERO, yychar, yyline, yytext());}
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
