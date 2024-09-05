import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author Anthony Keller
 */
public final class HelloWorld {

    /**
     * Default constructor--private to prevent instantiation.
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        out.print(-23 % 5);
    }
}
