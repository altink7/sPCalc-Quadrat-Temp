package slm.slm.UnitTests;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import slm.slm.CalcController;

public class CalcTest {

    @Test
    public void testCalcPlus(){
        CalcController calc= new CalcController();

        String actual = calc.calc("10","+","7");
        String excepted = "17";

        Assert.assertEquals(actual,excepted,"Should be 17!");
    }

    @Test
    public void testCalcMinus(){
        CalcController calc= new CalcController();

        String actual = calc.calc("10","-","7");
        String excepted = "3";

        Assert.assertEquals(actual,excepted,"Should be 3!");
    }

    @Test
    public void testCalcpMultiply(){
        CalcController calc= new CalcController();

        String actual = calc.calc("10","*","7");
        String excepted = "70";

        Assert.assertEquals(actual,excepted,"Should be 70!");
    }

    @Test
    public void testCalcDivide(){
        CalcController calc= new CalcController();

        String actual = calc.calc("10","/","2");
        String excepted = "5";

        Assert.assertEquals(actual,excepted,"Should be 5!");
    }
}
