package lexicoOCL;

import java.util.ArrayList;
import java.util.List;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;

public class KeywordStyledDocument extends DefaultStyledDocument  {
    private static final long serialVersionUID = 1L;
    private Style _defaultStyle;
    private Style _cwStyle;
    private Style _cwStyle2;

    public KeywordStyledDocument(Style defaultStyle, Style cwStyle, Style cwStyle2) {
        _defaultStyle =  defaultStyle;
        _cwStyle = cwStyle;
        _cwStyle2 = cwStyle2;
    }

     public void insertString (int offset, String str, AttributeSet a) throws BadLocationException {
         super.insertString(offset, str, a);
         refreshDocument();
     }

     public void remove (int offs, int len) throws BadLocationException {
         super.remove(offs, len);
         refreshDocument();
     }

     private synchronized void refreshDocument() throws BadLocationException {
         String text = getText(0, getLength());
         final List<HiliteWord> list = processWords(text);

         setCharacterAttributes(0, text.length(), _defaultStyle, true);   
         for(HiliteWord word : list) {
             int p0 = word._position;
             if (magenta(word._word) == true) {
                 setCharacterAttributes(p0, word._word.length(), _cwStyle, true);
             }	 else {
                 setCharacterAttributes(p0, word._word.length(), _cwStyle2, true);
             }
         }
     }       

     private static  List<HiliteWord> processWords(String content) {
         content += " ";
         List<HiliteWord> hiliteWords = new ArrayList<HiliteWord>();
         int lastWhitespacePosition = 0;
         String word = "";
         char[] data = content.toCharArray();

         for(int index=0; index < data.length; index++) {
             char ch = data[index];
             String s=String.valueOf(ch);  
             boolean reservada = isReservedWord(s);
             if(!(Character.isLetter(ch) || Character.isDigit(ch) || ch == '_' || reservada == true || ch == ':')) {
                 lastWhitespacePosition = index;
                 if(word.length() > 0) {
                     if(isReservedWord(word)) {
                         hiliteWords.add(new HiliteWord(word,(lastWhitespacePosition - word.length())));
                     }
                     word="";
                 }
             }
             else {
                 word += ch;
             }
        }
        return hiliteWords;
     }

     private static final boolean isReservedWord(String word) {
         return(word.toUpperCase().trim().equals("INV") ||
        		word.toUpperCase().trim().equals("INV:") || 
          		word.toUpperCase().trim().equals("PRE:") || 
          		word.toUpperCase().trim().equals("SELF") || 
          		word.toUpperCase().trim().equals("POST:") || 
          		word.toUpperCase().trim().equals("INIT:") || 
          		word.toUpperCase().trim().equals("DEF:") || 
          		word.toUpperCase().trim().equals("LET:") || 
                 word.toUpperCase().trim().equals("CONTEXT") ||
          		word.toUpperCase().trim().equals("::") ||
          		word.toUpperCase().trim().equals(">") || 
          		word.toUpperCase().trim().equals("<") || 
          		word.toUpperCase().trim().equals(">=") || 
          		word.toUpperCase().trim().equals("<=") || 
          		word.toUpperCase().trim().equals("=") || 
          		word.toUpperCase().trim().equals("<>") || 
          		word.toUpperCase().trim().equals("AND") || 
          		word.toUpperCase().trim().equals("OR") || 
          		word.toUpperCase().trim().equals("|") || 
          		word.toUpperCase().trim().equals("+") || 
          		word.toUpperCase().trim().equals("-") || 
          		word.toUpperCase().trim().equals("*") || 
          		word.toUpperCase().trim().equals("@") || 
          		word.toUpperCase().trim().equals("->") || 
          		word.toUpperCase().trim().equals("XOR") || 
          		word.toUpperCase().trim().equals("MOD") || 
          		word.toUpperCase().trim().equals("DIV") || 
          		word.toUpperCase().trim().equals("ABS") || 
          		word.toUpperCase().trim().equals("MAX") || 
          		word.toUpperCase().trim().equals("MIN") || 
          		word.toUpperCase().trim().equals("/") || 
          		word.toUpperCase().trim().equals("ROUND") || 
          		word.toUpperCase().trim().equals("FLOUR") || 
          		word.toUpperCase().trim().equals("SIZE") || 
          		word.toUpperCase().trim().equals("CONCAT") || 
          		word.toUpperCase().trim().equals("TOLOWER") || 
          		word.toUpperCase().trim().equals("TOUPPER") || 
          		word.toUpperCase().trim().equals("SUBSTRING"));
    }
     
     private static final boolean magenta(String word) {
         return(word.toUpperCase().trim().equals("INV") || 
        		word.toUpperCase().trim().equals("INV:") || 
           		word.toUpperCase().trim().equals("PRE:") || 
           		word.toUpperCase().trim().equals("SELF") || 
           		word.toUpperCase().trim().equals("POST:") || 
           		word.toUpperCase().trim().equals("INIT:") || 
           		word.toUpperCase().trim().equals("DEF:") || 
           		word.toUpperCase().trim().equals("LET:") || 
                word.toUpperCase().trim().equals("CONTEXT"));   
    }


}