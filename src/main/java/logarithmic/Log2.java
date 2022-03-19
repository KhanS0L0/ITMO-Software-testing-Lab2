package logarithmic;

import function.AbstractFunction;

public class Log2 extends AbstractFunction {

    {
        getStubsTable().put(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        getStubsTable().put(2.0 + 0.01, 1.00720);
        getStubsTable().put(2.0, 1.0);
        getStubsTable().put(2.0 - 0.01, 0.992768);
        getStubsTable().put(1.0 + 0.01, 0.0143553);
        getStubsTable().put(1.0, 0.0);
        getStubsTable().put(1.0 - 0.01, -0.0144996);
        getStubsTable().put(0.0 + 0.01, -6.632979274557514);
        getStubsTable().put(0.0, Double.NEGATIVE_INFINITY);
        getStubsTable().put(0.0 - 0.01, Double.NaN);
    }

    private final Ln ln;

    public Log2(Double accuracy, Ln ln) {
        super(accuracy);
        this.ln = new Ln(accuracy);
    }

    @Override
    public Double calculateFunction(Double x) {
        return ln.calculateFunction(x) / ln.calculateFunction(2.0);
    }

    @Override
    public Double calculateStub(Double stub) {
        return stub / ln.getStubsTable().get(2.0);
    }
}
