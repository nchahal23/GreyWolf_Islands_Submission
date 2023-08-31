import java.util.Scanner;

public class ClosedIslands {
    
    public int numclosedIsland(int[][] matrix_grid) {
        if (matrix_grid == null || matrix_grid.length == 0) {
            return 0;
        }

        int rows = matrix_grid.length;
        int cols = matrix_grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int closedIslands = 0;

        // Traverse the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if ((row*col == 0 || row == rows-1 || col == cols-1) && visited[row][col] == false && matrix_grid[row][col] == 1) {
                    dfs(matrix_grid, row, col, visited);    
                }
            }
        }

        // Track closed islands
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (visited[row][col] == false && matrix_grid[row][col] == 1) {
                    closedIslands++;
                    dfs(matrix_grid, row, col, visited);
                }
            }
        }

        return closedIslands;
    }

    private void dfs(int[][] matrix_grid, int row, int col, boolean[][] visited) {
        int rows = matrix_grid.length;
        int cols = matrix_grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] == true || matrix_grid[row][col]== 0) {
            return;  // Island touches the boundary
        }

        visited[row][col] = true;  // Mark visited cell

        // Explore adjacent cells in the matrix
        dfs(matrix_grid, row + 1, col, visited);
        dfs(matrix_grid, row - 1, col, visited);
        dfs(matrix_grid, row, col + 1, visited);
        dfs(matrix_grid, row, col - 1, visited);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of rows: ");
        int row = sc.nextInt();
        System.out.println("Enter the no. of columns: ");
        int col = sc.nextInt();
        System.out.println("Enter Matrix grid values (boolean): ");
        int[][] matrix_grid = new int[row][col];
        for(int i=0; i<row; i++)
         {            
            for(int j=0; j<col; j++)
            {
                matrix_grid[i][j]=sc.nextInt();
            }
         }
         
        // matrix_grid = 1 1 0 1 1
                    //   1 0 1 0 0
                    //   0 0 0 0 1
                    //   1 1 0 1 1

        ClosedIslands solution = new ClosedIslands();
        int totalclosedIslands = solution.numclosedIsland(matrix_grid);
        System.out.println("Total number of closed islands: " + totalclosedIslands);
        sc.close();
    }
}
