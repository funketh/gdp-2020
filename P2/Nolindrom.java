public class Nolindrom {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Bitte geben Sie die Obergrenze als Parameter an.");
            System.exit(-1);
        }

        int limit = Integer.parseInt(args[0]);

        long N = 1;
    }

    public static long reverseNum(long x) {
        long r = 0;
        while (x != 0) {
            r = (r * 10) + (x % 10);
            x /= 10;
        }
        return r;
    }
}
