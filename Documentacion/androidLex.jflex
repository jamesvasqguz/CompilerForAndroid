/*primer seccion: codigo de usuario*/
package com.example.androidcompiler.Analizadores.Lexico;
import java_cup.runtime.*;
import java.util.ArrayList;
import static com.example.androidcompiler.Analizadores.Lexico.sym.*;
import com.mycompany.android.lexer.TError;
import com.example.androidcompiler.Operadores.Occurencia;
%%

%{
    /*Almacenamos todos los errores en un lista*/
    private ArrayList<TError> errores = new ArrayList<>();
    //Recuperamos los Errores de la lista
    public ArrayList<TError> getErrores() {
        return this.errores;
    }
    //Almacenas todos los objetos y colores que se usaran
	private int[] usados = new int[14];
	
 	//metodo para recuperar los usos
 	public int[] gettUsados(){
 		return this.usados;
 	}
    
%}

%eof{   System.out.println("Cantidad en el array: "+getErrores().size());
		for(int i=0;i<errores.size();i++){
        System.out.println("Imprimiendo errores: -----> "+errores.get(i).toString());
        i++;        
        }
%eof}

/*segunda seccion: configuracion*/
%class Lexico
%cup
%unicode
%line
%column
%public 

/*Declaracion de enteros y decimal, tambien saltos de linea a ignorar*/
digito=[0-9]+("."[  |0-9]+)?
ignorar=[ \t\r\f]+
saltoLinea=[\n]+

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
"linea" {usados[12]++;return new Symbol(LINE,yyline,yycolumn,yytext());}
"curva" {usados[13]++;return new Symbol(CUR,yyline,yycolumn,yytext());}

/*Formas geometricas*/
"circulo" {usados[8]++;return new Symbol(CIR,yyline,yycolumn,yytext());}
"cuadrado" {usados[9]++;return new Symbol(CUADRA,yyline,yycolumn,yytext());}
"rectangulo" {usados[10]++;return new Symbol(REC,yyline,yycolumn,yytext());}
"poligono" {usados[11]++;return new Symbol(POL,yyline,yycolumn,yytext());}

/*Colores*/
"azul" {usados[0]++;return new Symbol(CAZ,yyline,yycolumn,yytext());}
"rojo" {usados[1]++;return new Symbol(CR,yyline,yycolumn,yytext());}
"verde" {usados[2]++;return new Symbol(CV,yyline,yycolumn,yytext());}
"amarillo" {usados[3]++;return new Symbol(CAM,yyline,yycolumn,yytext());}
"naranja" {usados[4]++;return new Symbol(CNA,yyline,yycolumn,yytext());}
"morado" {usados[5]++;return new Symbol(CM,yyline,yycolumn,yytext());}
"cafe" {usados[6]++;return new Symbol(CC,yyline,yycolumn,yytext());}
"negro" {usados[7]++;return new Symbol(CNE,yyline,yycolumn,yytext());}

{saltoLinea} {return new Symbol(SALTO,yyline,yycolumn);}

{ignorar} {/*Ignoramos*/}

}
[^] {return new Symbol(ELEX, yyline, yycolumn, yytext());
    errores.add(new TError(yytext(),yyline,yycolumn,"Error Lexico","Símbolo no existe en el lenguaje"));
    System.out.println("Se encontro un Error Lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yycolumn);
    }
