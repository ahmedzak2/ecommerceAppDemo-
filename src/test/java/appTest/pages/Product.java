package appTest.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class Product extends Basepage {
 private By header = By.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");

 public Product(AppiumDriver driver) {
  super(driver);
 }

 public String getHaederName(){
 return  findeElment(header).getText();
}
}
