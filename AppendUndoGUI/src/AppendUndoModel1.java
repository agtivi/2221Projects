import components.stack.Stack;
import components.stack.Stack1L;

/**
 * Model class.
 *
 * @author Bruce W. Weide
 * @author Paolo Bucci
 */
public final class AppendUndoModel1 implements AppendUndoModel {

    /**
     * Input string variable.
     */
    private String input;
    /**
     * Output stack variable.
     */
    private Stack<String> output;

    /**
     * Default constructor.
     */
    public AppendUndoModel1() {
        /*
         * Initialize model; both variables start as empty strings
         */
        this.input = "";
        this.output = new Stack1L<String>();
        this.output.push("");
    }

    @Override
    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String input() {
        return this.input;
    }

    @Override
    public Stack<String> output() {
        return this.output();
    }
}
