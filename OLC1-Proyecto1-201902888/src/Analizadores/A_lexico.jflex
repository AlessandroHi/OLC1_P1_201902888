
/*--------------------------------------------------
 ------------  1ra Area: Codigo de Usuario ---------
 ---------------------------------------------------*/

//------> Paquetes,importaciones
package Analizadores;
import java_cup.runtime.*;
import olc1.proyecto1.pkg201902888.Interfaz;
import olc1.proyecto1.pkg201902888.error;
/*----------------------------------------------------------
  ------------  2da Area: Opciones y Declaraciones ---------
  ----------------------------------------------------------*/
%%
%{
    //----> Codigo de usuario en sintaxis java
%}

//-------> Directivas
%public 
%class Analizador_Lexico
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode

//------> Expresiones Regulares
digito              = [0-9]
letra               = [a-zA-ZÑñ]
identificador       = {letra}({letra}|{digito}|"_")*
cadena              = [\"][^\"\n]+[\"]
notacion            = {letra} "~" {letra} | {digito} "~" {digito} | {especiales} "~" {especiales}
especiales          =[!-/]|[:-@]|[\\-`]|[{-~]

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

comentariosimple    = "//" {InputCharacter}* {LineTerminator}?
comentarioMulti =  "<!" [^/] ~"!>"




//------> Estados

%%
/*------------------------------------------------
  ------------  3ra Area: Reglas Lexicas ---------
  ------------------------------------------------*/

//-----> Simbolos

":"         { System.out.println("Reconocio "+yytext()+" dspnt"); return new Symbol(Simbolos.dspnt, yycolumn, yyline, yytext()); }
";"         { System.out.println("Reconocio "+yytext()+" pyc"); return new Symbol(Simbolos.pyc, yycolumn, yyline, yytext()); }
"."         { System.out.println("Reconocio "+yytext()+" pnt"); return new Symbol(Simbolos.pnt, yycolumn, yyline, yytext()); }
","         { System.out.println("Reconocio "+yytext()+" coma"); return new Symbol(Simbolos.coma, yycolumn, yyline, yytext()); }
"+"         { System.out.println("Reconocio "+yytext()+" mas"); return new Symbol(Simbolos.mas, yycolumn, yyline, yytext()); }
"-"         { System.out.println("Reconocio "+yytext()+" guion"); return new Symbol(Simbolos.guion, yycolumn, yyline, yytext()); }
"{"         { System.out.println("Reconocio "+yytext()+" llavea"); return new Symbol(Simbolos.llavea, yycolumn, yyline, yytext()); }
"}"         { System.out.println("Reconocio "+yytext()+" llavec"); return new Symbol(Simbolos.llavec, yycolumn, yyline, yytext()); }
"("         { System.out.println("Reconocio "+yytext()+" para"); return new Symbol(Simbolos.para, yycolumn, yyline, yytext()); }
")"         { System.out.println("Reconocio "+yytext()+" parc"); return new Symbol(Simbolos.parc, yycolumn, yyline, yytext()); }
"["         { System.out.println("Reconocio "+yytext()+" cora"); return new Symbol(Simbolos.cora, yycolumn, yyline, yytext()); }
"]"         { System.out.println("Reconocio "+yytext()+" corc"); return new Symbol(Simbolos.corc, yycolumn, yyline, yytext()); }
//"->"        { System.out.println("Reconocio "+yytext()+" produccion"); return new Symbol(Simbolos.produce, yycolumn, yyline, yytext()); }
">"         { System.out.println("Reconocio "+yytext()+" Mayor que"); return new Symbol(Simbolos.mayorque, yycolumn, yyline, yytext()); } 
"<"         { System.out.println("Reconocio "+yytext()+" Menor que"); return new Symbol(Simbolos.menorque, yycolumn, yyline, yytext()); }       
"!"         { System.out.println("Reconocio "+yytext()+" excla"); return new Symbol(Simbolos.excla, yycolumn, yyline, yytext()); }
"%"        { System.out.println("Reconocio "+yytext()+"  porcentaje"); return new Symbol(Simbolos.porcen, yycolumn, yyline, yytext()); }
"|"         { System.out.println("Reconocio "+yytext()+" or"); return new Symbol(Simbolos.or, yycolumn, yyline, yytext()); }
"*"         { System.out.println("Reconocio "+yytext()+" kleen"); return new Symbol(Simbolos.kleen, yycolumn, yyline, yytext()); }
"_"         { System.out.println("Reconocio "+yytext()+" guionb"); return new Symbol(Simbolos.guionb, yycolumn, yyline, yytext()); }
"~"         { System.out.println("Reconocio "+yytext()+" virgulilla"); return new Symbol(Simbolos.virgulilla, yycolumn, yyline, yytext()); }
"\\\""      { System.out.println("Reconocio "+yytext()+" Comillas Dobles"); return new Symbol(Simbolos.comilladoble, yycolumn, yyline, yytext()); }
"\\'"       { System.out.println("Reconocio "+yytext()+" Comilla simple"); return new Symbol(Simbolos.comillasimple, yycolumn, yyline, yytext()); }
"\\n"       { System.out.println("Reconocio "+yytext()+" salto de linea"); return new Symbol(Simbolos.salto, yycolumn, yyline, yytext()); }
"?"         { System.out.println("Reconocio "+yytext()+" signo interrogacion"); return new Symbol(Simbolos.inter, yycolumn, yyline, yytext()); }


//-----> Palabras reservadas
"CONJ"         { System.out.println("Reconocio "+yytext()+" Conjunto"); return new Symbol(Simbolos.CONJ, yycolumn, yyline, yytext()); }

//-------> Simbolos ER
{digito}                { System.out.println("Reconocio "+yytext()+" digito"); return new Symbol(Simbolos.digito, yycolumn, yyline, yytext()); }
{identificador}         { System.out.println("Reconocio "+yytext()+" id"); return new Symbol(Simbolos.identificador, yycolumn, yyline, yytext()); }
{cadena}                { System.out.println("Reconocio "+yytext()+" cadena"); return new Symbol(Simbolos.cadena, yycolumn, yyline, yytext()); }
{especiales}            { System.out.println("Reconocio "+yytext()+" simbolos especiales"); return new Symbol(Simbolos.especiales, yycolumn, yyline, yytext()); }
{notacion}              { System.out.println("Reconocio "+yytext()+" notacion"); return new Symbol(Simbolos.notacion, yycolumn, yyline, yytext()); }

//------> Espacios
{comentariosimple}      {System.out.println("Comentario Simple: "+yytext()); }
{comentarioMulti}       {System.out.println("Comentario Multiple: "+yytext()); }
[ \t\r\n\f]             {/* Espacios en blanco, se ignoran */}


//------> Errores Lexicos
.                       { System.err.println("Error Lexico: "+yytext()+" Linea: "+yyline+" Columna: "+yycolumn); 
                            error nuevo = new error("Error Lexico (Recuperado)", "El Simbolo: "+yytext()+" no pertenece al lenguaje", yyline, yycolumn);
                            Interfaz.listaErrores.add(nuevo);
                        }