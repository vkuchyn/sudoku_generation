package ua.com.kuchyn.sudoku.dao;

import ua.com.kuchyn.sudoku.model.Sudoku;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/11/13
 * Time: 10:12 AM
 * To change this template use File | Settings | File Templates.
 */
public interface SudokuDao
{
    public Sudoku save(Sudoku sudoku);
}
