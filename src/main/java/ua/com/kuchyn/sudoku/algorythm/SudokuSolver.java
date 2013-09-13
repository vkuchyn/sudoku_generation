package ua.com.kuchyn.sudoku.algorythm;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/12/13
 * Time: 12:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class SudokuSolver
{
    private int mBoard[][];
    private int mBoardSize;
    private int mBoxSize;
    private boolean mRowSubset[][];
    private boolean mColSubset[][];
    private boolean mBoxSubset[][];

    public SudokuSolver(int board[][])
    {
        mBoard = board;
        mBoardSize = mBoard.length;
        mBoxSize = (int) Math.sqrt(mBoardSize);
        initSubsets();
    }

    private void initSubsets()
    {
        mRowSubset = new boolean[mBoardSize][mBoardSize];
        mColSubset = new boolean[mBoardSize][mBoardSize];
        mBoxSubset = new boolean[mBoardSize][mBoardSize];
        for (int i = 0; i < mBoard.length; i++)
        {
            for (int j = 0; j < mBoard.length; j++)
            {
                int value = mBoard[i][j];
                if (value != 0)
                {
                    setSubsetValue(i, j, value, true);
                }
            }
        }
    }

    private void setSubsetValue(int i, int j, int value, boolean present)
    {
        mRowSubset[i][value - 1] = present;
        mColSubset[j][value - 1] = present;
        mBoxSubset[computeBoxNo(i, j)][value - 1] = present;
    }

    public boolean checkOnlyOneDecisionExists()
    {
        int desisionCount = 0;
        for (int i = 1; i <= mBoardSize; i++)
        {
            if (solve(0, 0, i, copyArray(mBoard)))
            {
                desisionCount++;
            }
            if (desisionCount > 1){
                return false;
            }
        }
        return desisionCount == 1;
    }

    private int[][] copyArray(int array[][])
    {
        int width = array[0].length;
        int height = array.length;
        int[][] res = new int[width][height];

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[0].length; j++)
            {
                res[i][j] = array[i][j];
            }
        }

        return res;
    }

    private boolean solve(int i, int j, int initialValue, int board[][])
    {
        boolean desisionWasFound = false;
        if (i == mBoardSize)
        {
            i = 0;
            if (++j == mBoardSize)
            {
                print(board);
                return true;
            }
        }
        if (board[i][j] != 0)
        {
            return solve(i + 1, j, 1, board);
        }
        int maxSize = mBoardSize;
        if (i == 0 && j == 0){
            maxSize = initialValue;
        }
        for (int value = initialValue; value <= maxSize; value++)
        {
            if (isValid(i, j, value))
            {
                board[i][j] = value;
                setSubsetValue(i, j, value, true);
                if (solve(i + 1, j, 1, board))
                {
                    setSubsetValue(i, j, value, false);
                    return true;
                }
                setSubsetValue(i, j, value, false);
            }
        }

        board[i][j] = 0;
        return desisionWasFound;
    }

    private boolean isValid(int i, int j, int val)
    {
        val--;
        boolean isPresent = mRowSubset[i][val] || mColSubset[j][val] || mBoxSubset[computeBoxNo(i, j)][val];
        return !isPresent;
    }

    private int computeBoxNo(int i, int j)
    {
        int boxRow = i / mBoxSize;
        int boxCol = j / mBoxSize;
        return boxRow * mBoxSize + boxCol;
    }

    public void print()
    {
        print(mBoard);
    }

    public String print(int[][] mBoard)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mBoardSize; i++)
        {
            if (i % mBoxSize == 0)
            {
                sb.append(" -----------------------").append("\n");
            }
            for (int j = 0; j < mBoardSize; j++)
            {
                if (j % mBoxSize == 0)
                {
                    sb.append("| ");
                }
                String cell = mBoard[i][j] != 0 ? (String.valueOf(mBoard[i][j])) : " ";
                sb.append(cell).append(' ');
            }

            System.out.println("|");
            sb.append("|").append("\n");
        }

        sb.append(" -----------------------");
        System.out.println(sb.toString());
        return sb.toString();
    }

}
