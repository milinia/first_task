import java.util.Arrays;
import java.util.Comparator;

public class Block3 {

    public void task1(double[] b, double[][] num, int modelNum) {
        double ch = 0;
        double zn = 0;
        double e;
        double prevE = 0;

        for (int i = 0; i < 500; i++) {
            e = num[i][1] - calculateValue(modelNum, b, i, num);
            ch += Math.pow(e - prevE, 2);
            zn += Math.pow(e, 2);
            prevE = e;
        }
        System.out.println("Критерий Дарбина-Уотсона = " + ch / zn + "\n");
    }

    private double calculateValue(int modelNum, double[] b, int numIndex, double[][] num) {
        Block1 block1 = new Block1();
        Block2 block2 = new Block2();
        switch (modelNum) {
            case (1):
                return block1.task1(b, num, numIndex);
            case (2):
                return block1.task2(b, num, numIndex);
            case (3):
                return block1.task3(b, num, numIndex);
            case (4):
                return block1.task4(b, num, numIndex);
            case (5):
                return block2.task1(b, num, numIndex);
            case (6):
                return block2.task3(b, num, numIndex);

        }
        return 0;
    }

    public void task2(double[] b, double[][] num, int modelNum) {
        Arrays.sort(num, Comparator.comparingDouble(o -> o[1])); //по возрастанию
        // 166 168 166
        double s1 = 0;
        double s3 = 0;
        double e1;
        double e2;
        int paramNum = 0;

        switch (modelNum) {
            case (1):
            case (4):
            case (3):
            case (2):
                paramNum = 1;
                break;
            case (5):
                paramNum = 2;
                break;
            case (6):
                paramNum = 3;
                break;
        }

        for (int i = 0; i < 166; i++) {
            e1 = num[i][1] - calculateValue(modelNum, b, i, num);
            s1 += Math.pow(e1, 2);
            e2 = num[500 - i - 1][1] - calculateValue(modelNum, b, i, num);
            s3 +=  Math.pow(e2, 2);
        }
        System.out.println("Тест Голдфелда-Квандта");
        System.out.println("F = " + s3 / (166 - paramNum - 1) / s1 / (166 - paramNum - 1)); // if F > Fкр(по табл?) - гипотеза об отсутствии
                                                                                            // гетероскедастичности откланяется
    }
}
