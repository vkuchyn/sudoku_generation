package ua.com.kuchyn.sudoku.application;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import ua.com.kuchyn.sudoku.service.SudokuService;
import ua.com.kuchyn.sudoku.service.simple.SimpleSudokuService;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/11/13
 * Time: 12:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class SudokuBinder extends AbstractBinder
{
    @Override
    protected void configure()
    {
        bind(SudokuService.class).to(SudokuService.class);
    }
}
