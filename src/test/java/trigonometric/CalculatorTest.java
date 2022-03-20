package trigonometric;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Trigonometric calculator test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {

    private Sin sin;
    private Cos cos;
    private Tan tan;
    private Csc csc;

    private final double ACCURACY = 0.0001;
    private final double DELTA = 0.0005;

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
            "-1.5707, -1.0",
            "-1.2,    -0.932",
            "-0.75,   -0.682",
            "0.0,      0.0",
            "0.75,     0.682",
            "1.2,      0.932",
            "1.5707,   1.0",
            "3.1415,   0.0"
            }
    )
    void sinTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, sin.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-3.1415, -1.0",
            "-1.5707,  0.0",
            "-1.2,     0.362",
            "-0.75,    0.732",
            "0.0,      1.0",
            "0.75,     0.732",
            "1.2,      0.362",
            "1.5707,   0.0",
            "3.1415,  -1.0"
            }
    )
    void cosTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, cos.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-3.1415,  0.0",
            "-1.2,    -2.572",
            "-0.75,   -0.932",
            "0.0,      0.0",
            "0.75,     0.932",
            "1.2,      2.572",
            "3.1415,   0.0"
            }
    )
    void tanTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, tan.calculateFunction(x), DELTA);
    }

    @Test
    void tanNanTest(){
        Tan tan = new Tan(0.000000001);
        assertEquals(Double.NaN, tan.calculateFunction(PI/2.0));
        assertEquals(Double.NEGATIVE_INFINITY, tan.calculateFunction(-PI/2.0));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-1.5707, -1.0",
            "-1.2,    -1.073",
            "-0.75,   -1.467",
            "0.75,     1.467",
            "1.2,      1.073",
            "1.5707,   1.0"
            }
    )
    void cscTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, csc.calculateFunction(x), DELTA);
    }

    @Test
    void cscNanTest(){
        Csc csc = new Csc(0.000000001);
        assertEquals(Double.NaN, csc.calculateFunction(PI));
        assertEquals(Double.POSITIVE_INFINITY, csc.calculateFunction(0.0));
        assertEquals(Double.NaN, csc.calculateFunction(-PI));
    }
}
