package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void registration(String email, String password, String userName) {

        typeEmail(email);
        clickConfirmEmailButton();
        typePassword(password);
        clickConfirmPasswordButton();
        typeUserName(userName);
        clickRegistrationButton();
    }

    private void typeEmail(String email) {
        type(email, "[data-qa='txtEmail']");
    }

    private void clickConfirmEmailButton() {
        driver.findElement(By.cssSelector("[data-qa='btnEmail']")).click();
    }

    private void typePassword(String password) {
        type(password, "[data-qa='txtPassword']");
    }

    private void clickConfirmPasswordButton() {
        driver.findElement(By.cssSelector("[data-qa='btnPassword']")).click();
    }

    private void typeUserName(String userName) {type(userName, "[data-qa='txtName']"); }

    private void clickRegistrationButton() {
        driver.findElement(By.cssSelector("[data-qa='btnSignUp']")).click();
    }

    /*private void selectDropdown(String value) {
        Select dropdown = new Select(driver.findElement(By.cssSelector("select[data-qa='txtRole']")));
        dropdown.selectByVisibleText(value);
    }*/

}
