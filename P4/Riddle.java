import java.util.ArrayList;

class Riddle {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Bitte eine Zahl als Parameter angeben.");
            System.exit(1);
        }
        int N = Integer.parseInt(args[0]);
        if (! (0 < N && N <= 15)) {
            System.out.println("Die Zahl muss zwischen 1 und 15 liegen.");
            System.exit(1);
        }
        ArrayList<int[]> list = new ArrayList<int[]>();
        riddle(N, new int[] {}, list);
        int l = list.toArray().length;
        if (l == 0)
            System.out.println("keine Loesung");
        else if (l == 1)
            System.out.println("eine Loesung");
        else
            System.out.println(l + " Loesungen");
    }

    static void riddle(int n, int[] a, ArrayList<int[]> solutions) {
        int[] indices = new int[n];
        int[] counter = new int[n];

        for (int i = 0; i < a.length; i++) {
            for (int x = 1; x <= n; x++)
                if (counter[x - 1] == 1 && i - indices[x - 1] - 1 > x)
                    return;

            if (counter[a[i] - 1] > 1)
                return;
            counter[a[i] - 1] += 1;

            int lastIndex = indices[a[i] - 1];
            if (lastIndex != 0 && i - lastIndex != a[i])
                return;
            indices[a[i] - 1] = i + 1;
        }

        if (a.length == 2 * n) {
            for (int[] b : solutions) {
                boolean areEqual = true;
                for (int i = 0; i < a.length; i++) {
                    if (a[i] != b[b.length-1 - i])
                        areEqual = false;
                }
                if (areEqual)
                    return;
            }

            solutions.add(a);

            if (n >= 10)
                return;
            for (int x : a)
                 System.out.print(x);
            System.out.println();
            return;
        }

        for (int x = 1; x <= n; x++)
            riddle(n, append(a, x), solutions);
    }

    static int[] append(int[] a, int i) {
        int[] b = new int[a.length + 1];
        System.arraycopy(a, 0, b, 0, a.length);
        b[a.length] = i;
        return b;
    }
}
