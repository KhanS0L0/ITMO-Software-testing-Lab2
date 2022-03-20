package logarithmic;

import function.AbstractFunction;
import static java.lang.Double.*;

public class Log5 extends AbstractFunction {

    {
        getStubsTable().put(POSITIVE_INFINITY, POSITIVE_INFINITY);
        getStubsTable().put(0.0, NEGATIVE_INFINITY);
        getStubsTable().put(0.5, -0.431);
        getStubsTable().put(1.0, 0.0);
        getStubsTable().put(1.4, 0.209);
        getStubsTable().put(2.3, 0.518);
        getStubsTable().put(3.4, 0.76);
        getStubsTable().put(5.2, 1.024);
        getStubsTable().put(10.515, 1.462);
        getStubsTable().put(11.5234, 1.519);
        getStubsTable().put(14.8432, 1.676);
        getStubsTable().put(100.0, 2.861);
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
