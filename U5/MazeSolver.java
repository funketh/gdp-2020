import gdp.stdlib.StdDraw;

public class MazeSolver {

    public static boolean solve(int[][] maze, int row, int col) {
        if (maze[row][col] == 3)
            return true;

        int c = maze[row][col];
        maze[row][col] = 2;
        draw(maze);
        StdDraw.show(100);

        // go left if possible
        if (col-1 >= 0 && maze[row][col-1] != 0)
            if (solve(maze, row, col-1))
                return true;

        // go down if going left any further wasn't an option
        if (row+1 < maze.length && maze[row+1][col] != 0)
            if (solve(maze, row+1, col))
                return true;

        maze[row][col] = c;
        draw(maze);
        StdDraw.show(100);
        return false;
    }

    public static void draw(int[][] maze) {
        StdDraw.setXscale(0, maze.length);
        StdDraw.setYscale(0, maze[0].length);

        for (int x = 0; x < maze[0].length; x++) {
            for (int y = 0; y < maze.length; y++) {
                switch (maze[maze.length - 1 - y][x]) {
                    case 0:
                        StdDraw.setPenColor(StdDraw.GRAY);
                        break;
                    case 1:
                        StdDraw.setPenColor(StdDraw.WHITE);
                        break;
                    case 2:
                        StdDraw.setPenColor(StdDraw.GREEN);
                        break;
                    case 3:
                        StdDraw.setPenColor(StdDraw.BLUE);
                        break;
                }
                StdDraw.filledSquare(x + 0.5, y + 0.5, 0.48);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.line(x, y, x + 1, y);
                StdDraw.line(x, y, x, y + 1);
                StdDraw.line(x + 1, y, x + 1, y + 1);
                StdDraw.line(x, y + 1, x + 1, y + 1);
            }
        }
    }
}
