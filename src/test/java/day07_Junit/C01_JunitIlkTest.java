package day07_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_JunitIlkTest {

    //main metod olusturmamiza gerek kalmadi cunku Junit freinworku ile calisiyoruz.

    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("htpps://techproeducation.com");
        driver.close();


    }

    @Test
    public void test02() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("htpps://amazon.com");
        driver.close();

    }
}
