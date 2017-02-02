import java_cup.runtime.*;

%%
%class CompilerLexer
%line // compte le nombre de lignes
%column // nombre de colonnes
// classe des mots-clés 
%cupsym CompilerSymbol
%cup
%x STR_STATE COMMENT_STATE

%{
	private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn, yytext());
	}

	private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value); 
	}
	
	public void yyerror () {
		System.err.println("syntax error line " + (yyline + 1) + " column " + (yycolumn + 1) + " symbol '" + yytext() + "'"); 
	}
	
	private StringBuffer stringBuffer = new StringBuffer();
	public int lineCounter = 1; /* ne tombe pas toujours juste, je comprends pas pourquoi... */
%}

id = [a-zA-Z][a-zA-Z0-9_]*
int = 0|[1-9][0-9]*|-(0|[1-9][0-9]*)
float = (0|[1-9][0-9]*)\.[0-9][0-9]*
power = ({int}|{float})E{int}

escape_char = '|\"|\\

%%

\"										{yybegin(STR_STATE); stringBuffer.delete(0, stringBuffer.length());}
<STR_STATE>\"							{yybegin(YYINITIAL); /*System.out.println("string found : " + stringBuffer.toString());*/ return symbol(CompilerSymbol.STR_LIT);}
<STR_STATE>\\{escape_char}				{stringBuffer.append(yytext().charAt(1));}
<STR_STATE>[^\t\"]						{stringBuffer.append(yytext());}
'\\''|'[^\t\r\n\']'|''|'\\[a-z]'		{return symbol(CompilerSymbol.CHAR_LIT);}
\/\*									{yybegin(COMMENT_STATE);}
<COMMENT_STATE>\n						{lineCounter++;}
<COMMENT_STATE>([^{\*\/}])				{}
<COMMENT_STATE>\*\/						{yybegin(YYINITIAL);}
\/\/.*\n|\/\/.*$						{} /* commentaires inline */

/* Opérateurs */
"("     	{return symbol(CompilerSymbol.OPAR);}
")"     	{return symbol(CompilerSymbol.CPAR);}
"{"			{return symbol(CompilerSymbol.OBRAC);}
"}"			{return symbol(CompilerSymbol.CBRAC);}
"["			{return symbol(CompilerSymbol.OBRACK);}
"]"			{return symbol(CompilerSymbol.CBRACK);}
"+"			{return symbol(CompilerSymbol.PLUS);}
"++"		{return symbol(CompilerSymbol.INC);}
"-"			{return symbol(CompilerSymbol.MINUS);}
"--" 		{return symbol(CompilerSymbol.DEC);}
"*"     	{return symbol(CompilerSymbol.STAR);}
"/"			{return symbol(CompilerSymbol.DIV);}
"%"			{return symbol(CompilerSymbol.MOD);}
";"    		{return symbol(CompilerSymbol.SEMIC);}
","			{return symbol(CompilerSymbol.COMMA);}
"."			{return symbol(CompilerSymbol.DOT);}
"->"		{return symbol(CompilerSymbol.ARROW);}
"<"			{return symbol(CompilerSymbol.LESS);}
">"			{return symbol(CompilerSymbol.MORE);}
"<="		{return symbol(CompilerSymbol.LESSEQ);}
">="		{return symbol(CompilerSymbol.MOREEQ);}
"="			{return symbol(CompilerSymbol.EQ);}
"=="		{return symbol(CompilerSymbol.EQTEST);}
"!="		{return symbol(CompilerSymbol.DIFF);}
"&&"		{return symbol(CompilerSymbol.AND);}
"||"		{return symbol(CompilerSymbol.OR);}
":"			{return symbol(CompilerSymbol.COLON);}
"^"			{return symbol(CompilerSymbol.CIRCON);}
"+="		{return symbol(CompilerSymbol.PLUSEQ);}
"-="		{return symbol(CompilerSymbol.MINUSEQ);}
"~"			{return symbol(CompilerSymbol.TILDE);}
"&"			{return symbol(CompilerSymbol.AMPER);}
"|"			{return symbol(CompilerSymbol.PIPE);}		
"<<"		{return symbol(CompilerSymbol.LSHIFT);}
">>"		{return symbol(CompilerSymbol.RSHIFT);}	

/* Constantes */
"true"		{return symbol(CompilerSymbol.TRUE);}
"false" 	{return symbol(CompilerSymbol.FALSE);}
"null"		{return symbol(CompilerSymbol.NULL);}

/* Types */
"integer"	{return symbol(CompilerSymbol.INT);}
"character" {return symbol(CompilerSymbol.CHAR);}
"float"		{return symbol(CompilerSymbol.FLOAT);}
"boolean"	{return symbol(CompilerSymbol.BOOL);}
"string"	{return symbol(CompilerSymbol.STR);}
"function"	{return symbol(CompilerSymbol.FCT);}
"procedure" {return symbol(CompilerSymbol.PROC);}
"list of"   {return symbol(CompilerSymbol.LISTOF);}
"type"		{return symbol(CompilerSymbol.TYPE);}
"structure"	{return symbol(CompilerSymbol.STRUCT);}
"static"	{return symbol(CompilerSymbol.STATIC);}
"class"		{return symbol(CompilerSymbol.CLASS);}

/* Retours */
"return"	{return symbol(CompilerSymbol.RETURN);}
"stop"		{return symbol(CompilerSymbol.STOP);}
"break"		{return symbol(CompilerSymbol.BREAK);}

/* Condtions et boucles */
"if"		{return symbol(CompilerSymbol.IF);}
"else"		{return symbol(CompilerSymbol.ELSE);}
"while"		{return symbol(CompilerSymbol.WHILE);}
"foreach"	{return symbol(CompilerSymbol.FOR);}
"in"		{return symbol(CompilerSymbol.IN);}
"repeat"	{return symbol(CompilerSymbol.REPEAT);}

/* Idenitifiants et nombres */
0x([0-f]){1,2} 				{return symbol(CompilerSymbol.HEX);}	
{id}     					{/*System.out.println(yytext());*/ return symbol(CompilerSymbol.ID);}
{int}|{float}|{power}		{/*System.out.println(yytext());*/ return symbol(CompilerSymbol.NB);}

\n					{lineCounter++;}
[ \t\v\f]			{}
.					{System.out.println("unknown character : " + yytext());}