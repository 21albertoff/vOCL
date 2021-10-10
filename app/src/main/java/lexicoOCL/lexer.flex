/*** SECCION DEFICION ***/
package analizadorOCL;
import static analizadorOCL.Tokens.*;

%%
/*** SECCION REGLAS ***/

/* Dar nombre a la clase generada */
%class lexer
%type Tokens
%line
%column

L=[a-zA-Z_]+
D=[0-9]+
ESPACIO=[ ,\t,\r,\n]+

%{ 
	public String lexeme; 
%}

%%
/*** SECCION CODIGO DE USUARIO ***/

{ESPACIO} {/*Ignore*/}
"=" { lexeme=yytext(); return IGUAL;}
"<>" { lexeme=yytext(); return DISTINTO;}
"<=" { lexeme=yytext(); return MENOR_IGUAL;}
">=" { lexeme=yytext(); return MAYOR_IGUAL;}
"<" { lexeme=yytext(); return MENOR;}
">" { lexeme=yytext(); return MAYOR;}
"OR" { lexeme=yytext(); return OR;}
"AND" { lexeme=yytext(); return AND;}
"XOR" { lexeme=yytext(); return XOR;}
"NOT" { lexeme=yytext(); return NOT;}
"IMPLIES" { lexeme=yytext(); return IMPLIES;}
"+" { lexeme=yytext(); return MAS;}
"-" { lexeme=yytext(); return MENOS;}
"*" { lexeme=yytext(); return MULTIPLICACION;}
".MOD" | ".mod" | ".Mod" { lexeme=yytext(); return MODULO;}
".DIV" | ".div" | ".Div" | "/" { lexeme=yytext(); return DIVISION;}
".ABS" | ".abs" | ".ABS" { lexeme=yytext(); return VALOR_ABSOLUTO;}
".MAX" | ".max" | ".Max" { lexeme=yytext(); return MAXIMO;}
".MIN" | ".min" | ".Min" { lexeme=yytext(); return MINIMO;}
".ROUND" | ".round" | ".Round" { lexeme=yytext(); return REDONDEO;}
".FLOOR" | ".floor" | ".Floor" { lexeme=yytext(); return TRUNCADO;}
".SIZE" | ".size" | ".Size" { lexeme=yytext(); return SIZE;}
".CONCAT" | ".concat" | ".Concat" { lexeme=yytext(); return CONCATENACION;}
".TOLOWER" | ".ToLower" | ".tolower" | ".Tolower" { lexeme=yytext(); return MINUSCULAS;}
".TOUPPER" | ".ToUpper" | ".toupper" | ".Toupper" { lexeme=yytext(); return MAYUSCULAS;}
".SUBSTRING" | ".Substring" | ".substring" { lexeme=yytext(); return SUBSTRING;}
"CONTEXT" |"Context" | "context" { lexeme=yytext(); return CONTEXT;}
"COLLECTION" |"Collection" | "collection" { lexeme=yytext(); return COLLECTION;}
"PRE" | "Pre" | "pre" { lexeme=yytext(); return PRECONDICION;}
"POST" | "Post" | "post" { lexeme=yytext(); return POSTCONDICION;}
"SELF" | "Sel" | "self" { lexeme=yytext(); return SELF;}
"INV" | "Inv" | "inv" { lexeme=yytext(); return INVARIANTE;}
"INTEGER" | "Integer" | "integer" { lexeme=yytext(); return INTEGER;}
"BOOLEAN" | "Boolean" | "boolean" { lexeme=yytext(); return BOOLEAN;}
"notEmpty" | "size" | "count" | "includes" | "includesAll" | "isEmpty" | "iterate" | "sum" | "exits" | "forAll" | "select" | "reject" | "collect" | "one" | "sortedBy" { lexeme=yytext(); return METODO;}
"."{L}({L}|{D})*"()" { lexeme=yytext(); return METODO;}
{L}({L}|{D})*"(" { lexeme=yytext(); return METODO;}
"."{L}({L}|{D})* { lexeme=yytext(); return ATRIBUTO;}
"." { lexeme=yytext(); return PUNTO;}
"::" { lexeme=yytext(); return DOBLEPUNTOS;}
":" { lexeme=yytext(); return DOSPUNTOS;}
"->" { lexeme=yytext(); return FLECHA;}
"(" { lexeme=yytext(); return PARENTESIS_IZQ;}
")" { lexeme=yytext(); return PARENTESIS_DER;}
"|" { lexeme=yytext(); return O;}
"@PRE" | "@Pre" | "@pre" { lexeme=yytext(); return VALORPROPIEDAD;}
"INIT" | "Init" | "init" { lexeme=yytext(); return VALORINICIAL;}
"DEF" | "Def" | "def" { lexeme=yytext(); return DEFINICION;}
"LET" | "Let" | "let" { lexeme=yytext(); return LET;}
{L}({L}|{D})*  { lexeme=yytext(); return IDENTIFICADOR;}
("(-"{D}+")")|{D}+  { lexeme=yytext(); return NUMERO;}
 . {return ERROR;}
 