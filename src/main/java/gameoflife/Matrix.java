package gameoflife;

public class Matrix {

    private final int rows;
    private final int columns;
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
        int[][] gridToSearch = getSearchGrid(row, column);

        for(int[] cells : gridToSearch) {
            int checkRow = cells[0];
            int checkColumn = cells[1];

            if(isWithinMatrix(checkRow,checkColumn) && isAlive(checkRow,checkColumn))
                livingNeighbours++;
        }
        return livingNeighbours;
    }

    public void setLivingCell(int row, int column) {
        matrix[row][column] = ALIVE;
    }

    public void buildNextGenMatrix() {

        int[][] nextGeneration = new int[rows][columns];
        updateLivingConditions(nextGeneration);
        matrix = nextGeneration.clone();
    }

    private void updateLivingConditions(int[][] nextGeneration) {
        for(int y = 0; y < rows; y++) {
            for(int x = 0; x < columns; x++) {
                if(aliveWithLessThanTwoLivingNeighbours(y,x))
                    nextGeneration[y][x] = DEAD;
                else if(aliveWithTwoOrThreeLivingNeighbours(y,x))
                    nextGeneration[y][x] = ALIVE;
                else if(deadWithExactlyThreeLivingNeighbours(y,x))
                    nextGeneration[y][x] = ALIVE;
                else if(aliveWithMoreThanThreeLivingNeighbours(y,x))
                    nextGeneration[y][x] = DEAD;
                else
                    nextGeneration[y][x] = matrix[y][x];
            }
        }
    }

    public boolean isAlive(int y, int x) {
        return matrix[y][x] == ALIVE;
    }

    public boolean isDead(int y, int x) {
        return matrix[y][x] == DEAD;
    }

    private boolean isWithinMatrix(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    private boolean aliveWithLessThanTwoLivingNeighbours(int y, int x) {
        return isAlive(y,x) && getLivingNeighbours(y,x) < 2;
    }

    private boolean aliveWithTwoOrThreeLivingNeighbours(int y, int x) {
        return isAlive(y,x) && (getLivingNeighbours(y,x) == 2 || getLivingNeighbours(y,x) == 3);
    }

    private boolean deadWithExactlyThreeLivingNeighbours(int y, int x) {
        return isDead(y,x) && getLivingNeighbours(y,x) == 3;
    }

    private boolean aliveWithMoreThanThreeLivingNeighbours(int y, int x) {
        return isAlive(y,x) && getLivingNeighbours(y,x) > 3;
    }

    private int[][] getSearchGrid(int row, int column) {

        int[][] grid = {{row - 1, column - 1}, {row - 1, column}, {row - 1, column + 1},
                        {row, column - 1},   /* den här  */       {row, column + 1},
                        {row + 1, column - 1}, {row + 1, column}, {row + 1, column + 1}};
        return grid;
    }

    public void print() {
        for(int[] columns : matrix) {
            for(int cell : columns) {
                if(cell == DEAD) {
                    System.out.print("x  ");
                }
                else {
                    System.out.print("0  ");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
    }
}
