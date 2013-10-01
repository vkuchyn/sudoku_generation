package ua.com.kuchyn.sudoku.algorythm.ua.com.kuchyn.model;

import com.sun.rowset.internal.Row;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

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

    private int[][] field;

    public Sudoku()
    {
        Random random = new Random();
        id = random.nextInt();
        initDefaultField();
    }

    private void initDefaultField()
    {
        field = new int[DEFAULT_FIELD_DIMETION][DEFAULT_FIELD_DIMETION];
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

    public int [][] getSudokuField(){
        return field;
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

        for (int i = 0; i < DEFAULT_FIELD_DIMETION; i++)
        {
            equals = equals && Arrays.equals(field[i], sudoku.field[i]);
        }

        return equals;
    }


    @Override
    public int hashCode()
    {
        if (field == null)
        {
            return 0;
        }
        int result = 1;
        for (int i = 0; i < DEFAULT_FIELD_DIMETION; i++)
        {
            int[] line = field[i];
            result = result * 31 + (line == null ? 0 : Arrays.hashCode(line));
        }
        return result;
    }

    @Override
    public String toString()
    {
        return "Sudoku{" +
                "id=" + id +
                ", field=" + printMatrix(field)+
                '}';
    }

    private String printMatrix(int [][] matrix){
        StringBuilder sb = new StringBuilder();
        for (int[] aField : field)
        {
            sb.append("{").append(Arrays.toString(aField)).append("} ");
        }

        return sb.toString();
    }

    public List<FieldRow> getSection(int section)
    {
        int offset = section * 3;
        return asList(getRow(offset), getRow(offset + 1), getRow(offset + 2));
    }

    public FieldRow getRow(int index)
    {
        return new FieldRow(field[index]);
    }

    public static class FieldRow
    {
        private int[] row;

        public FieldRow(int[] row)
        {
            this.row = row;
        }

        @Override
        public boolean equals(Object obj)
        {
            return obj instanceof FieldRow && Arrays.equals(((FieldRow) (obj)).row, row);
        }

        @Override
        public int hashCode()
        {
            return Arrays.hashCode(row);
        }
    }
}
