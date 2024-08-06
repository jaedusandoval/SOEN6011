public class PowerFunction {

    public double computePower(double x, double y) {
        if (x <= 0) {
            throw new IllegalArgumentException("Base x must be a positive real number.");
        }
        // This checks if y is zero. If it is, the method returns 1.0 because any number raised to the power of 0 is 1.
        if (y == 0) {
            return 1.0;
        }

        if (y == (int) y) {
            // If y is an integer, use exponentiation by squaring
            return powerInt(x, (int) y);
        } else {
            // If y is not an integer, use exponential and logarithm approximation
            return powerFractional(x, y);
        }
    }

    private double powerInt(double x, int y) {
        //This initializes result to 1.0. power is set to the absolute value of y to handle negative exponents.
        double result = 1.0;
        int power = y < 0 ? -y : y; // Manually handle the absolute value of y

        //This loop runs as long as power is greater than zero. Inside the loop:
        //If power is odd (checked using bitwise AND &), result is multiplied by x.
        //x is squared.
        //power is right-shifted by 1 bit, effectively dividing it by 2.

        while (power > 0) {
            if ((power & 1) == 1) {
                result *= x;
            }
            x *= x;
            power >>= 1;
        }

        //If y was negative, the method returns 1.0 / result. Otherwise, it returns result.
        return y < 0 ? 1.0 / result : result;
    }

    private double powerFractional(double x, double y) {
        //This block calculates the natural logarithm of x using a series expansion:
        //lnX is initialized to 0.0.
        //term is calculated as (x−1)/(x+1).
        //termSquared is the square of term.
        //numerator is initialized to term.
        //A loop runs from 1 to 999 in steps of 2. In each iteration:
        //lnX is incremented by numerator / n.
        //numerator is multiplied by termSquared.
        //Finally, lnX is multiplied by 2.

        // Calculate ln(x) using a series expansion
        double lnX = 0.0;
        double term = (x - 1) / (x + 1);
        double termSquared = term * term;
        double numerator = term;
        for (int n = 1; n < 1000; n += 2) {
            lnX += numerator / n;
            numerator *= termSquared;
        }
        lnX *= 2;

        //This block calculates e to the power of y⋅ln(x) using a series expansion:
        //result is initialized to 1.0.
        //termExp is calculated as y * lnX.
        //expTerm is initialized to 1.0.
        //A loop runs from 1 to 99. In each iteration:
        //expTerm is multiplied by termExp / i.
        //result is incremented by expTerm.

        // Use the exponential series to calculate e^(y * ln(x))
        double result = 1.0;
        double termExp = y * lnX;
        double expTerm = 1.0;
        for (int i = 1; i < 100; i++) {
            expTerm *= termExp / i;
            result += expTerm;
        }

        return result;
    }

}
