package logarithmic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Logarithmic calculator test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {

    private Ln ln;
    private Log2 log2;
    private Log5 log5;
    private Log10 log10;

    private final double DELTA = 0.05;
    private final double ACCURACY = 0.001;

    @BeforeAll
    void init() {
        this.ln = new Ln(ACCURACY);
        this.log2 = new Log2(ACCURACY, ln);
        this.log5 = new Log5(ACCURACY, ln);
        this.log10 = new Log10(ACCURACY, ln);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-3.0, NaN",
            "-2.0, NaN",
            "-1.0, NaN",
            "-0.1, NaN",
            "0.0, -Infinity",
            "0.2,  -1.609",
            "1.0,   0.0",
            "1.4,   0.336",
            "2.3,   0.833",
            "3.4,   1.224",
            "10.0,  2.303",
            "Infinity, Infinity"
    })
    void lnTest(Double x, Double expectedResult){
        assertEquals(expectedResult, ln.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-3.0, NaN",
            "-2.0, NaN",
            "-1.0, NaN",
            "-0.1, NaN",
            "0.0, -Infinity",
            "0.2,  -2.322",
            "1.0,   0.0",
            "1.4,   0.485",
            "2.3,   1.202",
            "3.4,   1.766",
            "10.0,  3.322",
            "Infinity, Infinity"
    })
    void log2Test(Double x, Double expectedResult) {
        assertEquals(expectedResult, log2.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-3.0, NaN",
            "-2.0, NaN",
            "-1.0, NaN",
            "-0.1, NaN",
            "0.0, -Infinity",
            "0.2,  -1.0",
            "1.0,   0.0",
            "1.4,   0.209",
            "2.3,   0.518",
            "3.4,   0.766",
            "10.0,  1.431",
            "Infinity, Infinity"
    })
    void log5Test(Double x, Double expectedResult) {
        assertEquals(expectedResult, log5.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-3.0, NaN",
            "-2.0, NaN",
            "-1.0, NaN",
            "-0.1, NaN",
            "0.0, -Infinity",
            "0.2,  -0.699",
            "1.0,   0.0",
            "1.4,   0.146",
            "2.3,   0.362",
            "3.4,   0.531",
            "10.0,  1.0",
            "Infinity, Infinity"
    })
    void log10Test(Double x, Double expectedResult) {
        assertEquals(expectedResult, log10.calculateFunction(x), DELTA);
    }

}
