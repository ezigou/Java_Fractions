// 13177951
// irenezi@live.com

import org.junit.Assert;
import org.junit.Test;

public class FractionImplTest {

    // Creation of Instances of FractionImpl class to use for testing
    FractionImpl fr1 = new FractionImpl(2, 4);
    FractionImpl fr2 = new FractionImpl(4, -2);
    FractionImpl fr3 = new FractionImpl(0);
    FractionImpl fr4 = new FractionImpl(-1,2);
    FractionImpl fr5 = new FractionImpl(1);
    FractionImpl fr6 = new FractionImpl("-3/5");


    // There is a limitation to the extend of which the constructors can be tested due to the fact that the instance
    // variables are private and the class FractionImplTest does not have access to them.

    /**
     * ConstructorsTest1 method checks if the 3 constructors create the same Fraction
     */
    @Test
    public void ConstructorsTest1(){
        // create FractionImpl objects
        FractionImpl c1 = new FractionImpl(3,1);
        FractionImpl c2 = new FractionImpl(3);
        FractionImpl c3 = new FractionImpl("3");
        // check equality of FractionImpl Objects
        Assert.assertEquals(c1,c2);
        Assert.assertEquals(c2,c3);
    }

    /**
     * ConstructorsTest2 method checks if the 3 constructors create objects of class Fraction
     */
    @Test
    public void ConstructorsTest2(){
        // create FractionImpl objects
        FractionImpl c1 = new FractionImpl(3,1);
        FractionImpl c2 = new FractionImpl(3);
        FractionImpl c3 = new FractionImpl("3");

        Assert.assertTrue(c1 instanceof Fraction);
        Assert.assertTrue(c2 instanceof Fraction);
        Assert.assertTrue(c3 instanceof Fraction);
    }

    /**
     * ConstructorsTest method checks if the first constructor throws ArithmeticException for zero denominator
     */
    @Test(expected = ArithmeticException.class)
    public void ConstructorsTest3() {
        //create FractionImpl object
        FractionImpl c1 = new FractionImpl(3,0);
    }

    /**
     * ConstructorsTest4 method checks if the third constructor throws ArithmeticException for zero denominator
     */
    @Test(expected = ArithmeticException.class)
    public void ConstructorsTest4() {
        // create FractionImpl object
        FractionImpl c3 = new FractionImpl("3/0");
    }

    /**
     * ConstructorsTest5 method checks if negative denominators passed to the constructors create the same Fractions,
     * comparison with inverted inputs
     */
    @Test
    public void ConstructorsTest5(){
        // create FractionImpl objects
        FractionImpl c1 = new FractionImpl(3,-1);
        FractionImpl c11 = new FractionImpl(-3,1);
        FractionImpl c2 = new FractionImpl(-3);
        FractionImpl c3 = new FractionImpl("3/-1");
        FractionImpl c33 = new FractionImpl("-3/1");
        // check equality of FractionImpl Objects
        Assert.assertEquals(c1,c11);
        Assert.assertEquals(c11,c2);
        Assert.assertEquals(c2,c3);
        Assert.assertEquals(c3,c33);
    }

    /**
     * CoonstructorsTest6 method checks if the first and third constructor keep a fraction in a reduced form,
     * comparison with fractions of reduced form
     */
    @Test
    public void ConstructorsTest6(){
        // create FractionImpl objects
        FractionImpl c1 = new FractionImpl(2,4);
        FractionImpl c11 = new FractionImpl(1,2);
        FractionImpl c3 = new FractionImpl("2/4");
        FractionImpl c33 = new FractionImpl("1/2");
        // check equality of FractionImpl Objects
        Assert.assertEquals(c1,c11);
        Assert.assertEquals(c11,c3);
        Assert.assertEquals(c3,c33);
    }

    /**
     * ConstructorsTest7 method checks if the third constructor creates the same Fraction
     * for the parameters "-5" and "5/-1"
     */
    @Test
    public void ConstructorsTest7(){
        // create FractionImpl objects
        FractionImpl c3 = new FractionImpl("-5");
        FractionImpl c33 = new FractionImpl("5/-1");
        // check equality of FractionImpl Objects
        Assert.assertEquals(c3,c33);
    }

    /**
     * ConstructorsTest8 method checks if a NumberFormatException is thrown for string input with blanks within integers
     * input String "3 2/5"
     */
    @Test (expected = NumberFormatException.class)
    public void ConstructorsTest8(){
        // create FractionImpl object
        FractionImpl c = new FractionImpl("3 2/5");
    }

    /**
     * method checks if a NumberFormatException is thrown for string input with blanks within integers
     *input String "3 2
     */
    @Test (expected = NumberFormatException.class)
    public void ConstructorsTest9(){
        // create FractionImpl object
        FractionImpl c = new FractionImpl("3 2");
    }

    /**
     *  ConstructorsTest10 method checks if a NumberFormatException is thrown for string input of an invalid form
     */
    @Test (expected = NumberFormatException.class)
    public void ConstructorsTest10(){
        // create FractionImpl object
        FractionImpl c = new FractionImpl("hello");
    }

    /**
     * normalizeTest1 method checks the output of the normalize method,
     * if the Greatest Common Divisor is one of the parameters passed
     */
    @Test
    public void normalizeTest1(){
        int[] expected = new int[2];
        int[] actual = FractionImpl.normalize(2,4);
        expected[0] = 1;
        expected[1] = 2;
        Assert.assertTrue(actual[0]==expected[0] && actual[1]==expected[1]);
    }

    /**
     * normalizeTest2 method checks the output of the normalize method,
     * if the Greatest Common Divisor is not one of the parameters passed
     */
    @Test
    public void normalizeTest2(){
        int[] expected = new int[2];
        int[] actual = FractionImpl.normalize(-8,-12);
        expected[0] = -2;
        expected[1] = -3;
        Assert.assertTrue(actual[0]==expected[0] && actual[1]==expected[1]);
    }

    /**
     * normalizeTest3 method checks the output of the normalize method,
     * if the Greatest Common Divisor is 1
     */
    @Test
    public void normalizeTest3(){
        int[] expected = new int[2];
        int[] actual = FractionImpl.normalize(-7,5);
        expected[0] = -7;
        expected[1] = 5;
        Assert.assertTrue(actual[0]==expected[0] && actual[1]==expected[1]);
    }

    /**
     * normalizeTest4 method checks if normalize method throws ArithmeticException for parameters (0,1)
     */
    @Test(expected = ArithmeticException.class)
    public void normalizeTest4() {
        FractionImpl.normalize(0,1);
    }

    /**
     * normalizeTest5 method checks if normalize method throws ArithmeticException for parameters (4,0)
     */
    @Test(expected = ArithmeticException.class)
    public void normalizeTest5() {
        FractionImpl.normalize(4,0);
    }

    /**
     * normalizeTest6 method checks if normalize method throws ArithmeticException for parameters (0,0)
     */
    @Test(expected = ArithmeticException.class)
    public void normalizeTest6() {
        FractionImpl.normalize(0,0);
    }

    // Method normalize throws ArithmeticException in case of inputs a and/or b equal to 0.

    // In case of a numerator equal to 0, constructors do not invoke the normalize method. Also, numerator 0 can result
    // from addiction, subtraction, multiplication or division of fractions. In that case, the corresponding methods
    // return the resulting fraction by passing the constructors the value of 0 for the numerator (normalize method is
    // not being called).

    // Input b will never be 0, as the constructors handle the situation by throwing an exception before calling the
    // method.

    // As a result method normalise will never an input equal to 0.


    /**
     * addTest1 method checks if method add returns an instance of class Fraction
     */
    @Test
    public void addTest1(){
        Assert.assertTrue(fr1.add(fr2) instanceof Fraction);
    }

    /**
     * addTest2 method checks method add for:
     * sum of 2/4 and (-4/2) to be -3/2
     */
    @Test
    public void addTest2(){
        Fraction expected = new FractionImpl(-3,2);
        Fraction actual = fr1.add(fr2);
        Assert.assertEquals(actual, expected);
    }

    /**
     * addTest3 method checks method add for:
     * sum of 2/4 and -1/2 to be 0
     */
    @Test
    public void addTest3(){
        Fraction expected = fr3;
        Fraction actual = fr1.add(fr4);
        Assert.assertEquals(actual, expected);
    }

    /**
     * addTest4 method checks method add for:
     * sum of 2/4 and 0 to be 1/2
     */
    @Test
    public void addTest4(){
        Fraction expected = new FractionImpl(1,2);
        Fraction actual = fr3.add(fr1);
        Assert.assertEquals(actual,expected);
    }

    /**
     * addTest5 method checks method add for:
     * sum of 0 and 2/4 to be 1/2
     */
    @Test
    public void addTest5(){
        Fraction expected = new FractionImpl(1,2);
        Fraction actual = fr1.add(fr3);
        Assert.assertEquals(actual,expected);
    }

    /**
     * addTest6 method checks method add for:
     * sum of 2/4 and -1/2 to be 0
     */
    @Test
    public void addTest6(){
        Fraction expected = fr1;
        Fraction actual = fr1.add(fr3);
        Assert.assertEquals(actual, expected);
    }

    /**
     * subtractTest1 method checks if method subtract returns an instance of class Fraction
     */
    @Test
    public void subtractTest1(){
        Assert.assertTrue(fr1.subtract(fr2) instanceof Fraction);
    }

    /**
     * subtractTest2 method checks method subtract for:
     * 1 minus 2/4 to be 1/2
     */
    @Test
    public void subtractTest2(){
        Fraction expected = new FractionImpl(1,2);
        Fraction actual = fr5.subtract(fr1);
        Assert.assertEquals(actual, expected);
    }

    /**
     * subtractTest3 method checks method subtract for:
     * -4/2 minus -1/2 to be -3/2
     */
    @Test
    public void subtractTest3(){
        Fraction expected = new FractionImpl("-3/2");
        Fraction actual = fr2.subtract(fr4);
        Assert.assertEquals(actual, expected);
    }

    /**
     * subtractTest4 method checks method subtract for:
     * -1/2 minus -1/2 to be 0
     */
    @Test
    public void subtractTest4(){
        Fraction expected = fr3;
        Fraction actual = fr4.subtract(fr4);
        Assert.assertEquals(actual, expected);
    }

    /**
     *multiplyTest1 method checks if method multiply returns an instance of class Fraction
     */
    @Test
    public void multiplyTest1(){
        Assert.assertTrue(fr1.multiply(fr2) instanceof Fraction);
    }

    /**
     * multiplyTest2 method checks method multiply for:
     * multiplication of -3/5 and 2/4 to be -3/10
     */
    @Test
    public void multiplyTest2(){
        Fraction expected = new FractionImpl("-3/10");
        Fraction actual = fr6.multiply(fr1);
        Assert.assertEquals(actual, expected);
    }

    /**
     * multiplyTest3 method checks method multiply for:
     * multiplication of -3/5 and -1/2 to be 3/10
     */
    @Test
    public void multiplyTest3(){
        Fraction expected = new FractionImpl("3/10");
        Fraction actual = fr6.multiply(fr4);
        Assert.assertEquals(actual, expected);
    }

    /**
     * multiplyTest4 method checks method multiply for:
     * multiplication of -3/5 and 0 to be 0
     */
    @Test
    public void multiplyTest4(){
        Fraction expected = fr3;
        Fraction actual = fr6.multiply(fr3);
        Assert.assertEquals(actual, expected);
    }

    /**
     * multiplyTest5 method checks method multiply for:
     * multiplication of 0 and -3/4 to be 0
     */
    @Test
    public void multiplyTest5(){
        Fraction expected = fr3;
        Fraction actual = fr3.multiply(fr6);
        Assert.assertEquals(actual, expected);
    }

    /**
     * multiplyTest6 method  checks method multiply for:
     * multiplication of -4/2 and 1 to be -2
     */
    @Test
    public void multiplyTest6(){
        Fraction expected = new FractionImpl(-2);
        Fraction actual = fr2.multiply(fr5);
        Assert.assertEquals(actual, expected);
    }

    /**
     * divideTest1 method checks if method divide returns an instance of class Fraction
     */
    @Test
    public void divideTest1(){
        Assert.assertTrue(fr1.divide(fr2) instanceof Fraction);
    }

    /**
     * divideTest2 method checks method divide for:
     * -3/5 divided by 1 to be -3/5
     */
    @Test
    public void divideTest2(){
        Fraction expected = fr6;
        Fraction actual = fr6.divide(fr5);
        Assert.assertEquals(actual, expected);
    }

    /**
     * divideTest3 method checks method divide for:
     * 1 divided by -3/5 to be -5/3
     */
    @Test
    public void divideTest3(){
        Fraction expected = new FractionImpl(-5,3);
        Fraction actual = fr5.divide(fr6);
        Assert.assertEquals(actual, expected);
    }

    /**
     * divideTest4 method checks method divide for:
     * 0 divided with -3/5 to be 0
     */
    @Test
    public void divideTest4(){
        Fraction expected = fr3;
        Fraction actual = fr3.divide(fr6);
        Assert.assertEquals(actual, expected);
    }

    /**
     * divideTest5 method checks if division of 2/4 by 0 throws ArithmeticException
     */
    @Test(expected = ArithmeticException.class)
    public void divideTest5(){
        fr1.divide(fr3);
    }

    /**
     * absTest1 method checks if method abs returns an instance of class Fraction
     */
    @Test
    public void absTest1(){
        Assert.assertTrue(fr1.abs() instanceof Fraction);
    }

    /**
     * absTest2 method checks method abs for positive fractions,
     * absolute value of 2/4 should be 2/4
     */
    @Test
    public void absTest2(){
        Fraction expected = fr1;
        Fraction actual = fr1.abs();
        Assert.assertEquals(actual, expected);
    }

    /**
     * absTest3 method checks method abs for negatove fractions,
     * absolute value of -4/2  should be 2
     */
    @Test
    public void absTest3(){
        Fraction expected = new FractionImpl(2);
        Fraction actual = fr2.abs();
        Assert.assertEquals(actual, expected);
    }

    /**
     * absTest4 method checks method abs for the zero fraction,
     * absolute value of 0 should be 0
     */
    @Test
    public void absTest4(){
        Fraction expected = fr3;
        Fraction actual = fr3.abs();
        Assert.assertEquals(actual, expected);
    }

    /**
     * negateTest1 method checks if negate method returns an instance of class Fraction
     */
    @Test
    public void negateTest1(){
        Assert.assertTrue(fr1.negate() instanceof Fraction);
    }

    /**
     * negateTest2 method checks negate method for a positive fraction (2/4)
     * negation of 2/4 should be -1/2
     */
    @Test
    public void negateTest2(){
        Fraction expected = new FractionImpl(-1,2);
        Fraction actual = fr1.negate();
        Assert.assertEquals(actual, expected);
    }

    /**
     * negateTest3 method checks negate method for a negative fraction (-3/5)
     * negation of -3/5 should be 3/5
     */
    @Test
    public void negateTest3(){
        Fraction expected = new FractionImpl("3/5");
        Fraction actual = fr6.negate();
        Assert.assertEquals(actual, expected);
    }

    /**
     * negateTest4 method checks negate method for zero fraction (0)
     * negation of 0 should be 0
     */
    @Test
    public void negateTest4(){
        Fraction expected = fr3;
        Fraction actual = fr3.negate();
        Assert.assertEquals(actual, expected);
    }

    /**
     * equalsTest1 method checks if method equals returns true or false
     */
    @Test
    public void equalsTest1(){
        Assert.assertTrue( fr1.equals(fr2)==true || fr1.equals(fr2)==false);
    }

    /**
     * equalsTest2 method checks if the parameter passed (-2) to equals method is equal to Fraction -4/2.
     * The method equals must return true
     */
    @Test
    public void equalsTest2(){
        Assert.assertTrue(fr2.equals((new FractionImpl(-2))));
    }

    /**
     * equalsTest3 method checks if the parameter passed (1) to equals method is not equal to -4/2.
     * The method equals must return false
     */
    @Test
    public void equalsTest3(){
        Assert.assertFalse(fr2.equals(fr4));
    }

    /**
     * equalsTest4 method checks if the method equals returns false for a String parameter passed ("hello")
     */
    @Test
    public void equalsTest4(){
        String a = "hello";
        Assert.assertFalse(fr2.equals(a));
    }

    /**
     * equalsTest5 method checks if method equals returns false while passing as a parameter an object of a wrong
     * declaration of fraction
     */
    @Test
    public void equalsTest5(){
        // checks if fraction 2/4 is equal to object 1/2
        Assert.assertFalse(fr1.equals(1/2));
    }

    /**
     * inverseTest1 method checks if method inverse returns an instance of class Fraction
     */
    @Test
    public void inverseTest1(){
        Assert.assertTrue(fr1.inverse() instanceof Fraction);
    }

    /**
     * inverseTest2 method checks inverse method for a positive fraction (2/4)
     * inversion of 2/4 should be 2
     */
    @Test
    public void inverseTest2(){
        Fraction expected = new FractionImpl(2);
        Fraction actual = fr1.inverse();
        Assert.assertEquals(actual, expected);
    }

    /**
     * inverseTest3 method checks inverse method for negative fraction (-3/5)
     * inversion of -3/5 should be -5/3
     */
    @Test
    public void inverseTest3(){
        Fraction expected = new FractionImpl("-5/3");
        Fraction actual = fr6.inverse();
        Assert.assertEquals(actual, expected);
    }

    /**
     * inverseTest4 method checks if inverse method in a zero fraction throws ArithmeticException
     */
    @Test(expected = ArithmeticException.class)
    public void inverseTest4(){
        fr3.inverse();
    }

    /**
     * compareToTest1 checks if method compareTo returns an int
     */
    @Test
    public void compareToTest1() {
        Assert.assertTrue( fr1.compareTo(fr2) == (int) fr1.compareTo(fr2));
    }

    /**
     * compareToTest2 checks if compareTo method returns a negative integer
     * as the fraction (1/1) is passed to the parameter of compareTo method, is greater than 2/4.
     */
    @Test
    public void compareToTest2(){
        Assert.assertTrue(fr1.compareTo(fr5)<0);
    }

    /**
     * compareToTest3 method checks if compareTo method returns a negative integer
     * as the fraction (1/1) is passed to the parameter of compareTo, is greater than 2/4.
     */
    @Test
    public void compareToTest3(){
        Assert.assertTrue(fr1.compareTo(fr2)>0);
    }

    /**
     * compareToTest4 method checks if compareTo method returns 0
     * as the fraction (2/4) is passed to the parameter of compareTo is equal to 2/4.
     */
    @Test
    public void compareToTest4(){
        Assert.assertTrue(fr1.compareTo(fr1)==00);
    }

    /**
     * toStringTest1 method checks if method toString returns an instance of String class
     */
    @Test
    public void toStringTest1(){
        Assert.assertTrue(fr1.toString() instanceof String);
    }

    /**
     * toStringTest2 method checks if method toString applied to fraction -1/2 returns the string "-1/2"
     */
    @Test
    public void toStringTest2(){
        String expected ="-1/2";
        String actual = fr4.toString();
        Assert.assertEquals(actual, expected);
    }

    /**
     * toStringTest3 method checks if method toString applied to fraction of 1 returns the string "1"
     */
    @Test
    public void toStringTest3(){
        String expected ="1";
        String actual = fr5.toString();
        Assert.assertEquals(actual, expected);
    }
}
