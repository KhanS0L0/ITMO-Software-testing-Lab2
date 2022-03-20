import function.SystemSolver;

import logarithmic.*;
import trigonometric.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("System solver tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SystemSolverTest {
    private SystemSolver systemSolver;

    @BeforeAll
    void init(){
        Double ACCURACY = 0.001;
        Ln ln = new Ln(ACCURACY);
        this.systemSolver = new SystemSolver(
                new TrigonometricFunction(ACCURACY,
                        new Sin(ACCURACY),
                        new Cos(ACCURACY),
                        new Tan(ACCURACY),
                        new Csc(ACCURACY)
                ),
                new LogarithmicFunction(ACCURACY, ln,
                new Log2(ACCURACY, ln),
                new Log5(ACCURACY, ln),
                new Log10(ACCURACY, ln))
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/system.csv")
    void systemSolverTest(Double x, Double expectedResult) {
        Double DELTA = 0.05;
        assertEquals(expectedResult, systemSolver.calculate(x), DELTA);
    }
}