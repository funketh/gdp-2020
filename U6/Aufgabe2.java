public class Aufgabe2_Vorlage {

    // Teilaufgabe Zeile 17
    public static boolean[] aufgabe_zeile17(boolean ergebnisseAusgeben) {
        // Geben Sie hier bitte für jede Aussage an, ob die Aussage richtig (true)
        // oder falsch (false) ist.
        boolean a = true; // Aussage a
        boolean b = true; // Aussage b
        boolean c = false; // Aussage c
        boolean d = false; // Aussage d
        boolean e = false; // Aussage e
        
        // ab hier bitte nichts mehr ändern
        boolean[] antworten = { a, b, c, d, e };
        if (ergebnisseAusgeben)
            print("Zeile 17", antworten);
        return antworten;
    }

    // Teilaufgabe Zeile 19
    public static boolean[] aufgabe_zeile19(boolean ergebnisseAusgeben) {
        // Geben Sie hier bitte für jede Aussage an, ob die Aussage richtig (true)
        // oder falsch (false) ist.
        boolean a = true; // Aussage a
        boolean b = true; // Aussage b
        boolean c = false; // Aussage c
        boolean d = false; // Aussage d
        boolean e = false; // Aussage e

        // ab hier bitte nichts mehr ändern
        boolean[] antworten = { a, b, c, d, e };
        if (ergebnisseAusgeben)
            print("Zeile 19", antworten);
        return antworten;
    }

    // Teilaufgabe Zeile 20
    public static boolean[] aufgabe_zeile20(boolean ergebnisseAusgeben) {
        // Geben Sie hier bitte für jede Aussage an, ob die Aussage richtig (true)
        // oder falsch (false) ist.
        boolean a = false; // Aussage a
        boolean b = true; // Aussage b
        boolean c = true; // Aussage c
        boolean d = false; // Aussage d

        // ab hier bitte nichts mehr ändern
        boolean[] antworten = { a, b, c, d };
        if (ergebnisseAusgeben)
            print("Zeile 20", antworten);
        return antworten;
    }

    // Teilaufgabe Zeile 21
    public static boolean[] aufgabe_zeile21(boolean ergebnisseAusgeben) {
        // Geben Sie hier bitte für jede Aussage an, ob die Aussage richtig (true)
        // oder falsch (false) ist.
        boolean a = false; // Aussage a
        boolean b = true; // Aussage b
        boolean c = true; // Aussage c
        boolean d = false; // Aussage d

        // ab hier bitte nichts mehr ändern
        boolean[] antworten = { a, b, c, d };
        if (ergebnisseAusgeben)
            print("Zeile 21", antworten);
        return antworten;
    }

    // Teilaufgabe Zeile 22
    public static boolean[] aufgabe_zeile22(boolean ergebnisseAusgeben) {
        // Geben Sie hier bitte für jede Aussage an, ob die Aussage richtig (true)
        // oder falsch (false) ist.
        boolean a = false; // Aussage a
        boolean b = true; // Aussage b
        boolean c = false; // Aussage c
        boolean d = true; // Aussage d

        // ab hier bitte nichts mehr ändern
        boolean[] antworten = { a, b, c, d };
        if (ergebnisseAusgeben)
            print("Zeile 22", antworten);
        return antworten;
    }
    
    // Teilaufgabe Zeile 23
    public static boolean[] aufgabe_zeile23(boolean ergebnisseAusgeben) {
        // Geben Sie hier bitte für jede Aussage an, ob die Aussage richtig (true)
        // oder falsch (false) ist.
        boolean a = false; // Aussage a
        boolean b = true; // Aussage b
        boolean c = false; // Aussage c
        boolean d = true; // Aussage d

        // ab hier bitte nichts mehr ändern
        boolean[] antworten = { a, b, c, d };
        if (ergebnisseAusgeben)
            print("Zeile 23", antworten);
        return antworten;
    }

    // Ausgabe der gewählten Antworten
    private static void print(String teilaufgabe, boolean[] b) {
        System.out.println("Teilaufgabe " + teilaufgabe + ")");
        for (int i = 0; i < b.length; i++) {
            System.out.print("Aussage " + (char) (65 + i) + " ist ");
            System.out.println(b[i] ? "richtig." : "falsch.");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Unsere Antwortmöglichkeiten für Aufgabe 1\n");
        aufgabe_zeile17(true);
        aufgabe_zeile19(true);
        aufgabe_zeile20(true);
        aufgabe_zeile21(true);
        aufgabe_zeile22(true);
        aufgabe_zeile23(true);
    }
}
