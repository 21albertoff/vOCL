package lexicoOCL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Alberto Fuentes
 *
 */
public class OCLLexico {
	
	public String analisisLexico(String sentenciaOCL) {
		
		//Variables
		String resultado = "";
		
		//Escritura de la sentencia en archivo
		File archivo = new File("archivo.txt");
		PrintWriter escribir;
	
		try {
			escribir = new PrintWriter(archivo);
			escribir.print(sentenciaOCL);
			escribir.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		//Lectura de la sentencia en el archivo 
		try {
			Reader lector = new BufferedReader(new FileReader("archivo.txt"));
			lexer lexer = new lexer(lector);
			while(true) {
				Tokens tokens = lexer.yylex();
				int linea = lexer.yyline;
				if (tokens == null) {
					return resultado;
				}
				
				switch(tokens) {
					case ERROR:	
						resultado += "ERROR:En la linea "+(linea+1)+" -> "+lexer.yytext()+"\n";
						break;
					default:
						resultado += "LEXEMA -> "+tokens+" -> "+lexer.lexeme+"\n";
						break;
						
				}
				
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return resultado;
		
	}

}
