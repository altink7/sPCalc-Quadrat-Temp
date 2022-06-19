package slm.slm.UnitTests;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import slm.slm.CapitalController;
import slm.slm.QuadratController;

public class QuadratTest {

    @Test
    public void testQuadrat(){
        QuadratController controller = new QuadratController();

        int actual= controller.quadrat(10,3);
        int excepted = 10*10*10;

        Assert.assertEquals(actual,excepted,"should be 10000!");
    }
}
