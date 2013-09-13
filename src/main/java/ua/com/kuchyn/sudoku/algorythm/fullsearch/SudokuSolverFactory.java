package ua.com.kuchyn.sudoku.algorythm.fullsearch;

import ua.com.kuchyn.sudoku.algorythm.SudokuSolver;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/13/13
 * Time: 3:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class SudokuSolverFactory
{

    public static SudokuSolver generateSudokuSolver(int grid[][]){
        return new FullSearchSudoSolver(grid);
    }
}
