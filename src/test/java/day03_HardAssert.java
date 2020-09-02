import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class day03_HardAssert {

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
    public void test(){

        String baslik = driver.getTitle();
        // contains - bir string ifadenin içerisinde diğer bir string ifadenin
        //            geçip geçmediğini kontrol ediyordu.
        // "Merhaba Dünya !" -> contains("Dünya") TRUE FALSE
        if(baslik.contains("Car")){ // TRUE ya da FALSE
            System.out.println("GEÇİYOR : " +baslik);
        }else{
            System.out.println("GEÇMİYOR : " +baslik);
        }

        boolean iceriyorMu=baslik.contains("Car");

        Assert.assertTrue(iceriyorMu);

    }

    @Test
    public void test2(){

        String baslik = driver.getTitle();
        boolean falseMu=baslik.contains("Google");
        Assert.assertFalse(falseMu);

    }

    @Test
    public void test3(){

        String baslik = driver.getTitle();

        Assert.assertEquals("Amazon.com",baslik);

    }


}
