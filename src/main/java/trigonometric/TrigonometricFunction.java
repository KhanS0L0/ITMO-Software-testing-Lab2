package trigonometric;

import function.AbstractFunction;

public class TrigonometricFunction extends AbstractFunction {
    private final Sin sin;
    private final Cos cos;
    private final Tan tan;
    private final Csc csc;

    public TrigonometricFunction(Double accuracy, Sin sin, Cos cos, Tan tan, Csc csc) {
        super(accuracy);
        this.sin = sin;
        this.cos = cos;
        this.tan = tan;
        this.csc = csc;
    }

    public Double calculateFunction(Double x) {
        if (x > 0.0) throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        double sinX = sin.calculateFunction(x);
        double cosX = cos.calculateFunction(x);
        double tanX = tan.calculateFunction(x);
        double cscX = csc.calculateFunction(x);
        return Math.pow(((((Math.pow(cscX,2)) / sinX) * (cosX - sinX)) / tanX), 2);
    }

    public Double calculateStub(Double x, Double sin, Double cos, Double tan, Double csc){
        if (x > 0.0) throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        System.out.println(sin + " " + cos + " " + tan + " " + csc);
        return Math.pow(((((Math.pow(csc,2)) / sin) * (cos - sin)) / tan), 2);
    }
}