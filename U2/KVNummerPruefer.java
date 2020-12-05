public class KVNummerPruefer {
    public static void main(String[] args) {
        String ensuranceNum = args[0];

        // only the base number of the input
        String baseNum = ensuranceNum.substring(0, ensuranceNum.length() - 1);
        // the input control number we will test
        int controlNum = intValue(ensuranceNum.charAt(ensuranceNum.length() - 1));

        int myControlNum = calcControlNum(baseNum);

        if (myControlNum == controlNum)
            System.out.println("Korrekt");
        else
            System.out.println("Inkorrekt\nKorrekte Ziffer: " + myControlNum);
    }

    public static int calcControlNum(String baseNum) {
        int[] weights = {7, 3, 1};
        int sum = 0;

        for (int i = 0; i < baseNum.length(); i++) {
            int value = intValue(baseNum.charAt(i));
            int weight = weights[i % weights.length];
            sum += value * weight;
        }

        return (sum / 10 * 10 + 10 - sum) % 10;
    }

    public static int intValue(char c) {
        if      (+c >= 48 && 57 >= +c) return c - 48; // numerical digit
        else if (+c >= 65 && 90 >= +c) return c - 55; // capital letter
        else throw new IllegalArgumentException("Invalid digit: " + c);
    }
}
