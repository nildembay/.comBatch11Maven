package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
Class Work Amazon Search Test
1- https://www.amazon.com/ sayfasina gidelim
2- arama kutusunu locate edelim
3- “Samsung headphones” ile arama yapalim
4- Bulunan sonuc sayisini yazdiralim
5- Ilk urunu tiklayalim
6- Sayfadaki tum basliklari yazdiralim

 */

public class FirstMavenClass {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //1
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //2
        WebElement searchBox=driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.click();
        //3
        String arananKelime = "Samsung headphones";
        searchBox.sendKeys(arananKelime);
        searchBox.submit();  //keys.ENTER
        //4
        WebElement sonucSayisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Samsung headphones icin sonuc sayisi \"" +sonucSayisi.getText()+"\"");
        //5
        driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/71LcAql4+aL._AC_UY218_.jpg']")).click();
        //6
        driver.navigate().back();
        List<WebElement> baslikListesi = driver.findElements(By.xpath("(//span[@dir='auto'])"));
        for (WebElement w : baslikListesi
        ) {
            System.out.println(w.getText());
        }




        driver.close();
    }

}
