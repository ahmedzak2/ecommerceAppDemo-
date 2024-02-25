package appTest.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class CheckOutPage extends Basepage {
    private By enterShippingAddresss = By.xpath("//android.widget.ScrollView[@content-desc='checkout address screen']/android.view.ViewGroup/android.widget.TextView[1]");
    private By fullName = By.xpath("//android.widget.EditText[@content-desc='Full Name* input field']");
    private By[] addressLine1 = new By[]{
            By.xpath("//android.widget.EditText[@content-desc='Address Line 1* input field']"),
            new AppiumBy.ByAccessibilityId("Full Name* input field"),
    };
    private By[] addressLine2 = new By[]{
            By.xpath("//android.widget.EditText[@content-desc='Address Line 2 input field']"),
            new AppiumBy.ByAccessibilityId("Address Line 2 input field"),
    };

    private By[] City = new By[]{
            By.xpath("//android.widget.EditText[@content-desc='City* input field']"),
            new AppiumBy.ByAccessibilityId("City* input field"),
    };
    private By[] stateRegion = new By[]{
            By.xpath("//android.widget.EditText[@content-desc='State/Region input field']"),
            new AppiumBy.ByAccessibilityId("State/Region input field"),
    };
    private By[] zipCode = new By[]{
            By.xpath("//android.widget.EditText[@content-desc='Zip Code* input field']"),
            new AppiumBy.ByAccessibilityId("Zip Code* input field"),
    };
    private By[] country = new By[]{
            By.xpath("//android.widget.EditText[@content-desc='Country* input field']"),
            new AppiumBy.ByAccessibilityId("Country* input field"),
    };
    private By[] toPayment = new By[]{
            By.xpath("//android.view.ViewGroup[@content-desc='To Payment button']"),
            new AppiumBy.ByAccessibilityId("To Payment button"),
    };
    private By paymentMethod = By.xpath("//android.widget.ScrollView[@content-desc='checkout payment screen']/android.view.ViewGroup/android.widget.TextView[1]");
    private By[] cardNumber = new By[]{
            new AppiumBy.ByAccessibilityId("Card Number* input field"),
            By.xpath("//android.widget.EditText[@content-desc='Card Number* input field']")
    };
    private By[] expirationDate = new By[]{
            new AppiumBy.ByAccessibilityId("Expiration Date* input field"),
            By.xpath("//android.widget.EditText[@content-desc='Expiration Date* input field']")
    };
    private By[] securityCode = new By[]{
            new AppiumBy.ByAccessibilityId("Security Code* input field"),
            By.xpath("//android.widget.EditText[@content-desc='Security Code* input field']")
    };

    private By[] placeOrder = new By[]{
            new AppiumBy.ByAccessibilityId("Place Order buttonPlace Order button"),
            By.xpath("//android.view.ViewGroup[@content-desc='Place Order button']")
    };
    private By[] reviewOrder = new By[]{
            new AppiumBy.ByAccessibilityId("Review Order button"),
            By.xpath("//android.view.ViewGroup[@content-desc='Review Order button']"),
            By.xpath("//android.view.ViewGroup[@content-desc='Review Order button']/android.widget.TextView"),
            By.linkText("Review Order")
    };
    private By checkoutComplete = By.xpath("//android.view.ViewGroup[@content-desc='checkout complete screen']/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]");
    private By yourOrder = By.xpath("//android.view.ViewGroup[@content-desc='checkout complete screen']/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[4]");
    private By[] continueShopping = new By[]{
            new AppiumBy.ByAccessibilityId("Continue Shopping button"),
            By.xpath("//android.view.ViewGroup[@content-desc='Continue Shopping button']"),
            By.xpath("//android.view.ViewGroup[@content-desc='Review Order button']/android.widget.TextView"),
            By.linkText("Continue Shopping")
    };
    public void fillFullName(String name) {
        final int MAX_TRIES = 3;
        for (int attempt = 0; attempt < MAX_TRIES; attempt++) {
            try {
                WebElement element = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Full Name* input field']"));
                element.sendKeys(name);
                break;  // Break out of the loop on success
            } catch (StaleElementReferenceException e) {
                if (attempt == MAX_TRIES - 1) throw e; // Rethrow the exception on the last attempt
                // Optionally, add a short delay here or take some action to ensure the element is stable
            }
        }
    }

    public void fillFirstAddresse(String address1) {
        findElement(addressLine1).sendKeys(address1);
    }

    public void fillSecondAddresse(String address2) {
        findElement(addressLine2).sendKeys(address2);
    }

    public void enterCity(String cityLine) {
        findElement(City).sendKeys(cityLine);
    }

    public void enterState(String state) {
        findElement(stateRegion).sendKeys(state);
    }

    public void fillZipCOde(String ZipCode) {
        scrollToElements(zipCode, 3);
        findElement(zipCode).sendKeys(ZipCode);
    }

    public void fillCountry(String Country) {
        findElement(country).sendKeys(Country);
    }

    public void clickOnPayment() {
        findElement(toPayment).click();
    }

    public void enterCardNumber(String number) {
        findElement(cardNumber).sendKeys(number);
    }

    public void enterExpireDate(String date) {
        findElement(expirationDate).sendKeys(date);
    }

    public void enterSecurityCode(String code) {
        findElement(securityCode).sendKeys(code);
    }

    public void clickOnReviewButton() {
        //    findElement(reviewOrder).click();
        pressFirstAvailableElement(reviewOrder);
    }

    public void clickonPlaceOrder() {
        pressFirstAvailableElement(placeOrder);
    }
    public String getCheckoutComplete(){
        return findeElment(checkoutComplete).getText();

    }
    public String getYourOrder(){
        return findeElment(yourOrder).getText();

    }

    public void clickOnContinueShopping() {
        pressFirstAvailableElement(continueShopping);
    }






}




