package ua.com.kuchyn.sudoku.algorythm;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/12/13
 * Time: 12:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class SudokuSolverTest
{
    private static final int[][] SOLVED_GRID = {
            {0, 0, 6, 0, 0, 0, 0, 0, 0},
            {8, 7, 0, 0, 1, 0, 0, 0, 6},
            {0, 0, 0, 5, 4, 0, 0, 0, 9},
            {6, 0, 0, 0, 8, 1, 3, 0, 4},
            {0, 0, 0, 3, 0, 0, 0, 5, 0},
            {0, 0, 0, 0, 0, 7, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 9, 0, 4, 0, 0, 0, 0, 8},
            {0, 0, 5, 0, 6, 0, 1, 0, 0}};

    @Test
    public void shouldSolveSudoku()
    {
        //Given
        SudokuSolver sudokuSolver = new SudokuSolver(SOLVED_GRID);

        //When
        boolean solved = sudokuSolver.solve();

        //Then
        assertThat(solved, is(true));
        sudokuSolver.print();
    }
}
