package logarithmic;

import function.AbstractFunction;

public class LogarithmicFunction extends AbstractFunction {

    private final Ln ln;
    private final Log2 log2;
    private final Log5 log5;
    private final Log10 log10;

    public LogarithmicFunction(Double accuracy, Ln ln, Log2 log2, Log5 log5, Log10 log10) {
        super(accuracy);
        this.ln = ln;
        this.log2 = log2;
        this.log5 = log5;
        this.log10 = log10;
    }

    @Override
    public Double calculateFunction(Double x) {
        if (x <= 0.0) { throw new IllegalArgumentException("X должен быть больше нуля"); }
        double lnX = ln.calculateFunction(x);
        double log2X = log2.calculateFunction(x);
        double log5X = log5.calculateFunction(x);
        double log10X = log10.calculateFunction(x);

        return ((((log10X * log10X) + lnX) + log2X) + lnX) / (Math.pow((log2X / log5X),2) + Math.pow(lnX,2));
    }

    public Double calculateStub(Double x, Double ln, Double log2, Double log5, Double log10) {
        if (x <= 0.0) { throw new IllegalArgumentException("X должен быть больше нуля"); }
        return ((((log10 * log10) + ln) + log2) + ln) / (Math.pow((log2 / log5),2) + Math.pow(ln,2));
    }
}