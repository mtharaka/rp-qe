import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IngestTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Desktop\\Selenium\\Chrome Exe\\chromedriver.exe");
        String baseUrl = "http://rp-test.adsharetoolbox.com/upload/index";
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.get(baseUrl);

        driver.findElement(By.id("loginform-username")).sendKeys("superadmin");
        driver.findElement(By.id("loginform-password")).sendKeys("alMHeQCAK");
        driver.findElement(By.name("login-button")).click();

        waitAndClickByXpath("//*[@id=\"exportButton\"]");
        waitAndClickByXpath("//*[@id=\"uploadForm\"]/div[1]/div[1]/div/span/span[1]/span");
        waitAndClickByXpath("//*[@role=\"treeitem\"][2]");

        waitAndClickByXpath("//*[@id=\"uploadForm\"]/div[2]/div/div/span/span[1]/span");
        waitAndClickByXpath("//*[@role=\"treeitem\"][3]");
        Thread.sleep(2000);

        waitAndClickByXpath("//*[@id=\"uploadForm\"]/div[3]/div/div/span/span[1]/span");
        waitAndClickByXpath("//*[@role=\"treeitem\"][2]");

//        waitAndClickByXpath("//*[@id=\"uploadForm\"]/div[5]/div/div/span/span[1]/span");
//        waitAndClickByXpath("//*[@role=\"treeitem\"][1]");

        WebElement uploadElement = driver.findElement(By.xpath("//*[@id=\"uploadform-file\"]"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("D:\\test.csv");
        Thread.sleep(2000);
        waitAndClickByXpath("//*[@id=\"formControlElement\"]/div/div/div[3]/div/div[2]/button");

//        driver.close();
    }

    public static void waitAndClickByXpath(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }
}
