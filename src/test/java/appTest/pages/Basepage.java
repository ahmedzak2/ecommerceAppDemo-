package appTest.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public  class  Basepage {
    public AppiumDriver driver;
    public Basepage(AppiumDriver driver) {
            this.driver = driver;
        }

    public WebElement findeElment(By locater){
       return driver.findElement(locater);
    }


}
