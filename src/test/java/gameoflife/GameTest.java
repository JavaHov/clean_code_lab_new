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
}
