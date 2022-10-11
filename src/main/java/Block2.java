import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.CommonOps;

public class Block2 {

    public double[] calculateValues(DenseMatrix64F matrixX, DenseMatrix64F matrixY) {

        DenseMatrix64F transMatrixX = new DenseMatrix64F(500, matrixX.numCols);
        CommonOps.addEquals(transMatrixX, matrixX);
        //X^T
        CommonOps.transpose(transMatrixX);
        //X^T * X
        DenseMatrix64F multMatrix = new DenseMatrix64F(matrixX.numCols, matrixX.numCols);
        CommonOps.mult(transMatrixX, matrixX, multMatrix);
        //(X^T * X)^-1
        CommonOps.invert(multMatrix);
        //(X^T * X)^-1 * X^T
        matrixX = new DenseMatrix64F(matrixX.numCols, 500);
        CommonOps.mult(multMatrix, transMatrixX, matrixX);
        //(X^T * X)^-1 * X^T * Y
        multMatrix = new DenseMatrix64F(matrixX.numRows, 1);
        CommonOps.mult(matrixX, matrixY, multMatrix);

        double[] b = new double[multMatrix.numRows];
        for (int i = 0; i < multMatrix.numRows; i++) {
            b[i] = multMatrix.get(i, 0);
        }
        return b;
    }

    //C - цена закрытия
    public double[] task1(double[][] num) {
        DenseMatrix64F matrixX = new DenseMatrix64F(500, 3);
        DenseMatrix64F matrixY = new DenseMatrix64F(500, 1);
        for (int i = 0; i < num.length; i++) {
            matrixX.set(i, 0, 1);
            matrixX.set(i, 1, num[i][2]);
            matrixX.set(i, 2, num[i][0]);
            matrixY.set(i, 0, num[i][1]);
        }
        double[] b = calculateValues(matrixX, matrixY);
        System.out.println("C = " + b[0] + " + " + b[1] + "*H + " + b[2] + "*O + " + "e" + "\n");
        return b;
    } //H - макс, O - цена открытия

    private double calculateR2ForThreeParameters(double[][] num, double[] b, int indexX1, int indexX2) {
        double ch = 0;
        double zn = 0;
        int y = 0;

        for (int i = 0; i < 500; i++) {
            y += num[i][1];
        }
        y = y / 500;
        for (int i = 0; i < 500; i++) {
            ch += Math.pow(b[0] + b[1] * num[i][indexX1] + b[2] * num[i][indexX2] - y, 2);
            zn += Math.pow(num[i][1] - y, 2);
        }
        return ch / zn;
    }

    public void task2(double[] b, double[][] num) {
        double r2 = calculateR2ForThreeParameters(num, b, 2, 0);
        System.out.println("Коэффициент детерминации: " + r2);
        double mn = (double) (num.length - 1) / (num.length - 3);
        System.out.println("Скоректированный коэффициент детерминации: " + (1 - (1 - r2) * mn) + "\n");
    }

    //C - цена закрытия
    public double[] task3(double[][] num) {
        DenseMatrix64F matrixX = new DenseMatrix64F(500, 4);
        DenseMatrix64F matrixY = new DenseMatrix64F(500, 1);
        for (int i = 0; i < num.length; i++) {
            matrixX.set(i, 0, 1);
            matrixX.set(i, 1, num[i][2]);
            matrixX.set(i, 2, num[i][3]);
            matrixX.set(i, 3, num[i][0]);
            matrixY.set(i, 0, num[i][1]);
        }
        double[] b = calculateValues(matrixX, matrixY);
        System.out.println("C = " + b[0] + " + " + b[1] + "*H + " + b[2] + "*L + " +  b[3] + "*O + " + "e" + "\n");
        return b;
    } //H - макс, L - наим, O - цена открытия

    private double calculateR2ForFourParameters(double[][] num, double[] b, int indexX1, int indexX2, int indexX3) {
        double ch = 0;
        double zn = 0;
        int y = 0;

        for (int i = 0; i < 500; i++) {
            y += num[i][1];
        }
        y = y / 500;
        for (int i = 0; i < 500; i++) {
            ch += Math.pow(b[0] + b[1] * num[i][indexX1] + b[2] * num[i][indexX2] + b[3] * num[i][indexX3] - y, 2);
            zn += Math.pow(num[i][1] - y, 2);
        }
        return ch / zn;
    }

    public void task4(double[] b, double[][] num) {
        double r2 = calculateR2ForFourParameters(num, b, 2, 3, 0);
        System.out.println("Коэффициент детерминации: " + r2);
        double mn = (double) (num.length - 1) / (num.length - 4);
        System.out.println("Скоректированный коэффициент детерминации: " + (1 - (1 - r2) * mn) + "\n");
    }

    public void task5(double[][] num) {
        double[] residualsModel5 = new double[num.length];
        double[] residualsModel6 = new double[num.length];

        double[] bModel5 = task1(num);
        double[] bModel6 = task3(num);

        for (int i = 0; i < num.length; i++) {
            residualsModel5[i] = num[i][1] - (bModel5[0] + bModel5[1] * num[i][2]
                    + bModel5[2] * num[i][0]);
            residualsModel6[i] = num[i][1] - (bModel6[0] + bModel6[1] * num[i][2] + bModel6[2] * num[i][3]
                    + bModel6[3] * num[i][0]);
        }
        Histogram histogram = new Histogram();
        histogram.drawHistogram(residualsModel5, "Histogram for 5 model");
        histogram.drawHistogram(residualsModel6, "Histogram for 6 model");
    }
}
