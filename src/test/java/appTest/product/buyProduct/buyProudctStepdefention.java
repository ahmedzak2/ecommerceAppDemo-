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


       Assert.assertEquals(cartPage.calculateTheTotalOfItem(), cartPage.getTotalPrice(),"there wrong in calacute ");
    }

    @And("the customer enters username {string} and password {string}")
    public void theCustomerEntersUsernameAndPassword(String username, String password) throws InterruptedException {
        String user = configReader.getProperty(username);
        String passwordInput = configReader.getProperty(password);
        login.fillUserName(user);
        login.fillPassword(passwordInput);
        login.clickOnlogin();
        Thread.sleep(30000);
    }


    @When("customer processed to checkOut page to buy product")
    public void customerProcessedToCheckOutPageToBuyProduct() {
        cartPage.clickOnProceedToCheckoutButton();
    }

    @And("the customer enters fullname {string}")
    public void theCustomerEntersFullname(String fullName) {
        String user = configReader.getProperty(fullName);
        checkOutPage.fillFullName(user);
    }

    @And("the customer enters city {string} and region {string} and zipCode {string} and Country {string}")
    public void theCustomerEntersCityAndRegionAndZipCodeAndCountry(String arg0, String arg1, String arg2, String arg3) {
        String city = configReader.getProperty(arg0);
        String region = configReader.getProperty(arg1);
        String zipCode = configReader.getProperty(arg2);
        String country = configReader.getProperty(arg3);
        checkOutPage.enterCity(city);
        checkOutPage.enterState(region);
        checkOutPage.fillZipCOde(zipCode);
        checkOutPage.enterState(region);
        checkOutPage.fillCountry(country);
    }

    @Then("customer click on to payment")
    public void customerClickOnToPayment() {
    checkOutPage.clickOnPayment();
    }

    @And("the customer enters address {string} and address {string}")
    public void theCustomerEntersAddressAndAddress(String arg0, String arg1) {
    checkOutPage.fillFirstAddresse(arg0);
    checkOutPage.fillSecondAddresse(arg1);
    }

    @And("the customer enters fullname written on card  {string}")
    public void theCustomerEntersFullnameWrittenOnCard(String fullName) {
        String user = configReader.getProperty(fullName);
        checkOutPage.fillFullName(user);
    }

    @And("The customer enter cardNumber {string}")
    public void theCustomerEnterCardNumber(String arg0) {
        String number = configReader.getProperty(arg0);
        checkOutPage.fillFullName(number);
    }

    @And("The customer enter expire date  {string}")
    public void theCustomerEnterExpireDate(String arg0) {
        String date = configReader.getProperty(arg0);
        checkOutPage.fillFullName(date);
    }

    @And("The customer enter security code  {string}")
    public void theCustomerEnterSecurityCode(String arg0) {
        String code = configReader.getProperty(arg0);
        checkOutPage.fillFullName(code);
    }

    @And("the customer click on review order")
    public void theCustomerClickOnReviewOrder() throws InterruptedException {
        checkOutPage.clickOnReviewButton();
        Thread.sleep(5000);
    }
}
