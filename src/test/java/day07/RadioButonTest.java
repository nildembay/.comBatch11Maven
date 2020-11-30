package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
1.Bir class oluşturun : RadioButtonTest
2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
- https://www.facebook.com adresine gidin
- “Create an Account” button’una basin
- “radio buttons” elementlerini locate edin
- Secili degilse cinsiyet butonundan size uygun olani secin
 */
public class RadioButonTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
    }
    @Test
    public void CreateAccount(){
        WebElement createAccountButonu=driver.findElement(By.id("u_0_2"));
        createAccountButonu.click();
        WebElement femaleRadio=driver.findElement(By.xpath("(//label[@class='_58mt'])[1]"));
        WebElement maleRadio=driver.findElement(By.xpath("(//label[@class='_58mt'])[2]"));
        WebElement customRadio=driver.findElement(By.xpath("(//label[@class='_58mt'])[3]"));
        if (!femaleRadio.isSelected()){
            femaleRadio.click();
        }

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
