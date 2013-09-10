package ua.com.kuchyn.sudoku.model;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/10/13
 * Time: 11:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sudoku
{
    private Integer id;

    public Sudoku()
    {
        Random random = new Random();
        id = random.nextInt();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
}
