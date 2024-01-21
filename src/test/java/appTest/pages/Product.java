package appTest.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class Product extends Basepage {
 private By header = By.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");
private By filter = By.xpath("//*[contains(@content-desc, 'sort button')]/android.widget.ImageView");
private By priceHighToLow = By.xpath("//*[contains(@content-desc, 'priceDesc')]/android.widget.TextView[2]\n");
private By firstHighestItem = By.xpath("(//android.widget.TextView[@content-desc='store item text'])[1]");
 private By secondHighestItem = By.xpath("(//android.widget.TextView[@content-desc='store item text'])[2]");
private AppiumBy addToCart = (AppiumBy) AppiumBy.accessibilityId("Add To Cart button");
private By addItem = By.xpath("//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView");
private By decraseItem = By.xpath("//android.view.ViewGroup[@content-desc='counter minus button']/android.widget.ImageView");

private By MenuApp = By.xpath(" //android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView");

 private AppiumBy catalogMenu = (AppiumBy) AppiumBy.accessibilityId("open menu");
 private By catalog = By.linkText("Catalog");
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


 public By getFirstHighestItem() {
  return firstHighestItem;
 }

 public void setFirstHighestItem(By firstHighestItem) {
  this.firstHighestItem = firstHighestItem;
 }
}

