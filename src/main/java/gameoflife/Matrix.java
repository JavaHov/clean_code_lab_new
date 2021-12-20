package gameoflife;

public class Matrix {


    private int rows;
    private int columns;
    //private boolean STATE = false;
    private final static int DEAD = 0;
    private final static int ALIVE = 1;
    private int[][] matrix;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new int[rows][columns];

        for(int y  = 0; y < rows; y++) {
            for(int x = 0; x < columns; x++) {
                matrix[y][x] = DEAD;
            }
        }
    }


    public int getLivingNeighbours() {

        return 1;
    }
}
