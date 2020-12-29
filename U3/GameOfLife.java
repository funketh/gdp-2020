import gdp.stdlib.StdIn;
import gdp.stdlib.StdOut;
import gdp.stdlib.StdDraw;

public class GameOfLife {
    public static void main(String[] args) {
        int COOLDOWN = 200;
        double RADIUS = 0.4;

        int X = StdIn.readInt();
        int Y = StdIn.readInt();
        boolean[][] board = new boolean[X][Y];

        int aliveCells = StdIn.readInt();
        // initialize alive cells to true
        for (int i = 0; i < aliveCells; i++)
            board[StdIn.readInt()][StdIn.readInt()] = true;

        // set up grid
        StdDraw.setXscale(0, X);
        StdDraw.setYscale(0, Y);
        StdDraw.setPenColor(StdDraw.BLUE);
        for (int x = 0; x <= X; x++)
            StdDraw.line(x, 0, x, Y);
        for (int y = 0; y <= Y; y++)
            StdDraw.line(0, y, X, y);

        while (true) {
            for (int i = 0; i < X; i++) {
                for (int j = 0; j < Y; j++) {
                    // use green for alive cells and white for dead ones
                    if (board[i][j])
                        StdDraw.setPenColor(StdDraw.GREEN);
                    else
                        StdDraw.setPenColor(StdDraw.WHITE);

                    StdDraw.filledSquare(i + 0.5, j + 0.5, RADIUS);
                }
            }
            StdDraw.show(COOLDOWN);
            oneRound(board, X, Y);
        }
    }

    static void oneRound(boolean[][] board, int X, int Y) {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                int n = neighbours(board, X, Y, i, j);

                if (!board[i][j] && n == 3)
                    board[i][j] = true;
                else if (board[i][j] && (n == 2 || n == 3))
                    board[i][j] = true;
                else
                    board[i][j] = false;
            }
        }
    }

    static int neighbours(boolean[][] board, int X, int Y, int x, int y) {
        int n = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                int adj_k = adjustOverflow(X, i);
                int adj_l = adjustOverflow(Y, j);
                if (board[adj_k][adj_l])
                    n++;
            }
        }
        return n;
    }

    static int adjustOverflow(int length, int index) {
        if (index >= length)
            return index - length;
        if (index < 0)
            return length + index;
        return index;
    }
}
