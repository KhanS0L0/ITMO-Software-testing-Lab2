package utils;

import function.AbstractFunction;
import lombok.Data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Locale;

@Data
public class CsvLogger {
    private String filePath = "src/test/resources/";
    private double step;
    private double lowerBorder;
    private double upperBorder;
    private final char CSV_SEPARATOR = ',';

    public CsvLogger(String fileName, double lowerBorder, double upperBorder, double step) {
        this.filePath = String.format("%s%s", filePath, fileName);
        this.lowerBorder = lowerBorder;
        this.upperBorder = upperBorder;
        this.step = step;
    }

    public void setFilePath(String fileName) {
        this.filePath = String.format("src/test/resources/%s", fileName);
    }

    public void log(AbstractFunction function) {
        String csvString = "";

        try(PrintStream printStream = new PrintStream(new FileOutputStream(filePath, true))) {
            for (double i = lowerBorder; i < upperBorder; i += step) {
                double result = function.calculateFunction(i);
                csvString = String.format(Locale.US, "%f%s %f\n", i, CSV_SEPARATOR, result);
                printStream.print(csvString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
