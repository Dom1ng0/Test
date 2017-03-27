
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
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
        typeUserName();
        typeEmail();
        typePassword();
        selectDropdown("Student (Non-native Speaker)");
        clickRegistrationButton();

        AssertEquals("Hello, tester", driver.findElement(By.cssSelector("span[data-qa='txtUsername']")).getText());
    }

    private void typePassword() {
        driver.findElement(By.cssSelector("input[data-qa='txtPassword']")).sendKeys("test123"); //pass
    }

    private void typeEmail() {
        driver.findElement(By.cssSelector("input[data-qa='txtEmail']")).sendKeys("test" + Math.random() + "@test.com");
    }

    private void typeUserName() {
        driver.findElement(By.cssSelector("input[data-qa='txtName']")).sendKeys("tester"); //name
    }

    private void clickRegistrationButton() {
        driver.findElement(By.cssSelector("input[data-qa='btnSignUp']")).click();
    }

    private void selectDropdown(String value) {
        Select dropdown = new Select(driver.findElement(By.cssSelector("select[data-qa='txtRole']")));
        dropdown.selectByVisibleText(value);
    }

    @After
    public void tearDown() throws Exception{
    driver.quit();
    }
}
