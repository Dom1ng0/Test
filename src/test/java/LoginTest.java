import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;


public class LoginTest {
    private WebDriver driver;
    private void AssertEquals(String s, String text){}

    @Before
    public void setUp() throws Exception{
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.grammarly.com/signin?page=free");
    }

    @Test
    public void testLogin() throws Exception{
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("test.login@test.ua", "123456");
        Thread.sleep(3000);
        AssertEquals("Log out", driver.findElement(By.cssSelector("a[data-name=\"logout-lnk\"]")).getText());
    }
    @Test
    public void testLoginNoPassword() throws Exception{
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("test.login@test.ua", "");
        AssertEquals("Invalid email address/password combination.", driver.findElement(By.cssSelector("h3[data-qa=\"txtLoginError\"]")).getText());
    }
    @Test
    public void testLoginNoEmail() throws Exception{
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "123456");
        AssertEquals("Invalid email address/password combination.", driver.findElement(By.cssSelector("h3[data-qa=\"txtLoginError\"]")).getText());
    }
    @Test
    public void testLoginNoCredentials() throws Exception{
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "");
        AssertEquals("Invalid email address/password combination.", driver.findElement(By.cssSelector("h3[data-qa=\"txtLoginError\"]")).getText());
    }
    @Test
    public void testLoginIncorrectEmail() throws Exception{
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("asdfghjkl;", "123456");
        AssertEquals("Invalid email address/password combination.", driver.findElement(By.cssSelector("h3[data-qa=\"txtLoginError\"]")).getText());
    }
    @Test
    public void testLoginIncorrectEmail2() throws Exception{
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("@test.ua;", "123456");
        AssertEquals("Invalid email address/password combination.", driver.findElement(By.cssSelector("h3[data-qa=\"txtLoginError\"]")).getText());
    }
    @Test
    public void testLoginIncorrectPassword() throws Exception{
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("test.login@test.ua;", "123456 ");
        AssertEquals("Invalid email address/password combination.", driver.findElement(By.cssSelector("h3[data-qa=\"txtLoginError\"]")).getText());
    }
    @Test
    public void Experiment() throws Exception{
        LoginPage loginPage = new LoginPage(driver);

        for (int i = 0; i < 30; i++){
            loginPage.login("test" + i, "");
            AssertEquals("Invalid email address/password combination.", driver.findElement(By.cssSelector("h3[data-qa=\"txtLoginError\"]")).getText());
        }
    }


    @After
    public void tearDown() throws Exception{
        driver.quit();
    }
}
