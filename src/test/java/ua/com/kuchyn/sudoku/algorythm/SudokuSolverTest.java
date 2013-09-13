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
    private static final int[][] SINGLE_SOLUTION_GRID = {
            {0, 0, 0, 0, 4, 0, 0, 3, 8},
            {9, 0, 0, 0, 0, 0, 0, 5, 0},
            {2, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 3, 5, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 9, 0, 0},
            {0, 4, 0, 0, 0, 7, 1, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 6, 0},
            {0, 0, 0, 0, 0, 2, 0, 0, 0}};

    private static final int[][] MULTIPLY_SOLUTION_GRID = {
            {0, 0, 0, 0, 4, 0, 0, 3, 8},
            {0, 0, 0, 0, 0, 0, 0, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 3, 5, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 9, 0, 0},
            {0, 4, 0, 0, 0, 7, 1, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 6, 0},
            {0, 0, 0, 0, 0, 2, 0, 0, 0}};

    @Test
    public void shouldFindOnlyOneDecision()
    {
        //Given
        SudokuSolver sudokuSolver = new SudokuSolver(SINGLE_SOLUTION_GRID);

        //When
        boolean solved = sudokuSolver.checkOnlyOneDecisionExists();

        //Then
        assertThat(solved, is(true));
    }

    @Test
    public void shouldNotSolveSudokuWhenMoreThanOneDesision(){
        //Given
        SudokuSolver sudokuSolver = new SudokuSolver(MULTIPLY_SOLUTION_GRID);

        //When
        boolean solved = sudokuSolver.checkOnlyOneDecisionExists();

        //Then
        assertThat(solved, is(false));

    }
}
