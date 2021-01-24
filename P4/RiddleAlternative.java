import java.util.ArrayList;

class RiddleAlternative {
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
        int[] counter = new int[N];
        for (int x = 1; x <= N; x++){
            counter[x-1] += 1;
            riddle(N, new int[] {x}, counter, list);
            counter[x-1] -= 1;
        }
        int l = list.toArray().length;
        if (l == 0)
            System.out.println("keine Loesung");
        else if (l == 1)
            System.out.println("eine Loesung");
        else
            System.out.println(l + " Loesungen");
    }

    static void riddle(int n, int[] a, int[] counter, ArrayList<int[]> solutions) {

        /*
        for (int x : a){
            System.out.print(x);
        }
        System.out.println();
        
        for (int x : counter){
            System.out.print(x);
        }
        System.out.println();

        if (counter[a[a.length-1]-1] > 2){
            return;
        }
        */

        for (int i = 0; i < a.length-1; i++){
            if (i + a[i] + 1 == a.length - 1){
                if (counter[a[i]-1] != 2 && a[i] != a[a.length-1]){
                    return;
                }
            } else if (a[i] == a[a.length-1]){
                return;
            }
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

        for (int x = 1; x <= n; x++){
            counter[x-1] += 1;
            riddle(n, append(a, x), counter, solutions);
            counter[x-1] -= 1;
        }
    }

    static int[] append(int[] a, int i) {
        int[] b = new int[a.length + 1];
        System.arraycopy(a, 0, b, 0, a.length);
        b[a.length] = i;
        return b;
    }
}
