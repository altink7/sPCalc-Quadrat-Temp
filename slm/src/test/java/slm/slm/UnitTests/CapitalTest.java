package slm.slm.UnitTests;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import slm.slm.CapitalController;

public class CapitalTest {

    @Test
    public void testCapitalAustria(){
        CapitalController controller = new CapitalController();

        String actual= controller.capital("Austria");
        String excepted ="Vienna";

        Assert.assertEquals(actual,excepted,"should be Vienna!");
    }

    @Test
    public void testCapitalGermany(){
        CapitalController controller = new CapitalController();

        String actual= controller.capital("Germany");
        String excepted ="Berlin";

        Assert.assertEquals(actual,excepted,"should be Berlin!");
    }
}
