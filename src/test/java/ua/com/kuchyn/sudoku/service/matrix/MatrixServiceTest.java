package ua.com.kuchyn.sudoku.service.matrix;

import org.junit.Test;
import ua.com.kuchyn.sudoku.service.matrix.array.ArrayMatrixService;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/12/13
 * Time: 9:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatrixServiceTest
{

    private MatrixService matrixService = new ArrayMatrixService();

    //Given
    private static final int[][] INITIAL_MATRIX = {
            {1, 3, 2},
            {3, 2, 1},
            {3, 1, 2}
    };

    private static final int[][] TRANSPONSED_MATRIX = {
            {1, 3, 3},
            {3, 2, 1},
            {2, 1, 2}
    };

    @Test
    public void shouldTransponseMatrix()
    {
        //When
        int [][] actualMatrix = matrixService.transponseMatrix(INITIAL_MATRIX);

        //Then
        assertThat(actualMatrix, is(TRANSPONSED_MATRIX));
    }
}
