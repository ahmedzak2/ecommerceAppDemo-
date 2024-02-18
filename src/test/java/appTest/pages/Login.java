package appTest.pages;

import appTest.Base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class Login extends Basepage {
    private AppiumBy  userName = new AppiumBy.ByAccessibilityId("Username input field");
    private AppiumBy passwordInput = new AppiumBy.ByAccessibilityId("Password input field");
    private AppiumBy loginButoon = new AppiumBy.ByAccessibilityId("Login button");

    public void fillUserName(String name)
    {
        findeElment(userName).sendKeys(name);
    }
public void fillPassword (String password){
        findeElment(passwordInput).sendKeys(password);
}
public void clickOnlogin(){
        findeElment(loginButoon).click();
}
}
