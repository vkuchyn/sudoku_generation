package ua.com.kuchyn.sudoku.service.simple;

import ua.com.kuchyn.sudoku.model.Sudoku;
import ua.com.kuchyn.sudoku.service.SudokuService;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/10/13
 * Time: 11:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleSudokuService implements SudokuService
{
    @Override
    public Sudoku generateSudoku()
    {
        return new Sudoku();
    }
}
