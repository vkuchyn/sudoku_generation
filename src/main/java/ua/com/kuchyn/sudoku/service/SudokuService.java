package ua.com.kuchyn.sudoku.service;

import ua.com.kuchyn.sudoku.model.Sudoku;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/11/13
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */
public interface SudokuService
{
    public Sudoku generateSudoku();

    public Sudoku saveSudoku(Sudoku sudoku);

    public Sudoku getSudokuById(Integer id);
}
