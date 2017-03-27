package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    private WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    public void login(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }
    private void type(String value, String cssLocator) {
        driver.findElement(By.cssSelector(cssLocator)).clear();
        driver.findElement(By.cssSelector(cssLocator)).sendKeys(value);
    }
    private void typeEmail(String email) {
        type(email, "input[data-qa=\"txtEmail\"]");
    }
    private void typePassword(String password) {
        type(password, "input[data-qa=\"txtPassword\"]");
    }
    private void clickLoginButton() {
        driver.findElement(By.cssSelector("input[data-qa=\"btnLogin\"]")).click();
    }

}
