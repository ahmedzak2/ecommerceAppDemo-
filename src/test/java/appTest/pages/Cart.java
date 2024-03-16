package appTest.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Cart extends Basepage {
    private By[] cart = new By[]{
            By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView"),
            By.xpath("//android.view.ViewGroup[@content-desc='cart badge']"),
            // By.id("00000000-0000-0132-ffff-ffff0000002a")
    };
    private By priceOfitem = By.xpath("(//android.widget.TextView[@content-desc='product price'])[1]"); // Corrected
    private AppiumBy totalCheckout = new AppiumBy.ByAccessibilityId("total price");
    private By[] ProceedToCheckoutButton = new By[]{
            By.xpath("//android.view.ViewGroup[@content-desc='Proceed To Checkout button']/android.widget.TextView"), new AppiumBy.ByAccessibilityId("Proceed To Checkout button")
    };
    private By[] DHLStandard = new By[]{
            By.xpath("//android.view.ViewGroup[@content-desc='checkout delivery details']/android.widget.TextView[2]"),
            By.xpath("//android.view.ViewGroup[@content-desc='checkout billing address']/android.widget.TextView"),
            By.xpath("//android.view.ViewGroup[@content-desc='checkout delivery details']"),
            By.xpath("//android.widget.ScrollView[@content-desc='checkout review order screen']/android.view.ViewGroup/android.widget.TextView")
    };

//

    private By[] placeOrder = new By[]{
            new AppiumBy.ByAccessibilityId("Place Order buttonPlace Order button"),
            By.xpath("//android.view.ViewGroup[@content-desc='Place Order button']")
    };

    public void clickOnCart() {
        findElement(cart).click();
    }

    public List<String> fetchAllItemPrices() {
        List<String> itemPrices = new ArrayList<>();
        int itemIndex = 1; // Start with the first item

        while (true) {
            try {
                // Construct the XPath for the current item index
                By priceOfItem = By.xpath("(//android.widget.TextView[@content-desc='product price'])[" + itemIndex + "]");
                // Find the element and get its price
                String price = findeElment(priceOfItem).getText();
                itemPrices.add(price);
                itemIndex++; // Move to the next item
            } catch (NoSuchElementException e) {
                // If no element is found, break the loop
                break;
            }
        }

        return itemPrices; // Return the list of fetched prices
    }

    public double calculateTotal(List<String> itemPrices) {
        double total = 0.0;

        for (String price : itemPrices) {
            try {
                // Remove any currency symbols or commas before parsing
                String sanitizedPrice = price.replaceAll("[^\\d.]", "");
                total += Double.parseDouble(sanitizedPrice);
                System.out.println("price is :" + total);
            } catch (NumberFormatException e) {
                System.err.println("Error parsing price: " + price);
            }
        }

        return total;
    }

    public double calculateTheTotalOfItem() {

        List<String> pricesList = fetchAllItemPrices();
        double prices = calculateTotal(pricesList);
        return prices;
    }

    public double calculateTheTotalOfItemAndDelveriy() {

        List<String> pricesList = fetchAllItemPrices();
        double prices = calculateTotal(pricesList);
        return prices;
    }

    public Double getTotalPrice() {
        Double price = 0.0;
        String totalCheckoutPrice = findeElment(totalCheckout).getText();
        String sanitizedPrice = totalCheckoutPrice.replaceAll("[^\\d.]", "");
        price = Double.parseDouble(sanitizedPrice);
        return price;
    }

    public Double getDeliveryPrice() throws InterruptedException {
        Thread.sleep(2000);
        verticalScrollAdjusted();
        Double price = 0.0;
        // Wait for the elements to ensure the list is not empty before proceeding
        try {
            List<WebElement> deliveryPriceElements = findListOfElements(By.xpath("//*[contains(@text, '$')]"));
            for (WebElement element : deliveryPriceElements) {
                String text = element.getText();
                System.out.println(text);
            }
            if (deliveryPriceElements.size() >= 2) { // Ensure there are at least two elements
                WebElement elementBeforeLast = deliveryPriceElements.get(deliveryPriceElements.size() -2); // Get the element before the last

                String totalCheckoutPrice = elementBeforeLast.getText();
                System.out.println("Text of the element before the last: " + totalCheckoutPrice);

                // Extract numerical value from the element's text
                String deliveryPrice = totalCheckoutPrice.replaceAll("[^\\d.]", "");
                System.out.println("Extracted delivery price: " + deliveryPrice);

                price = Double.parseDouble(deliveryPrice);
            } else {
                System.err.println("Not enough elements found.");
            }
        } catch (Exception e) {
            System.err.println("Error retrieving delivery price: " + e.getMessage());
        }
        return price;
    }


    public double calculateTheAllPrices() throws InterruptedException {
        double num = calculateTheTotalOfItem();
        System.out.println("pass the items is :" + num);
        //  scrollBySwipeNum(5);
        //   verticalScrollToEnd();

        //  scrollToElements(placeOrder,8);
//DHLStandard
        double total = getDeliveryPrice() + num;
        System.out.println("delivery price "+ getDeliveryPrice());
        System.out.println("prices of items "+calculateTheTotalOfItem());
        System.out.println("prices of items total "+total);
        return total;

    }

    public void clickOnProceedToCheckoutButton() {
        findElement(ProceedToCheckoutButton).click();
    }



}