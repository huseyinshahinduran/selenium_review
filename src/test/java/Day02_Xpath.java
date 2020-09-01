import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day02_Xpath {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){

        driver.get("http://a.testaddressbook.com/");
        WebElement singIn=driver.findElement(By.linkText("Sign in"));
        singIn.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        List<WebElement> tumLinkler=driver.findElements(By.xpath("//a"));
        for (WebElement w:tumLinkler){
            System.out.println(w.getText());
        }

        WebElement username=driver.findElement(By.xpath("//*[@class='form-control']"));
        username.sendKeys("testtechproed@gmail.com");

        WebElement password=driver.findElement(By.id("session_password"));
        password.sendKeys("Test1234!");

        driver.findElement(By.name("commit")).click();

        List<WebElement> tumKelimer=driver.findElements(By.xpath("//*"));
        for (WebElement w:tumKelimer){
            System.out.println(w.getText());
        }

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }



}
