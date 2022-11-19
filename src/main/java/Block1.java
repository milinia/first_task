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
        for (double[] doubles : num) {
            x += doubles[indexX];
            x2 += doubles[indexX] * doubles[indexX];
            y += doubles[indexY];
            xy += doubles[indexX] * doubles[indexY];
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
    public double task1(double[] b, double[][] num, int numIndex) {
//        System.out.println("Model 1");
//        System.out.println("C = " + b[0] + " + " + b[1] + "*t + " + "e");
//        System.out.println("Коэффициент детерминации: " + calculateR2(num, b, 4) + "\n");
        return b[0] + b[1] * num[numIndex][4];
    } //t - время

    public double task2(double[] b, double[][] num, int numIndex) {
//        System.out.println("Model 2");
//        System.out.println("C = " + b[0] + " + " + b[1] + "*O + " + "e");
//        System.out.println("Коэффициент детерминации: " + calculateR2(num, b, 0) + "\n");
        return b[0] + b[1] * num[numIndex][0];
    } //O - цена открытия

    public double task3(double[] b, double[][] num, int numIndex) {
//        System.out.println("Model 3");
//        System.out.println("C = " + b[0] + " + " + b[1] + "*L + " + "e");
//        System.out.println("Коэффициент детерминации: " + calculateR2(num, b, 3) + "\n");
        return b[0] + b[1] * num[numIndex][3];
    } //L - наим цена периода

    public double task4(double[] b, double[][] num, int numIndex) {
//        System.out.println("Model 4");
//        System.out.println("C = " + b[0] + " + " + b[1] + "*H + " + "e");
//        System.out.println("Коэффициент детерминации: " + calculateR2(num, b, 2) + "\n");
        return b[0] + b[1] * num[numIndex][2];
    } //H - наиб цена периода
}
