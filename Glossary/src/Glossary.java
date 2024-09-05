import components.map.Map;
import components.map.Map1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Anthony Keller
 *
 */
public final class Glossary {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Glossary() {
    }

    /**
     * Checks if the words in definitions contain other terms in glossary.
     *
     * @param glossary
     *            The map to be checked and modified if definitions contain
     *            other terms
     * @updates glossary
     * @requires <pre>
     *glossary Map.Pairs only consist of strings
     *</pre>
     * @ensures [glossary definitions contain links to other terms]
     */
    private static void createLinksToOtherTerms(Map<String, String> glossary) {
        Map<String, String> temp = glossary.newInstance();
        while (glossary.size() > 0) {
            Map.Pair<String, String> current = glossary.removeAny();
            String def = current.value();
            int index = 0;
            for (Map.Pair<String, String> tester : glossary) {
                if (def.contains(" " + tester.key() + " ")) {
                    index = def.indexOf(tester.key());
                    def = def.substring(0, index) + "<a href=\"" + tester.key()
                            + ".html\">" + tester.key() + "</a>"
                            + def.substring(index + tester.key().length());
                }
            }
            for (Map.Pair<String, String> tester : temp) {
                if (def.contains(" " + tester.key() + " ")) {
                    index = def.indexOf(tester.key());
                    def = def.substring(0, index) + "<a href=\"" + tester.key()
                            + ".html\">" + tester.key() + "</a>"
                            + def.substring(index + tester.key().length());
                }
            }
            temp.add(current.key(), def);
        }
        glossary.transferFrom(temp);
    }

    /**
     * Input text file of definitions and turn definitions into a glossary map.
     *
     * @param terms
     *            text file of terms and their definitions
     * @param glossary
     *            terms -> glossary
     * @updates glossary
     * @requires <pre>
     * terms.is_open and
     * [terms.content begins with a word or term and is followed by in the next
     * line with the following definition. Each set of terms and their definitions
     * must be separated by an empty line.]
     * </pre>
     * @ensures [glossary contains term -> definition]
     */
    private static void createMap(SimpleReader terms,
            Map<String, String> glossary) {
        String term, definition = "", current;
        while (!terms.atEOS()) {
            current = terms.nextLine();
            if (!current.equals("")) {
                term = current;
                current = terms.nextLine();
                definition = definition + current;
                while (!current.equals("")) {
                    current = terms.nextLine();
                    definition = definition + " " + current;
                }
                glossary.add(term, definition);
                definition = "";
            }
        }
        createLinksToOtherTerms(glossary);
    }

    /**
     * Creates an HTML file for the glossary index that references every term in
     * alphabetical order.
     *
     * @param glossary
     *            Map consisting of pairs with only strings
     * @param outputFolder
     *            Folder to save created HTML files in.
     * @requires <pre>
     *          Map only consists of pairs with strings
     * </pre>
     * @ensures an HTML file is created to display the glossary index with links
     *          to each terms definition file
     */
    private static void createIndexHTML(Map<String, String> glossary,
            String outputFolder) {
        SimpleWriter outFile = new SimpleWriter1L(
                outputFolder + "\\index.html");
        outFile.println("<html>");
        outFile.println("   <head>");
        outFile.println("       <title>Glossary</title>");
        outFile.println("   </head>");
        outFile.println("   <body>");
        outFile.println("       <h2>Glossary</h2>");
        outFile.println("       <hr />");
        outFile.println("       <h3>Index</h3>");
        outFile.println("       <ul>");
        Map<String, String> temp = glossary.newInstance();
        String[] termArray = new String[glossary.size()];
        for (int i = 0; i < termArray.length; i++) {
            Map.Pair<String, String> current = glossary.removeAny();
            termArray[i] = current.key();
            temp.add(current.key(), current.value());
        }
        glossary.transferFrom(temp);
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < termArray.length - 1; i++) {
                if (termArray[i].compareToIgnoreCase(termArray[i + 1]) > 0) {
                    sorted = false;
                    String higher = termArray[i], lower = termArray[i + 1];
                    termArray[i] = lower;
                    termArray[i + 1] = higher;
                }
            }
        }
        for (String selected : termArray) {
            while (glossary.size() > 0) {
                Map.Pair<String, String> current = glossary.removeAny();
                if (selected.equals(current.key())) {
                    outFile.println("           <li><a href=\"" + current.key()
                            + ".html\">" + current.key() + "</a></li>");
                    createDefHTML(current, outputFolder);
                }
                temp.add(current.key(), current.value());
            }
            glossary.transferFrom(temp);
        }
        outFile.println("       </ul>");
        outFile.println("   </body>");
        outFile.println("</html>");
        outFile.close();
    }

    /**
     * Creates an HTML file for a single pair of term and definition.
     *
     * @param pair
     *            Map pair consisting of term and definition
     * @param outputFolder
     *            Folder to save created HTML files in.
     * @requires <pre>
     * pair consist of only strings
     * </pre>
     * @ensures an HTML file is created to display the term and definition.
     */
    private static void createDefHTML(Map.Pair<String, String> pair,
            String outputFolder) {
        String term = pair.key(), definition = pair.value();
        SimpleWriter outFile = new SimpleWriter1L(
                outputFolder + "\\" + term + ".html");
        outFile.println("<html>");
        outFile.println("   <head>");
        outFile.println("       <title>" + term + "</title>");
        outFile.println("   </head>");
        outFile.println("   <body>");
        outFile.println("       <h2><b><i><font color=\"red\">" + term
                + "</font></i></b></h2>");
        outFile.println("       <blockquote>" + definition + "</blockquote>");
        outFile.println("       <hr />");
        outFile.println(
                "       <p>Return to <a href=\"index.html\">index</a>.</p>");
        outFile.println("   </body>");
        outFile.println("</html>");
        outFile.close();
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        Map<String, String> glossary = new Map1L<String, String>();
        out.println("Input the name of the output file folder: ");
        String outputFolder = in.nextLine();
        out.println("Input the name of the input file: ");
        String termsPath = in.nextLine();
        SimpleReader terms = new SimpleReader1L(termsPath);
        createMap(terms, glossary);
        createIndexHTML(glossary, outputFolder);
        terms.close();
        in.close();
        out.close();
    }

}
