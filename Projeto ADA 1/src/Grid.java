public class Grid {

    public final int rows;
    public final int cols;

    public Grid(char[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
    }
}
