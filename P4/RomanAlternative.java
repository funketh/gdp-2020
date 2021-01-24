class RomanAlternative {
    static final int[] romanNumerals = { 1, 5, 10, 50, 100, 500, 1000 };
    static final String[] romanLetters = { "I", "V", "X", "L", "C", "D", "M" };

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Bitte eine Zahl als Parameter angeben.");
            System.exit(1);
        }
        int N = Integer.parseInt(args[0]);
        if (!(1 <= N && N <= 5000)) {
            System.out.println("Die Zahl muss zwischen 1 und 5000 liegen.");
            System.exit(1);
        }
        System.out.println(roman(N));
    }

    // wrapper function starting recursion
    static String roman(int n) {
        return romanHelper(n, romanNumerals.length - 1);
    }

    static String romanHelper(int n, int i) {
        int b = romanNumerals[i];

        // calculate how often b fits into n
        int r = n / b;

        String str = repeat(romanLetters[i], r);
        
        // reduce number 
        n = n % b;

        // check whether four successive letters need to be replaced
        // then check whether five + four successive letters need to be replaced
        if (b != 1000 && r == 4) {
            str = romanLetters[i] + romanLetters[i + 1];
            if (b == 1)
                return str;
            return str + romanHelper(n % b, i - 1);
        } else if (i > 1 && i % 2 == 0 && n / romanNumerals[i - 2] == 9) {
            b = romanNumerals[i - 2];
            str += romanLetters[i - 2] + romanLetters[i];
            if (b == 1)
                return str;
            return str + romanHelper(n % b, i - 2);
        } else if (b == 1) {
            return str;
        }
        return str + romanHelper(n, i - 1);
    }

    static String repeat(String str, int n) {
        if (n == 0)
            return "";
        return str + repeat(str, n - 1);
    }
}
