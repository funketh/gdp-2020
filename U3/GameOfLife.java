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
            board = oneRound(board, X, Y);
        }
    }

    static boolean[][] oneRound(boolean[][] board, int X, int Y) {
        boolean[][] newBoard = deepcopy(board);
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                int n = neighbours(board, X, Y, i, j);

                if (!board[i][j] && n == 3)
                    newBoard[i][j] = true;
                else if (board[i][j] && (n == 2 || n == 3))
                    newBoard[i][j] = true;
                else
                    newBoard[i][j] = false;
            }
        }
        return newBoard;
    }

    static boolean[][] deepcopy(boolean[][] arr) {
        if (arr.length == 0)
            return new boolean[][] {};

        boolean[][] newArr = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++)
            newArr[i] = arr[i].clone();
        return newArr;
    }

    static int neighbours(boolean[][] board, int X, int Y, int x, int y) {
        int n = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                int adj_i = adjustOverflow(X, i);
                int adj_j = adjustOverflow(Y, j);
                if (adj_i == x && adj_j == y)
                    continue;
                if (board[adj_i][adj_j])
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
