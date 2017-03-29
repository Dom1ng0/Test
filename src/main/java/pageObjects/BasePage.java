package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    protected void type(String value, String cssLocator) {
        driver.findElement(By.cssSelector(cssLocator)).clear();
        driver.findElement(By.cssSelector(cssLocator)).sendKeys(value);
    }
}
