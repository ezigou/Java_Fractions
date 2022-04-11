// 13177951
// irenezi@live.com

public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;

    /**
     * This method is the first constructor for a FractionImpl class object.
     * It receives two integers that represent the numerator and the denominator of a fraction.
     * The instance variables of the object are kept in a reduced form, representing the fraction into its lowest terms.
     * normalize function is called, to calculate the values that need to be stored as the instance variables.
     * An ArithmeticException is thrown while passing the value 0 as the denominator parameter.
     *
     * @param numerator : an integer number that represents the numerator of a fraction
     * @param denominator : an integer number that represents the denominator of a fraction
     */
    public FractionImpl(int numerator, int denominator) throws ArithmeticException {

        if (denominator == 0) {     // denominator cannot be 0
            throw new ArithmeticException("Denominator cannot be 0!"); }
        else {
            if (numerator==0){      // zero is represented as 0/1
                this.numerator=0;
                this.denominator=1; }
            else {
                int[] factors = normalize(numerator, denominator);
                // array "factors" stores the normalized values of numerator and denominator respectively
                if (factors[1] < 0) {       // negative denominator turns to positive and numerator changes sign
                    this.denominator = -factors[1];
                    this.numerator = -factors[0]; }
                else {      // if denominator is positive
                    this.numerator = factors[0];
                    this.denominator = factors[1];
                }
            }
        }
    }


    /**
     * This method is the second constructor for a FractionImpl class object.
     * It receives an integer that represents the numerator of a fraction. The denominator is considered to be 1.
     *
     * @param wholeNumber : representing the numerator of a fraction
     */
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }


    /**
     * This method is the third constructor for a FractionImpl class object.
     * It receives a String that represents a fraction.
     * The input string contains either a whole number or a mathematical representation of a fraction (using "/"),
     * blanks around (but not within) integers are allowed.
     * The instance variables of the object are kept in a reduced form, representing the fraction into its lowest terms.
     * normalize function is called, to calculate the values that need to be stored as the instance variables.
     * An ArithmeticException is thrown while passing the value 0 as the denominator parameter.
     * In case of a malformed input, a NumberFormatException is thrown.
     *
     * @param fraction : the string representation of the fraction
     */
    public FractionImpl(String fraction) throws ArithmeticException, NumberFormatException {

        try {
            if (!fraction.contains("/")) {
                // for input parameter not in a mathematical form of a fraction, Exception is thrown
                // ( due to Integer.parseInt() ),
                // unless it is an integer number in String form (including blanks around),
                // when instance variables are initialized.
                this.numerator = Integer.parseInt(fraction.trim());
                this.denominator = 1;
            } else {
                // if the input is in a valid form of fraction, instance variables are initialized,
                // else Exception is thrown ( due to Integer.parseInt() ).
                String[] numbers = fraction.split("/");

                int numerator = Integer.parseInt(numbers[0].trim());
                int denominator = Integer.parseInt(numbers[1].trim());

                if (denominator == 0) {     // exception for 0 denominator
                    throw new ArithmeticException("Denominator cannot be 0!");
                } else {
                    // initialize variables
                    if (numerator == 0) {
                        this.numerator = numerator;
                        this.denominator = 1;
                    } else {
                        int[] factors = normalize(numerator, denominator);
                        // call normalize method to calculate the normalized values
                        if (factors[1] < 0) {   // handles negative denominator case
                            this.denominator = -factors[1];
                            this.numerator = -factors[0];
                        } else {
                            this.numerator = factors[0];
                            this.denominator = factors[1];
                        }
                    }
                }
            }
        }
        catch (NumberFormatException e1){throw new NumberFormatException("Wrong input!");}
        catch (ArithmeticException e2){throw new ArithmeticException("Denominator cannot be 0!");}

    }


    /**
     * Additional Helper method for normalization.
     * Euclid's algorithm is used to calculate the Greatest Common Divisor (gcd) of two integer (positive) numbers.
     * The method calculates the input numbers divided by their gcd.
     *
     * @param a : the first integer number
     * @param b : the second integer number
     * @return arr : an array, whose first element is the value of the division of parameter a by the gcd and
     * the second element is the result od the division of parameter b by the gcd.
     *
     * Throws ArithmeticException if one or both the parameters equals to 0.
     */
    protected static int[] normalize(int a, int b) {

        int x = Math.max(Math.abs(a), Math.abs(b)); // x is the greater number of the absolute a and b values
        int y = Math.min(Math.abs(a), Math.abs(b)); // y is the smaller number of the absolute a and b values
        int gcd =y;
        while (x % y != 0) {
            gcd = x % y;
            x = y;
            y = gcd;
        }
        int[] arr = new int[2]; // creates an array to contain the normalized values
        arr[0] = a / gcd;
        arr[1] = b / gcd;
        return arr;
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        FractionImpl frac = (FractionImpl) f; //casts Fraction f to a FractionImpl instance
        int newNumerator = (this.numerator * frac.denominator) + (this.denominator * frac.numerator);
        int newDenominator = this.denominator * frac.denominator;
        return new FractionImpl(newNumerator, newDenominator);
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        FractionImpl frac = (FractionImpl) f;  // casts Fraction f to a FractionImpl instance
        int newNumerator = (this.numerator * frac.denominator) - (this.denominator * frac.numerator);
        int newDenominator = this.denominator * frac.denominator;
        return  new FractionImpl(newNumerator, newDenominator);
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        FractionImpl frac = (FractionImpl) f; //casts Fraction f to a FractionImpl instance
        int newNumerator = this.numerator * frac.numerator;
        int newDenominator = this.denominator * frac.denominator;
        return new FractionImpl(newNumerator, newDenominator);
    }


    /**
     * @inheritDoc
     * Also, an ArithmeticException is thrown while trying to divide by zero.
     */
    @Override
    public Fraction divide(Fraction f) {

        FractionImpl frac = (FractionImpl) f; //casts Fraction f to a FractionImpl instance
        int newNumerator = this.numerator * frac.denominator;
        int newDenominator = this.denominator * frac.numerator;
        return new FractionImpl(newNumerator, newDenominator);
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return new FractionImpl(Math.abs(this.numerator), Math.abs(this.denominator));
    }


    /**
     * @return
     * @inheritDoc
     */
    public Fraction negate() {
        this.numerator *= (-1);     // to negate a fraction it suffices to multiply its numerator by -1
        return new FractionImpl(this.numerator, this.denominator);
    }


    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }


    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Fraction) {
            FractionImpl f = ((FractionImpl) obj);  //casts Fraction obj to a FractionImpl instance
            return (this.numerator == f.numerator && this.denominator == f.denominator);
        } else {
            return false;
        }
    }


    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    /**
     * @inheritDoc
     * Also, ArithmeticException is thrown while trying to inverse the zero fraction
     */
    @Override
    public Fraction inverse() {
        return new FractionImpl(this.denominator, this.numerator);
    }


    /**
     * Returns:
     *     <li>A negative <pre>int</pre> (value: -1) if <pre>this</pre> is less than <pre>o</pre>.</li>
     *     <li>Zero if <pre>this</pre> is equal to <pre>o</pre>.</li>
     *     <li>A positive <pre>int</pre> (value: 1) if <pre>this</pre> is greater than <pre>o</pre>.</li>
     * </ul>
     *
     * @param o: the fraction to compare <pre>this</pre> to
     * @return : the result of the comparison as an integer (1 or 0 or -1)
     */
    @Override
    public int compareTo(Fraction o) {

        FractionImpl frac = ((FractionImpl) o); // casts Fraction o to an instance of FractionImpl
        // cast numerators to floats in order to calculate the fraction values, considering them as divisions
        float x = (float) this.numerator / this.denominator;
        float y = (float) frac.numerator / frac.denominator;
        if (x > y) {
            return 1;
        } else if (x < y) {
            return -1;
        } else {
            return 0;
        }
    }


    /**
     * @inheritDoc
     */
    @Override
    public String toString() {

        if (this.denominator == 1) {
            return "" + this.numerator;
        } else {
            return "" + this.numerator + "/" + "" + this.denominator;
        }
    }


    public static void main(String[] args) {

    }
}

