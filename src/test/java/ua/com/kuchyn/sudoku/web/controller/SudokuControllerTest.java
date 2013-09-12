package ua.com.kuchyn.sudoku.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ua.com.kuchyn.sudoku.model.Sudoku;
import ua.com.kuchyn.sudoku.service.SudokuService;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
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
    public void shouldGenerateAndSaveSudoku()
    {
        //Given
        Sudoku sudoku = new Sudoku();
        sudoku.setId(24);
        when(sudokuService.generateSudoku()).thenReturn(sudoku);
        when(sudokuService.saveSudoku(sudoku)).thenReturn(sudoku);

        //When
        Sudoku actualSudoku = sudokuController.generateSudoku();

        //Then
        verify(sudokuService).generateSudoku();
        verify(sudokuService).saveSudoku(sudoku);
        assertThat(actualSudoku, is(sudoku));
    }

    @Test
    public void shouldAddCellToSudoku(){
        //Given
        int i =2;
        int j = 3;
        int number = 2;
        int id = 23;
        Sudoku sudoku = new Sudoku();
        when(sudokuService.getSudokuById(23)).thenReturn(sudoku);

        //When
        sudokuController.addCellToSudoku(id, i, j, number);

        //Then
        verify(sudokuService).getSudokuById(23);
        verify(sudokuService).saveSudoku(sudoku);
        assertThat(sudoku.getSudokuField()[i][j], is(2));

    }

    @Test
    public void shouldGetSudokuById(){
        //Given
        Sudoku sudoku = new Sudoku();
        int id = 32;
        when(sudokuService.getSudokuById(id)).thenReturn(sudoku);

        //When
        Sudoku actualSudoku = sudokuController.getSudokuById(id);

        //Then
        assertThat(actualSudoku, is(sudoku));
        verify(sudokuService).getSudokuById(id);
    }

}
