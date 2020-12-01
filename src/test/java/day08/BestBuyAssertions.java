package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
1) Bir class oluşturun: BestBuyAssertions
2) https://www.bestbuy.com/ Adresine gidin
 farkli test method’lari olusturarak asagidaki testleri yapin
  ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
 ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
 ○ logoTest => BestBuy logosunun görüntülendigini test edin
 ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
 */
public class BestBuyAssertions {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com/");

    }
    @Test
    public void urlEsit(){
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    String actualUrl=driver.getCurrentUrl();
    String expectedUrl="https://www.bestbuy.com/";
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Test
    public void titleIcerik(){
        //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String arananKelime="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(arananKelime));
    }
    @Test
    public void logoGoruntulenme(){
        //logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo=driver.findElement(By.xpath("//img[@src='https://www.bestbuy.com/~assets/bby/_com/header-footer/images/bby_logo-a7e90594729ed2e119331378def6c97e.png'][1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void fransizcaLinkG(){
        WebElement fLink=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(fLink.isDisplayed());


    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
