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


    public int getLivingNeighbours(int row, int column) {

        int livingNeighbours = 0;

        int[][] gridToSearch = {{row-1, column-1}, {row-1, column}, {row-1, column+1},
                                {row, column-1}, /*this one*/       {row, column+1},
                                {row+1, column-1}, {row+1, column}, {row+1, column+1}};

        for(int[] cells : gridToSearch) {

            int checkRow = cells[0];
            int checkColumn = cells[1];

            if(checkRow >= 0 && checkRow < rows && checkColumn >= 0 && checkColumn < columns && matrix[checkRow][checkColumn] == ALIVE)
                livingNeighbours++;
        }
        return livingNeighbours;
    }

    public void setLivingCell(int row, int column) {

        matrix[row][column] = ALIVE;
    }

    public void buildNextGenMatrix() {

        int[][] nextGeneration = new int[rows][columns];

        for(int y = 0; y < rows; y++) {
            for(int x = 0; x < columns; x++) {

                if(isAlive(y,x) && getLivingNeighbours(y,x) < 2)
                    nextGeneration[y][x] = DEAD;
                else if(isAlive(y,x) && (getLivingNeighbours(y,x) == 2 || getLivingNeighbours(y,x) == 3))
                    nextGeneration[y][x] = ALIVE;
                else
                    nextGeneration[y][x] = matrix[y][x];
            }


        }
        matrix = nextGeneration.clone();
    }

    public boolean isAlive(int y, int x) {
        return matrix[y][x] == ALIVE;
    }

    public boolean isDead(int y, int x) {
        return matrix[y][x] == DEAD;
    }
}
