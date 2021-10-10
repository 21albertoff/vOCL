package lexicoOCL;

import java.awt.Color;
import java.io.StringReader;

import java_cup.runtime.Symbol;

public class analizadorSintactico {
	
	public static String analizadorSintactico(String sentencia) {
		String resultado = "";
		Sintax s = new Sintax(new lexicoOCL.LexerCup(new StringReader(sentencia)));				
		try {
			s.parse();
			resultado = "Analisis realizado correctamente";
		} catch (Exception ex) {
			Symbol sym = s.getS();
			int Linea = sym.right +1;
			int Columna = (Linea != 1)? sym.left-1: sym.left+1;
			if (sym.value == null) {
				resultado = "Error de sintaxis, es posible que la sentencia no este acabada.";
			} else {
				resultado = "Error de sintaxis, Linea: "+Linea+" Posicion: "+Columna+" Texto: \""+sym.value+"\"" ;
			}
		}
		
		System.out.println(resultado);
		return resultado;
	}

}
