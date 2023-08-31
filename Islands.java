import java.util.Scanner;

public class Islands {
    
    public int numIslands(int[][] matrix_grid) {
        if (matrix_grid == null || matrix_grid.length == 0) {
            return 0;
        }

        int rows = matrix_grid.length;
        int cols = matrix_grid[0].length;
        int totalIslands = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix_grid[row][col] == 1) {
                    int count = dfs(matrix_grid, row, col);
                    if (count > 1) {  // Count only if more than one '1' in the group (horizontally or vertically)
                        totalIslands++;
                    }
                }
            }
        }

        return totalIslands;
    }

    private int dfs(int[][] matrix_grid, int row, int col) {
        int rows = matrix_grid.length;
        int cols = matrix_grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix_grid[row][col] == 0) {
            return 0;
        }

        matrix_grid[row][col] = 0;  // Marking visited cells as '0'

        // Explore adjacent cells in the matrix
        int count = 1;
        count += dfs(matrix_grid, row + 1, col);
        count += dfs(matrix_grid, row - 1, col);
        count += dfs(matrix_grid, row, col + 1);
        count += dfs(matrix_grid, row, col - 1);
        return count;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of rows: ");
        int row = sc.nextInt();
        System.out.println("Enter the no. of columns: ");
        int col = sc.nextInt();
        System.out.println("Enter Matrix grid values (boolean): ");
        int[][] matrix_grid = new int[row][col];
        for(int i=0; i<row;i++)
         {            
            for(int j=0; j<col;j++)
            {
                matrix_grid[i][j]=sc.nextInt();
            }
         }
         
        // matrix_grid = 1 1 0 1 1
                    //   1 0 1 0 0
                    //   0 0 0 0 1
                    //   1 1 0 1 1

        Islands solution = new Islands();
        int totalIslands = solution.numIslands(matrix_grid);
        System.out.println("Total number of islands: " + totalIslands);
        sc.close();
    }
}
