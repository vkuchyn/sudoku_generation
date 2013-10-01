package ua.com.kuchyn.sudoku.service.shuffle;

import ua.com.kuchyn.sudoku.algorythm.ua.com.kuchyn.model.Sudoku;
import ua.com.kuchyn.sudoku.service.SudokuService;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 10/1/13
 * Time: 8:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShuffleSudokuService implements SudokuService
{


    public static final int QUADRANT_SIZE = 3;
    public static final int DIMENTION = (int) Math.pow(QUADRANT_SIZE, 2);

    @Override
    public Sudoku generateInitialState()
    {
        Sudoku sudoku = new Sudoku();
        for (int i = 0; i < DIMENTION; i++)
        {
            for (int j = 0; j < DIMENTION; j++)
            {
                sudoku.setValue(i, j, (j + i * QUADRANT_SIZE + i / QUADRANT_SIZE)
                        % DIMENTION + 1);

            }
        }

        return sudoku;
    }
}
