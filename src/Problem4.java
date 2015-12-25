/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {
    private static final int MAX_MULTIPLIER = 999;
    private static final int MIN_MULTIPLIER = 100;

    private static final int MAX_FIRST_PART = 998;

    public static void main(String[] args) {
        int firstMultiplier = MAX_MULTIPLIER;
        int secondaryMultiplier = MAX_MULTIPLIER;

        int firstPart = MAX_FIRST_PART;
        long number = Long.MAX_VALUE;
        boolean isFound = false;

        while (!isFound) {
            firstPart--;
            number = buildPalindrome(firstPart);

            for (int i = MAX_MULTIPLIER; i > MIN_MULTIPLIER; i--) {
                if ((number / i) > MAX_MULTIPLIER || i * i < number) {
                    break;
                }

                if (number % i == 0) {
                    isFound = true;
                    firstMultiplier = (int) (number / i);
                    secondaryMultiplier = i;
                    break;
                }
            }
        }

        System.out.println(firstMultiplier + " * " + secondaryMultiplier + " = " + number);
    }

    private static long buildPalindrome(int firstPart) {
        String firstPartStr = String.valueOf(firstPart);
        String resultStr = firstPartStr + new StringBuilder(firstPartStr).reverse();

        return Long.valueOf(resultStr);
    }
}
