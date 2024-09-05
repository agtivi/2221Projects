import components.set.Set;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public final class WordsAndSeparators {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private WordsAndSeparators() {
        // no code needed here
    }

    /**
     * Generates the set of characters in the given {@code String} into the
     * given {@code Set}.
     *
     * @param str
     *            the given {@code String}
     * @param charSet
     *            the {@code Set} to be replaced
     * @replaces charSet
     * @ensures charSet = entries(str)
     */
    private static void generateElements(String str, Set<Character> charSet) {
        if (str.length() > 0) {
            charSet.clear();
            char input;
            for (int i = 0; i < str.length(); i++) {
                input = str.charAt(i);
                charSet.add(input);
            }
        }
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     * </pre>
     */
    private static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        boolean isSeparator = false;
        for (Character s : separators) {
            if (text.charAt(position) == s) {
                isSeparator = true;
            }
        }
        String solution = text.substring(position, text.length());
        int index = position;
        if (!isSeparator) {
            for (int i = position; i < solution.length(); i++) {
                for (Character s : separators) {
                    if (text.charAt(position) != s) {
                        isSeparator = false;
                    } else {
                        isSeparator = true;
                    }
                }
                if (!isSeparator) {
                    solution = solution + text.charAt(position);
                    index = index + 1;
                } else {
                    i = solution.length();
                }
            }
        } else {
            for (int i = position; i < solution.length(); i++) {
                for (Character s : separators) {
                    if (text.charAt(position) != s) {
                        isSeparator = false;
                    } else {
                        isSeparator = true;
                    }
                }
                if (isSeparator) {
                    solution = solution + text.charAt(position);
                    index = index + 1;
                } else {
                    i = solution.length();
                }
            }
        }
        return solution;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        out.println("Hello World!");
        out.close();
    }

}
