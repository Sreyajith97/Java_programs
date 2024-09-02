import java.util.Stack;

public class celebritySolution {
    public static int celebritySol(int[][] mat) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < mat.length; i++) {
            stk.push(i);
        }
        while (stk.size() > 1) {
            int col = stk.pop();
            int row = stk.pop();
            if (mat[row][col] == 1) {
                stk.push(col);
            } else {
                stk.push(row);
            }
        }
        int x = stk.pop();
        for (int j = 0; j < mat.length; j++) {
            if (j == x)
                continue;
            if (mat[x][j] == 1) {
                return -1;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            if (i == x)
                continue;
            if (mat[i][x] == 0) {
                return -1;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 1, 0 }, 
                           { 0, 0, 0, 0 }, 
                           { 0, 1, 0, 0 }, 
                           { 1, 1, 0, 0 } };
        int res = celebritySol(matrix);  
        if (res == -1) {
            System.out.println("There is no celebrity in the party");
        } else {
            System.out.println(res + " is the celebrity in the party");
        }
    }
}
