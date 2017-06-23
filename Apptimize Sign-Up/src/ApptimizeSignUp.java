//Apptimize 30 day trial sign up script
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by janish on 6/22/2017.
 */
public class ApptimizeSignUp {

    //Creating ChromeDriver instance
    static WebDriver driver;
    WebElement elem;

    @BeforeClass
    public static void setUp() {
        //Set chrome driver path of your system in the below line
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Chromedriver\\chromedriver.exe");//add chrome driver path of local system
        driver = new ChromeDriver();
    }

    @Test
    public void signUp() {
        //Launching the URL
        driver.get("https://apptimize.com/");

        //Wait time added for page to load & verify that signup button is visible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/30-day-trial']")));
        //maximizing the window
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@href='/30-day-trial']")).click();

        //Wait time added for page to load & verify that first name field is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fname")));

        //Sign Up
        Assert.assertEquals("30 day trial - Apptimize", driver.getTitle());
        driver.findElement(By.id("fname")).clear();
        driver.findElement(By.id("fname")).sendKeys("Janish");
        driver.findElement(By.id("lname")).clear();
        driver.findElement(By.id("lname")).sendKeys("Siroya");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("janish.siroya@sjsu.edu"); //update the email id for script execution
        driver.findElement(By.id("company")).clear();
        driver.findElement(By.id("company")).sendKeys("Apptimize Candidate");
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys("6692048803");
        driver.findElement(By.id("jobtitle")).clear();
        driver.findElement(By.id("jobtitle")).sendKeys("QA Engineer");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Apptimize@123");
        driver.findElement(By.xpath("//input[@name='purchased'][2]")).click();
        driver.findElement(By.id("eula")).click();
        driver.findElement(By.id("submit")).click();

        //Adding wait time for page to load
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zet-app-name")));

        Assert.assertEquals("Create App - Apptimize",driver.getTitle());

        //Will be executed only if sign up is successful
        System.out.println("30 day trial sign up successful");
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }
}
