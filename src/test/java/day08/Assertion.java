package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assertion {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.techproeducation.com");

    }


    @Test
    public void positiveTest(){
        //sayfa başlığında TECHPROED olduğunu doğrulayın

        String arananKelime="TECHPROED";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime));
    }


    @Test
    public void negativeTest(){
        //Sayfa başlığının Mehmet kelimesi içermediğini doğrulayın
        String arananKelime="Mehmet";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(arananKelime));
    }

    @Test
    public void equalsTest(){
        // sayfa başlığının TECHPROED | SDET | Java Developer | Web Developer | DevOps Engineer olduğunu doğrula
        String actualTitle= driver.getTitle();
        String expectedTitle="TECHPROED | SDET | Java Developer | Web Developer | DevOps Engineer";
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @AfterClass
    public static void tearDown(){
       driver.close();
    }
}
