package crux;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Compiler {
    public static String studentName = "Andrew Leader";
    public static String studentID = "45136371";
    public static String uciNetID = "ableader";
    
    public static boolean release = false;
    
    public static void main(String[] args)
    {
    	if (release) {
    		releasedMain(args[0]);
    	} else {
	        for (int i=1; i<11; ++i) {
	        	String sourceFilename = String.format("tests/test%02d.crx", i);
	        	fileCompile(sourceFilename);
	        }
    	}
    }
    
    public static void releasedMain(String sourceFilename)
    {
        Scanner s = null;
        try {
            s = new Scanner(new FileReader(sourceFilename));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error accessing the source file: \"" + sourceFilename + "\"");
            System.exit(-2);
        }

        Parser p = new Parser(s);
        p.parse();
        if (p.hasError()) {
            System.out.println("Error parsing file.");
            System.out.println(p.errorReport());
            System.exit(-3);
        }
        System.out.println("Crux program successfully parsed.");

    }
        
    public static void fileCompile(String sourceFilename)
    {
    	System.out.println("outputing for " + sourceFilename);
        
        Scanner s = null;
        try {
            s = new Scanner(new FileReader(sourceFilename));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error accessing the source file: \"" + sourceFilename + "\"");
            System.exit(-2);
        }

        Parser p = new Parser(s);
        ast.DeclarationList program = p.parse();
        /*
        if (p.hasError()) {
            System.out.println("Error parsing file " + sourceFilename);
            System.out.println(p.errorReport());
            System.exit(-3);
        }
        System.out.println("Crux program successfully parsed.");
        */
        

        String outFilename = sourceFilename.replace(".crx", ".out.new");
        try {
            File outFile = new File(outFilename);
            PrintStream outStream = new PrintStream(outFile);
            if (p.hasError()) {
                outStream.println("Error parsing file.");
                outStream.println(p.errorReport());
                outStream.close();
                //System.exit(-3);
            }
            
            outStream.println("Crux Abstract Syntax Tree:");
            outStream.println(program.toString());
            outStream.println("Crux program successfully parsed.");
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error creating output file: \"" + outFilename + "\"");
            System.exit(-6);
        }
    }
}
    
