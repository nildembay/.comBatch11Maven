package day06;
/*
1. http://zero.webappsecurity.com sayfasina gidin
 2. Signin buttonuna tiklayin
 3. Login alanine  “username” yazdirin
 4. Password alanine “password” yazdirin
 5. Sign in buttonuna tiklayin
 6. Pay Bills sayfasina gidin
 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
 8. tarih kismina “2020-09-10”
 9. Pay buttonuna tiklayin
 10. “The payment was successfully submitted.” mesajinin ciktigini control edin
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //        1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //        2. Signin buttonuna tiklayin
        WebElement signInButonu=driver.findElement(By.id("signin_button"));
        signInButonu.click();

//        3. Login alanine  “username” yazdirin
        String kelime="username";
        WebElement loginTextBox=driver.findElement(By.id("user_login"));
        loginTextBox.click();
        loginTextBox.sendKeys(kelime);
//
//        4. Password alanine “password” yazdirin
        String passwordAlani="password";
        WebElement passwordTextBox=driver.findElement(By.id("user_password"));
        passwordTextBox.click();
        passwordTextBox.sendKeys(passwordAlani);

//        5. Sign in buttonuna tiklayin
        WebElement signInButonu2=driver.findElement(By.name("submit"));
        signInButonu2.click();

//        6. Pay Bills sayfasina gidin
        WebElement payBillsLinki=driver.findElement(By.linkText("Pay Bills"));
        payBillsLinki.click();

//        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
            WebElement amountTextBox=driver.findElement(By.id("sp_amount"));
            amountTextBox.click();
            amountTextBox.sendKeys("5000");
//        8. tarih kismina “2020-09-10”
        WebElement tarihTextBox=driver.findElement(By.id("sp_date"));
        tarihTextBox.click();
        tarihTextBox.sendKeys("2020-09-10");


//        9. Pay buttonuna tiklayin
        WebElement payButonu=driver.findElement(By.id("pay_saved_payees"));
        payButonu.click();

//        10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement expectedResult=driver.findElement(By.xpath("//span[@title='$ 5000 payed to payee sprint']"));
        if (expectedResult.isDisplayed()){
            System.out.println("Sonuc ciktisi testi PASS");
        }else{
            System.out.println("Sonuc çiktisi testi FAILED");
        }
        driver.close();

    }

}
