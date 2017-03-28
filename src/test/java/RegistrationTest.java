
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    private WebDriver driver;
    private void AssertEquals(String s, String text){}

    @Before
    public void setUp() throws Exception{
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.grammarly.com/signup?breadcrumbs=true&no_install=true");
    }

    @Test
    public void testRegistrationNewUser() throws Exception{
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("tester", "test" + Math.random() + "@test.com", "test123", "Other");
        AssertEquals("Hello, tester", driver.findElement(By.cssSelector("span[data-qa='txtUsername']")).getText());
    }
    @Test
    public void testRegistrationNoUserName() throws Exception{
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("", "test" + Math.random() + "@test.com", "test123", "Other");
        AssertEquals("Required", driver.findElement(By.cssSelector("div[data-qa='msgErrorName']")).getText());
    }
    @Test
    public void testRegistrationNoEmail() throws Exception{
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("tester", "", "test123", "Other");
        AssertEquals("Required", driver.findElement(By.cssSelector("div[data-qa='msgErrorEmail']")).getText());
    }
    @Test
    public void testRegistrationNoPassword() throws Exception{
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("tester", "test" + Math.random() + "@test.com", "", "Other");
        AssertEquals("Required", driver.findElement(By.cssSelector("div[data-qa='msgErrorPassword']")).getText());
    }
    @Test
    public void testRegistrationNotSelectedDropdown() throws Exception{
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration("tester", "test" + Math.random() + "@test.com", "test123", "");
        AssertEquals("Required", driver.findElement(By.cssSelector("div[data-qa='msgErrorundefined']")).getText());
    }

    @After
    public void tearDown() throws Exception{
    driver.quit();
    }
}
