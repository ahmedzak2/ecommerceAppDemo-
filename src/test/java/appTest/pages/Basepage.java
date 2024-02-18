package appTest.pages;

import appTest.uitily.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;


public  class  Basepage {
    public AppiumDriver driver =  DriverManager.getDriver();


    public WebElement findeElment(By locater){
       return driver.findElement(locater);
    }
    public WebElement findElement(By[] locators) {
        for (By locator : locators) {
            List<WebElement> elements = driver.findElements(locator);
            if (!elements.isEmpty()) {
                // Return the first element if found
                return elements.get(0);
            }
        }
        // Throw an exception or return null if no element was found using any of the locators
        throw new NoSuchElementException("No element found using the given locators");
    }


}
