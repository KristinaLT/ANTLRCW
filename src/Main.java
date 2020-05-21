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
            CharStream input = CharStreams.fromFileName("C:\\ANTLRCW\\src\\test.ispr");
              System.out.println(input);
            isprLexer lexer = new isprLexer(input);
            isprParser parser = new isprParser(new CommonTokenStream(lexer));
            parser.addParseListener(new MyListener());
            parser.program();
            ParseTree der = parser.program();
        } catch (IIOException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}