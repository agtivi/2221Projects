import java.util.Comparator;

import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Layered implementations of secondary method {@code sort} for
 * {@code Queue<String>}.
 */
public final class Queue1LSort1 extends Queue1L<String> {

    /**
     * No-argument constructor.
     */
    public Queue1LSort1() {
        super();
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
     * q /= empty_string  and
     *  [the relation computed by order.compare is a total preorder]
     * </pre>
     * @ensures <pre>
     * (q * <removeMin>) is permutation of #q  and
     *  for all x: string of character
     *      where (x is in entries (q))
     *    ([relation computed by order.compare method](removeMin, x))
     * </pre>
     */
    private static String removeMin(Queue<String> q, Comparator<String> order) {
        assert q != null : "Violation of: q is not null";
        assert order != null : "Violation of: order is not null";
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
        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */
        return min;
    }

    @Override
    public void sort(Comparator<String> order) {
        assert order != null : "Violation of: order is not null";
        Queue<String> temp = new Queue1L<String>();

        String min = this.dequeue();

        while (this.length() > 0) {
            String current = this.dequeue();
            if (current.compareTo(min) < 0) {
                temp.enqueue(min);
                min = current;
            } else {
                temp.enqueue(current);
            }
        }
        temp.sort(order);
        this.enqueue(min);
        this.append(temp);
    }

}
