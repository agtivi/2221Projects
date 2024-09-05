import java.util.Comparator;

import components.queue.Queue;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Not Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author Anthony Keller
 */
public final class QueueIII {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private QueueIII() {
        // no code needed here
    }

    /**
     * Sorts {@code q} according to the ordering provided by the {@code compare}
     * method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to sort
     * @updates q
     * @requires [the relation computed by order.compare is a total preorder]
     * @ensures q = [# ordered by the relation computed by order.compare]
     */
    public static void sort(Queue<String> q, Comparator<String> order) {
        String first = q.dequeue(), second = q.dequeue();
        if (q.length() > 2) {
            if (first.compareTo(second) < 0) {
                q.enqueue(first);
                sort(q, order);
                q.enqueue(second);
            } else {
                q.enqueue(second);
                sort(q, order);
                q.enqueue(first);
            }
        } else {
            if (first.compareTo(second) < 0) {
                q.enqueue(first);
                q.enqueue(second);
            } else {
                q.enqueue(second);
                q.enqueue(first);
            }
        }
    }

    /**
     * Removes and returns the minimum value from {@code q} according to the
     * ordering provided by the {@code compare} method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to compare entries
     * @return the minimum value from {@code q}
     * @updates q
     * @requires <pre>
     * q /= empty_string and
     *  [the relation computed by order.compare is a total preorder[
     * </pre>
     * @ensures <pre>
     * perms(q * <removeMin>, #q)   and
     *  for all x: string of character
     *      where (x is in entries (q))
     *    ([relation computed by order.compare method](removeMin, x))
     * </pre>
     */
    private static String removeMin(Queue<String> q, Comparator<String> order) {
        String first = q.dequeue(), second = q.dequeue(), min;

        if (q.length() > 2) {
            if (first.compareTo(second) < 0) {
                q.enqueue(first);
                min = removeMin(q, order);
                q.enqueue(second);
            } else {
                q.enqueue(second);
                min = removeMin(q, order);
                q.enqueue(first);
            }
        } else {
            if (first.compareTo(second) < 0) {
                min = first;
                q.enqueue(second);
            } else {
                min = second;
                q.enqueue(first);
            }
        }
        //confused why there's an error here?
        return min;
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
