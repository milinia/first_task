import org.ejml.data.DenseMatrix64F;

import java.nio.file.Paths;
import java.util.List;

public class Application2 {
    public static void main(String[] args) throws Exception {
        SimpleCSVReader reader = new SimpleCSVReader();
        List<String[]> data = reader.readAllLines(Paths.get("/Users/milinia/Downloads/files_data_analysis/usd_jpy2.csv"));
        int n = 500;
        double[][] num = new double[n][5];
        for (int i = 0; i < n; i++) {
            num[i][0] = Double.parseDouble(data.get(i + 1)[2]); //открытие
            num[i][1] = Double.parseDouble(data.get(i + 1)[5]); //закрытие
            num[i][2] = Double.parseDouble(data.get(i + 1)[3]); //макс
            num[i][3] = Double.parseDouble(data.get(i + 1)[4]); //мин
            num[i][4] = i + 1; //время
        }

//        Block1 block1 = new Block1();
//        //1
//        block1.task1(block1.calculateValues(num, 4, 1), num);
//        //2
//        block1.task2(block1.calculateValues(num, 0, 1), num);
//        //3
//        block1.task3(block1.calculateValues(num, 3, 1), num);
//        //4
//        block1.task4(block1.calculateValues(num, 2, 1), num);


//        Block2 block2 = new Block2();
//        //1
//        System.out.println("Model 5");
//        block2.task1(num);
//        //2
//        block2.task2(block2.task1(num), num);
//        //3
//        System.out.println("Model 6");
//        block2.task3(num);
//        //4
//        block2.task4(block2.task3(num), num);
//        //5
//        block2.task5(num);

        Block1 block1 = new Block1();
        Block2 block2 = new Block2();
        Block3 block3 = new Block3();
        double[] b;

//        //1
//        System.out.println("Model 1");
//        b = block1.calculateValues(num, 4, 1);
//        block3.task1(b, num, 1);
//
//        System.out.println("\nModel 2");
//        b = block1.calculateValues(num, 0, 1);
//        block3.task1(b, num , 2);
//
//        System.out.println("\nModel 3");
//        b = block1.calculateValues(num, 3, 1);
//        block3.task1(b, num , 3);
//
//        System.out.println("\nModel 4");
//        b = block1.calculateValues(num, 2, 1);
//        block3.task1(b, num, 4);
//
//        System.out.println("\nModel 5");
//        DenseMatrix64F matrixX = new DenseMatrix64F(500, 3);
//        DenseMatrix64F matrixY = new DenseMatrix64F(500, 1);
//        for (int i = 0; i < num.length; i++) {
//            matrixX.set(i, 0, 1);
//            matrixX.set(i, 1, num[i][2]);
//            matrixX.set(i, 2, num[i][0]);
//            matrixY.set(i, 0, num[i][1]);
//        }
//        b = block2.calculateValues(matrixX, matrixY);
//        block3.task1(b, num, 5);
//
//        System.out.println("\nModel 6");
//        matrixX = new DenseMatrix64F(500, 4);
//        matrixY = new DenseMatrix64F(500, 1);
//        for (int i = 0; i < num.length; i++) {
//            matrixX.set(i, 0, 1);
//            matrixX.set(i, 1, num[i][2]);
//            matrixX.set(i, 2, num[i][3]);
//            matrixX.set(i, 3, num[i][0]);
//            matrixY.set(i, 0, num[i][1]);
//        }
//        b = block2.calculateValues(matrixX, matrixY);
//        block3.task1(b, num, 6);

//        //2
//        System.out.println("Model 1");
//        b = block1.calculateValues(num, 4, 1);
//        block3.task2(b, num, 1);
//
//        System.out.println("\nModel 2");
//        b = block1.calculateValues(num, 0, 1);
//        block3.task2(b, num, 2);
//
//        System.out.println("\nModel 3");
//        b = block1.calculateValues(num, 3, 1);
//        block3.task2(b, num, 3);
//
//        System.out.println("\nModel 4");
//        b = block1.calculateValues(num, 2, 1);
//        block3.task2(b, num, 4);
//
//        System.out.println("\nModel 5");
//        DenseMatrix64F matrixX = new DenseMatrix64F(500, 3);
//        DenseMatrix64F matrixY = new DenseMatrix64F(500, 1);
//        for (int i = 0; i < num.length; i++) {
//            matrixX.set(i, 0, 1);
//            matrixX.set(i, 1, num[i][2]);
//            matrixX.set(i, 2, num[i][0]);
//            matrixY.set(i, 0, num[i][1]);
//        }
//        b = block2.calculateValues(matrixX, matrixY);
//        block3.task2(b, num, 5);
//
//        System.out.println("\nModel 6");
//        matrixX = new DenseMatrix64F(500, 4);
//        matrixY = new DenseMatrix64F(500, 1);
//        for (int i = 0; i < num.length; i++) {
//            matrixX.set(i, 0, 1);
//            matrixX.set(i, 1, num[i][2]);
//            matrixX.set(i, 2, num[i][3]);
//            matrixX.set(i, 3, num[i][0]);
//            matrixY.set(i, 0, num[i][1]);
//        }
//        b = block2.calculateValues(matrixX, matrixY);
//        block3.task2(b, num, 6);
        
    }
}
