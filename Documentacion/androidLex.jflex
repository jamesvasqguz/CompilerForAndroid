/*primer seccion: codigo de usuario*/
package  com.mycompany.android.lexer;
import java_cup.runtime.*;
import java.io.*;
import java.util.LinkedList;
import static com.mycompany.android.lexer.sym.*;
import  com.mycompany.android.lexer.TError;
%%

%{
    /*Almacenamos todos los errores en un lista*/
    public static LinkedList<TError> tablaErrores=new LinkedList<TError>();
%}

/*segunda seccion: configuracion*/
%class Lexico
%cup
%unicode
%line
%column
%public 

/*Declaracion de enteros y decimal, tambien saltos de linea a ignorar*/
digito=[0-9]+("."[  |0-9]+)?
saltoLinea=[ \n\t\r\f]+


%init{
yyline = 1; 
yycolumn=1;
%init}

%%

/*tercera seccion: reglas lexicas*/
<YYINITIAL> {
    
{digito}+ { return new Symbol(NUMERO,yyline,yycolumn,yytext());}

/*Operadores Aritmeticos*/
"+" {return new Symbol(SUMA,yyline,yycolumn,yytext());}
"-" {return new Symbol(RESTA,yyline,yycolumn,yytext());}
"*" {return new Symbol(MUL,yyline,yycolumn,yytext());}
"/" {return new Symbol(DIV,yyline,yycolumn,yytext());}
"(" {return new Symbol(PAA,yyline,yycolumn,yytext());}
")" {return new Symbol(PAC,yyline,yycolumn,yytext());}
"," {return new Symbol(COMA,yyline,yycolumn,yytext());}

/*Asignaciones de acciones*/
"graficar" {return new Symbol(GRAF,yyline,yycolumn,yytext());}
"animar" {return new Symbol(ANI,yyline,yycolumn,yytext());}
"objeto" {return new Symbol(OBJ,yyline,yycolumn,yytext());}
"anterior" {return new Symbol(ANT,yyline,yycolumn,yytext());}
"linea" {return new Symbol(LINE,yyline,yycolumn,yytext());}
"curva" {return new Symbol(CUR,yyline,yycolumn,yytext());}

/*Formas geometricas*/
"circulo" {return new Symbol(CIR,yyline,yycolumn,yytext());}
"cuadrado" {return new Symbol(CUADRA,yyline,yycolumn,yytext());}
"rectangulo" {return new Symbol(REC,yyline,yycolumn,yytext());}
"poligono" {return new Symbol(POL,yyline,yycolumn,yytext());}

/*Colores*/
"azul" {return new Symbol(CAZ,yyline,yycolumn,yytext());}
"rojo" {return new Symbol(CR,yyline,yycolumn,yytext());}
"verde" {return new Symbol(CV,yyline,yycolumn,yytext());}
"amarillo" {return new Symbol(CAM,yyline,yycolumn,yytext());}
"naranja" {return new Symbol(CNA,yyline,yycolumn,yytext());}
"morado" {return new Symbol(CM,yyline,yycolumn,yytext());}
"cafe" {return new Symbol(CC,yyline,yycolumn,yytext());}
"negro" {return new Symbol(CNE,yyline,yycolumn,yytext());}

{saltoLinea} {/*Ignoramos*/}

. { System.out.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yycolumn);
    TError errores= new TError(yytext(),yyline,yycolumn,"Error lexico","Simbolo no existe en la gramatica");
    tablaErrores.add(errores);
    }
}

[^] {}
