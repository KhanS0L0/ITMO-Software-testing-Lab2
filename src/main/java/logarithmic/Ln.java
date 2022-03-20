package logarithmic;

import function.AbstractFunction;

import static java.lang.Double.*;
import static java.lang.Math.*;

public class Ln extends AbstractFunction {

    {
        getStubsTable().put(POSITIVE_INFINITY, log(POSITIVE_INFINITY));
        getStubsTable().put(0.0, log(0.0));
        getStubsTable().put(0.5, log(0.5));
        getStubsTable().put(1.0, log(1.0));
        getStubsTable().put(1.4, log(1.4));
        getStubsTable().put(2.3, log(2.3));
        getStubsTable().put(3.4, log(3.4));
        getStubsTable().put(5.2, log(5.2));
        getStubsTable().put(10.515, log(10.515));
        getStubsTable().put(11.5234, log(11.5234));
        getStubsTable().put(14.8432, log(14.8432));
        getStubsTable().put(100.0, log(100.0));
    }

    public Ln(Double accuracy) {
        super(accuracy);
    }

    @Override
    public Double calculateFunction(Double x) {
        if (isNaN(x) || x < 0.0) {
            return NaN;
        }

        if (x == POSITIVE_INFINITY) {
            return POSITIVE_INFINITY;
        }

        if (x == 0.0) {
            return NEGATIVE_INFINITY;
        }

        double value = 0;
        double prevValue;
        int n = 1;
        int k = 1;
        if (Math.abs(x - 1) <= 1) {
            do {
                prevValue = value;
                value -= ((Math.pow(-1, n) * Math.pow(x - 1, n)) / n);
                n++;
            } while (getAccuracy() <= Math.abs(value - prevValue));
        } else {
            do {
                prevValue = value;
                value -= ((Math.pow(-1, k) * Math.pow(x - 1, -k)) / k);
                k++;
            } while (getAccuracy() <= Math.abs(value - prevValue));
            value += this.calculateFunction(x - 1);
        }
        return value;
    }
}