package ua.com.kuchyn.sudoku.service;

import org.junit.Test;
import ua.com.kuchyn.sudoku.algorythm.ua.com.kuchyn.model.Sudoku;
import ua.com.kuchyn.sudoku.service.shuffle.ShuffleSudokuService;

import static org.hamcrest.core.Is.is;
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

    /**
     * this test should generate initial state
     */
    @Test
    public void shouldGenerateSudokuInitialState() throws Exception
    {
        //Given
        SudokuService sudokuService = new ShuffleSudokuService();

        //When
        Sudoku actualSudoku = sudokuService.generateInitialState();

        //Then
        assertThat(actualSudoku.getSudokuField(), is(SUDOKU_INITIAL_STATE));

    }
}
