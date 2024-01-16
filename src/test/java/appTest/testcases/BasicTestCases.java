package appTest.testcases;

import appTest.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTestCases extends BaseTest {
    @Test
    public void checkNameOfPage() throws InterruptedException {
        String text = productPage.getHaederName();
        Assert.assertEquals(text, "Products");
        productPage.clickONFilter();
    productPage.chooseFormOption();
    }
}
