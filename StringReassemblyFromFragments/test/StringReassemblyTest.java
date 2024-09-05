import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

    //addToSetAvoidingSubstrings tests
    @Test
    public void addToSetAvoidingSubstrings_routineTest1() {
        Set<String> a = new Set1L<>();
        String b = "ABCDEFG";
        String c = "EFGHJIK";
        String d = "JIK";
        Set<String> e = new Set1L<>();
        String f = "ABCDEFG";
        String g = "EFGHJIK";
        e.add(f);
        e.add(g);
        StringReassembly.addToSetAvoidingSubstrings(a, b);
        StringReassembly.addToSetAvoidingSubstrings(a, c);
        StringReassembly.addToSetAvoidingSubstrings(a, d);
        assertEquals(e, a);
    }

    @Test
    public void addToSetAvoidingSubstrings_routineTest2() {
        Set<String> a = new Set1L<>();
        String b = "aBcDeFg";
        String c = "EFGHJIK";
        String d = "AbC";
        Set<String> e = new Set1L<>();
        String f = "aBcDeFg";
        String g = "EFGHJIK";
        String h = "AbC";
        e.add(f);
        e.add(g);
        e.add(h);
        StringReassembly.addToSetAvoidingSubstrings(a, b);
        StringReassembly.addToSetAvoidingSubstrings(a, c);
        StringReassembly.addToSetAvoidingSubstrings(a, d);
        assertEquals(e, a);
    }

    @Test
    public void addToSetAvoidingSubstrings_routineTest3() {
        Set<String> a = new Set1L<>();
        String b = "a b c d";
        String c = "e f g h";
        String d = "g h";
        Set<String> e = new Set1L<>();
        String f = "a b c d";
        String g = "e f g h";
        e.add(f);
        e.add(g);
        StringReassembly.addToSetAvoidingSubstrings(a, b);
        StringReassembly.addToSetAvoidingSubstrings(a, c);
        StringReassembly.addToSetAvoidingSubstrings(a, d);
        assertEquals(e, a);
    }

    @Test
    public void addToSetAvoidingSubstrings_routineTest4() {
        Set<String> a = new Set1L<>();
        String b = "1234";
        String c = "5678";
        String d = "56";
        Set<String> e = new Set1L<>();
        String f = "1234";
        String g = "5678";
        e.add(f);
        e.add(g);
        StringReassembly.addToSetAvoidingSubstrings(a, b);
        StringReassembly.addToSetAvoidingSubstrings(a, c);
        StringReassembly.addToSetAvoidingSubstrings(a, d);
        assertEquals(e, a);
    }

    @Test
    public void addToSetAvoidingSubstrings_routineTest5() {
        Set<String> a = new Set1L<>();
        String b = "   ";
        String c = "  ";
        String d = " ";
        Set<String> e = new Set1L<>();
        String f = "   ";
        e.add(f);
        StringReassembly.addToSetAvoidingSubstrings(a, b);
        StringReassembly.addToSetAvoidingSubstrings(a, c);
        StringReassembly.addToSetAvoidingSubstrings(a, d);
        assertEquals(e, a);
    }

    @Test
    public void addToSetAvoidingSubstrings_challengingTest1() {
        Set<String> a = new Set1L<>();
        String b = "fUIEFHibi2funb98fh27hVSEIU";
        String c = "UIEFHibi2funb98fh27hVSEIU";
        String d = "UIEFHibi2funb98fh27hVSEIUt";
        Set<String> e = new Set1L<>();
        String f = "fUIEFHibi2funb98fh27hVSEIU";
        String g = "UIEFHibi2funb98fh27hVSEIUt";
        e.add(f);
        e.add(g);
        StringReassembly.addToSetAvoidingSubstrings(a, b);
        StringReassembly.addToSetAvoidingSubstrings(a, c);
        StringReassembly.addToSetAvoidingSubstrings(a, d);
        assertEquals(e, a);
    }

    @Test
    public void addToSetAvoidingSubstrings_challengingTest2() {
        Set<String> a = new Set1L<>();
        String b = "111111111118888888111111111111111";
        String c = "1118888";
        String d = "88888";
        Set<String> e = new Set1L<>();
        String f = "111111111118888888111111111111111";
        e.add(f);
        StringReassembly.addToSetAvoidingSubstrings(a, b);
        StringReassembly.addToSetAvoidingSubstrings(a, c);
        StringReassembly.addToSetAvoidingSubstrings(a, d);
        assertEquals(e, a);
    }

    @Test
    public void addToSetAvoidingSubstrings_boundaryTest1() {
        Set<String> a = new Set1L<>();
        String b = "111111111118888888111111111111111";
        String c = "111111111118888888111111111111111";
        Set<String> e = new Set1L<>();
        String f = "111111111118888888111111111111111";
        e.add(f);
        StringReassembly.addToSetAvoidingSubstrings(a, b);
        StringReassembly.addToSetAvoidingSubstrings(a, c);
        assertEquals(e, a);
    }

    //linesFromInput tests

    @Test
    public void linesFromInputs_routineTest1() {
        SimpleReader input = new SimpleReader1L(
                "C:\\Users\\Anthony\\Desktop\\CSE 2221\\workspace\\StringReassemblyFromFragments\\data\\LFITest1");
        Set<String> comparison = new Set1L<>();
        comparison.add("bruh");
        comparison.add("fudge");
        Set<String> test = StringReassembly.linesFromInput(input);
        assertEquals(comparison, test);
    }

    @Test
    public void linesFromInputs_challengeTest1() {
        SimpleReader input = new SimpleReader1L(
                "C:\\Users\\Anthony\\Desktop\\CSE 2221\\workspace\\StringReassemblyFromFragments\\data\\LFITest2");
        Set<String> comparison = new Set1L<>();
        comparison.add("awefoiawe;ofiabweo;fiajf;oajwef");
        comparison.add("vnowevjaowejfoawejfowefaf");
        comparison.add("wefja;owfijea;oivawueoaiwe");
        comparison.add("waengaweijfoaiwejfa;owef;oai");
        comparison.add("joijweao;vaw;oebf");
        Set<String> test = StringReassembly.linesFromInput(input);
        assertEquals(comparison, test);
    }

    @Test
    public void linesFromInputs_boundaryTest1() {
        SimpleReader input = new SimpleReader1L(
                "C:\\Users\\Anthony\\Desktop\\CSE 2221\\workspace\\StringReassemblyFromFragments\\data\\LFITest3");
        Set<String> comparison = new Set1L<>();
        comparison.add("111111111111111111111111111111111111111111111111111");
        comparison.add("222222222222222222222222222222222222222222222222222");
        comparison.add("333333333333333333333333333333333333333333333333333");
        comparison.add("444444444444444444444444444444444444444444444444444");
        comparison.add("555555555555555555555555555555555555555555555555555");
        comparison.add("666666666666666666666666666666666666666666666666666");
        comparison.add("777777777777777777777777777777777777777777777777777");
        comparison.add("888888888888888888888888888888888888888888888888888");
        comparison.add("999999999999999999999999999999999999999999999999999");
        Set<String> test = StringReassembly.linesFromInput(input);
        assertEquals(comparison, test);
    }

    //printWithLineSeparators tests

    @Test
    public void printWithLineSeparators_routineTest1() {
        SimpleWriter test = new SimpleWriter1L(
                "C:\\Users\\Anthony\\Desktop\\CSE 2221\\workspace\\StringReassemblyFromFragments\\data\\test.txt");
        SimpleReader read = new SimpleReader1L(
                "C:\\Users\\Anthony\\Desktop\\CSE 2221\\workspace\\StringReassemblyFromFragments\\data\\test.txt");
        String input = "bruh~bruh";
        StringReassembly.printWithLineSeparators(input, test);
        String comparison = "bruh" + "\n" + "bruh";
        String tester = read.nextLine();
        tester = tester + "\n" + read.nextLine();
        assertEquals(comparison, tester);
    }

    @Test
    public void printWithLineSeparators_challengingTest1() {
        SimpleWriter test = new SimpleWriter1L(
                "C:\\Users\\Anthony\\Desktop\\CSE 2221\\workspace\\StringReassemblyFromFragments\\data\\test.txt");
        SimpleReader read = new SimpleReader1L(
                "C:\\Users\\Anthony\\Desktop\\CSE 2221\\workspace\\StringReassemblyFromFragments\\data\\test.txt");
        String input = "~~aw9uwfa~fe9u~~~@F`~igeaj";
        StringReassembly.printWithLineSeparators(input, test);
        String comparison = "\n" + "\n" + "aw9uwfa" + "\n" + "fe9u" + "\n"
                + "\n" + "\n" + "@F`" + "\n" + "igeaj";
        String tester = read.nextLine();
        tester = tester + "\n" + read.nextLine();
        tester = tester + "\n" + read.nextLine();
        tester = tester + "\n" + read.nextLine();
        tester = tester + "\n" + read.nextLine();
        tester = tester + "\n" + read.nextLine();
        tester = tester + "\n" + read.nextLine();
        tester = tester + "\n" + read.nextLine();
        assertEquals(comparison, tester);
    }

}
