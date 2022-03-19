package trigonometric;

import function.AbstractFunction;

import static java.lang.Math.*;

public class Cos extends AbstractFunction {

    {
        getStubsTable().put(3*PI/4, cos(3*PI/4));
        getStubsTable().put(PI/3,   cos(PI/3));
        getStubsTable().put(PI/2,   cos(PI/2));
        getStubsTable().put(PI/4,   cos(PI/4));
        getStubsTable().put(PI/6,   cos(PI/6));
        getStubsTable().put(PI,     cos(PI));
        getStubsTable().put(0.0,    cos(0.0));
        getStubsTable().put(-PI,    cos(-PI));
        getStubsTable().put(-PI/6,  cos(-PI/6));
        getStubsTable().put(-PI/4,  cos(-PI/4));
        getStubsTable().put(-PI/2,  cos(-PI/2));
        getStubsTable().put(-PI/3,  cos(-PI/3));
        getStubsTable().put(-3*PI/4,cos(-3*PI/4));
        getStubsTable().put(-5.49778, cos(-5.49778));
        getStubsTable().put(-5.25712, cos(-5.25712));
        getStubsTable().put(-5.12345, cos(-5.12345));
        getStubsTable().put(-2.509,   cos(-2.509));
        getStubsTable().put(-2.35619, cos(-2.35619));
    }

    private final Sin sinCalculator;

    public Cos(Double accuracy) {
        super(accuracy);
        this.sinCalculator = new Sin(accuracy);
    }

    public Double calculateFunction(Double arg){
        return sinCalculator.calculateFunction(arg + PI / 2);
    }
}
