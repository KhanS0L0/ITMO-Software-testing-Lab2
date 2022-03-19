package logarithmic;

import function.AbstractFunction;
import static java.lang.Math.*;
import static java.lang.Double.*;

public class Log10 extends AbstractFunction {

    {
        getStubsTable().put(POSITIVE_INFINITY, log10(POSITIVE_INFINITY));
        getStubsTable().put(10.0 + 0.01, log10(10.0 + 0.01));
        getStubsTable().put(10.0, log10(10.0));
        getStubsTable().put(10.0 - 0.01, log10(10.0 - 0.01));
        getStubsTable().put(1.0 + 0.01, log10(1.0 + 0.01));
        getStubsTable().put(1.0, log10(1.0));
        getStubsTable().put(1.0 - 0.01, log10(1.0 - 0.01));
        getStubsTable().put(0.0 + 0.01, log10(0.0 + 0.01));
        getStubsTable().put(0.0, log10(0.0));
        getStubsTable().put(0.0 - 0.01, log10(0.0 - 0.01));
    }

    private final Ln ln;

    public Log10(Double accuracy, Ln ln) {
        super(accuracy);
        this.ln = new Ln(accuracy);
    }

    @Override
    public Double calculateFunction(Double x) {
        return ln.calculateFunction(x) / ln.calculateFunction(10.0);
    }

    @Override
    public Double calculateStub(Double stub) {
        return stub / ln.getStubsTable().get(10.0);
    }
}
