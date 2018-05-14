import org.junit.*;
import org.openqa.selenium.*;
import pageObjects.LoginPage;
import static org.junit.Assert.*;

public class LoginTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        super.setUp();
        driver.get(this.loginUrl);
    }

    @Test
    public void testLogin() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test.login@test.ua", "123456");
        assertEquals("Log out", driver.findElement(By.cssSelector("[data-name=\"logout-lnk\"]")).getText());
    }

    @Test
    public void testLoginNoPassword() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test.login@test.ua", "");
        assertEquals("Invalid email address/password combination.", driver.findElement(By.cssSelector("[data-qa=\"txtLoginError\"]")).getText());
    }

    @Test
    public void testLoginNoEmail() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "123456");
        assertEquals("Invalid email address/password combination.", driver.findElement(By.cssSelector("[data-qa=\"txtLoginError\"]")).getText());
    }

    @Test
    public void testLoginNoCredentials() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        assertEquals("Invalid email address/password combination.", driver.findElement(By.cssSelector("[data-qa=\"txtLoginError\"]")).getText());
    }

    @Test
    public void testLoginIncorrectEmail() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("asdfghjkl@", "123456");
        assertEquals("Invalid", driver.findElement(By.cssSelector("[data-qa=\"errEmail\"]")).getText());
    }

    @Test
    public void testLoginIncorrectEmail2() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("@test.ua;", "123456");
        assertEquals("Invalid", driver.findElement(By.cssSelector("[data-qa=\"errEmail\"]")).getText());    }

    @Test
    public void testLoginIncorrectPassword() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test.login@test.ua", "123456 ");
        assertEquals("Invalid email address/password combination.", driver.findElement(By.cssSelector("[data-qa=\"txtLoginError\"]")).getText());
    }

    @Test
    public void Experiment() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        for (int i = 0; i < 30; i++) {
            loginPage.login("test" + i, "");
            assertEquals("Invalid", driver.findElement(By.cssSelector("[data-qa=\"errEmail\"]")).getText());        }
    }
}
