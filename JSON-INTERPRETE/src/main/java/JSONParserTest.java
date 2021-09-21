import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class JSONParserTest {

    public static void main(String[] args){

        try{

            String content = new Scanner(new File("jsonExample.json")).useDelimiter("\\Z").next();
            System.out.println( "JSON File:\n" + content + "\n\n");

            ANTLRInputStream input = new ANTLRInputStream( content );

            JSONLexer lexer = new JSONLexer(input);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            JSONParser parser = new JSONParser(tokens);

            ParseTree tree = parser.json();

            AST ast = new AST( tree );

            System.out.println( "ParseTree:\n" + tree.toStringTree( parser ) + "\n");
            System.out.println( "Improved ParseTree:\n" + ast.toString() );

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
