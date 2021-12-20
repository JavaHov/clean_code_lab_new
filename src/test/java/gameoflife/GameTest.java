package gameoflife;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void foundOneLivingCellInMatrix() {

        Matrix matrix = new Matrix();
        int livingNeighbours = matrix.getLivingNeighbours();
        assertThat(livingNeighbours).isEqualTo(1);
    }
}
