package appTest.pages;

import appTest.uitily.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public  class  Basepage {
    public AppiumDriver driver =  DriverManager.getDriver();


    public WebElement findeElment(By locater){
       return driver.findElement(locater);
    }


}
