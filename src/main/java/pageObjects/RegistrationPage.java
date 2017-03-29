package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void registration(String userName, String email, String password, String dropDown) {
        typeUserName(userName);
        typeEmail(email);
        typePassword(password);
        selectDropdown(dropDown);
        clickRegistrationButton();
    }

    private void typeUserName(String userName) {
        type(userName, "input[data-qa='txtName']");
    }

    private void typeEmail(String email) {
        type(email, "input[data-qa='txtEmail']");
    }

    private void typePassword(String password) {
        type(password, "input[data-qa='txtPassword']");
    }

    private void clickRegistrationButton() {
        driver.findElement(By.cssSelector("input[data-qa='btnSignUp']")).click();
    }

    private void selectDropdown(String value) {
        Select dropdown = new Select(driver.findElement(By.cssSelector("select[data-qa='txtRole']")));
        dropdown.selectByVisibleText(value);
    }

}
