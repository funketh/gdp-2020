class Roman {
    static final int[] romanNumerals = { 1, 5, 10, 50, 100, 500, 1000 };
    static final String[] romanLetters = { "I", "V", "X", "L", "C", "D", "M" };

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Bitte eine Zahl als Parameter angeben.");
            System.exit(1);
        }
        int N = Integer.parseInt(args[0]);
        if (! (1 <= N && N <= 5000)) {
            System.out.println("Die Zahl muss zwischen 1 und 5000 liegen.");
            System.exit(1);
        }
        System.out.println(roman(N));
    }

    static String roman(int n) {
        return romanHelper(n, romanNumerals.length - 1);
    }

    static String romanHelper(int n, int i) {
        int b = romanNumerals[i];

        int r = n / b;
        String str;
        if (i != romanNumerals.length - 1)
            if (r == 4) {
                str = romanLetters[i] + romanLetters[i + 1];
                if (b == 1)
                    return str;
                return str + romanHelper(n % b, i - 1);
            }
            else if (r == 1) {
                int nextN = n % b;
                int nextB = romanNumerals[i - 1];
                int nextR = nextN / nextB;
                if (nextR == 4) {
                    str = romanLetters[i - 1] + romanLetters[i + 1];
                    if (b == 5)
                        return str;
                    return str + romanHelper(nextN % nextB, i - 2);
                }
            }

        str = repeat(romanLetters[i], r);
        if (b == 1)
            return str;
        return str + romanHelper(n % b, i - 1);
    }

    static String repeat(String str, int n) {
        if (n == 0) return "";
        return str + repeat(str, n - 1);
    }
}
