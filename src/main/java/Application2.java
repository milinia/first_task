import java.nio.file.Paths;
import java.util.List;

public class Application2 {
    public static void main(String[] args) throws Exception {
        SimpleCSVReader reader = new SimpleCSVReader();
        List<String[]> data = reader.readAllLines(Paths.get("/Users/milinia/Downloads/usd_jpy2.csv"));
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


        Block2 block2 = new Block2();
        //1
        System.out.println("Model 5");
        block2.task1(num);
        //2
        block2.task2(block2.task1(num), num);
        //3
        System.out.println("Model 6");
        block2.task3(num);
        //4
        block2.task4(block2.task3(num), num);
        //5
        block2.task5(num);
    }
}
