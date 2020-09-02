import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_isDisplayed {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void isDisplayed(){

        WebElement baslik=driver.findElement(By.xpath("//*[.='Dynamic Controls']"));
        boolean gorunuyorMu=baslik.isDisplayed();
        System.out.println(gorunuyorMu);

    }

    @Test
    public void isSelected(){

        WebElement secimElementi=driver.findElement(By.xpath("//input[@type='checkbox']"));
        boolean seiliMi=secimElementi.isSelected();
        System.out.println("Secili mi: "+seiliMi);

        secimElementi.click();

        boolean seciliMi2=secimElementi.isSelected();
        System.out.println("Secili mi 2: "+seciliMi2);

    }

    @Test
    public void isEnabled(){

        WebElement inputKutusu=driver.findElement(By.xpath("//input[@type='text']"));
        boolean aktifMi=inputKutusu.isEnabled();
        System.out.println("Aktif Mi: "+aktifMi);

        WebElement enableButton=driver.findElement(By.xpath("//*[.='Enable']"));
        enableButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        boolean aktifMi2 = inputKutusu.isEnabled(); // true false
        System.out.println("Aktif Mi 2: " + aktifMi2);

    }

}
