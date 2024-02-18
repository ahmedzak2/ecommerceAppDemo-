package appTest.product.buyProduct;

import appTest.Base.BaseTest;
import appTest.pages.Product;
import appTest.uitily.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class buyProudctStepdefention extends BaseTest {

    @Given("the customer is on the product page")
    public void theCustomerIsOnTheProductPage() {
        test();
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
    public void theResultShouldMeetExpectations() throws InterruptedException {
      Thread.sleep(5000);

Assert.assertEquals(cartPage.calculateTheTotalOfItem(), cartPage.getTotalPrice(),"there is different on price ");

    }

    @And("customer choose the second highest priced item")
    public void customerChooseTheSecondHighestPricedItem() throws InterruptedException {
        productPage.chooseSecondHightProduct();
        productPage.addProductToCart();
        productPage.openMenu();
        productPage.chooseCatolg();
        Thread.sleep(1000);
    }

    @And("customer open the cart")
    public void cutomerOpenTheCart() {
        cartPage.clickOnCart();
    }

    @Then("the total cost of items shown is equal to total calculated  items")
    public void theTotalCostOfItemsShownIsEqualToTotalCalculatedItems() {
        cartPage.clickOnProceedToCheckoutButton();
    }

    @And("the customer enters username {string} and password {string}")
    public void theCustomerEntersUsernameAndPassword(String username, String password) throws InterruptedException {
        String user = configReader.getProperty(username);
        String passwordInput = configReader.getProperty(password);
        login.fillUserName(user);
        login.fillPassword(passwordInput);
        Thread.sleep(20000);
    }

    @And("customer processed to checkOut page")
    public void customerProcessedToCheckOutPage() {
        cartPage.clickOnProceedToCheckoutButton();
    }
}
