class Bigs {
    // addiert die Ziffernfelder a und b
    public static int[] add(int[] a, int[] b) {
        int minL = Math.min(a.length, b.length);
        int maxL = Math.max(a.length, b.length);

        int[] maxA;
        if (a.length == maxL)
            maxA = a;
        else
            maxA = b;

        int[] result = new int[maxL];
        int carry = 0;

        for (int i = 0; i < minL; i++) {
            int sum = a[i] + b[i] + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }

        for (int i = minL; i < maxL; i++) {
            int sum = maxA[i] + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry != 0) {
            int[] newResult = new int[maxL + 1];
            System.arraycopy(result, 0, newResult, 0, maxL);
            newResult[maxL] = carry;
            return newResult;
        }

        return result;
    }

    // gibt das Ziffernfeld n in lesbarer dezimaler Form aus
    // bei sehr langen Zahlen soll das Format verwendet werden, welches auch von
    // bc (s.u.) benutzt wird: Umbruch nach 68 Ziffern mit einem \ am Ende
    static void print(int[] n) {
        for (int i = n.length - 1; i >= 0; i--) {
            System.out.print(n[i]);
            if ((i - n.length) % 68 == 0)
                System.out.println("\\");
        }
        System.out.println();
    }

    // konstruiert ein einstelliges Ziffernfeld aus der Ziffer d
    static int[] digit(int d) {
        return new int[] { d };
    }

    // konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
    static int[] Null() {
        return digit(0);
    }

    // konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
    static int[] One() {
        return digit(1);
    }

    // Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
    static int mod10(int[] n) {
        return n[0];
    }

    // ganzzahliger Quotient bei Division durch 10
    static int[] div10(int[] n) {
        int[] m = new int[n.length - 1];
        System.arraycopy(n, 1, m, 0, m.length);
        return m;
    }

    // Umwandlung einer beliebigen int-Zahl in ein Ziffernfeld
    static int[] fromInt(int n) {
        int l = 0;
        for (int m = n; m != 0; m /= 10)
            l++;

        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = n % 10;
            n /= 10;
        }
        return arr;
    }

    // kopiert den Wert von n
    static int[] copy(int[] n) {
        return n.clone();
    }

    // multipliziert das Ziffernfeld n mit einer (einstelligen!) int-Zahl
    static int[] times(int[] n, int d) {
        int[] result = new int[n.length];
        int carry = 0;
        for (int i = 0; i < n.length; i++) {
            int product = n[i] * d + carry;
            result[i] = product % 10;
            carry = product / 10;
        }

        if (carry != 0) {
            int[] newResult = new int[result.length + 1];
            System.arraycopy(result, 0, newResult, 0, result.length);
            newResult[result.length] = carry;
            return newResult;
        }

        return result;
    }

    // multipliziert das Ziffernfeld n mit 10
    static int[] times10(int[] n) {
        return timesPowerOf10(n, 1);
    }

    static int[] timesPowerOf10(int[] n, int d) {
        int[] result = new int[n.length + d];
        System.arraycopy(n, 0, result, d, n.length);
        return result;
    }

    // multipliziert zwei Ziffernfelder
    static int[] times(int[] a, int[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            int[] prod = times(a, b[i]);
            prod = timesPowerOf10(prod, i);
            result = add(result, prod);
        }
        return result;
    }

    // Quadratzahl eines Ziffernfeldes
    static int[] square(int[] a) {
        return times(a, a);
    }

    // Kubikzahl eines Ziffernfeldes
    static int[] cubic(int[] a) {
        return times(square(a), a);
    }

    // Test auf kleiner-Relation zweier Ziffernfelder: a < b ?
    static boolean less(int[] a, int[] b) {
        if (a.length > b.length)
            return false;
        if (a.length < b.length)
            return true;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] < b[i])
                return true;
            if (a[i] > b[i])
                return false;
        }
        return false;
    }

    // Test auf Gleichheit zweier Ziffernfelder
    static boolean equal(int[] a, int[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                return false;
        return true;
    }

    // Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt
    // mindenstens eine Ziffer, alle Positionen liegen zwischen 0 und 9 keine
    // fuehrenden Nullen (ausser bei Null selbst)
    static boolean ok(int[] n) {
        if (n == null || n.length == 0 || (n.length > 1 && n[n.length - 1] == 0))
            return false;
        for (int i = 0; i < n.length; i++)
            if (n[i] < 0 || n[i] > 9)
                return false;
        return true;
    }

    // gibt die (kleinste) Ziffer mit der groessten Haeufigkeit in n aus
    static void maxDigit(int[] n) {
        int[] digits = new int[10];
        for (int i = 0; i < n.length; i++)
            digits[n[i]]++;

        int max = 0;
        for (int i = 0; i < digits.length; i++)
            if (digits[i] > max)
                max = digits[i];
        System.out.println(max);
    }

    public static void main(String[] s) {
        int[] a = One();
        for (int i = 0; i < 33222; ++i) {
            a = times(a, 2);
        }
        System.out.println("2^33222 hat " + a.length + " Stellen");
        print(a);
        System.out.println();
        int[] b = fromInt(13);
        int[] c = copy(b);
        for (int i = 1; i < 8978; ++i) {
            c = times(c, b);
        }
        System.out.println("13^8978 hat " + c.length + " Stellen");
        print(c);
        System.out.println();
        System.out.println(less(a, c));
        // beantwortet die Frage aus der Aufgabenueberschrift
        maxDigit(a);
        maxDigit(c);
    }
}
