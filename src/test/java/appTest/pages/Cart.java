package appTest.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;

public class Cart extends Basepage{
    private By[] cart = new By[] {
            By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView"),
            By.xpath("//android.view.ViewGroup[@content-desc='cart badge']"),
           // By.id("00000000-0000-0132-ffff-ffff0000002a")
    };
    private By priceOfitem = By.xpath("(//android.widget.TextView[@content-desc='product price'])[1])");
    private AppiumBy totalCheckout= new AppiumBy.ByAccessibilityId("total price");
private By[] ProceedToCheckoutButton = new By[]{
        By.xpath("//android.view.ViewGroup[@content-desc='Proceed To Checkout button']/android.widget.TextView"), new AppiumBy.ByAccessibilityId("Proceed To Checkout button")
};

    public void clickOnCart(){
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
            } catch (NumberFormatException e) {
                System.err.println("Error parsing price: " + price);
            }
        }

        return total;
    }
    public double calculateTheTotalOfItem(){

        List<String> pricesList = fetchAllItemPrices();
        double prices= calculateTotal(pricesList);
        return prices;
    }
    public Double getTotalPrice(){
        Double price = 0.0;
        String totalCheckoutPrice= findeElment(totalCheckout).getText();
        String sanitizedPrice = totalCheckoutPrice.replaceAll("[^\\d.]", "");
        price=  Double.parseDouble(sanitizedPrice);
        return price;
    }
public void clickOnProceedToCheckoutButton(){
        findElement(ProceedToCheckoutButton).click();}

}
