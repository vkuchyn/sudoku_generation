package ua.com.kuchyn.sudoku.service;

import org.junit.Test;
import ua.com.kuchyn.sudoku.algorythm.ua.com.kuchyn.model.Sudoku;
import ua.com.kuchyn.sudoku.service.shuffle.ShuffleSudokuService;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 10/1/13
 * Time: 8:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class SudokuServiceTest
{

    public static final int[][] SUDOKU_INITIAL_STATE = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

    private final SudokuService sudokuService = new ShuffleSudokuService();

    /**
     * this test should generate initial state
     */
    @Test
    public void shouldGenerateSudokuInitialState() throws Exception
    {
        //Given

        //When
        Sudoku actualSudoku = sudokuService.generateInitialState();

        //Then
        assertThat(actualSudoku.getSudokuField(), is(SUDOKU_INITIAL_STATE));
//        git pull origin xpinjection
    }

    @Test
    public void shouldShuffleRows() throws Exception
    {
        //Given
        Sudoku initialSudoku = sudokuService.generateInitialState();

        //When
        Sudoku actualSudoku = sudokuService.shuffleRows(initialSudoku);

        //Then
        assertThat(actualSudoku.getSudokuField(), is(not(SUDOKU_INITIAL_STATE)));

        for (int i = 0; i < 9; i++)
        {
            assertThat(assertRowIsPresent(actualSudoku, i), is(true));
        }
    }

    private boolean assertRowIsPresent(Sudoku actualSudoku, int row)
    {
        int cellSection = row / 3;
        return assertRowsEquals(actualSudoku, cellSection, row) ||
                assertRowsEquals(actualSudoku, cellSection + 1, row) ||
                assertRowsEquals(actualSudoku, cellSection + 2, row);
    }

    private boolean assertRowsEquals(Sudoku actualSudoku, int cellSection, int row)
    {
        return Arrays.equals(actualSudoku.getSudokuField()[cellSection], SUDOKU_INITIAL_STATE[row]);
    }

}
