package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }

    private void typeEmail(String email) {
        type(email, "[data-qa=\"txtEmail\"]");
    }

    private void typePassword(String password) {
        type(password, "[data-qa=\"txtPassword\"]");
    }

    private void clickLoginButton() {
        driver.findElement(By.cssSelector("[data-qa=\"btnLogin\"]")).click();
    }
}
