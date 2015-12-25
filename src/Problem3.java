import java.util.ArrayList;
import java.util.List;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 */
public class Problem3 {
    private static final long FACTORIZED_NUMBER = 600851475143L;

    public static void main(String[] args) {
        List<Integer> numbers = processNumbers(getFactors(FACTORIZED_NUMBER));

        System.out.println(numbers.get(numbers.size() - 1));
    }

    private static List<Integer> getFactors(long number) {
        List<Integer> result = new ArrayList<>();
        int maxFactor = (int) Math.sqrt(number);

        for (int i = 2; i <= maxFactor; i++) {
            if (number % i == 0) {
                if (!result.contains(i)) {
                    result.add(i);
                }
            }
        }

        return result;
    }

    private static List<Integer> processNumbers(List<Integer> numbers) {
        int index = 0;
        while (index < numbers.size()) {
            if (!getFactors(numbers.get(index)).isEmpty()) {
                numbers.remove(index);
                continue;
            }

            index++;
        }

        return numbers;
    }
}
