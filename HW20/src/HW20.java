import components.sequence.Sequence1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.stack.Stack;
import components.stack.Stack1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public final class HW20 {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private HW20() {
        // no code needed here
    }

    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public void flipStack() {
        /*
         * I'm confused about the object type, do we need to include T inbetween
         * the "<>" or do we just need the "<>" by itself?
         */
        Stack<T> flipped = new Stack1L<T>();
        while (this.size() > 0) {
            flipped.push(this.pop());
        }
        this.transferFrom(flipped);
    }

    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public void flipSequenceLoop() {
        Sequence<T> flipped = new Sequence1L<T>();
        while (this.size() > 0) {
            flipped.add(flipped.size(), this.remove());
        }
        this.transferFrom(flipped);
    }

    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public void flipSequenceRecursion() {
        Sequence<T> flipped = new Sequence1L<T>();
        if (this.size() > 1) {
            flipped = this.remove();
            this.flipSequenceRecursion();
            this.add(this.size(), flipped);
        }
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
