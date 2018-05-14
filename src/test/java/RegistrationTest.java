import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.RegistrationPage;
import static org.junit.Assert.*;

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
        assertEquals("Hello, tester", driver.findElement(By.cssSelector("[data-qa='txtUsername']")).getText());
    }

    @Test
    public void testRegistrationNoUserName() throws Exception {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("test" + Math.random() + "@test.com", "test123", "");
        assertEquals("Required", driver.findElement(By.cssSelector("[data-qa='errName']")).getText());
    }

    @Test
    public void testRegistrationNoEmail() throws Exception {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("", "test123", "tester");
        assertEquals("Required", driver.findElement(By.cssSelector("[data-qa='errEmail']")).getText());
    }

    @Test
    public void testRegistrationNoPassword() throws Exception {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("test" + Math.random() + "@test.com", "", "tester");
        assertEquals("Required", driver.findElement(By.cssSelector("[data-qa='errPassword']")).getText());
    }
}
