import java.io.IOException;
import java.util.Scanner;

class Oktadoku {
    public enum Variante {
        normal, mitDiagonalen
    };

    private Variante var;
    private Integer[][] songoku;

    public Oktadoku(Variante var) {
        this.var = var;
        this.songoku = new Integer[8][8];
    }

    public void read() throws IOException {
        Scanner sc = new Scanner(System.in).useDelimiter("");

        for (int i = 0; i < songoku.length; i++) {
            for (int j = 0; j < songoku[i].length; j++) {
                String s = Character.toString((char) sc.next().charAt(0));
                Integer v;
                try {
                    v = Integer.parseInt(s);
                    if (v < 1 || v > 8)
                        v = null;
                } catch (NumberFormatException e) {
                    v = null;
                }
                songoku[i][j] = v;
            }
            sc.nextLine();
        }
        sc.close();
    }

    public void write() {
        System.out.println("+-----+-----+-----+-----+");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                boolean even = j % 2 == 0;

                if (even)
                    System.out.print("|");
                System.out.print(" ");

                if (songoku[i][j] == null)
                    System.out.print(" ");
                else
                    System.out.print(songoku[i][j]);

                if (!even)
                    System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("+-----+-----+-----+-----+");
        for (int i = 4; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean even = j % 2 == 0;

                if (even)
                    System.out.print("|");
                System.out.print(" ");

                if (songoku[i][j] == null)
                    System.out.print(" ");
                else
                    System.out.print(songoku[i][j]);

                if (!even)
                    System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("+-----+-----+-----+-----+");
    }

    public boolean check() {
        for (int i = 0; i < songoku.length; i++)
            for (int j = 0; j < songoku[0].length; j++)
                if (!checkAt(i, j))
                    return false;
        return true;
    }

    boolean checkAt(int x, int y) {
        Integer v = songoku[x][y];
        if (v == null)
            return true;

        // check row
        for (int j = 0; j < songoku[x].length; j++)
            if (j != y && songoku[x][j] != null && songoku[x][j] == v)
                return false;

        // check column
        for (int i = 0; i < songoku.length; i++)
            if (i != x && songoku[i][y] != null && songoku[i][y] == v)
                return false;

        // check rectangle
        int rectRow = x / 4;
        int rectCol = y / 2;
        int startX = rectRow * 4;
        int startY = rectCol * 2;
        for (int i = startX; i <= startX + 3; i++)
            for (int j = startY; j <= startY + 1; j++)
                if (!(i == x && j == y) && songoku[i][j] != null && songoku[i][j] == v)
                    return false;

        // check diagonal
        if (this.var == Variante.mitDiagonalen)
            if (x == y) {
                for (int i = 0, j = 0; i < 8; i++, j++)
                    if (!(i == x && j == y) && songoku[i][j] != null && songoku[i][j] == v)
                        return false;
            } else if (x + y == 7) {
                for (int i = 0, j = 7; i < 8; i++, j--)
                    if (!(i == x && j == y) && songoku[i][j] != null && songoku[i][j] == v)
                        return false;
            }

        return true;
    }

    public void solve() {
        int[] a = nextFreeIndex(0, 0);
        int x = a[0];
        int y = a[1];
        boolean solvable = false;
        for (int i = 1; i <= 8; i++)
            if (solveHelper(i, x, y)) {
                solvable = true;
                break;
            } else
                songoku[x][y] = null;
        if (solvable) {
            System.out.println(this.var == Variante.normal ? "Oktadoku" : "Oktadoku mit Diagonalen");
            write();
        } else {
            System.out.println("nicht loesbar :-(");
        }
    }

    boolean solveHelper(int v, int x, int y) {
        songoku[x][y] = v;

        if (!checkAt(x, y))
            return false;

        int[] a = nextFreeIndex(0, 0);
        if (a == null)
            return true;
        x = a[0];
        y = a[1];
        for (int i = 1; i <= 8; i++)
            if (solveHelper(i, x, y))
                return true;
            else
                songoku[x][y] = null;
        return false;
    }

    int[] nextFreeIndex(int x, int y) {
        while (songoku[x][y] != null)
            if (y < songoku[0].length - 1)
                y++;
            else if (x < songoku.length - 1) {
                y = 0;
                x++;
            } else
                return null;
        return new int[] { x, y };
    }
}
