package ua.com.kuchyn.sudoku.model;

import java.util.Arrays;
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
    public static final int DEFAULT_FIELD_DIMETION = 9;
    private Integer id;

    private int [][] field;

    public Sudoku()
    {
        Random random = new Random();
        id = random.nextInt();
        initDefaultField();
    }

    private void initDefaultField(){
        field = new int [DEFAULT_FIELD_DIMETION][DEFAULT_FIELD_DIMETION];
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setValue(int i, int j, int value)
    {
        field[i][j] = value;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Sudoku))
        {
            return false;
        }

        Sudoku sudoku = (Sudoku) o;
        boolean equals = true;

        for (int i = 0; i < DEFAULT_FIELD_DIMETION ; i++){
            equals = equals && Arrays.equals(field[i], sudoku.field[i]);
        }

        return equals;
    }


    @Override
    public int hashCode()
    {
        if (field == null) return 0;
        int result = 1;
        for (int i = 0; i < DEFAULT_FIELD_DIMETION; i++){
            int [] line = field[i];
            result = result*31 + (line == null ? 0 : Arrays.hashCode(line));
        }
        return result;
    }
}
