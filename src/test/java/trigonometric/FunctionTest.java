package trigonometric;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.CsvLogger;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

/*
*   Up to down integration test
*/
@DisplayName("Trigonometric function test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FunctionTest {

    private TrigonometricFunction function;
    private Sin sin;
    private Cos cos;
    private Tan tan;
    private Csc csc;

    private final double ACCURACY = 0.001;
    private final double DELTA = 0.05;

    private final CsvLogger logger = new CsvLogger("trigonometric/cos-results.csv", -7.0, 0.0, 0.5);

    @BeforeAll
    void init(){
        this.sin = new Sin(ACCURACY);
        this.cos = new Cos(ACCURACY);
        this.tan = new Tan(ACCURACY);
        this.csc = new Csc(ACCURACY);
        this.function = new TrigonometricFunction(ACCURACY, sin, cos, tan, csc);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("all are stubs")
    void allAreStubs(Double x, Double expectedResult) {

        double sinStub = sin.getStubsTable().get(x);
        double cosStub = cos.getStubsTable().get(x);
        double tanStub = tan.getStubsTable().get(x);
        double cscStub = csc.getStubsTable().get(x);

        double actualResult = function.calculateStub(x, sinStub, cosStub, tanStub, cscStub);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("sin(x) is a stub; all other aren't a stub")
    void sinCalculatorIsStub(Double x, Double expectedResult) {
        double sinStub = sin.getStubsTable().get(x);
        double cosX = cos.calculateFunction(x);
        double tanX = tan.calculateFunction(x);
        double cscX = csc.calculateFunction(x);

        double actualResult = function.calculateStub(x, sinStub, cosX, tanX, cscX);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("cos(x) is a stub; all other aren't a stub")
    void cosCalculatorIsStub(Double x, Double expectedResult) {
        double cosStub = cos.getStubsTable().get(x);
        double sinX = sin.calculateFunction(x);
        double cscX = csc.calculateFunction(x);
        double tanX = tan.calculateFunction(x);

        double actualResult = function.calculateStub(x, sinX, cosStub, tanX, cscX);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("tan(x) is a stub; all other aren't a stub")
    void tanCalculatorIsStub(Double x, Double expectedResult) {
        double sinX = sin.calculateFunction(x);
        double cosX = cos.calculateFunction(x);
        double tanStub = tan.getStubsTable().get(x);
        double cscX = csc.calculateFunction(x);

        double actualResult = function.calculateStub(x, sinX, cosX, tanStub, cscX);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("cos(x) is a stub; all other aren't a stub")
    void cscCalculatorIsStub(Double x, Double expectedResult) {
        double sinX = sin.calculateFunction(x);
        double cosX = cos.calculateFunction(x);
        double tanX = tan.calculateFunction(x);
        double cscStub = csc.getStubsTable().get(x);

        double actualResult = function.calculateStub(x, sinX, cosX, tanX, cscStub);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("All calculators aren't stubs")
    void nothingIsStub(Double x, Double expectedResult) {
        double actualResult = function.calculateFunction(x);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Ignore
    @Test
    void log() {
        logger.log(cos);

        logger.setFilePath("trigonometric/csc-results.csv");
        logger.log(csc);

        logger.setFilePath("trigonometric/function-results.csv");
        logger.log(function);
    }
}
