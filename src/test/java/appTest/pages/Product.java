package appTest.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class Product extends Basepage {
 private By header = By.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");
private By filter = By.xpath("//*[contains(@content-desc, 'sort button')]/android.widget.ImageView");
private By priceHighToLow = By.xpath("//*[contains(@content-desc, 'priceDesc')]/android.widget.TextView[2]\n");
public Product(AppiumDriver driver) {
  super(driver);
 }

 public String getHaederName(){
 return  findeElment(header).getText();
}

public void clickONFilter() {
findeElment(filter).click();
 }
 public void chooseFormOption() throws InterruptedException {
 findeElment(priceHighToLow).click();
 Thread.sleep(100000);
 }


}

