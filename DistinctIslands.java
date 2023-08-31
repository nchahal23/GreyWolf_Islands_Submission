import java.util.Scanner;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class DistinctIslands {

    public int numDistinctIslands(int[][] matrix_grid) {
        if (matrix_grid == null || matrix_grid.length == 0) {
            return 0;
        }

        int rows = matrix_grid.length;
        int cols = matrix_grid[0].length;
        HashSet<List<Integer>> distinctIslands = new HashSet<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix_grid[row][col] == 1) {
                    List<Integer> shape = new ArrayList<>();
                    dfs(matrix_grid, row, col, shape, 0);  // Origin is the point of island
                    if (shape.size() > 1) {  // Excluding single '1' island
                        distinctIslands.add(shape);
                    }
                }
            }
        }

        return distinctIslands.size();
    }


    private void dfs(int[][] matrix_grid, int row, int col, List<Integer> shape, int direction) {
        int rows = matrix_grid.length;
        int cols = matrix_grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix_grid[row][col] == 0) {
            return;
        }

        matrix_grid[row][col] = 0;  // Mark visited cell as '0'

        // Explore adjacent cells in the matrix
        shape.add(direction);  // Add direction to shape
        dfs(matrix_grid, row + 1, col, shape, 1);  // Down
        dfs(matrix_grid, row - 1, col, shape, 2);  // Up
        dfs(matrix_grid, row, col + 1, shape, 3);  // Right
        dfs(matrix_grid, row, col - 1, shape, 4);  // Left
    }

    public static void main(String[] args) {
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

        DistinctIslands solution = new DistinctIslands();
        int totalDistinctIslands = solution.numDistinctIslands(matrix_grid);
        System.out.println("Total number of distinct islands: " + totalDistinctIslands);
        sc.close();
    }
}
 