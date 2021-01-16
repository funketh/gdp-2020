public class ArmstrongNumbers {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] arr = giveArmstrongNumbers(n);
        printArray(arr);
    }

    public static boolean isArmstrongNumber(int number) {
        int[] digits = toDigits(number);
        int sum = 0;
        for (int d : digits)
            sum += Math.pow(d, digits.length);
        return sum == number;
    }

    public static int[] toDigits(int number) {
        if (number == 0)
            return new int[] { 0 };

        int l = 0;
        for (int m = number; m != 0; m /= 10)
            l++;

        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = number % 10;
            number /= 10;
        }
        return arr;
    }

    public static int[] giveArmstrongNumbers(int n) {
        int[] arr = new int[n];
        for (int i = 0, c = 0; c < n; i++)
            if (isArmstrongNumber(i)) {
                arr[c] = i;
                c++;
            }
        return arr;
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(i < a.length - 1 ? ", " : "\n");
        }
    }
}
