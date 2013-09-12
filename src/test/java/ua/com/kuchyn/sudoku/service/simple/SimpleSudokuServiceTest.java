package ua.com.kuchyn.sudoku.service.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.com.kuchyn.sudoku.dao.SudokuDao;
import ua.com.kuchyn.sudoku.model.Sudoku;
import ua.com.kuchyn.sudoku.service.SudokuService;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/11/13
 * Time: 10:15 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class SimpleSudokuServiceTest
{

    @Mock
    private SudokuDao sudokuDao;

    @InjectMocks
    private SudokuService sudokuService = new SimpleSudokuService();

    @Test
    public void shouldSaveSudoku()
    {
        //Given
        Sudoku sudoku = new Sudoku();
        when(sudokuDao.save(sudoku)).thenReturn(sudoku);

        //When
        Sudoku actualSudoku = sudokuService.saveSudoku(sudoku);

        //Then
        assertThat(actualSudoku, is(sudoku));
        verify(sudokuDao).save(sudoku);
    }

    @Test
    public void shouldGenerateSudoku()
    {
        //Given
        Sudoku etalonSudoku = generateEtalonSudoku();

        //When
        Sudoku actualSudoku = sudokuService.generateSudoku();

        //Then
        assertThat(actualSudoku, is(etalonSudoku));
        assertThat(actualSudoku.hashCode(), is(etalonSudoku.hashCode()));
    }

    @Test
    public void shouldReturnSudokuById(){
        //Given
        Sudoku sudoku = new Sudoku();
        int id = 43;
        when(sudokuDao.getSudokuById(id)).thenReturn(sudoku);

        //When
        Sudoku actualSudoku = sudokuService.getSudokuById(id);

        //Then
        assertThat(actualSudoku, is(sudoku));
        verify(sudokuDao).getSudokuById(id);
    }

    private Sudoku generateEtalonSudoku()
    {
        int size = 9;
        Sudoku sudoku = new Sudoku();
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                int value = (i + j) % size + 1;
                sudoku.setValue(i, j, value);
            }
        }

        return sudoku;
    }


}
