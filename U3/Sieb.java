public class Sieb {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        print_first_primes(N);
    }

    public static void print_first_primes(int N) {
        if (N == 0)
            return;

        int M = 9;
        int count = 0;
        int i = 2;
        while (true) {
            // recalculate all primes <= M
            boolean[] p = sieve(M);

            // print all new primes
            while (i < p.length) {
                if (p[i]) {
                    System.out.println(i);
                    if (++count == N)
                        return;
                }
                i++;
            }

            // didn't find enough primes, check 10 times more numbers
            M *= 10;
        }
    }

    public static boolean[] sieve(int M) {
        boolean[] p = new boolean[M];
        for (int i = 2; i < M; i++)
            p[i] = true; // initialization: no factors found yet

        for (int i = 2; i * i < M; i++) {
            if (p[i]) {
                // i is prime number -> leave p[i] == true
                // mark multiples of i as nonprime
                for (int k = 2; k * i < M; k++)
                    p[k * i] = false;
            }
        }

        return p;
    }
}
