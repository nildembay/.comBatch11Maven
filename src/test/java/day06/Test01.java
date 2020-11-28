package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
1-Test01 isimli bir class olusturun
2- https://www.walmart.com/ adresine gidin
3- Browseri tam sayfa yapin
4-Sayfayi “refresh” yapin
5- Sayfa basliginin “Save” ifadesi icerdigini control edin
6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
7- URL in walmart.com icerdigini control edin
8-”Nutella” icin arama yapiniz
9- Kac sonuc bulundugunu yaziniz
10-Sayfayi kapatin
 */
public class Test01 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //https://www.walmart.com/ adresine gidin
        driver.get("https://www.walmart.com/");

        //Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        String pageTitle= driver.getTitle();
        String aranan="Save";


        if (pageTitle.contains(aranan)){
            System.out.println("Sayfa title da aranan ifade bulma testi: PASS");
        }else{
            System.out.println("Sayfa title da aranan ifade bulma testi: FAILED");
        }


        //6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        if (pageTitle.equals("Walmart.com | Save Money.Live Better")){
            System.out.println("Title testi PASS");
        }else{
            System.out.println("Title testi FAILED");
        }


        //7- URL in walmart.com icerdigini control edin
        String actualUrl= driver.getCurrentUrl();
        String arananIfade="walmart.com";
        if (actualUrl.contains(arananIfade)){
            System.out.println("URL içerme testi PASS");
        }else{
            System.out.println("URL içerme testi FAILED");
        }

        //8-”Nutella” icin arama yapiniz
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement searchBox=driver.findElement(By.xpath("//input[@name='query']"));
        searchBox.click();
        String arananKelime="Nutella";
        searchBox.sendKeys(arananKelime+ Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //9- Kac sonuc bulundugunu yaziniz
        WebElement sonucSayisi= driver.findElement(By.xpath("//div[@class='result-summary-container']"));
        System.out.println("Nutella için sonuç sayısı: "+sonucSayisi.getText());

        //10-Sayfayi kapatin
        driver.close();
    }
}
