import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected void AssertEquals(String s, String text){}
    protected String baseUrl = "https://www.grammarly.com/";
    protected String loginUrl = baseUrl + "signin?page=free";
    protected String registrationUrl = baseUrl + "signup?breadcrumbs=true&no_install=true";

    @BeforeClass
    public static void beforeAll(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("BEFORE CLASS IS EXECUTED");
    }
    @Before
    public void setUp() throws Exception{
        System.out.println("BEFORE TEST");
    }
    @After
    public void tearDown() throws Exception{
        driver.manage().deleteAllCookies();
        System.out.println("AFTER TEST");
    }
    @AfterClass
    public static void afterAll() {
        driver.quit();
        System.out.println("AFTER CLASS IS EXECUTED");
    }

}
