package ua.com.kuchyn.sudoku.service.simple;

import ua.com.kuchyn.sudoku.dao.SudokuDao;
import ua.com.kuchyn.sudoku.model.Sudoku;
import ua.com.kuchyn.sudoku.service.SudokuService;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/10/13
 * Time: 11:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleSudokuService implements SudokuService
{
    @Inject
    private SudokuDao sudokuDao;

    @Override
    public Sudoku generateSudoku()
    {
        Sudoku sudoku = new Sudoku();
        for (int i = 0; i < Sudoku.DEFAULT_FIELD_DIMETION; i++)
        {
            for (int j = 0; j < Sudoku.DEFAULT_FIELD_DIMETION; j++)
            {
                int value = (i + j) % Sudoku.DEFAULT_FIELD_DIMETION + 1;
                sudoku.setValue(i, j, value);
            }
        }
        return sudoku;
    }

    @Override
    public Sudoku saveSudoku(Sudoku sudoku)
    {
        return sudokuDao.save(sudoku);
    }

    @Override
    public Sudoku getSudokuById(Integer id)
    {
        return sudokuDao.getSudokuById(id);
    }
}
