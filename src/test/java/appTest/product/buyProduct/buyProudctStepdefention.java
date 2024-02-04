package appTest.product.buyProduct;

import appTest.Base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class buyProudctStepdefention extends BaseTest {

    @Given("the customer is on the product page")
    public void theCustomerIsOnTheProductPage() {
        String text = productPage.getHaederName();
        Assert.assertEquals(text, "Products");
    }

    @When("the customer filters the products by price")
    public void theCustomerFiltersTheProductsByPrice() {
        productPage.clickONFilter();
        productPage.chooseFormOption();
    }

    @And("the customer chooses the first highest priced item")
    public void theCustomerChoosesTheFirstHighestPricedItem() throws InterruptedException {
        productPage.chooseFirstProduct();
        productPage.addProductToCart();
        productPage.openMenu();
        productPage.chooseCatolg();
        Thread.sleep(1000);
    }

    @Then("the result should meet expectations")
    public void theResultShouldMeetExpectations() {
    }
}
