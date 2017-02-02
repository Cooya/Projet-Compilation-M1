import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
    	final String ANSI_RESET = "\u001B[0m";
    	final String ANSI_RED = "\u001B[31m";
    	
        try {
            FileReader  myFile = new FileReader(args[0]);
            CompilerLexer myLex = new CompilerLexer(myFile);
            CompilerParser myParser = new CompilerParser(myLex);          
            try {
                myParser.parse();
                System.out.println("Parse succeeded");
            }
            catch (Exception e) {
            	System.out.println(ANSI_RED + "Line " + myLex.lineCounter + " : " + e + ANSI_RESET);
            }
        }
        catch (Exception e) {
        	System.out.println("Invalid file");
        }
    }
}