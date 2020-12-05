public class KVNummerPruefer {
    public static void main(String[] args) {
        String ensurance_num = args[0];

        // only the base number of the input
        String base_num = ensurance_num.substring(0, ensurance_num.length() - 1);
        // the input control number we will test
        int control_num = int_value(ensurance_num.charAt(ensurance_num.length() - 1));

        int my_control_num = calc_control_num(base_num);

        if (my_control_num == control_num)
            System.out.println("Korrekt");
        else
            System.out.println("Inkorrekt\nKorrekte Ziffer: " + my_control_num);
    }

    public static int calc_control_num(String base_num) {
        int[] weights = {7, 3, 1};
        int sum = 0;

        for (int i = 0; i < base_num.length(); i++) {
            int value = int_value(base_num.charAt(i));
            int weight = weights[i % weights.length];
            sum += value * weight;
        }

        return (sum / 10 * 10 + 10 - sum) % 10;
    }

    public static int int_value(char c) {
        if      (+c >= 48 && 57 >= +c) return c - 48; // numerical digit
        else if (+c >= 65 && 90 >= +c) return c - 55; // capital letter
        else throw new InvalidArgumentException("Invalid digit: " + c);
    }
}
