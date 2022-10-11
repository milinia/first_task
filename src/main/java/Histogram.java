import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;

import javax.swing.*;
import java.awt.*;

public class Histogram {

    public void drawHistogram(double[] values, String title) {
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("key", values, 500);
        JFreeChart histogram = ChartFactory.createHistogram(title, "time", "value", dataset,
                PlotOrientation.VERTICAL, false, false, false);
        ChartPanel chartPanel = new ChartPanel(histogram);
        createGUI(chartPanel);
    }

    private static void createGUI(ChartPanel chartPanel)
    {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(chartPanel);
        frame.setPreferredSize(new Dimension(500, 400));

        frame.pack();
        frame.setVisible(true);
    }
}
