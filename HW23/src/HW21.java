import components.map.Map;
import components.program.Program.Instruction;
import components.sequence.Sequence;
import components.statement.Statement;
import components.statement.StatementKernel.Condition;

public final class HW31 {
    /**
     * Converts {@code Condition} into corresponding conditional jump
     * instruction byte code.
     *
     * @param c
     *            the {@code Condition} to be converted
     * @return the conditional jump instruction byte code corresponding to
     *         {@code c}
     * @ensures <pre>
     * conditionalJump =
     *  [conditional jump instruction byte code corresponding to c]
     * </pre>
     */
    private static Instruction conditionalJump(Condition c) {

    }

    /**
     * Generates the sequence of virtual machine instructions ("byte codes")
     * corresponding to {@code s} and appends it at the end of {@code cp}.
     *
     * @param s
     *            the {@code Statement} for which to generate code
     * @param context
     *            the {@code Context} in which to find user defined instructions
     * @param cp
     *            the {@code Sequence} containing the generated code
     * @updates cp
     * @ensures <pre>
     * if [all instructions called in s are either primitive or
     *     defined in context]  and
     *    [context does not include any calling cycles, i.e., recursion] then
     *  cp = #cp * [sequence of virtual machine "byte codes" corresponding to s]
     * else
     *  [reports an appropriate error message to the console and terminates client]
     * </pre>
     */
    private static void generateCodeForStatement(Statement s,
            Map<String, Statement> context, Sequence<Integer> cp) {

        final int dummy = 0;

        switch (s.kind()) {
            case BLOCK: {
                int length = s.lengthOfBlock();
                Statement temp = s.newInstance();
                for (int i = 0; i < length; i++) {
                    temp = s.removeFromBlock(0);
                    generateCodeForStatement(temp, context, cp);
                    s.addToBlock(length, s);
                }
                break;
            }
            case IF: {
                Statement b = s.newInstance();
                Condition c = s.disassembleIf(b);
                cp.add(cp.length(), conditionalJump(c).byteCode());
                int jump = cp.length();
                cp.add(cp.length(), dummy);
                generateCodeForStatement(b, context, cp);
                cp.replaceEntry(jump, cp.length());
                s.assembleIf(c, b);
                break;
            }
            case IF_ELSE: {
                Statement ifStatement = s.newInstance();
                Statement elseStatement = s.newInstance();
                Condition condition = s.disassembleIfElse(ifStatement,
                        elseStatement);
                cp.add(cp.length(), conditionalJump(condition).byteCode());
                int jump = cp.length();
                cp.add(cp.length(), dummy);
                generateCodeForStatement(ifStatement, context, cp);
                int secondJump = cp.length();
                cp.add(cp.length(), dummy);
                cp.replaceEntry(jump, cp.length());
                generateCodeForStatement(elseStatement, context, cp);
                cp.replaceEntry(secondJump, cp.length());
                s.assembleIfElse(condition, ifStatement, elseStatement);
                break;
            }
            case WHILE: {
                Statement whileStatement = s.newInstance();
                Condition condition = s.disassembleWhile(whileStatement);
                cp.add(cp.length(), conditionalJump(condition).byteCode());
                int jump = cp.length();
                cp.add(cp.length(), dummy);
                generateCodeForStatement(whileStatement, context, cp);
                cp.add(cp.length(), jump + 1);
                cp.replaceEntry(jump, cp.length());
                break;
            }
            // remaining case CALL goes here
        }
    }
}
