package slm.slm.UnitTests;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import slm.slm.CapitalController;
import slm.slm.TempController;

public class TempTest {

    @Test
    public void testTemp(){
        TempController controller = new TempController();

        String actual= controller.temp(100);
        String excepted ="37,8";

        Assert.assertEquals(actual,excepted,"should be 37,8!");
    }
}
