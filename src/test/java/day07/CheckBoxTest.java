package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
1. Bir class oluşturun : CheckBoxTest
2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
 a. Verilen web sayfasına gidin.
 https://the-internet.herokuapp.com/checkboxes
 b. Checkbox1 ve checkbox2 elementlerini locate edin.
 c. Checkbox1 seçili değilse onay kutusunu tıklayın
 d. Checkbox2 seçili değilse onay kutusunu tıklayın
 */

public class CheckBoxTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

        @Test
         public void checkSecili(){
             WebElement check1=driver.findElement(By.xpath(" (//input[@type='checkbox'])[1]"));
             if (!check1.isSelected()){
                 check1.click();

             }
            WebElement check2=driver.findElement(By.xpath(" (//input[@type='checkbox'])[2]"));
            if (!check2.isSelected()) {
                check2.click();
            }
         }

         @AfterClass
         public static void tearDown(){
             driver.close();
         }




}
