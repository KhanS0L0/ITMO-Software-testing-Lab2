package trigonometric;

import function.AbstractFunction;
import static java.lang.Math.*;

public class Csc extends AbstractFunction {

    {
        getStubsTable().put(3*PI/4, 1/sin(3*PI/4));
        getStubsTable().put(PI/2,   1/sin(PI/2));
        getStubsTable().put(PI/3,   1/sin(PI/3));
        getStubsTable().put(PI/4,   1/sin(PI/4));
        getStubsTable().put(PI/6,   1/sin(PI/6));
        getStubsTable().put(PI,     1/sin(PI));
        getStubsTable().put(0.0,    1/sin(0.0));
        getStubsTable().put(-PI,    1/sin(-PI));
        getStubsTable().put(-PI/6,  1/sin(-PI/6));
        getStubsTable().put(-PI/4,  1/sin(-PI/4));
        getStubsTable().put(-PI/3,  1/sin(-PI/3));
        getStubsTable().put(-PI/2,  1/sin(-PI/2));
        getStubsTable().put(-3*PI/4,1/sin(-3*PI/4));
        getStubsTable().put(-5.49778, 1/sin(-5.49778));
        getStubsTable().put(-5.25712, 1/sin(-5.25712));
        getStubsTable().put(-5.12345, 1/sin(-5.12345));
        getStubsTable().put(-2.509,   1/sin(-2.509));
        getStubsTable().put(-2.35619, 1/sin(-2.35619));
    }

    private final Sin sinCalculator;

    public Csc(Double accuracy) {
        super(accuracy);
        this.sinCalculator = new Sin(accuracy);
    }

    public Double calculateFunction(Double arg){
        return 1 / sinCalculator.calculateFunction(arg);
    }
}