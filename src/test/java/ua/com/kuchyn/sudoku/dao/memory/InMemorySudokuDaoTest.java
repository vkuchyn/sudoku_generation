package ua.com.kuchyn.sudoku.dao.memory;

import org.junit.Test;
import ua.com.kuchyn.sudoku.dao.SudokuDao;
import ua.com.kuchyn.sudoku.model.Sudoku;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/12/13
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class InMemorySudokuDaoTest
{
    public static final int ID = 234;
    private SudokuDao sudokuDao = new InMemorySudokuDao();

    @Test
    public void shouldSaveSudokuAndGetById(){
        //Given
        Sudoku sudoku = new Sudoku();
        sudoku.setId(ID);

        //When
        Sudoku savedSudoku = sudokuDao.save(sudoku);
        Sudoku sudokuGotById = sudokuDao.getSudokuById(ID);

        //Then
        assertThat(savedSudoku, is(sudoku));
        assertThat(sudokuGotById, is(savedSudoku));
    }
}
