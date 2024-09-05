import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Anthony Keller
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(21);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_99999999_1() {
        NaturalNumber n = new NaturalNumber2(99999999);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(1);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_99999999_99999999() {
        NaturalNumber n = new NaturalNumber2(99999999);
        NaturalNumber nExpected = new NaturalNumber2(99999999);
        NaturalNumber m = new NaturalNumber2(99999999);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_38246998_374598137() {
        NaturalNumber n = new NaturalNumber2(38246998);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(374598137);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_38246998_374598136() {
        NaturalNumber n = new NaturalNumber2(38246998);
        NaturalNumber nExpected = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(374598136);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_88888888_99999999() {
        NaturalNumber n = new NaturalNumber2(88888888);
        NaturalNumber nExpected = new NaturalNumber2(11111111);
        NaturalNumber m = new NaturalNumber2(99999999);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_0_99999999() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(99999999);
        NaturalNumber m = new NaturalNumber2(99999999);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_7() {
        NaturalNumber n = new NaturalNumber2(7);
        NaturalNumber nExpected = new NaturalNumber2(7);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_304580() {
        NaturalNumber n = new NaturalNumber2(304580);
        NaturalNumber nExpected = new NaturalNumber2(304580);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_304581() {
        NaturalNumber n = new NaturalNumber2(304581);
        NaturalNumber nExpected = new NaturalNumber2(304581);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_9999999() {
        NaturalNumber n = new NaturalNumber2(9999999);
        NaturalNumber nExpected = new NaturalNumber2(9999999);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_9999998() {
        NaturalNumber n = new NaturalNumber2(9999998);
        NaturalNumber nExpected = new NaturalNumber2(9999998);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_2_2_7() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(4);
        NaturalNumber p = new NaturalNumber2(2);
        NaturalNumber pExpected = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(7);
        NaturalNumber mExpected = new NaturalNumber2(7);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_2_32_2() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(32);
        NaturalNumber pExpected = new NaturalNumber2(32);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber pExpected = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isWitnessToCompositeness
     */
    @Test
    public void testIsWitnessToCompositeness_2_4() {
        NaturalNumber w = new NaturalNumber2(2);
        NaturalNumber wExpected = new NaturalNumber2(2);
        NaturalNumber n = new NaturalNumber2(4);
        NaturalNumber nExpected = new NaturalNumber2(4);
        boolean result = CryptoUtilities.isWitnessToCompositeness(wExpected,
                nExpected);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(result, true);
    }

    @Test
    public void testIsWitnessToCompositeness_2_7() {
        NaturalNumber w = new NaturalNumber2(2);
        NaturalNumber wExpected = new NaturalNumber2(2);
        NaturalNumber n = new NaturalNumber2(7);
        NaturalNumber nExpected = new NaturalNumber2(7);
        boolean result = CryptoUtilities.isWitnessToCompositeness(wExpected,
                nExpected);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(result, false);
    }

    @Test
    public void testIsWitnessToCompositeness_3_7() {
        NaturalNumber w = new NaturalNumber2(3);
        NaturalNumber wExpected = new NaturalNumber2(3);
        NaturalNumber n = new NaturalNumber2(7);
        NaturalNumber nExpected = new NaturalNumber2(7);
        boolean result = CryptoUtilities.isWitnessToCompositeness(wExpected,
                nExpected);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(result, false);
    }

    @Test
    public void testIsWitnessToCompositeness_9997_9999() {
        NaturalNumber w = new NaturalNumber2(9997);
        NaturalNumber wExpected = new NaturalNumber2(9997);
        NaturalNumber n = new NaturalNumber2(9999);
        NaturalNumber nExpected = new NaturalNumber2(9999);
        boolean result = CryptoUtilities.isWitnessToCompositeness(wExpected,
                nExpected);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(result, true);
    }

    @Test
    public void testIsWitnessToCompositeness_9995_9997() {
        NaturalNumber w = new NaturalNumber2(9995);
        NaturalNumber wExpected = new NaturalNumber2(9995);
        NaturalNumber n = new NaturalNumber2(9997);
        NaturalNumber nExpected = new NaturalNumber2(9997);
        boolean result = CryptoUtilities.isWitnessToCompositeness(wExpected,
                nExpected);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(result, true);
    }

    /*
     * Test isPrime2
     */

    @Test
    public void testIsPrime2_7() {
        NaturalNumber w = new NaturalNumber2(7);
        NaturalNumber wExpected = new NaturalNumber2(7);
        boolean result = CryptoUtilities.isPrime2(w);
        assertEquals(wExpected, w);
        assertEquals(result, true);
    }

    @Test
    public void testIsPrime2_9() {
        NaturalNumber w = new NaturalNumber2(9);
        NaturalNumber wExpected = new NaturalNumber2(9);
        boolean result = CryptoUtilities.isPrime2(w);
        assertEquals(wExpected, w);
        assertEquals(result, false);
    }

    @Test
    public void testIsPrime2_24229() {
        NaturalNumber w = new NaturalNumber2(24229);
        NaturalNumber wExpected = new NaturalNumber2(24229);
        boolean result = CryptoUtilities.isPrime2(w);
        assertEquals(wExpected, w);
        assertEquals(result, true);
    }

    @Test
    public void testIsPrime2_17285() {
        NaturalNumber w = new NaturalNumber2(17285);
        NaturalNumber wExpected = new NaturalNumber2(17285);
        boolean result = CryptoUtilities.isPrime2(w);
        assertEquals(wExpected, w);
        assertEquals(result, false);
    }

    /*
     * Test generateNextLikelyPrime
     */

    @Test
    public void testGenerateNextLikelyPrime_2() {
        NaturalNumber w = new NaturalNumber2(2);
        NaturalNumber wExpected = new NaturalNumber2(2);
        CryptoUtilities.generateNextLikelyPrime(w);
        assertEquals(wExpected, w);
    }

    @Test
    public void testGenerateNextLikelyPrime_4() {
        NaturalNumber w = new NaturalNumber2(4);
        NaturalNumber wExpected = new NaturalNumber2(7);
        CryptoUtilities.generateNextLikelyPrime(w);
        assertEquals(wExpected, w);
    }

    @Test
    public void testGenerateNextLikelyPrime_20700() {
        NaturalNumber w = new NaturalNumber2(20700);
        NaturalNumber wExpected = new NaturalNumber2(20707);
        CryptoUtilities.generateNextLikelyPrime(w);
        assertEquals(wExpected, w);
    }

}
