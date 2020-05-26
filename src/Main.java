import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        try {
            CharStream input = CharStreams.fromFileName("C:\\Users\\Кристина\\IdeaProjects\\ANTLRCW\\src\\test.ispr");
              System.out.println(input);
            isprLexer lexer = new isprLexer(input);
            isprParser parser = new isprParser(new CommonTokenStream(lexer));
           // parser.addParseListener(new MyListener());
            ParseTree tree = parser.program();
            MyVisitor visitor = new MyVisitor();
            visitor.visit(tree);
        } catch (IIOException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}