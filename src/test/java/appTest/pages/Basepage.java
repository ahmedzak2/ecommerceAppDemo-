package appTest.pages;

import appTest.uitily.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;


public  class  Basepage {
    public AppiumDriver driver = DriverManager.getDriver();


    public WebElement findeElment(By locater) {
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

    private void verticalScroll() {
        // Adjust these values as needed for your app
        int startPercentageY = 80; // Start from 80% of the height (bottom)
        int endPercentageY = 20; // End at 20% of the height (top)
        int duration = 500; // Milliseconds

        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        int startX = width / 2;
        int startY = (int) (height * startPercentageY / 100);
        int endY = (int) (height * endPercentageY / 100);

        new TouchAction((PerformsTouchActions) driver)
                .press(point(startX, startY))
                .waitAction(waitOptions(Duration.ofMillis(duration)))
                .moveTo(point(startX, endY))
                .release()
                .perform();
    }

    public void scrollToElement(By locator, int maxSwipes) {
        int swipes = 0;
        while (driver.findElements(locator).isEmpty() && swipes < maxSwipes) {
            verticalScroll();
            swipes++;
        }
    }

    public void scrollToElements(By[] locators, int maxSwipes) {
        int swipes = 0;
        boolean elementFound = false;

        // Loop until either an element is found or the max number of swipes is reached
        while (!elementFound && swipes < maxSwipes) {
            // Iterate through all locators to check if any element is displayed
            for (By locator : locators) {
                if (!driver.findElements(locator).isEmpty() && driver.findElement(locator).isDisplayed()) {
                    elementFound = true;
                    break; // Exit the for-loop if an element is found
                }
            }

            if (!elementFound) {
                verticalScroll(); // Scroll if no element was found
                swipes++;
            }
        }

        if (!elementFound) {
            System.out.println("None of the elements were found after " + maxSwipes + " swipes.");
        }
    }

    public void clickFirstAvailableElement(By[] locators) {
        for (By locator : locators) {
            List<WebElement> elements = driver.findElements(locator);
            for (WebElement element : elements) {
                if (element.isDisplayed() && element.isEnabled()) {
                    element.click();
                    return; // exit after the first successful click
                }
            }
        }
        throw new NoSuchElementException("No clickable element found using provided locators.");
    }

    public void pressFirstAvailableElement(By[] locators) {
        for (By locator : locators) {
            List<WebElement> elements = driver.findElements(locator);
            for (WebElement element : elements) {
                if (element.isDisplayed() && element.isEnabled()) {
                    // Create a new TouchAction object
                    TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
                    // Perform press action on the element
                    touchAction.press(ElementOption.element(element)).release().perform();
                    return; // Exit after the first successful press
                }
            }
        }
        throw new NoSuchElementException("No pressable element found using provided locators.");
    }
}
