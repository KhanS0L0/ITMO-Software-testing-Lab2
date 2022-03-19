package trigonometric;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Trigonometric calculator test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {

    private Sin sin;
    private Cos cos;
    private Tan tan;
    private Csc csc;

    private final double ACCURACY = 0.001;
    private final double DELTA = 0.05;

    @BeforeAll
    void init(){
        this.sin = new Sin(ACCURACY);
        this.cos = new Cos(ACCURACY);
        this.tan = new Tan(ACCURACY);
        this.csc = new Csc(ACCURACY);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-3.1415,  0.0",
            "-3.0,    -0.141",
            "-2.0,    -0.909",
            "-1.5707, -1.0",
            "-1.0,    -0.841",
            "0.0,      0.0",
            "1.0,      0.841",
            "1.5707,   1.0",
            "2.0,      0.909",
            "3.0,      0.141",
            "3.1415,   0.0"
    }
    )
    void sinTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, sin.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-3.1415, -1.0",
            "-3.0,    -0.99",
            "-2.0,    -0.416",
            "-1.5707,  0.0",
            "-1.0,     0.54",
            "0.0,      1.0",
            "1.0,      0.54",
            "1.5707,   0.0",
            "2.0,     -0.416",
            "3.0,     -0.99",
            "3.1415,  -1.0"
            }
    )
    void cosTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, cos.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-3.1415,  0.0",
            "-3.0,     0.143",
            "-2.0,     2.185",
            "-1.5,    -14.101",
            "-1.0,    -1.557",
            "0.0,      0.0",
            "1.0,      1.557",
            "1.5,      14.101",
            "2.0,     -2.185",
            "3.0,     -0.143",
            "3.1415,   0.0"
    }
    )
    void tanTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, tan.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-4,       1.321",
            "-3.0,    -7.086",
            "-2.0,    -1.1",
            "-1.5707, -1.0",
            "-1.0,    -1.188",
            "1.0,      1.188",
            "1.5707,   1.0",
            "2.0,      1.1",
            "3.0,      7.086",
            "4,       -1.321"
    }
    )
    void cscTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, csc.calculateFunction(x), DELTA);
    }
}
