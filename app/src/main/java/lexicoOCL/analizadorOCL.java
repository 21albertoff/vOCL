package lexicoOCL;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Analizador Lexico
 * 
 * @author Alberto Fuentes
 *
 */
public class analizadorOCL {

	public static void main(String[] args) throws IOException, Exception {
		
		String rutaLexico = "C:/Users/alber/vocl/vOCL/src/lexicoOCL/lexer.flex";
		String rutaSintactico = "C:/Users/alber/vocl/vOCL/src/lexicoOCL/lexerCup.flex";	
		String[] rutaStringSintactico = {"-parser", "Sintax", "C:/Users/alber/vocl/vOCL/src/lexicoOCL/Sintax.cup"};
		
		generaLexicoOCL(rutaLexico);
		generaSintacticoOCL(rutaSintactico, rutaStringSintactico);

	}
	
	public static void generaLexicoOCL(String ruta) {
		File archivo = new File(ruta);
		jflex.Main.generate(archivo);
	}
	
	public static void generaSintacticoOCL(String ruta, String[] rutaS) throws IOException, Exception {
		java_cup.Main.main(rutaS);
		
		Path rutaSym = Paths.get("C:/Users/alber/vocl/vOCL/src/lexicoOCL/sym.java");
		
		if (Files.exists(rutaSym)) {
			Files.delete(rutaSym);
		}
		
		Files.move(
				Paths.get("C:/Users/alber/vocl/vOCL/sym.java"), 
				Paths.get("C:/Users/alber/vocl/vOCL/src/lexicoOCL/sym.java"));
		
		
		Path rutaSym2 = Paths.get("C:/Users/alber/vocl/vOCL/src/lexicoOCL/Sintax.java");
		
		if (Files.exists(rutaSym2)) {
			Files.delete(rutaSym2);
		}
		Files.move(
				Paths.get("C:/Users/alber/vocl/vOCL/Sintax.java"), 
				Paths.get("C:/Users/alber/vocl/vOCL/src/lexicoOCL/Sintax.java"));
	}
	

}
