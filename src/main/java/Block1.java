public class Block1 {

//    double e = 0.001;

    public double[] calculateValues(double[][] num, int indexX, int indexY) {
        //нахождение прямой
        double x = 0;
        double x2 = 0;
        double xy = 0;
        double y = 0;
        double a;
        double b;
        for (int i = 0; i < num.length; i++) {
            x += num[i][indexX];
            x2 += num[i][indexX] * num[i][indexX];
            y += num[i][indexY];
            xy += num[i][indexX] * num[i][indexY];
        }
        x = x / num.length;
        x2 = x2 / num.length;
        y = y / num.length;
        xy = xy / num.length;
        a = (xy - x * y) / (x2 - x * x); //b1
        b = y - a * x; //b0

        return new double[]{b, a, y};
    }

    private double calculateR2(double[][] num, double[] b, int indexX) {
        double ch = 0;
        double zn = 0;
        for (int i = 0; i < 500; i++) {
            ch += Math.pow(b[0] + b[1] * num[i][indexX] - b[2], 2);
            zn += Math.pow(num[i][1] - b[2], 2);
        }
        return ch / zn;
    }

    //C - цена закрытия
    public void task1(double[] b, double[][] num) {
        System.out.println("Model 1");
        System.out.println("C = " + b[0] + " + " + b[1] + "*t + " + "e");
        System.out.println("Коэффициент детерминации: " + calculateR2(num, b, 4) + "\n");
    } //t - время

    public void task2(double[] b, double[][] num) {
        System.out.println("Model 2");
        System.out.println("C = " + b[0] + " + " + b[1] + "*O + " + "e");
        System.out.println("Коэффициент детерминации: " + calculateR2(num, b, 0) + "\n");
    } //O - цена открытия

    public void task3(double[] b, double[][] num) {
        System.out.println("Model 3");
        System.out.println("C = " + b[0] + " + " + b[1] + "*L + " + "e");
        System.out.println("Коэффициент детерминации: " + calculateR2(num, b, 3) + "\n");
    } //L - наим цена периода

    public void task4(double[] b, double[][] num) {
        System.out.println("Model 4");
        System.out.println("C = " + b[0] + " + " + b[1] + "*H + " + "e");
        System.out.println("Коэффициент детерминации: " + calculateR2(num, b, 2) + "\n");
    } //H - наиб цена периода
}
