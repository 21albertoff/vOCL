package lexicoOCL;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import java_cup.runtime.Symbol;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtEntrada2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/imagenes/favicon.png")));
		setForeground(SystemColor.menu);
		setBackground(SystemColor.menu);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1109, 718);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(686, 168, 375, 231);
		contentPane.add(scrollPane);
		
		JTextArea txtResultadoLexico = new JTextArea();
		scrollPane.setViewportView(txtResultadoLexico);
		txtResultadoLexico.setEditable(false);
		txtResultadoLexico.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JTextArea txtResultadoSintactico = new JTextArea();
		txtResultadoSintactico.setEditable(false);
		txtResultadoSintactico.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtResultadoSintactico.setBounds(25, 479, 586, 115);
		contentPane.add(txtResultadoSintactico);
		
	
		//JButton logoUAL = new JButton("");		
		
        //ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource("/imagenes/01 Logotipo.png"));
        //Image imagen = icono.getImage();
        //ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(300,120,Image.SCALE_SMOOTH));
        //logoUAL.setIcon(iconoEscalado);
        //logoUAL.setBorder(null);
		//logoUAL.setForeground(SystemColor.windowBorder);
		//logoUAL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		//logoUAL.setBackground(SystemColor.menu);
		//logoUAL.setBounds(686, 449, 375, 131);
		//contentPane.add(logoUAL);
		
		JSeparator separator_Abajo = new JSeparator();
		separator_Abajo.setBounds(0, 633, 1136, 2);
		contentPane.add(separator_Abajo);
		
		JSeparator separator_Arriba = new JSeparator();
		separator_Arriba.setBounds(0, 108, 1136, 2);
		contentPane.add(separator_Arriba);
		
		JLabel lblPie = new JLabel("@2021 Alberto Fuentes - Todos los derechos reservados");
		lblPie.setForeground(Color.GRAY);
		lblPie.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPie.setBounds(343, 646, 469, 25);
		contentPane.add(lblPie);
		
		/** JButton logo = new JButton("");
		//ImageIcon iconologo = new javax.swing.ImageIcon(getClass().getResource("/imagenes/blue.png"));
	    //Image imagenlogo = iconologo.getImage();
	    //ImageIcon iconoEscaladologo = new ImageIcon (imagenlogo.getScaledInstance(200,70,Image.SCALE_SMOOTH));
	    logo.setIcon(iconoEscaladologo);
		logo.setForeground(SystemColor.menu);
		logo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		logo.setBorder(null);
		logo.setBackground(SystemColor.menu);
		logo.setBounds(470, 11, 186, 88);
		contentPane.add(logo);
		**/
		StyleContext styleContext = new StyleContext();
        Style defaultStyle = styleContext.getStyle(StyleContext.DEFAULT_STYLE);
        Style cwStyle = styleContext.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(cwStyle, Color.MAGENTA);
        StyleConstants.setBold(cwStyle, true);
        
        StyleContext styleContext2 = new StyleContext();
        Style defaultStyle2 = styleContext2.getStyle(StyleContext.DEFAULT_STYLE);
        Style cwStyle2 = styleContext2.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(cwStyle2, Color.BLUE);
        StyleConstants.setBold(cwStyle2, true);
        
        
        final JTextPane textPane = new JTextPane(new KeywordStyledDocument(defaultStyle, cwStyle, cwStyle2));
        textPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
        
        JScrollPane scrollPane_1 = new JScrollPane(textPane);
        scrollPane_1.setBounds(35, 168, 576, 231);
        getContentPane().add(scrollPane_1, BorderLayout.CENTER);
        contentPane.add(scrollPane_1);
        
        JTextArea txtEntrada_1 = new JTextArea();
        txtEntrada_1.setColumns(3);
        txtEntrada_1.setTabSize(3);
        scrollPane_1.setRowHeaderView(txtEntrada_1);
        txtEntrada_1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 13));
        txtEntrada_1.setText(" 1\r\n 2\r\n 3\r\n 4\r\n 5\r\n 6\r\n 7\r\n 8\r\n 9\r\n10\r\n11\r\n12\r\n13\r\n14\r\n15\r\n16\r\n17\r\n18\r\n19\r\n20\r\n21\r\n22\r\n23\r\n24\r\n25\r\n26\r\n27\r\n28\r\n29\r\n30");
        txtEntrada_1.setBackground(SystemColor.activeCaptionBorder);
        txtEntrada_1.setEditable(false);
        txtEntrada_1.setLineWrap(true);
        txtEntrada_1.setForeground(SystemColor.textInactiveText);
        
        
        JButton btnAnalizarLexico = new JButton("Analizar lexicamente");
		btnAnalizarLexico.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				File archivo = new File("archivo.txt");
				PrintWriter escribir;

				try {
					escribir = new PrintWriter(archivo);
					escribir.print(textPane.getText());
					escribir.close();
				} catch (FileNotFoundException ex) {
					Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
				}
				
				//Analizador lexico
				
				try {
					Reader lector = new BufferedReader(new FileReader("archivo.txt"));
					lexer lexer = new lexer(lector);
					String resultado = "";
					while(true) {
						Tokens tokens = lexer.yylex();
						int linea = lexer.yyline;
						if (tokens == null) {
							resultado +="\n #FIN DEL ANALISIS LEXICO#";
							txtResultadoLexico.setText(resultado);
							return;
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnCargarEntrada = new JButton("Cargar entrada");
		
		btnCargarEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				
				File archivo = new File("archivo.txt");
				FileReader fr = null;
			    BufferedReader br = null;
			    PrintWriter escribir = null;

				try {
					escribir = new PrintWriter(archivo);
			        fr = new FileReader (chooser.getSelectedFile());
			        br = new BufferedReader(fr);
			         String linea;
			         String text = "";
			         while((linea=br.readLine())!=null) {
			        	 escribir.println(linea);
			        	 text+=linea+"\n";
			        	 textPane.setText(text);
			         }
			         
				} catch(Exception e1){
			         e1.printStackTrace();
			      }finally{
			         try{                    
			            if( null != fr){   
			               fr.close();
			            } 
			            if( null != escribir){   
				              escribir.close();
				         }  
			         }catch (Exception e2){ 
			            e2.printStackTrace();
			         }
			      }
								
				
				//Analizador lexico
				try {
					Reader lector2 = new BufferedReader(new FileReader("archivo.txt"));
					lexer lexer = new lexer(lector2);
					String resultado = "";
					while(true) {
						Tokens tokens = lexer.yylex();
						int linea = lexer.yyline;
						if (tokens == null) {
							resultado +="\n #FIN DEL ANALISIS LEXICO#";
							txtResultadoLexico.setText(resultado);
							return;
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
				
		});
		
		//btnCargarEntrada.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/imgAbrir.png")));
		btnCargarEntrada.setForeground(SystemColor.windowBorder);
		btnCargarEntrada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCargarEntrada.setBackground(SystemColor.menu);
		btnCargarEntrada.setBounds(25, 121, 174, 36);
		btnCargarEntrada.setBorder(null);
		contentPane.add(btnCargarEntrada);
		
		btnAnalizarLexico.setForeground(SystemColor.text);
		//btnAnalizarLexico.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/imgLexico.png")));
		btnAnalizarLexico.setBackground(new Color(51, 102, 255));
		btnAnalizarLexico.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAnalizarLexico.setBounds(686, 121, 375, 36);
		btnAnalizarLexico.setBorder(null);
		contentPane.add(btnAnalizarLexico);
		
		
		JButton btnAnalizarSintactico = new JButton("Analizar sintacticamente");
		btnAnalizarSintactico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ST = textPane.getText();
				Sintax s = new Sintax(new lexicoOCL.LexerCup(new StringReader(ST)));				
				try {
					s.parse();
					txtResultadoSintactico.setText("Analisis realizado correctamente");
					txtResultadoSintactico.setForeground(new Color(0, 128, 0));
				} catch (Exception ex) {
					Symbol sym = s.getS();
					int Linea = sym.right +1;
					int Columna = (Linea != 1)? sym.left-1: sym.left+1;
					if (sym.value == null) {
						txtResultadoSintactico.setText("Error de sintaxis, es posible que la sentencia no este acabada.");
					} else {
						txtResultadoSintactico.setText("Error de sintaxis, Linea: "+Linea+" Posici�n: "+Columna+" Texto: \""+sym.value+"\"");
					}
					txtResultadoSintactico.setForeground(Color.red);
				}
			}
		});
		//btnAnalizarSintactico.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/imgSintactico.png")));
		btnAnalizarSintactico.setForeground(SystemColor.text);
		btnAnalizarSintactico.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAnalizarSintactico.setBackground(new Color(51, 102, 255));
		btnAnalizarSintactico.setBounds(25, 432, 586, 36);
		btnAnalizarSintactico.setBorder(null);
		
		contentPane.add(btnAnalizarSintactico);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
			}
		});
		
		
		//btnLimpiar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/imgLimpiar.png")));
		btnLimpiar.setForeground(SystemColor.windowBorder);
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpiar.setBackground(SystemColor.menu);
		btnLimpiar.setBounds(209, 121, 172, 36);
		btnLimpiar.setBorder(null);
		contentPane.add(btnLimpiar);
		
		
		
        
        
		
		
	}
}
