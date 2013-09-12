package ua.com.kuchyn.sudoku.dao.memory;

import ua.com.kuchyn.sudoku.dao.SudokuDao;
import ua.com.kuchyn.sudoku.model.Sudoku;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/11/13
 * Time: 10:13 AM
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class InMemorySudokuDao implements SudokuDao
{

    private static Map<Integer, Sudoku> sudokuMap = new HashMap<Integer, Sudoku>();
    @Override
    public Sudoku save(Sudoku sudoku)
    {
        sudokuMap.put(sudoku.getId(), sudoku);
        return sudoku;
    }

    @Override
    public Sudoku getSudokuById(int id)
    {
        return sudokuMap.get(id);
    }

}
