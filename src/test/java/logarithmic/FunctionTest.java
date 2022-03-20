package logarithmic;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.CsvLogger;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Logarithmic function test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FunctionTest {

    private Ln ln;
    private Log2 log2;
    private Log5 log5;
    private Log10 log10;
    private LogarithmicFunction function;

    private final double DELTA = 0.05;
    private final double ACCURACY = 0.0001;
    private final CsvLogger logger = new CsvLogger("logarithmic/ln-results.csv", 0.25, 5.0, 0.5);

    @BeforeAll
    void init() {
        this.ln = new Ln(ACCURACY);
        this.log2 = new Log2(ACCURACY, ln);
        this.log5 = new Log5(ACCURACY, ln);
        this.log10 = new Log10(ACCURACY, ln);
        this.function = new LogarithmicFunction(ACCURACY, ln, log2, log5, log10);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/ln.csv")
    void allAreStubs(Double x, Double expectedResult) {
        double lnStub = ln.getStubsTable().get(x);
        double log2Stub = log2.getStubsTable().get(x);
        double log5Stub = log5.getStubsTable().get(x);
        double log10Stub = log10.getStubsTable().get(x);

        double actualResult = function.calculateStub(x, lnStub, log2Stub, log5Stub, log10Stub);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/ln.csv")
    void lnIsStub(Double x, Double expectedResult){
        double lnStub = ln.getStubsTable().get(x);
        double log2X = log2.calculateFunction(x);
        double log5X = log5.calculateFunction(x);
        double log10X = log10.calculateFunction(x);

        double actualResult = function.calculateStub(x, lnStub, log2X, log5X, log10X);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/ln.csv")
    void log2IsStub(Double x, Double expectedResult){
        double lnX = ln.calculateFunction(x);
        double log2Stub = log2.getStubsTable().get(x);
        double log5X = log5.calculateFunction(x);
        double log10X = log10.calculateFunction(x);

        double actualResult = function.calculateStub(x, lnX, log2Stub, log5X, log10X);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/ln.csv")
    void log5isStub(Double x, Double expectedResult){
        double lnX = ln.calculateFunction(x);
        double log2X = log2.calculateFunction(x);
        double log5Stub = log5.calculateFunction(x);
        double log10X = log10.calculateFunction(x);

        double actualResult = function.calculateStub(x, lnX, log2X, log5Stub, log10X);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/ln.csv")
    void log10isStub(Double x, Double expectedResult){
        double lnX = ln.calculateFunction(x);
        double log2X = log2.calculateFunction(x);
        double log5X = log5.calculateFunction(x);
        double log10Stub = log10.calculateFunction(x);

        double actualResult = function.calculateStub(x, lnX, log2X, log5X, log10Stub);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/ln.csv")
    void nothingIsStubs(Double x, Double expectedResult){
        double actualResult = function.calculateFunction(x);
        assertEquals(actualResult, expectedResult, DELTA);
    }

    @Ignore
    @Test
    void logResults() {
        logger.log(ln);

        logger.setFilePath("logarithmic/log2-results.csv");
        logger.log(log2);

        logger.setFilePath("logarithmic/log5-results.csv");
        logger.setUpperBorder(10.0);
        logger.log(log5);

        logger.setFilePath("logarithmic/log10-results.csv");
        logger.setUpperBorder(15.0);
        logger.log(log10);

        logger.setFilePath("logarithmic/function-results.csv");
        logger.log(function);
    }
}
