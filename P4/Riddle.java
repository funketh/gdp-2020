import java.util.ArrayList;
import java.util.Iterator;

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
        int l = riddle(N);
        if (l == 0)
            System.out.println("keine Loesung");
        else if (l == 1)
            System.out.println("eine Loesung");
        else
            System.out.println(l + " Loesungen");
    }

    static int riddle(int n) {
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] counter = new int[n];
        int[] a = new int[2*n];
        int[] solutionNum = {0};
        for (int x = 1; x <= n; x++){
            counter[x-1] += 1;
            a[0] = x;
            riddleHelper(n, a, 1, counter, list, solutionNum);
            a[0] = 0;
            counter[x-1] -= 1;
        }
        return solutionNum[0];
    }

    static void riddleHelper(int n, int[] a, int aLength, int[] counter, ArrayList<int[]> solutions, int[] solutionNum) {
        int l = aLength;

        int c = counter[a[l-1]-1];
        if (c > 2)
            return;
        if (c == 2) {
            int i = l-1 - a[l-1]-1;
            if (i < 0 || a[i] != a[l-1])
                return;
        }

        for (int i = 0; i < l-1; i++)
            if (i + a[i] + 1 == l - 1)
                if (counter[a[i]-1] != 2 && a[i] != a[l-1])
                    return;

        if (a[a.length-1] != 0) {
            Iterator<int[]> iter = solutions.iterator();
            while (iter.hasNext()) {
                int[] b = iter.next();

                boolean areEqual = true;
                for (int i = 0; i < l; i++) {
                    if (a[i] != b[b.length-1 - i])
                        areEqual = false;
                }

                if (areEqual) {
                    iter.remove();
                    return;
                }
            }

            solutions.add(a.clone());
            solutionNum[0]++;

            if (n >= 10)
                return;
            for (int x : a)
                 System.out.print(x);
            System.out.println();
            return;
        }

        for (int x = 1; x <= n; x++){
            counter[x-1] += 1;
            a[l] = x;
            riddleHelper(n, a, aLength + 1, counter, solutions, solutionNum);
            a[l] = 0;
            counter[x-1] -= 1;
        }
    }
}
