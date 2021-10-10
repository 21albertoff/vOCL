package lexicoOCL;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class TestLexico extends TestCase{

	private OCLLexico analizador;
	
	public void inicializar() {
		analizador = new OCLLexico();
	}
	
	@Test
	public void testAnalizadorLexicoSencillo() {
		inicializar();
		assertEquals(analizador.analisisLexico(""), "");
		assertEquals(analizador.analisisLexico(" "), "");
		assertEquals(analizador.analisisLexico("'"), "ERROR:En la linea 1 -> '\n");
		assertEquals(analizador.analisisLexico(" �"), "ERROR:En la linea 1 -> �\n");
		assertEquals(analizador.analisisLexico(" ~ "), "ERROR:En la linea 1 -> ~\n");
		assertEquals(analizador.analisisLexico("Test"), "LEXEMA -> IDENTIFICADOR -> Test\n");
		assertEquals(analizador.analisisLexico("test"), "LEXEMA -> IDENTIFICADOR -> test\n");
		assertEquals(analizador.analisisLexico("TEST"), "LEXEMA -> IDENTIFICADOR -> TEST\n");
		assertEquals(analizador.analisisLexico("Test1"), "LEXEMA -> IDENTIFICADOR -> Test1\n");
		assertEquals(analizador.analisisLexico(" Test"), "LEXEMA -> IDENTIFICADOR -> Test\n");
		assertEquals(analizador.analisisLexico("Test "), "LEXEMA -> IDENTIFICADOR -> Test\n");
		assertEquals(analizador.analisisLexico(" Test "), "LEXEMA -> IDENTIFICADOR -> Test\n");
		assertEquals(analizador.analisisLexico("1"), "LEXEMA -> NUMERO -> 1\n");
		assertEquals(analizador.analisisLexico(" 2"), "LEXEMA -> NUMERO -> 2\n");
		assertEquals(analizador.analisisLexico("3 "), "LEXEMA -> NUMERO -> 3\n");
		assertEquals(analizador.analisisLexico(" 10 "), "LEXEMA -> NUMERO -> 10\n");
		assertEquals(analizador.analisisLexico("Context"), "LEXEMA -> CONTEXT -> Context\n");
		assertEquals(analizador.analisisLexico("CONTEXT"), "LEXEMA -> CONTEXT -> CONTEXT\n");
		assertEquals(analizador.analisisLexico("context"), "LEXEMA -> CONTEXT -> context\n");
		assertEquals(analizador.analisisLexico(":"), "LEXEMA -> DOSPUNTOS -> :\n");
		assertEquals(analizador.analisisLexico("INV"), "LEXEMA -> INVARIANTE -> INV\n");
		assertEquals(analizador.analisisLexico("PRE"), "LEXEMA -> PRECONDICION -> PRE\n");
		assertEquals(analizador.analisisLexico("POST"), "LEXEMA -> POSTCONDICION -> POST\n");
		assertEquals(analizador.analisisLexico("Def"), "LEXEMA -> DEFINICION -> Def\n");
		assertEquals(analizador.analisisLexico("INV"), "LEXEMA -> INVARIANTE -> INV\n");
		
	}
	
	@Test
	public void testAnalizadorLexicoSencilloVariasLineas() {
		inicializar();
		assertEquals(analizador.analisisLexico("\n"), "");
		assertEquals(analizador.analisisLexico("\n "), "");
		assertEquals(analizador.analisisLexico("\n'"), "ERROR:En la linea 2 -> '\n");
		assertEquals(analizador.analisisLexico("\n �"), "ERROR:En la linea 2 -> �\n");
		assertEquals(analizador.analisisLexico("\n ~ "), "ERROR:En la linea 2 -> ~\n");
		
		
		assertEquals(analizador.analisisLexico("\n\nTest"), "LEXEMA -> IDENTIFICADOR -> Test\n");
		
		assertEquals(analizador.analisisLexico("test1\nTest2"), "LEXEMA -> IDENTIFICADOR -> test1\n"
															  + "LEXEMA -> IDENTIFICADOR -> Test2\n");
		
		assertEquals(analizador.analisisLexico("\nTEST\ntest2"), "LEXEMA -> IDENTIFICADOR -> TEST\n"
															   + "LEXEMA -> IDENTIFICADOR -> test2\n");
		
		assertEquals(analizador.analisisLexico(" Test\ncontext"), "LEXEMA -> IDENTIFICADOR -> Test\n"
																+ "LEXEMA -> CONTEXT -> context\n");
		
		assertEquals(analizador.analisisLexico("Test\n inv"), "LEXEMA -> IDENTIFICADOR -> Test\n"
															+ "LEXEMA -> INVARIANTE -> inv\n");
		
		assertEquals(analizador.analisisLexico("Test \ninv"), "LEXEMA -> IDENTIFICADOR -> Test\n"
															+ "LEXEMA -> INVARIANTE -> inv\n");
		
		assertEquals(analizador.analisisLexico("Test \n inv"), "LEXEMA -> IDENTIFICADOR -> Test\n"
															 + "LEXEMA -> INVARIANTE -> inv\n");
		
		assertEquals(analizador.analisisLexico("Test \n      inv"), "LEXEMA -> IDENTIFICADOR -> Test\n"
																  + "LEXEMA -> INVARIANTE -> inv\n");
		
		assertEquals(analizador.analisisLexico("1+0\n def"), "LEXEMA -> NUMERO -> 1\nLEXEMA -> MAS -> +\n"
														   + "LEXEMA -> NUMERO -> 0\nLEXEMA -> DEFINICION -> def\n");
		
		assertEquals(analizador.analisisLexico("\nPRE:"), "LEXEMA -> PRECONDICION -> PRE\n"
														+ "LEXEMA -> DOSPUNTOS -> :\n");

		assertEquals(analizador.analisisLexico("INV\n INV\n INV"), "LEXEMA -> INVARIANTE -> INV\n"
																	+ "LEXEMA -> INVARIANTE -> INV\n"
																	+ "LEXEMA -> INVARIANTE -> INV\n");
		
		assertEquals(analizador.analisisLexico("\nPRE:\n"), "LEXEMA -> PRECONDICION -> PRE\n"
														  + "LEXEMA -> DOSPUNTOS -> :\n");
		
		assertEquals(analizador.analisisLexico("\nPOST\n:\n"), "LEXEMA -> POSTCONDICION -> POST\n"
															  + "LEXEMA -> DOSPUNTOS -> :\n");
		
		assertEquals(analizador.analisisLexico("Def"), "LEXEMA -> DEFINICION -> Def\n");
		
		assertEquals(analizador.analisisLexico("context\nnotEmpty"), "LEXEMA -> CONTEXT -> context\n"
																   + "LEXEMA -> METODO -> notEmpty\n");
	}
	
	@Test
	public void testAnalizadorIntermedio() {
		inicializar();
		assertEquals(analizador.analisisLexico("context Trabajo"), "LEXEMA -> CONTEXT -> context\n"
																 + "LEXEMA -> IDENTIFICADOR -> Trabajo\n");
		
		assertEquals(analizador.analisisLexico("Context trabajo"), "LEXEMA -> CONTEXT -> Context\n"
																 + "LEXEMA -> IDENTIFICADOR -> trabajo\n");
		
		assertEquals(analizador.analisisLexico("CONTEXT TRABAJO"), "LEXEMA -> CONTEXT -> CONTEXT\n"
																 + "LEXEMA -> IDENTIFICADOR -> TRABAJO\n");
		
		assertEquals(analizador.analisisLexico("context Trabajo inv"), "LEXEMA -> CONTEXT -> context\n"
																	 + "LEXEMA -> IDENTIFICADOR -> Trabajo\n"
																	 + "LEXEMA -> INVARIANTE -> inv\n");
		
		assertEquals(analizador.analisisLexico("context Trabajo inv:"), "LEXEMA -> CONTEXT -> context\n"
																	 + "LEXEMA -> IDENTIFICADOR -> Trabajo\n"
																	 + "LEXEMA -> INVARIANTE -> inv\n"
																	 + "LEXEMA -> DOSPUNTOS -> :\n");
		
		assertEquals(analizador.analisisLexico("context Empresa inv minimoEmpleados:"), "LEXEMA -> CONTEXT -> context\n"
																					  + "LEXEMA -> IDENTIFICADOR -> Empresa\n"
																					  + "LEXEMA -> INVARIANTE -> inv\n"
																					  + "LEXEMA -> IDENTIFICADOR -> minimoEmpleados\n"
																					  + "LEXEMA -> DOSPUNTOS -> :\n");
		
		assertEquals(analizador.analisisLexico("CONTEXT Empresa INV minimoEmpleados:"), "LEXEMA -> CONTEXT -> CONTEXT\n"
																					  + "LEXEMA -> IDENTIFICADOR -> Empresa\n"
																					  + "LEXEMA -> INVARIANTE -> INV\n"
																					  + "LEXEMA -> IDENTIFICADOR -> minimoEmpleados\n"
																					  + "LEXEMA -> DOSPUNTOS -> :\n");
		
		assertEquals(analizador.analisisLexico("context EMPRESA inv MINIMOEMPLEADOS:"), "LEXEMA -> CONTEXT -> context\n"
																					  + "LEXEMA -> IDENTIFICADOR -> EMPRESA\n"
																					  + "LEXEMA -> INVARIANTE -> inv\n"
																					  + "LEXEMA -> IDENTIFICADOR -> MINIMOEMPLEADOS\n"
																					  + "LEXEMA -> DOSPUNTOS -> :\n");
		
		assertEquals(analizador.analisisLexico("context Empresa inv minimo_empleados:"), "LEXEMA -> CONTEXT -> context\n"
																					   + "LEXEMA -> IDENTIFICADOR -> Empresa\n"
																					   + "LEXEMA -> INVARIANTE -> inv\n"
																					   + "LEXEMA -> IDENTIFICADOR -> minimo_empleados\n"
																					   + "LEXEMA -> DOSPUNTOS -> :\n");
		
		assertEquals(analizador.analisisLexico("context Cliente def: "), "LEXEMA -> CONTEXT -> context\n"
																	   + "LEXEMA -> IDENTIFICADOR -> Cliente\n"
																	   + "LEXEMA -> DEFINICION -> def\n"
																	   + "LEXEMA -> DOSPUNTOS -> :\n");
		
		assertEquals(analizador.analisisLexico("a = b "), "LEXEMA -> IDENTIFICADOR -> a\n"
													    + "LEXEMA -> IGUAL -> =\n"
													    + "LEXEMA -> IDENTIFICADOR -> b\n");
		
		assertEquals(analizador.analisisLexico("a + b "), "LEXEMA -> IDENTIFICADOR -> a\n"
													    + "LEXEMA -> MAS -> +\n"
													    + "LEXEMA -> IDENTIFICADOR -> b\n");
		
		assertEquals(analizador.analisisLexico("a - b "), "LEXEMA -> IDENTIFICADOR -> a\n"
													    + "LEXEMA -> MENOS -> -\n"
													    + "LEXEMA -> IDENTIFICADOR -> b\n");
		
		assertEquals(analizador.analisisLexico("a <> b "), "LEXEMA -> IDENTIFICADOR -> a\n"
														 + "LEXEMA -> DISTINTO -> <>\n"
														 + "LEXEMA -> IDENTIFICADOR -> b\n");
		
		assertEquals(analizador.analisisLexico("a OR b "), "LEXEMA -> IDENTIFICADOR -> a\n"
														 + "LEXEMA -> OR -> OR\n"
														 + "LEXEMA -> IDENTIFICADOR -> b\n");
		
		assertEquals(analizador.analisisLexico("a AND b "), "LEXEMA -> IDENTIFICADOR -> a\n"
														  + "LEXEMA -> AND -> AND\n"
														  + "LEXEMA -> IDENTIFICADOR -> b\n");
													
		assertEquals(analizador.analisisLexico("(a = b)"), "LEXEMA -> PARENTESIS_IZQ -> (\n"
														 + "LEXEMA -> IDENTIFICADOR -> a\n"
														 + "LEXEMA -> IGUAL -> =\n"
														 + "LEXEMA -> IDENTIFICADOR -> b\n"
														 + "LEXEMA -> PARENTESIS_DER -> )\n");

		
		assertEquals(analizador.analisisLexico("context Empresa def 6*3:"), "LEXEMA -> CONTEXT -> context\n"
																		  + "LEXEMA -> IDENTIFICADOR -> Empresa\n"
																		  + "LEXEMA -> DEFINICION -> def\n"
																		  + "LEXEMA -> NUMERO -> 6\n"
																		  + "LEXEMA -> MULTIPLICACION -> *\n"
																		  + "LEXEMA -> NUMERO -> 3\n"
																	      + "LEXEMA -> DOSPUNTOS -> :\n");
		
		assertEquals(analizador.analisisLexico(" context  Empresa  def  6  *  3  :  "), "LEXEMA -> CONTEXT -> context\n"
																					  + "LEXEMA -> IDENTIFICADOR -> Empresa\n"
																					  + "LEXEMA -> DEFINICION -> def\n"
																					  + "LEXEMA -> NUMERO -> 6\n"
																					  + "LEXEMA -> MULTIPLICACION -> *\n"
																					  + "LEXEMA -> NUMERO -> 3\n"
																				      + "LEXEMA -> DOSPUNTOS -> :\n");

		assertEquals(analizador.analisisLexico("a.min(b)"), "LEXEMA -> IDENTIFICADOR -> a\n"
														+ "LEXEMA -> MINIMO -> .min\n"
														+ "LEXEMA -> PARENTESIS_IZQ -> (\n"
														+ "LEXEMA -> IDENTIFICADOR -> b\n"
														+ "LEXEMA -> PARENTESIS_DER -> )\n");
		
	}

	@Test
	public void testAnalizadorIntermedioVariasLineas() {
		inicializar();
		assertEquals(analizador.analisisLexico("context Company inv:\nself.noEmployees <= 50\n?"), "LEXEMA -> CONTEXT -> context\n"
																							 + "LEXEMA -> IDENTIFICADOR -> Company\n"
																							 + "LEXEMA -> INVARIANTE -> inv\n"
																							 + "LEXEMA -> DOSPUNTOS -> :\n"
																							 + "LEXEMA -> SELF -> self\n"
																							 + "LEXEMA -> ATRIBUTO -> .noEmployees\n"
																							 + "LEXEMA -> MENOR_IGUAL -> <=\n"
																							 + "LEXEMA -> NUMERO -> 50\n"
																							 + "ERROR:En la linea 3 -> ?\n");
		
		assertEquals(analizador.analisisLexico("context Company inv:\nself.noEmployees <= 50"), "LEXEMA -> CONTEXT -> context\n"
																								+ "LEXEMA -> IDENTIFICADOR -> Company\n"
																								+ "LEXEMA -> INVARIANTE -> inv\n"
																								+ "LEXEMA -> DOSPUNTOS -> :\n"
																								+ "LEXEMA -> SELF -> self\n"
																								+ "LEXEMA -> ATRIBUTO -> .noEmployees\n"
																								+ "LEXEMA -> MENOR_IGUAL -> <=\n"
																								+ "LEXEMA -> NUMERO -> 50\n");
		
		assertEquals(analizador.analisisLexico("context Company inv:\r\nself.noEmployees <= 50"), "LEXEMA -> CONTEXT -> context\n"
																								+ "LEXEMA -> IDENTIFICADOR -> Company\n"
																								+ "LEXEMA -> INVARIANTE -> inv\n"
																								+ "LEXEMA -> DOSPUNTOS -> :\n"
																								+ "LEXEMA -> SELF -> self\n"
																								+ "LEXEMA -> ATRIBUTO -> .noEmployees\n"
																								+ "LEXEMA -> MENOR_IGUAL -> <=\n"
																								+ "LEXEMA -> NUMERO -> 50\n");
		
		assertEquals(analizador.analisisLexico("Context c: Company inv SME:\n c.noEmployees <= 50"),  "LEXEMA -> CONTEXT -> Context\n"
																									+ "LEXEMA -> IDENTIFICADOR -> c\n"
																									+ "LEXEMA -> DOSPUNTOS -> :\n"
																									+ "LEXEMA -> IDENTIFICADOR -> Company\n"
																									+ "LEXEMA -> INVARIANTE -> inv\n"
																									+ "LEXEMA -> IDENTIFICADOR -> SME\n"
																									+ "LEXEMA -> DOSPUNTOS -> :\n"
																									+ "LEXEMA -> IDENTIFICADOR -> c\n"
																									+ "LEXEMA -> ATRIBUTO -> .noEmployees\n"
																									+ "LEXEMA -> MENOR_IGUAL -> <=\n"
																									+ "LEXEMA -> NUMERO -> 50\n");
		
		assertEquals(analizador.analisisLexico("context Company inv:\nself.stockPrice() > 0\n"),  "LEXEMA -> CONTEXT -> context\n"
																								+ "LEXEMA -> IDENTIFICADOR -> Company\n"
																								+ "LEXEMA -> INVARIANTE -> inv\n"
																								+ "LEXEMA -> DOSPUNTOS -> :\n"
																								+ "LEXEMA -> SELF -> self\n"
																								+ "LEXEMA -> METODO -> .stockPrice()\n"
																								+ "LEXEMA -> MAYOR -> >\n"
																								+ "LEXEMA -> NUMERO -> 0\n");
		
		assertEquals(analizador.analisisLexico("\r\ncontext Company inv:\nself.stockPrice() > 0\n"),  "LEXEMA -> CONTEXT -> context\n"
																									+ "LEXEMA -> IDENTIFICADOR -> Company\n"
																									+ "LEXEMA -> INVARIANTE -> inv\n"
																									+ "LEXEMA -> DOSPUNTOS -> :\n"
																									+ "LEXEMA -> SELF -> self\n"
																									+ "LEXEMA -> METODO -> .stockPrice()\n"
																									+ "LEXEMA -> MAYOR -> >\n"
																									+ "LEXEMA -> NUMERO -> 0\n");
		
		assertEquals(analizador.analisisLexico("context e:Empresa inv minimoEmpleados:\ne.numero_De_Empleados > 18"),    "LEXEMA -> CONTEXT -> context\n"
																														+ "LEXEMA -> IDENTIFICADOR -> e\n"
																														+ "LEXEMA -> DOSPUNTOS -> :\n"
																														+ "LEXEMA -> IDENTIFICADOR -> Empresa\n"
																														+ "LEXEMA -> INVARIANTE -> inv\n"
																														+ "LEXEMA -> IDENTIFICADOR -> minimoEmpleados\n"
																														+ "LEXEMA -> DOSPUNTOS -> :\n"
																														+ "LEXEMA -> IDENTIFICADOR -> e\n"
																														+ "LEXEMA -> ATRIBUTO -> .numero_De_Empleados\n"
																														+ "LEXEMA -> MAYOR -> >\n"
																														+ "LEXEMA -> NUMERO -> 18\n");
		
		assertEquals(analizador.analisisLexico("context Trabajo::puesto: Integer\ninit: Principiante"),   "LEXEMA -> CONTEXT -> context\n"
																										+ "LEXEMA -> IDENTIFICADOR -> Trabajo\n"
																										+ "LEXEMA -> DOBLEPUNTOS -> ::\n"
																										+ "LEXEMA -> IDENTIFICADOR -> puesto\n"
																										+ "LEXEMA -> DOSPUNTOS -> :\n"
																										+ "LEXEMA -> INTEGER -> Integer\n"
																										+ "LEXEMA -> VALORINICIAL -> init\n"
																										+ "LEXEMA -> DOSPUNTOS -> :\n"
																										+ "LEXEMA -> IDENTIFICADOR -> Principiante\n");
		
		assertEquals(analizador.analisisLexico("context Trabajo:puesto: Integer\ninit: Principiante"),   "LEXEMA -> CONTEXT -> context\n"
																										+ "LEXEMA -> IDENTIFICADOR -> Trabajo\n"
																										+ "LEXEMA -> DOSPUNTOS -> :\n"
																										+ "LEXEMA -> IDENTIFICADOR -> puesto\n"
																										+ "LEXEMA -> DOSPUNTOS -> :\n"
																										+ "LEXEMA -> INTEGER -> Integer\n"
																										+ "LEXEMA -> VALORINICIAL -> init\n"
																										+ "LEXEMA -> DOSPUNTOS -> :\n"
																										+ "LEXEMA -> IDENTIFICADOR -> Principiante\n");
		
		assertEquals(analizador.analisisLexico("context Trabajo:puesto: Integer\ninit: 'Principiante'"),   "LEXEMA -> CONTEXT -> context\n"
																										 + "LEXEMA -> IDENTIFICADOR -> Trabajo\n"
																										 + "LEXEMA -> DOSPUNTOS -> :\n"
																										 + "LEXEMA -> IDENTIFICADOR -> puesto\n"
																										 + "LEXEMA -> DOSPUNTOS -> :\n"
																										 + "LEXEMA -> INTEGER -> Integer\n"
																										 + "LEXEMA -> VALORINICIAL -> init\n"
																										 + "LEXEMA -> DOSPUNTOS -> :\n"
																										 + "ERROR:En la linea 2 -> '\n"
																										 + "LEXEMA -> IDENTIFICADOR -> Principiante\n"
																										 + "ERROR:En la linea 2 -> '\n");
		
		assertEquals(analizador.analisisLexico("context Trabajo:puesto: Integer\ninit: Principiante'"),   "LEXEMA -> CONTEXT -> context\n"
																										+ "LEXEMA -> IDENTIFICADOR -> Trabajo\n"
																										+ "LEXEMA -> DOSPUNTOS -> :\n"
																										+ "LEXEMA -> IDENTIFICADOR -> puesto\n"
																										+ "LEXEMA -> DOSPUNTOS -> :\n"
																										+ "LEXEMA -> INTEGER -> Integer\n"
																										+ "LEXEMA -> VALORINICIAL -> init\n"
																										+ "LEXEMA -> DOSPUNTOS -> :\n"
																										+ "LEXEMA -> IDENTIFICADOR -> Principiante\n"
																										+ "ERROR:En la linea 2 -> '\n");
		
		assertEquals(analizador.analisisLexico("context Trabajo:puesto: Integer\ninit: Principiante'"),   "LEXEMA -> CONTEXT -> context\n"
																										+ "LEXEMA -> IDENTIFICADOR -> Trabajo\n"
																										+ "LEXEMA -> DOSPUNTOS -> :\n"
																										+ "LEXEMA -> IDENTIFICADOR -> puesto\n"
																										+ "LEXEMA -> DOSPUNTOS -> :\n"
																										+ "LEXEMA -> INTEGER -> Integer\n"
																										+ "LEXEMA -> VALORINICIAL -> init\n"
																										+ "LEXEMA -> DOSPUNTOS -> :\n"
																										+ "LEXEMA -> IDENTIFICADOR -> Principiante\n"
																										+ "ERROR:En la linea 2 -> '\n");
		
		assertEquals(analizador.analisisLexico("context Trabajo:puesto: Integer\ninit: '"),   "LEXEMA -> CONTEXT -> context\n"
																							+ "LEXEMA -> IDENTIFICADOR -> Trabajo\n"
																							+ "LEXEMA -> DOSPUNTOS -> :\n"
																							+ "LEXEMA -> IDENTIFICADOR -> puesto\n"
																							+ "LEXEMA -> DOSPUNTOS -> :\n"
																							+ "LEXEMA -> INTEGER -> Integer\n"
																							+ "LEXEMA -> VALORINICIAL -> init\n"
																							+ "LEXEMA -> DOSPUNTOS -> :\n"
																							+ "ERROR:En la linea 2 -> '\n");
		
		assertEquals(analizador.analisisLexico("context Trabajo:puesto: Integer\ninit: ''"),  "LEXEMA -> CONTEXT -> context\n"
																							+ "LEXEMA -> IDENTIFICADOR -> Trabajo\n"
																							+ "LEXEMA -> DOSPUNTOS -> :\n"
																							+ "LEXEMA -> IDENTIFICADOR -> puesto\n"
																							+ "LEXEMA -> DOSPUNTOS -> :\n"
																							+ "LEXEMA -> INTEGER -> Integer\n"
																							+ "LEXEMA -> VALORINICIAL -> init\n"
																							+ "LEXEMA -> DOSPUNTOS -> :\n"
																							+ "ERROR:En la linea 2 -> '\n"
																							+ "ERROR:En la linea 2 -> '\n");
		
		assertEquals(analizador.analisisLexico("context Cliente def:\nlet: antiguedad = 0;"), "LEXEMA -> CONTEXT -> context\n"
																							+ "LEXEMA -> IDENTIFICADOR -> Cliente\n"
																							+ "LEXEMA -> DEFINICION -> def\n"
																							+ "LEXEMA -> DOSPUNTOS -> :\n"
																							+ "LEXEMA -> LET -> let\n"
																							+ "LEXEMA -> DOSPUNTOS -> :\n"
																							+ "LEXEMA -> IDENTIFICADOR -> antiguedad\n"
																							+ "LEXEMA -> IGUAL -> =\n"
																							+ "LEXEMA -> NUMERO -> 0\n"
																							+ "ERROR:En la linea 2 -> ;\n");
		
		
	}
	
	@Test
	public void testAnalizarLexicoAvanzado() {
		inicializar();
		assertEquals(analizador.analisisLexico("context Company inv: self.noEmployees <= 50?"), "LEXEMA -> CONTEXT -> context\n"
				 + "LEXEMA -> IDENTIFICADOR -> Company\n"
				 + "LEXEMA -> INVARIANTE -> inv\n"
				 + "LEXEMA -> DOSPUNTOS -> :\n"
				 + "LEXEMA -> SELF -> self\n"
				 + "LEXEMA -> ATRIBUTO -> .noEmployees\n"
				 + "LEXEMA -> MENOR_IGUAL -> <=\n"
				 + "LEXEMA -> NUMERO -> 50\n"
				 + "ERROR:En la linea 1 -> ?\n");

		assertEquals(analizador.analisisLexico("context Company inv: self.noEmployees <= 50"), "LEXEMA -> CONTEXT -> context\n"
							+ "LEXEMA -> IDENTIFICADOR -> Company\n"
							+ "LEXEMA -> INVARIANTE -> inv\n"
							+ "LEXEMA -> DOSPUNTOS -> :\n"
							+ "LEXEMA -> SELF -> self\n"
							+ "LEXEMA -> ATRIBUTO -> .noEmployees\n"
							+ "LEXEMA -> MENOR_IGUAL -> <=\n"
							+ "LEXEMA -> NUMERO -> 50\n");
		
		assertEquals(analizador.analisisLexico("context Company inv: self.noEmployees <= 50"), "LEXEMA -> CONTEXT -> context\n"
							+ "LEXEMA -> IDENTIFICADOR -> Company\n"
							+ "LEXEMA -> INVARIANTE -> inv\n"
							+ "LEXEMA -> DOSPUNTOS -> :\n"
							+ "LEXEMA -> SELF -> self\n"
							+ "LEXEMA -> ATRIBUTO -> .noEmployees\n"
							+ "LEXEMA -> MENOR_IGUAL -> <=\n"
							+ "LEXEMA -> NUMERO -> 50\n");
		
		assertEquals(analizador.analisisLexico("Context c: Company inv SME:  c.noEmployees <= 50"),  "LEXEMA -> CONTEXT -> Context\n"
								+ "LEXEMA -> IDENTIFICADOR -> c\n"
								+ "LEXEMA -> DOSPUNTOS -> :\n"
								+ "LEXEMA -> IDENTIFICADOR -> Company\n"
								+ "LEXEMA -> INVARIANTE -> inv\n"
								+ "LEXEMA -> IDENTIFICADOR -> SME\n"
								+ "LEXEMA -> DOSPUNTOS -> :\n"
								+ "LEXEMA -> IDENTIFICADOR -> c\n"
								+ "LEXEMA -> ATRIBUTO -> .noEmployees\n"
								+ "LEXEMA -> MENOR_IGUAL -> <=\n"
								+ "LEXEMA -> NUMERO -> 50\n");
		
		assertEquals(analizador.analisisLexico("context Company inv: self.stockPrice() > 0"),  "LEXEMA -> CONTEXT -> context\n"
							+ "LEXEMA -> IDENTIFICADOR -> Company\n"
							+ "LEXEMA -> INVARIANTE -> inv\n"
							+ "LEXEMA -> DOSPUNTOS -> :\n"
							+ "LEXEMA -> SELF -> self\n"
							+ "LEXEMA -> METODO -> .stockPrice()\n"
							+ "LEXEMA -> MAYOR -> >\n"
							+ "LEXEMA -> NUMERO -> 0\n");

		assertEquals(analizador.analisisLexico("context Banco inv: selft.cuentas -> select(c: Cuenta | c.saldo>0) -> notEmpty())"),     "LEXEMA -> CONTEXT -> context\n"
				+ "LEXEMA -> IDENTIFICADOR -> Banco\n"
				+ "LEXEMA -> INVARIANTE -> inv\n"
				+ "LEXEMA -> DOSPUNTOS -> :\n"
				+ "LEXEMA -> IDENTIFICADOR -> selft\n"
				+ "LEXEMA -> ATRIBUTO -> .cuentas\n"
				+ "LEXEMA -> FLECHA -> ->\n"
				+ "LEXEMA -> METODO -> select(\n"
				+ "LEXEMA -> IDENTIFICADOR -> c\n"
				+ "LEXEMA -> DOSPUNTOS -> :\n"
				+ "LEXEMA -> IDENTIFICADOR -> Cuenta\n"
				+ "LEXEMA -> O -> |\n"
				+ "LEXEMA -> IDENTIFICADOR -> c\n"
				+ "LEXEMA -> ATRIBUTO -> .saldo\n"
				+ "LEXEMA -> MAYOR -> >\n"
				+ "LEXEMA -> NUMERO -> 0\n"
				+ "LEXEMA -> PARENTESIS_DER -> )\n"
				+ "LEXEMA -> FLECHA -> ->\n"
				+ "LEXEMA -> METODO -> notEmpty(\n"
				+ "LEXEMA -> PARENTESIS_DER -> )\n"
				+ "LEXEMA -> PARENTESIS_DER -> )\n");

		assertEquals(analizador.analisisLexico("context Banco inv: self.cuentas -> select(c: Cuenta | c.saldo>0) -> notEmpty())"),    "LEXEMA -> CONTEXT -> context\n"
						+ "LEXEMA -> IDENTIFICADOR -> Banco\n"
						+ "LEXEMA -> INVARIANTE -> inv\n"
						+ "LEXEMA -> DOSPUNTOS -> :\n"
						+ "LEXEMA -> SELF -> self\n"
						+ "LEXEMA -> ATRIBUTO -> .cuentas\n"
						+ "LEXEMA -> FLECHA -> ->\n"
						+ "LEXEMA -> METODO -> select(\n"
						+ "LEXEMA -> IDENTIFICADOR -> c\n"
						+ "LEXEMA -> DOSPUNTOS -> :\n"
						+ "LEXEMA -> IDENTIFICADOR -> Cuenta\n"
						+ "LEXEMA -> O -> |\n"
						+ "LEXEMA -> IDENTIFICADOR -> c\n"
						+ "LEXEMA -> ATRIBUTO -> .saldo\n"
						+ "LEXEMA -> MAYOR -> >\n"
						+ "LEXEMA -> NUMERO -> 0\n"
						+ "LEXEMA -> PARENTESIS_DER -> )\n"
						+ "LEXEMA -> FLECHA -> ->\n"
						+ "LEXEMA -> METODO -> notEmpty(\n"
						+ "LEXEMA -> PARENTESIS_DER -> )\n"
						+ "LEXEMA -> PARENTESIS_DER -> )\n");
		
		
		assertEquals(analizador.analisisLexico("context Cliente def: let: tieneCuenta : Boolean = self.cuentas-> notEmpty()"),   "LEXEMA -> CONTEXT -> context\n"
					+ "LEXEMA -> IDENTIFICADOR -> Cliente\n"
					+ "LEXEMA -> DEFINICION -> def\n"
					+ "LEXEMA -> DOSPUNTOS -> :\n"
					+ "LEXEMA -> LET -> let\n"
					+ "LEXEMA -> DOSPUNTOS -> :\n"
					+ "LEXEMA -> IDENTIFICADOR -> tieneCuenta\n"
					+ "LEXEMA -> DOSPUNTOS -> :\n"
					+ "LEXEMA -> BOOLEAN -> Boolean\n"
					+ "LEXEMA -> IGUAL -> =\n"
					+ "LEXEMA -> SELF -> self\n"
					+ "LEXEMA -> ATRIBUTO -> .cuentas\n"
					+ "LEXEMA -> FLECHA -> ->\n"
					+ "LEXEMA -> METODO -> notEmpty(\n"
					+ "LEXEMA -> PARENTESIS_DER -> )\n");
		
		assertEquals(analizador.analisisLexico("context Cliente def: let: tieneCuenta : Boolean = self.cuentas()-> notEmpty()"),   "LEXEMA -> CONTEXT -> context\n"
					+ "LEXEMA -> IDENTIFICADOR -> Cliente\n"
					+ "LEXEMA -> DEFINICION -> def\n"
					+ "LEXEMA -> DOSPUNTOS -> :\n"
					+ "LEXEMA -> LET -> let\n"
					+ "LEXEMA -> DOSPUNTOS -> :\n"
					+ "LEXEMA -> IDENTIFICADOR -> tieneCuenta\n"
					+ "LEXEMA -> DOSPUNTOS -> :\n"
					+ "LEXEMA -> BOOLEAN -> Boolean\n"
					+ "LEXEMA -> IGUAL -> =\n"
					+ "LEXEMA -> SELF -> self\n"
					+ "LEXEMA -> METODO -> .cuentas()\n"
					+ "LEXEMA -> FLECHA -> ->\n"
					+ "LEXEMA -> METODO -> notEmpty(\n"
					+ "LEXEMA -> PARENTESIS_DER -> )\n");
		
		assertEquals(analizador.analisisLexico("context Banco inv: self.cuentas -> select(c | c.saldo>0) -> notEmpty()"),    "LEXEMA -> CONTEXT -> context\n"
			+ "LEXEMA -> IDENTIFICADOR -> Banco\n"
			+ "LEXEMA -> INVARIANTE -> inv\n"
			+ "LEXEMA -> DOSPUNTOS -> :\n"
			+ "LEXEMA -> SELF -> self\n"
			+ "LEXEMA -> ATRIBUTO -> .cuentas\n"
			+ "LEXEMA -> FLECHA -> ->\n"
			+ "LEXEMA -> METODO -> select(\n"
			+ "LEXEMA -> IDENTIFICADOR -> c\n"
			+ "LEXEMA -> O -> |\n"
			+ "LEXEMA -> IDENTIFICADOR -> c\n"
			+ "LEXEMA -> ATRIBUTO -> .saldo\n"
			+ "LEXEMA -> MAYOR -> >\n"
			+ "LEXEMA -> NUMERO -> 0\n"
			+ "LEXEMA -> PARENTESIS_DER -> )\n"
			+ "LEXEMA -> FLECHA -> ->\n"
			+ "LEXEMA -> METODO -> notEmpty(\n"
			+ "LEXEMA -> PARENTESIS_DER -> )\n");
		
		
		
		assertEquals(analizador.analisisLexico("context Cuenta:depositar(cantidad: Integer): Integer post: saldo = self.saldo@pre + cant '"),   "LEXEMA -> CONTEXT -> context\n"
									+ "LEXEMA -> IDENTIFICADOR -> Cuenta\n"
									+ "LEXEMA -> DOSPUNTOS -> :\n"
									+ "LEXEMA -> METODO -> depositar(\n"
									+ "LEXEMA -> IDENTIFICADOR -> cantidad\n"
									+ "LEXEMA -> DOSPUNTOS -> :\n"
									+ "LEXEMA -> INTEGER -> Integer\n"
									+ "LEXEMA -> PARENTESIS_DER -> )\n"
									+ "LEXEMA -> DOSPUNTOS -> :\n"
									+ "LEXEMA -> INTEGER -> Integer\n"
									+ "LEXEMA -> POSTCONDICION -> post\n"
									+ "LEXEMA -> DOSPUNTOS -> :\n"
									+ "LEXEMA -> IDENTIFICADOR -> saldo\n"
									+ "LEXEMA -> IGUAL -> =\n"
									+ "LEXEMA -> SELF -> self\n"
									+ "LEXEMA -> ATRIBUTO -> .saldo\n"
									+ "LEXEMA -> VALORPROPIEDAD -> @pre\n"
									+ "LEXEMA -> MAS -> +\n"
									+ "LEXEMA -> IDENTIFICADOR -> cant\n"
									+ "ERROR:En la linea 1 -> '\n");
		
		
		assertEquals(analizador.analisisLexico("context Cuenta:depositar(cantidad: Integer): Integer post: saldo = self.saldo@pre + cant"),   "LEXEMA -> CONTEXT -> context\n"
								+ "LEXEMA -> IDENTIFICADOR -> Cuenta\n"
								+ "LEXEMA -> DOSPUNTOS -> :\n"
								+ "LEXEMA -> METODO -> depositar(\n"
								+ "LEXEMA -> IDENTIFICADOR -> cantidad\n"
								+ "LEXEMA -> DOSPUNTOS -> :\n"
								+ "LEXEMA -> INTEGER -> Integer\n"
								+ "LEXEMA -> PARENTESIS_DER -> )\n"
								+ "LEXEMA -> DOSPUNTOS -> :\n"
								+ "LEXEMA -> INTEGER -> Integer\n"
								+ "LEXEMA -> POSTCONDICION -> post\n"
								+ "LEXEMA -> DOSPUNTOS -> :\n"
								+ "LEXEMA -> IDENTIFICADOR -> saldo\n"
								+ "LEXEMA -> IGUAL -> =\n"
								+ "LEXEMA -> SELF -> self\n"
								+ "LEXEMA -> ATRIBUTO -> .saldo\n"
								+ "LEXEMA -> VALORPROPIEDAD -> @pre\n"
								+ "LEXEMA -> MAS -> +\n"
								+ "LEXEMA -> IDENTIFICADOR -> cant\n");
		
		assertEquals(analizador.analisisLexico("context Cuenta:depositar(cantidad: Integer): Integer pre : cantidad > 0"),    "LEXEMA -> CONTEXT -> context\n"
				+ "LEXEMA -> IDENTIFICADOR -> Cuenta\n"
				+ "LEXEMA -> DOSPUNTOS -> :\n"
				+ "LEXEMA -> METODO -> depositar(\n"
				+ "LEXEMA -> IDENTIFICADOR -> cantidad\n"
				+ "LEXEMA -> DOSPUNTOS -> :\n"
				+ "LEXEMA -> INTEGER -> Integer\n"
				+ "LEXEMA -> PARENTESIS_DER -> )\n"
				+ "LEXEMA -> DOSPUNTOS -> :\n"
				+ "LEXEMA -> INTEGER -> Integer\n"
				+ "LEXEMA -> PRECONDICION -> pre\n"
				+ "LEXEMA -> DOSPUNTOS -> :\n"
				+ "LEXEMA -> IDENTIFICADOR -> cantidad\n"
				+ "LEXEMA -> MAYOR -> >\n"
				+ "LEXEMA -> NUMERO -> 0\n");
		
		assertEquals(analizador.analisisLexico("context Cuenta:depositar(': Integer): Integer pre : cantidad > 0"),    "LEXEMA -> CONTEXT -> context\n"
								+ "LEXEMA -> IDENTIFICADOR -> Cuenta\n"
								+ "LEXEMA -> DOSPUNTOS -> :\n"
								+ "LEXEMA -> METODO -> depositar(\n"
								+ "ERROR:En la linea 1 -> '\n"
								+ "LEXEMA -> DOSPUNTOS -> :\n"
								+ "LEXEMA -> INTEGER -> Integer\n"
								+ "LEXEMA -> PARENTESIS_DER -> )\n"
								+ "LEXEMA -> DOSPUNTOS -> :\n"
								+ "LEXEMA -> INTEGER -> Integer\n"
								+ "LEXEMA -> PRECONDICION -> pre\n"
								+ "LEXEMA -> DOSPUNTOS -> :\n"
								+ "LEXEMA -> IDENTIFICADOR -> cantidad\n"
								+ "LEXEMA -> MAYOR -> >\n"
								+ "LEXEMA -> NUMERO -> 0\n");
		
		assertEquals(analizador.analisisLexico("context Cuenta:depositar(cantidad: Integer): Integer pre : cantidad > 0post : saldo = self.saldo@pre + cant"),      "LEXEMA -> CONTEXT -> context\n"
							+ "LEXEMA -> IDENTIFICADOR -> Cuenta\n"
							+ "LEXEMA -> DOSPUNTOS -> :\n"
							+ "LEXEMA -> METODO -> depositar(\n"
							+ "LEXEMA -> IDENTIFICADOR -> cantidad\n"
							+ "LEXEMA -> DOSPUNTOS -> :\n"
							+ "LEXEMA -> INTEGER -> Integer\n"
							+ "LEXEMA -> PARENTESIS_DER -> )\n"
							+ "LEXEMA -> DOSPUNTOS -> :\n"
							+ "LEXEMA -> INTEGER -> Integer\n"
							+ "LEXEMA -> PRECONDICION -> pre\n"
							+ "LEXEMA -> DOSPUNTOS -> :\n"
							+ "LEXEMA -> IDENTIFICADOR -> cantidad\n"
							+ "LEXEMA -> MAYOR -> >\n"
							+ "LEXEMA -> NUMERO -> 0\n"
							+ "LEXEMA -> POSTCONDICION -> post\n"
							+ "LEXEMA -> DOSPUNTOS -> :\n"
							+ "LEXEMA -> IDENTIFICADOR -> saldo\n"
							+ "LEXEMA -> IGUAL -> =\n"
							+ "LEXEMA -> SELF -> self\n"
							+ "LEXEMA -> ATRIBUTO -> .saldo\n"
							+ "LEXEMA -> VALORPROPIEDAD -> @pre\n"
							+ "LEXEMA -> MAS -> +\n"
							+ "LEXEMA -> IDENTIFICADOR -> cant\n");
	}
	
	@Test
	public void testAnalizarLexicoAvanzadoVariasLineas() {
		inicializar();
		assertEquals(analizador.analisisLexico("context Banco inv:\r\nselft.cuentas -> select(c: Cuenta | c.saldo>0) -> notEmpty())"),    "LEXEMA -> CONTEXT -> context\n"
																																		+ "LEXEMA -> IDENTIFICADOR -> Banco\n"
																																		+ "LEXEMA -> INVARIANTE -> inv\n"
																																		+ "LEXEMA -> DOSPUNTOS -> :\n"
																																		+ "LEXEMA -> IDENTIFICADOR -> selft\n"
																																		+ "LEXEMA -> ATRIBUTO -> .cuentas\n"
																																		+ "LEXEMA -> FLECHA -> ->\n"
																																		+ "LEXEMA -> METODO -> select(\n"
																																		+ "LEXEMA -> IDENTIFICADOR -> c\n"
																																		+ "LEXEMA -> DOSPUNTOS -> :\n"
																																		+ "LEXEMA -> IDENTIFICADOR -> Cuenta\n"
																																		+ "LEXEMA -> O -> |\n"
																																		+ "LEXEMA -> IDENTIFICADOR -> c\n"
																																		+ "LEXEMA -> ATRIBUTO -> .saldo\n"
																																		+ "LEXEMA -> MAYOR -> >\n"
																																		+ "LEXEMA -> NUMERO -> 0\n"
																																		+ "LEXEMA -> PARENTESIS_DER -> )\n"
																																		+ "LEXEMA -> FLECHA -> ->\n"
																																		+ "LEXEMA -> METODO -> notEmpty(\n"
																																		+ "LEXEMA -> PARENTESIS_DER -> )\n"
																																		+ "LEXEMA -> PARENTESIS_DER -> )\n");
	
		assertEquals(analizador.analisisLexico("context Banco inv:\r\nself.cuentas -> select(c: Cuenta | c.saldo>0) -> notEmpty())"),     "LEXEMA -> CONTEXT -> context\n"
																																		+ "LEXEMA -> IDENTIFICADOR -> Banco\n"
																																		+ "LEXEMA -> INVARIANTE -> inv\n"
																																		+ "LEXEMA -> DOSPUNTOS -> :\n"
																																		+ "LEXEMA -> SELF -> self\n"
																																		+ "LEXEMA -> ATRIBUTO -> .cuentas\n"
																																		+ "LEXEMA -> FLECHA -> ->\n"
																																		+ "LEXEMA -> METODO -> select(\n"
																																		+ "LEXEMA -> IDENTIFICADOR -> c\n"
																																		+ "LEXEMA -> DOSPUNTOS -> :\n"
																																		+ "LEXEMA -> IDENTIFICADOR -> Cuenta\n"
																																		+ "LEXEMA -> O -> |\n"
																																		+ "LEXEMA -> IDENTIFICADOR -> c\n"
																																		+ "LEXEMA -> ATRIBUTO -> .saldo\n"
																																		+ "LEXEMA -> MAYOR -> >\n"
																																		+ "LEXEMA -> NUMERO -> 0\n"
																																		+ "LEXEMA -> PARENTESIS_DER -> )\n"
																																		+ "LEXEMA -> FLECHA -> ->\n"
																																		+ "LEXEMA -> METODO -> notEmpty(\n"
																																		+ "LEXEMA -> PARENTESIS_DER -> )\n"
																																		+ "LEXEMA -> PARENTESIS_DER -> )\n");

		
		assertEquals(analizador.analisisLexico("context Cliente def:\n"+ "let: tieneCuenta : Boolean = self.cuentas-> notEmpty()"),   "LEXEMA -> CONTEXT -> context\n"
																																	+ "LEXEMA -> IDENTIFICADOR -> Cliente\n"
																																	+ "LEXEMA -> DEFINICION -> def\n"
																																	+ "LEXEMA -> DOSPUNTOS -> :\n"
																																	+ "LEXEMA -> LET -> let\n"
																																	+ "LEXEMA -> DOSPUNTOS -> :\n"
																																	+ "LEXEMA -> IDENTIFICADOR -> tieneCuenta\n"
																																	+ "LEXEMA -> DOSPUNTOS -> :\n"
																																	+ "LEXEMA -> BOOLEAN -> Boolean\n"
																																	+ "LEXEMA -> IGUAL -> =\n"
																																	+ "LEXEMA -> SELF -> self\n"
																																	+ "LEXEMA -> ATRIBUTO -> .cuentas\n"
																																	+ "LEXEMA -> FLECHA -> ->\n"
																																	+ "LEXEMA -> METODO -> notEmpty(\n"
																																	+ "LEXEMA -> PARENTESIS_DER -> )\n");
		
		assertEquals(analizador.analisisLexico("context Cliente def:\n"+ "let: tieneCuenta : Boolean = self.cuentas()-> notEmpty()"),   "LEXEMA -> CONTEXT -> context\n"
																																	+ "LEXEMA -> IDENTIFICADOR -> Cliente\n"
																																	+ "LEXEMA -> DEFINICION -> def\n"
																																	+ "LEXEMA -> DOSPUNTOS -> :\n"
																																	+ "LEXEMA -> LET -> let\n"
																																	+ "LEXEMA -> DOSPUNTOS -> :\n"
																																	+ "LEXEMA -> IDENTIFICADOR -> tieneCuenta\n"
																																	+ "LEXEMA -> DOSPUNTOS -> :\n"
																																	+ "LEXEMA -> BOOLEAN -> Boolean\n"
																																	+ "LEXEMA -> IGUAL -> =\n"
																																	+ "LEXEMA -> SELF -> self\n"
																																	+ "LEXEMA -> METODO -> .cuentas()\n"
																																	+ "LEXEMA -> FLECHA -> ->\n"
																																	+ "LEXEMA -> METODO -> notEmpty(\n"
																																	+ "LEXEMA -> PARENTESIS_DER -> )\n");
		
		assertEquals(analizador.analisisLexico("context Banco inv:\nself.cuentas -> select(c | c.saldo>0) -> notEmpty()"),    "LEXEMA -> CONTEXT -> context\n"
																															+ "LEXEMA -> IDENTIFICADOR -> Banco\n"
																															+ "LEXEMA -> INVARIANTE -> inv\n"
																															+ "LEXEMA -> DOSPUNTOS -> :\n"
																															+ "LEXEMA -> SELF -> self\n"
																															+ "LEXEMA -> ATRIBUTO -> .cuentas\n"
																															+ "LEXEMA -> FLECHA -> ->\n"
																															+ "LEXEMA -> METODO -> select(\n"
																															+ "LEXEMA -> IDENTIFICADOR -> c\n"
																															+ "LEXEMA -> O -> |\n"
																															+ "LEXEMA -> IDENTIFICADOR -> c\n"
																															+ "LEXEMA -> ATRIBUTO -> .saldo\n"
																															+ "LEXEMA -> MAYOR -> >\n"
																															+ "LEXEMA -> NUMERO -> 0\n"
																															+ "LEXEMA -> PARENTESIS_DER -> )\n"
																															+ "LEXEMA -> FLECHA -> ->\n"
																															+ "LEXEMA -> METODO -> notEmpty(\n"
																															+ "LEXEMA -> PARENTESIS_DER -> )\n");
		


		assertEquals(analizador.analisisLexico("context Cuenta:depositar(cantidad: Integer): Integer\r\npost: saldo = self.saldo@pre + cant\n'"),   "LEXEMA -> CONTEXT -> context\n"
																																					+ "LEXEMA -> IDENTIFICADOR -> Cuenta\n"
																																					+ "LEXEMA -> DOSPUNTOS -> :\n"
																																					+ "LEXEMA -> METODO -> depositar(\n"
																																					+ "LEXEMA -> IDENTIFICADOR -> cantidad\n"
																																					+ "LEXEMA -> DOSPUNTOS -> :\n"
																																					+ "LEXEMA -> INTEGER -> Integer\n"
																																					+ "LEXEMA -> PARENTESIS_DER -> )\n"
																																					+ "LEXEMA -> DOSPUNTOS -> :\n"
																																					+ "LEXEMA -> INTEGER -> Integer\n"
																																					+ "LEXEMA -> POSTCONDICION -> post\n"
																																					+ "LEXEMA -> DOSPUNTOS -> :\n"
																																					+ "LEXEMA -> IDENTIFICADOR -> saldo\n"
																																					+ "LEXEMA -> IGUAL -> =\n"
																																					+ "LEXEMA -> SELF -> self\n"
																																					+ "LEXEMA -> ATRIBUTO -> .saldo\n"
																																					+ "LEXEMA -> VALORPROPIEDAD -> @pre\n"
																																					+ "LEXEMA -> MAS -> +\n"
																																					+ "LEXEMA -> IDENTIFICADOR -> cant\n"
																																					+ "ERROR:En la linea 3 -> '\n");
		
		
		assertEquals(analizador.analisisLexico("context Cuenta:depositar(cantidad: Integer): Integer\r\npost: saldo = self.saldo@pre + cant"),   "LEXEMA -> CONTEXT -> context\n"
																																				+ "LEXEMA -> IDENTIFICADOR -> Cuenta\n"
																																				+ "LEXEMA -> DOSPUNTOS -> :\n"
																																				+ "LEXEMA -> METODO -> depositar(\n"
																																				+ "LEXEMA -> IDENTIFICADOR -> cantidad\n"
																																				+ "LEXEMA -> DOSPUNTOS -> :\n"
																																				+ "LEXEMA -> INTEGER -> Integer\n"
																																				+ "LEXEMA -> PARENTESIS_DER -> )\n"
																																				+ "LEXEMA -> DOSPUNTOS -> :\n"
																																				+ "LEXEMA -> INTEGER -> Integer\n"
																																				+ "LEXEMA -> POSTCONDICION -> post\n"
																																				+ "LEXEMA -> DOSPUNTOS -> :\n"
																																				+ "LEXEMA -> IDENTIFICADOR -> saldo\n"
																																				+ "LEXEMA -> IGUAL -> =\n"
																																				+ "LEXEMA -> SELF -> self\n"
																																				+ "LEXEMA -> ATRIBUTO -> .saldo\n"
																																				+ "LEXEMA -> VALORPROPIEDAD -> @pre\n"
																																				+ "LEXEMA -> MAS -> +\n"
																																				+ "LEXEMA -> IDENTIFICADOR -> cant\n");
		
		assertEquals(analizador.analisisLexico("context Cuenta:depositar(cantidad: Integer): Integer\r\npre : cantidad > 0"),    "LEXEMA -> CONTEXT -> context\n"
																																+ "LEXEMA -> IDENTIFICADOR -> Cuenta\n"
																																+ "LEXEMA -> DOSPUNTOS -> :\n"
																																+ "LEXEMA -> METODO -> depositar(\n"
																																+ "LEXEMA -> IDENTIFICADOR -> cantidad\n"
																																+ "LEXEMA -> DOSPUNTOS -> :\n"
																																+ "LEXEMA -> INTEGER -> Integer\n"
																																+ "LEXEMA -> PARENTESIS_DER -> )\n"
																																+ "LEXEMA -> DOSPUNTOS -> :\n"
																																+ "LEXEMA -> INTEGER -> Integer\n"
																																+ "LEXEMA -> PRECONDICION -> pre\n"
																																+ "LEXEMA -> DOSPUNTOS -> :\n"
																																+ "LEXEMA -> IDENTIFICADOR -> cantidad\n"
																																+ "LEXEMA -> MAYOR -> >\n"
																																+ "LEXEMA -> NUMERO -> 0\n");
		
		assertEquals(analizador.analisisLexico("context Cuenta:depositar(': Integer): Integer\r\npre : cantidad > 0"),    "LEXEMA -> CONTEXT -> context\n"
																														+ "LEXEMA -> IDENTIFICADOR -> Cuenta\n"
																														+ "LEXEMA -> DOSPUNTOS -> :\n"
																														+ "LEXEMA -> METODO -> depositar(\n"
																														+ "ERROR:En la linea 1 -> '\n"
																														+ "LEXEMA -> DOSPUNTOS -> :\n"
																														+ "LEXEMA -> INTEGER -> Integer\n"
																														+ "LEXEMA -> PARENTESIS_DER -> )\n"
																														+ "LEXEMA -> DOSPUNTOS -> :\n"
																														+ "LEXEMA -> INTEGER -> Integer\n"
																														+ "LEXEMA -> PRECONDICION -> pre\n"
																														+ "LEXEMA -> DOSPUNTOS -> :\n"
																														+ "LEXEMA -> IDENTIFICADOR -> cantidad\n"
																														+ "LEXEMA -> MAYOR -> >\n"
																														+ "LEXEMA -> NUMERO -> 0\n");
		
		assertEquals(analizador.analisisLexico("context Cuenta:depositar(cantidad: Integer): Integer\r\npre : cantidad > 0\r"
				+ "\npost : saldo = self.saldo@pre + cant"),      "LEXEMA -> CONTEXT -> context\n"
																+ "LEXEMA -> IDENTIFICADOR -> Cuenta\n"
																+ "LEXEMA -> DOSPUNTOS -> :\n"
																+ "LEXEMA -> METODO -> depositar(\n"
																+ "LEXEMA -> IDENTIFICADOR -> cantidad\n"
																+ "LEXEMA -> DOSPUNTOS -> :\n"
																+ "LEXEMA -> INTEGER -> Integer\n"
																+ "LEXEMA -> PARENTESIS_DER -> )\n"
																+ "LEXEMA -> DOSPUNTOS -> :\n"
																+ "LEXEMA -> INTEGER -> Integer\n"
																+ "LEXEMA -> PRECONDICION -> pre\n"
																+ "LEXEMA -> DOSPUNTOS -> :\n"
																+ "LEXEMA -> IDENTIFICADOR -> cantidad\n"
																+ "LEXEMA -> MAYOR -> >\n"
																+ "LEXEMA -> NUMERO -> 0\n"
																+ "LEXEMA -> POSTCONDICION -> post\n"
																+ "LEXEMA -> DOSPUNTOS -> :\n"
																+ "LEXEMA -> IDENTIFICADOR -> saldo\n"
																+ "LEXEMA -> IGUAL -> =\n"
																+ "LEXEMA -> SELF -> self\n"
																+ "LEXEMA -> ATRIBUTO -> .saldo\n"
																+ "LEXEMA -> VALORPROPIEDAD -> @pre\n"
																+ "LEXEMA -> MAS -> +\n"
																+ "LEXEMA -> IDENTIFICADOR -> cant\n");
		
	}

}
