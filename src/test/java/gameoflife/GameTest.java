package gameoflife;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void foundOneLivingNeighbourInMatrix() {

        Matrix matrix = new Matrix(8, 8);
        matrix.setLivingCell(2, 1);
        int livingNeighbours = matrix.getLivingNeighbours(2, 2);
        assertThat(livingNeighbours).isEqualTo(1);
    }

    @Test
    public void foundNoLivingNeighbourInMatrix() {

        Matrix matrix = new Matrix(8, 8);
        matrix.setLivingCell(5, 5);
        int livingNeighbours = matrix.getLivingNeighbours(3, 3);
        assertThat(livingNeighbours).isEqualTo(0);
    }

    @Test
    public void foundThreeLivingNeighboursInMatrix() {

        Matrix matrix = new Matrix(6, 6);
        matrix.setLivingCell(0, 0);
        matrix.setLivingCell(0, 1);
        matrix.setLivingCell(1, 0);
        int livingNeighbours = matrix.getLivingNeighbours(1, 1);
        assertThat(livingNeighbours).isEqualTo(3);
    }

    @Test
    public void foundEightLivingNeighboursInMatrix() {

        Matrix matrix = new Matrix(6, 6);
        matrix.setLivingCell(1, 2);
        matrix.setLivingCell(1, 3);
        matrix.setLivingCell(1, 4);
        matrix.setLivingCell(2, 2);
        matrix.setLivingCell(2, 4);
        matrix.setLivingCell(3, 2);
        matrix.setLivingCell(3, 3);
        matrix.setLivingCell(3, 4);
        int livingNeighbours = matrix.getLivingNeighbours(2, 3);
        assertThat(livingNeighbours).isEqualTo(8);
    }
}
