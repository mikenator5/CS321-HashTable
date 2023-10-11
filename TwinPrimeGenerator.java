import java.util.Arrays;

public class TwinPrimeGenerator {

    private static boolean isPrime(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count <= 2;
    }
    public static int[] generateTwinPrime(int min, int max) {
        for (int i = min + 2; i <= max; i++) {
            if (isPrime(i) && isPrime(i - 2)) {
                return new int[]{i - 2, i};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] twins = generateTwinPrime(95500, 96000);
        System.out.println(Arrays.toString(twins));
    }
}
