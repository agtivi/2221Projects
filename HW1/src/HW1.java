import components.sequence.Sequence;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public final class HW1 {
    /**
     * constructor.
     */
    private HW1() {

    }

    /**
     * No informal description here for obvious reasons...
     *
     * @param s1
     *            a sequence
     * @param s2
     *            another sequence
     * @replaces s2
     * @requires |s1| >= 1
     * @ensures <pre>
     * |s2| = |s1| - 1  and
     *  for all i, j: integer, a, b: string of integer
     *      where (s1 = a * <i> * <j> * b)
     *    (there exists c, d: string of integer
     *       (|c| = |a|  and
     *        s2 = c * <(i+j)/2> * d))
     *
     * </pre>
     */
    public static void smooth(Sequence<Integer> s1, Sequence<Integer> s2) {
        int firstInt = s1.remove(s1.length() - 1);
        if (s1.length() > 0) {
            int secondInt = s1.remove(s1.length() - 1);
            s2.append(s1);
            s2.add(0, ((firstInt + secondInt) / 2));
            smooth(s1, s2);
        } else {
            s2.add(0, firstInt);
        }
    }

}
