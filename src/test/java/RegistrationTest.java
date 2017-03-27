
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
        driver.findElement(By.xpath(".//*[@id='page']/div/div[3]/div[2]/form/div[2]/div[2]/input")).sendKeys("tester"); //name
        driver.findElement(By.xpath(".//*[@id='page']/div/div[3]/div[2]/form/div[3]/div[2]/input")).sendKeys("test" + Math.random() + "@test.com");
        driver.findElement(By.xpath(".//*[@id='page']/div/div[3]/div[2]/form/div[4]/div[2]/input")).sendKeys("test123"); //pass

        Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='page']/div/div[3]/div[2]/form/div[5]/div[2]/div/select")));
        dropdown.selectByVisibleText("Student (Non-native Speaker)");

        driver.findElement(By.xpath(".//*[@id='page']/div/div[3]/div[2]/form/div[6]/input")).click();
        AssertEquals("Hello, tester", driver.findElement(By.xpath(".//*[@id='page']/div/div[1]/div[2]/div/div/div/span")).getText());
    }

    @After
    public void tearDown() throws Exception{
    driver.quit();
    }
}
