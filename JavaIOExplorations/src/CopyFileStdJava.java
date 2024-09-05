import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Program to copy a text file into another file.
 *
 * @author Put your name here
 *
 */
public final class CopyFileStdJava {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CopyFileStdJava() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments: input-file-name output-file-name
     */
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Input file to be read");
        String inputFileName = input.readLine();
        BufferedReader inFile = null;
        while (inFile == null) {
            try {
                inFile = new BufferedReader(new FileReader(inputFileName));
            } catch (IOException e) {
                System.out
                        .println("Invalid filename. Enter another filename: ");
                inputFileName = input.readLine();
            }
        }
        System.out.println("Input file to be copied to");
        String outputFileName = input.readLine();
        PrintWriter outFile = null;
        while (outFile == null) {
            try {
                outFile = new PrintWriter(
                        new BufferedWriter(new FileWriter(outputFileName)));
            } catch (IOException e) {
                System.out
                        .println("Invalid filename. Enter another filename: ");
                outputFileName = input.readLine();
            }
        }
        System.out.println("Input filter file");
        String filterFileName = input.readLine();
        BufferedReader filterFile = null;
        while (filterFile == null) {
            try {
                filterFile = new BufferedReader(new FileReader(filterFileName));
            } catch (IOException e) {
                System.out
                        .println("Invalid filename. Enter another filename: ");
                filterFileName = input.readLine();
            }
        }
        List<String> l = new ArrayList<>();
        String c = filterFile.readLine();
        while (c != null) {
            l.add(c);
            c = filterFile.readLine();
        }
        try {
            String s = inFile.readLine();
            while (s != null) {
                for (String current : l) {
                    if (s.contains(current)) {
                        outFile.println(s);
                        break;
                    }
                }
                s = inFile.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error reading input file");
        }
    }
}