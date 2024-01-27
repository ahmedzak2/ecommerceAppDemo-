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
    productPage.chooseFirstProduct();
    productPage.addProductToCart();
    Thread.sleep(10000);
    productPage.openMenu();
    productPage.chooseCatolg();
    productPage.chooseSecondHightProduct();
    productPage.addProductToCart();
productPage.clickOnCart();
    Thread.sleep(20000);
    }
}
