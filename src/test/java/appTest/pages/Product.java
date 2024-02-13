package appTest.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class Product extends Basepage {
/* public Product(AppiumDriver driver) {
  super(driver);

 }*/

  private By header = By.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");
private By filter = By.xpath("//*[contains(@content-desc, 'sort button')]/android.widget.ImageView");
private By priceHighToLow = By.xpath("//*[contains(@content-desc, 'priceDesc')]/android.widget.TextView[2]\n");
 private By firstHighestItem = By.xpath("(//android.view.ViewGroup[@content-desc='store item']//android.widget.ImageView)[1]");
 private By secondHighestItem =  By.xpath("(//android.view.ViewGroup[@content-desc='store item']//android.widget.ImageView)[2]");
private AppiumBy addToCart = (AppiumBy) AppiumBy.accessibilityId("Add To Cart button");
private By addItem = By.xpath("//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView");
private By decraseItem = By.xpath("//android.view.ViewGroup[@content-desc='counter minus button']/android.widget.ImageView");

private By MenuApp = By.xpath(" //android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView");

 private AppiumBy catalogMenu = (AppiumBy) AppiumBy.accessibilityId("open menu");
 private By cart = By.xpath("//android.view.ViewGroup[@content-desc='cart badge']");
 private By catalog = By.linkText("Catalog");

 public void print(){
  System.out.println("it enter the ship ");
  System.out.println(driver.getStatus()+" why me Ziko ");

 }
 public String getHaederName(){
 return  findeElment(header).getText();
}

public void clickONFilter() {
findeElment(filter).click();
 }
 public void chooseFormOption()  {
 findeElment(priceHighToLow).click();
 }


 public By getFirstHighestItem() {
  return firstHighestItem;
 }

 public void setFirstHighestItem(By firstHighestItem) {
  this.firstHighestItem = firstHighestItem;
 }

 public void chooseFirstProduct(){
 findeElment(firstHighestItem).click();
 }
 public void addProductToCart(){
 findeElment(addToCart).click();
 }
public void openMenu(){
 findeElment(MenuApp).click();
}
public void  chooseCatolg(){
 findeElment(catalogMenu).click();
}
public void chooseSecondHightProduct(){
 findeElment(secondHighestItem).click();
}
public void clickOnCart(){
 findeElment(cart).click();
}
}


