package matrix.workingPeoplesImitation.task_592_Fraction_Addition_and_Subtraction;

import java.util.Scanner;

public class Solution {

    // my solution
    public String fractionAddition(String expression) {
        String[] fractionStrings = expression.split("(?=[+|-])");
        Fraction[] fractions = new Fraction[fractionStrings.length];
        for (int i = 0; i < fractionStrings.length; i++) {
            String[] nums = fractionStrings[i].split("/");
            fractions[i] = new Fraction(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        }
        Fraction fraction = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            fraction.add(fractions[i]);
        }
        if (fraction.getNumerator() == 0) {
            fraction.setDenominator(1);
        }
        return fraction.getNumerator() + "/" + fraction.getDenominator();
    }

    static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        private int gsd(int a, int b) {
            while (a * b != 0) {
                if (a > b) {
                    a %= b;
                } else {
                    b %= a;
                }
            }
            return a + b;
        }

        private void add(Fraction fraction) {
            int newNumerator = this.numerator * fraction.getDenominator() + fraction.getNumerator() * this.denominator;
            int newDenominator = this.denominator * fraction.getDenominator();
            int d = gsd(Math.abs(newNumerator), Math.abs(newDenominator));
            while (d > 1) {
                newNumerator /= d;
                newDenominator /= d;
                d = gsd(Math.abs(newNumerator), Math.abs(newDenominator));
            }
            this.numerator = newNumerator;
            this.denominator = newDenominator;
        }

        public int getNumerator() {
            return numerator;
        }

        public void setNumerator(int numerator) {
            this.numerator = numerator;
        }

        public int getDenominator() {
            return denominator;
        }

        public void setDenominator(int denominator) {
            this.denominator = denominator;
        }
    }

    // from leetcode editorial (Approach 1: Manual Parsing + Common Denominator)
    public String fractionAddition2(String expression) {
        int num = 0;
        int denom = 1;

        int i = 0;
        while (i < expression.length()) {
            int currNum = 0;
            int currDenom = 0;

            boolean isNegative = false;

            // check for sign
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                if (expression.charAt(i) == '-') {
                    isNegative = true;
                }
                // move to next character
                i++;
            }

            // build numerator
            while (Character.isDigit(expression.charAt(i))) {
                int val = expression.charAt(i) - '0';
                currNum = currNum * 10 + val;
                i++;
            }

            if (isNegative) currNum *= -1;

            //skip divisor
            i++;

            // build denominator
            while (
                    i < expression.length() &&
                            Character.isDigit(expression.charAt(i))
            ) {
                int val = expression.charAt(i) - '0';
                currDenom = currDenom * 10 + val;
                i++;
            }

            // add fractions together using common denominator
            num = num * currDenom + currNum * denom;
            denom = denom * currDenom;
        }

        int gcd = Math.abs(FindGCD(num, denom));

        // reduce fractions
        num /= gcd;
        denom /= gcd;

        return num + "/" + denom;
    }

    private int FindGCD(int a, int b) {
        if (a == 0) return b;
        return FindGCD(b % a, a);
    }

    // from leetcode editorial (Approach 2 - Parsing with Regular Expressions)
    public String fractionAddition3(String expression) {
        int num = 0;
        int denom = 1;

        // separate expression into signed numbers
        String[] nums = expression.split("/|(?=[-+])");

        for (int i = 0; i < nums.length; i += 2) {
            int currNum = Integer.valueOf(nums[i]);
            int currDenom = Integer.valueOf(nums[i + 1]);

            num = num * currDenom + currNum * denom;
            denom = denom * currDenom;
        }

        int gcd = Math.abs(FindGCD2(num, denom));

        num /= gcd;
        denom /= gcd;

        return num + "/" + denom;
    }

    private int FindGCD2(int a, int b) {
        if (a == 0) return b;
        return FindGCD2(b % a, a);
    }

    // from walkccc.me
    public String fractionAddition4(String expression) {
        Scanner sc = new Scanner(expression).useDelimiter("/|(?=[+-])");
        int A = 0;
        int B = 1;

        // Init: A / B = 0 / 1
        // A / B + a / b = (Ab + aB) / Bb
        // So, in each round, set A = Ab + aB, B = Bb.
        while (sc.hasNext()) {
            final int a = sc.nextInt();
            final int b = sc.nextInt();
            A = A * b + a * B;
            B *= b;
            final int g = gcd(A, B);
            A /= g;
            B /= g;
        }

        return A + "/" + B;
    }

    private int gcd(int a, int b) {
        return a == 0 ? Math.abs(b) : gcd(b % a, a);
    }

}
