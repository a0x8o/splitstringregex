import java.lang.*;
import java.util.*;
import java.util.regex.*;

// Output:
//   java -cp .:$CLASSPATH SplitStringRegex
//   Return: ["Hello World", marker, coffee, "Headphones eraser"]
//   ...
//   java -cp .:$CLASSPATH SplitStringRegex "Welcome to \"Thunder Dome\" Max"
//   Return: ["Hello World", marker, coffee, "Headphones eraser"]
//   ...
//   Return: [Welcome, to, "Thunder Dome", Max]
//

public class SplitStringRegex {

		public SplitStringRegex() {
		}

		public static void main(String args[]) {
		    System.out.println("SplitString - Regular Expression Solution");
            System.out.println("=========================================");
            String input = "\"Hello World\" marker coffee \"Headphones eraser\"";
		    System.out.println("Return: " + splitStringToArray(input));
            String input1 = "!cmd 45 90 \"An argument\" Another AndAnother \"Another one in quotes\"";
                System.out.println("Return: " + splitStringToArray(input1).toString());
                String input2 = "'foo bar' c;\"baz,blurb\" d;\"quux,syzygy\"";
                System.out.println("Return: " + splitStringToArray(input2).toString());
                String input3 = "";
                System.out.println("Return: " + splitStringToArray(input3).toString());
                if (args != null) {
                    for (String s : args) {
                        System.out.println("Return: " + splitStringToArray(s).toString());
                    }
                }
		}

		static List<String> splitStringToArray(String input) {
		    String splitConditions = "([^\"]\\S*|\".+?\")\\s*";
		    // [^"]  -- token starting with something other than "
		    // \S*   -- followed by zero of more non-space characters
		    // |     -- or
		    // ".+?" -- a " symbol followed by non " character(s), until another "
		    List<String> list = new ArrayList<String>();
		    Matcher m = Pattern.compile(splitConditions).matcher(input);
		    while (m.find())
			list.add(m.group(1));

		    return list;
		}
}
