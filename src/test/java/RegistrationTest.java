import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        super.setUp();
        driver.get(this.registrationUrl);
    }

    @Test
    public void testRegistrationNewUser() throws Exception {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("tester", "test" + Math.random() + "@test.com", "test123", "Other");
        AssertEquals("Hello, tester", driver.findElement(By.cssSelector("span[data-qa='txtUsername']")).getText());
    }

    @Test
    public void testRegistrationNoUserName() throws Exception {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("", "test" + Math.random() + "@test.com", "test123", "Other");
        AssertEquals("Required", driver.findElement(By.cssSelector("div[data-qa='msgErrorName']")).getText());
    }

    @Test
    public void testRegistrationNoEmail() throws Exception {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("tester", "", "test123", "Other");
        AssertEquals("Required", driver.findElement(By.cssSelector("div[data-qa='msgErrorEmail']")).getText());
    }

    @Test
    public void testRegistrationNoPassword() throws Exception {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("tester", "test" + Math.random() + "@test.com", "", "Other");
        AssertEquals("Required", driver.findElement(By.cssSelector("div[data-qa='msgErrorPassword']")).getText());
    }

    @Test
    public void testRegistrationNotSelectedDropdown() throws Exception {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("tester", "test" + Math.random() + "@test.com", "test123", "");
        AssertEquals("Required", driver.findElement(By.cssSelector("div[data-qa='msgErrorundefined']")).getText());
    }
}
