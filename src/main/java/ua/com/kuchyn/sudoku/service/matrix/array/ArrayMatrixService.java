package ua.com.kuchyn.sudoku.service.matrix.array;

import ua.com.kuchyn.sudoku.service.matrix.MatrixService;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/12/13
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayMatrixService implements MatrixService
{
    @Override
    public int[][] transponseMatrix(int[][] matrix)
    {
        int width = matrix[0].length;
        int height = matrix.length;
        int [][] transponedMatrix = new int [height][width];

        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                transponedMatrix[j][i] = matrix[i][j];
            }
        }
        return transponedMatrix;
    }
}
