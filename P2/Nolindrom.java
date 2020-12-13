import java.math.BigInteger;

public class Nolindrom {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Bitte geben Sie die Obergrenze als Parameter an.");
            System.exit(-1);
        }

        int limit = Integer.parseInt(args[0]);

        if (args.length < 2 || !args[1].equals("x"))
            printNolindromes(limit);
        else
            checkNolindromeOverflows(limit);
    }

    public static void printNolindromes(int limit) {
        N_loop: for (long N = 1; N <= limit; N++) {
            long currentN = N;
            long R = reverseNum(currentN);

            // Check if the sum would overflow
            while (currentN < Long.MAX_VALUE - R) {
                currentN += R;
                R = reverseNum(currentN);

                // Check if the sum is a palindrome
                if (currentN == R)
                    continue N_loop;
            }

            System.out.println(N);
        }
    }

    public static void checkNolindromeOverflows(int limit) {
        for (long N = 1; N <= limit; N++) {
            BigInteger currentN = BigInteger.valueOf(N);
            BigInteger R = reverseNum(currentN);

            for (int i = 1; i <= 100; i++) {
                currentN = currentN.add(R);
                R = reverseNum(currentN);

                // Check if the sum is a palindrome
                if (currentN.compareTo(R) == 0) {
                    if (currentN.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0)
                        break; // Continue if the sum didn't overflow

                    System.out.println(N + " braucht " + i + " Iterationen bis zum Palindrom " + currentN);
                    return;
                }
            }
        }

        System.out.println("alle Zahlen werden auch durch Abbruch per Ueberlauf gefunden");
    }

    public static long reverseNum(long x) {
        long r = 0;
        while (x != 0) {
            r = (r * 10) + (x % 10);
            x /= 10;
        }
        return r;
    }

    public static BigInteger reverseNum(BigInteger x) {
        BigInteger r = BigInteger.ZERO;
        while (x.compareTo(BigInteger.ZERO) != 0) {
            r = r.multiply(BigInteger.TEN).add(x.mod(BigInteger.TEN));
            x = x.divide(BigInteger.TEN);
        }
        return r;
    }
}
