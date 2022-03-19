package function;

import logarithmic.LogarithmicFunction;
import trigonometric.TrigonometricFunction;

public class SystemSolver {
    private final TrigonometricFunction trigonometricFunction;
    private final LogarithmicFunction logarithmicFunction;

    public SystemSolver(TrigonometricFunction trigonometricFunction, LogarithmicFunction logarithmicFunction) {
        this.trigonometricFunction = trigonometricFunction;
        this.logarithmicFunction = logarithmicFunction;
    }

    public Double calculate(Double x) {
        if (x <= 0) return trigonometricFunction.calculateFunction(x);
        else return logarithmicFunction.calculateFunction(x);
    }
}