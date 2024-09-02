import java.util.Scanner;

public class RatMazeSolving {
    static int sol[][], cont = 0;

    static boolean MazeSolve(int maze[][], int x, int y) {
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isPassible(maze, x, y)) {
            sol[x][y] = 1;

            if (MazeSolve(maze, x, y + 1))
                return true;

            if (MazeSolve(maze, x + 1, y))
                return true;

            sol[x][y] = 0;
        }
        return false;
    }

    static boolean isPassible(int maze[][], int x, int y) {
        cont++;
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        int maze[][] = new int[rows][columns];
        System.out.println("Enter the maze (0 for blocked cell, 1 for open cell):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        sol = new int[rows][columns];

        if (MazeSolve(maze, 0, 0)) {
            System.out.println("Solution:");
            for (int i = 0; i < sol.length; i++) {
                for (int j = 0; j < sol[0].length; j++)
                    System.out.print(" " + sol[i][j] + " ");
                System.out.println();
            }
        } else
            System.out.println("Solution is not possible");

        scanner.close();
    }
}
