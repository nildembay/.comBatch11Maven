package day06;
/*
1. “https://www.saucedemo.com” Adresine gidin
2. Username kutusuna “standard_user” yazdirin
3. Password kutusuna “secret_sauce” yazdirin
4. Login tusuna basin
5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test03 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

//        1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

//        2. Username kutusuna “standard_user” yazdirin
        String userName="standard_user";
        WebElement usernameTextBox= driver.findElement(By.id("user-name"));
        usernameTextBox.click();
        usernameTextBox.sendKeys(userName);

//        3. Password kutusuna “secret_sauce” yazdirin
        String passwordBilgi="secret_sauce";
        WebElement passwordTextBox= driver.findElement(By.id("password"));
        passwordTextBox.click();
        passwordTextBox.sendKeys(passwordBilgi);

//        4. Login tusuna basin
        WebElement loginButon=driver.findElement(By.id("login-button"));
        loginButon.click();

//        5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        WebElement ilkUrunLinki=driver.findElement(By.linkText("Sauce Labs Backpack"));
        String ilkUrun= ilkUrunLinki.getText();
        ilkUrunLinki.click();

//        6. Add to Cart butonuna basin
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement addButton=driver.findElement(By.xpath("//button[@class='btn_primary btn_inventory']"));
        addButton.click();
//
//        7. Alisveris sepetine tiklayin
        WebElement sepetLinki= driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']"));
        sepetLinki.click();
//
//        8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement urunAdi=driver.findElement(By.linkText("Sauce Labs Backpack"));
        if (urunAdi.getText().equals(ilkUrun)){
            System.out.println(" Sepete ekleme testi PASS");
        }else{
            System.out.println(" Sepete ekleme testi FAILED");
        }

//        9. Sayfayi kapatin
        driver.close();
    }
}
