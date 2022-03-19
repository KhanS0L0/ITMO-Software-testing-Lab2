package logarithmic;

import function.AbstractFunction;

import static java.lang.Double.*;
import static java.lang.Math.*;

public class Ln extends AbstractFunction {

    {
        getStubsTable().put(POSITIVE_INFINITY, log(POSITIVE_INFINITY));
        getStubsTable().put(10.0, log(10.0));
        getStubsTable().put(5.0, log(5.0));
        getStubsTable().put(PI, log(PI));
        getStubsTable().put(3.0, log(3.0));
        getStubsTable().put(E + 0.01, log(E + 0.01));
        getStubsTable().put(E, log(Math.E));
        getStubsTable().put(2.0, log(2.0));
        getStubsTable().put(E - 0.01, log(E - 0.01));
        getStubsTable().put(1.0 + 0.01, log(1.0 + 0.01));
        getStubsTable().put(1.0, log(1.0));
        getStubsTable().put(1.0 - 0.01, log(1.0 - 0.01));
        getStubsTable().put(0.0 + 0.01, log(0.0 + 0.01));
        getStubsTable().put(0.0, log(0.0));
        getStubsTable().put(0.0 - 0.01, log(0.0 - 0.01));
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