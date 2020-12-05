public class GGT {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        if (a <= 0 || b <= 0) {
            System.out.println("nur positive ganze Zahlen als Argumente erlaubt");
            System.exit(-1);
        }

        int result = gcd(a, b);

        System.out.println("ggT(" + a + ", " + b + ") = " + result);
    }

    public static int gcd(int a, int b) {
        int r;
        int tmp; // used to swap other variables

        // repeat until the gcd is found (which is when r == 0)
        do {
            // a becomes the larger one and b the smaller one of {a, b}
            if (a < b) {
                // swap a and b
                tmp = a;
                a = b;
                b = tmp;
            }

            r = a - b;
            a = b;
            b = r;
        } while (r != 0);

        return a;
    }
}
