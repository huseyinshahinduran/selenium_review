import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day03_Ornek {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://amazon.com");
    }

    @Test
    public void amazonDropdownTest() {

        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDown);

        select.selectByVisibleText("Books");

        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("JAVA"+ Keys.ENTER);

        WebElement toplamSonuc=driver.findElement(By.xpath("//*[.='1-16 of over 20,000 results for']"));
        System.out.println("Toplam sonuc: "+toplamSonuc.getText());

        WebElement ilkSira=driver.findElement(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));
        ilkSira.click();

        WebElement geriButonu=driver.findElement(By.id("breadcrumb-back-link"));
        boolean gorunuyotMu=geriButonu.isDisplayed();
        System.out.println(gorunuyotMu);

    }

}
