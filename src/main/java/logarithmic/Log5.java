package logarithmic;

import function.AbstractFunction;
import static java.lang.Double.*;

public class Log5 extends AbstractFunction {

    {
        getStubsTable().put(POSITIVE_INFINITY, POSITIVE_INFINITY);
        getStubsTable().put(5.0 + 0.01, 1.00124);
        getStubsTable().put(5.0, 1.0);
        getStubsTable().put(5.0 - 0.01, 0.998756);
        getStubsTable().put(1.0 + 0.01, 0.00618249);
        getStubsTable().put(1.0, 0.0);
        getStubsTable().put(1.0 - 0.01, -0.00624462);
        getStubsTable().put(0.0 + 0.01, -2.861353);
        getStubsTable().put(0.0, NEGATIVE_INFINITY);
        getStubsTable().put(0.0 - 0.01, NaN);
    }

    private final Ln ln;

    public Log5(Double accuracy, Ln ln) {
        super(accuracy);
        this.ln = new Ln(accuracy);
    }

    @Override
    public Double calculateFunction(Double x) {
        return ln.calculateFunction(x) / ln.calculateFunction(5.0);
    }

    @Override
    public Double calculateStub(Double stub) {
        return stub / ln.getStubsTable().get(5.0);
    }
}
