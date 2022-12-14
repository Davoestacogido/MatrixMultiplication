package es.ulpgc.multiplications.sequentials;

import es.ulpgc.Matrix;
import es.ulpgc.MatrixException;
import es.ulpgc.Multiplication;
import es.ulpgc.matrices.DenseMatrix;

public class DenseMatrixStandardMultiplication implements Multiplication {
    @Override
    public Matrix execute(Matrix a, Matrix b) {
        checkIsDenseMatrix(a);
        checkIsDenseMatrix(b);
        double[][] c = new double[a.size()][a.size()];
        for (int i = 0; i < a.size(); i++)
            for (int j = 0; j < a.size(); j++)
                for (int k = 0; k < a.size(); k++)
                    c[i][j] += a.value(i, k) * b.value(k, j);
        return new DenseMatrix(c);
    }

    private void checkIsDenseMatrix(Matrix matrix) {
        if (matrix instanceof DenseMatrix) return;
        throw new MatrixException("Supplied Matrix is of unsupported type");
    }
}
