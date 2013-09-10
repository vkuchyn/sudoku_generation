package ua.com.kuchyn.sudoku.service;

import ua.com.kuchyn.sudoku.model.Sudoku;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/10/13
 * Time: 11:15 PM
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class SudokuService
{
    public Sudoku generateSudoku()
    {
        return new Sudoku();
    }
}
