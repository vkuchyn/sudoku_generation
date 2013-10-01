package ua.com.kuchyn.sudoku.service;

import ua.com.kuchyn.sudoku.algorythm.ua.com.kuchyn.model.Sudoku;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 10/1/13
 * Time: 8:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface SudokuService
{
    Sudoku generateInitialState();

    Sudoku shuffleRows(Sudoku initialSudoku);
}
