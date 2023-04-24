package day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C02_MavenClassWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://zero.webappsecurity.com sayfasina gidiniz
        driver.get("https://zero.webappsecurity.com");

        //Signin butonunu tiklayin

        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        driver.navigate().back();//guvenlik duvarini asmak icin yaptik
        //login alanina username yazdirin
        WebElement login=driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");


        //password alanina paswsowr yazdirin

WebElement password=driver.findElement(with(By.tagName("input")).below(login));

//Pay bill sayfasina gidin-->Pay Bills bolumune ulasabilmek icin once online Banking bolumune tiklamaliyiz.
        // xpath-->//strong[text()='Online Banking']
        //xpath-->//*[.='Online Banking']
        driver.findElement(By.xpath("//*[.='Online Banking']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills'])")).click();

        //amount kismina yatirmak istediginiz herhangi bir miktari yazin

        WebElement amount=driver.findElement(By.cssSelector("input[id='sp_amount']"));
        amount.sendKeys("100");
        //tarih kismina "2020-09-10" yazdirin

        WebElement tarih=driver.findElement(By.cssSelector("input[id='sp_date']"));
        tarih.sendKeys("2020-09-10");
        //Pay butonuna tiklayin
        driver.findElement(By.cssSelector("input[id='pay_saved_payees']")).click();
        //"the payment was successfuly submitted."" msjinin ciktigini kontrol edin

        WebElement mesaj=driver.findElement(By.xpath("//[*text()='the payment was successfuly submitted']"));
        if (mesaj.isDisplayed()){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");
        //Sayfayi kapatiniz
        driver.close();


    }
}
