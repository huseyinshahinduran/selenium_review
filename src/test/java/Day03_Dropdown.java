import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day03_Dropdown {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dropdown1(){

        driver.get("http://amazon.com");
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDown);

        select.getFirstSelectedOption();
        select.selectByVisibleText("Baby");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        select.selectByIndex(5);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        select.selectByValue("search-alias=computers-intl-ship");

        List<WebElement> tumSecenekler=select.getOptions();
        for (WebElement w:tumSecenekler){
            System.out.println(w.getText());
        }

        System.out.println("Toplam Kategori Sayisi: "+tumSecenekler.size());

        WebElement secili = select.getFirstSelectedOption();
        System.out.println("Şuan Seçili Olan : " + secili.getText());
    }

}
