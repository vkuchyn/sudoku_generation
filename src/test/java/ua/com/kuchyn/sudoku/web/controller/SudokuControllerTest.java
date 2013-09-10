package ua.com.kuchyn.sudoku.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.com.kuchyn.sudoku.model.Sudoku;
import ua.com.kuchyn.sudoku.service.SudokuService;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/10/13
 * Time: 11:13 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class SudokuControllerTest
{

    @Mock
    private SudokuService sudokuService;

    @InjectMocks
    private SudokuController sudokuController = new SudokuController();

    @Test
    public void shouldGenerateSudoku(){
        //Given
        Sudoku sudoku = new Sudoku();
        when(sudokuService.generateSudoku()).thenReturn(sudoku);

        //When
        Sudoku actualSudoku = sudokuController.generateSudoku();

        //Then
        verify(sudokuService).generateSudoku();
        assertThat(actualSudoku, is(sudoku));
    }
}
