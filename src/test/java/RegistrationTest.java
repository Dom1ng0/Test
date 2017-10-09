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
        registrationPage.registration("test" + Math.random() + "@test.com", "test123", "tester");
        AssertEquals("Hello, tester", driver.findElement(By.cssSelector("[data-qa='txtUsername']")).getText());
    }

    @Test
    public void testRegistrationNoUserName() throws Exception {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("test" + Math.random() + "@test.com", "test123", "");
        AssertEquals("Required", driver.findElement(By.cssSelector("[data-qa='errName']")).getText());
    }

    @Test
    public void testRegistrationNoEmail() throws Exception {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("", "test123", "tester");
        AssertEquals("Required", driver.findElement(By.cssSelector("[data-qa='errEmail']")).getText());
    }

    @Test
    public void testRegistrationNoPassword() throws Exception {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("test" + Math.random() + "@test.com", "", "tester");
        AssertEquals("Required", driver.findElement(By.cssSelector("[data-qa='errPassword']")).getText());
    }
}
