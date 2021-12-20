package gameoflife;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void foundOneLivingCellInMatrix() {

        Matrix matrix = new Matrix(8, 8);
        int livingNeighbours = matrix.getLivingNeighbours();
        assertThat(livingNeighbours).isEqualTo(1);
    }

    @Test
    public void foundNoLivingCellInMatrix() {

    }
}
