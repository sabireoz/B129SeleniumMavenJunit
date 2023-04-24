package day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C01_MavenIlkTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://amazon.com/sayfasina giselim
        driver.get("https://amazon.com");

        //arama kutusunu locate edelim

        WebElement aramakutusu=driver.findElement(By.id("twotabserachtextbox"));

                //Samsung headphones ile arama yapalim
        aramakutusu.sendKeys("Samsung headphones");
        aramakutusu.submit();
        //Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisi=driver.findElement(By.xpath("//*[@class='a-section a-spacing-top-small'"));
        String[] sonuc=sonucSayisi.getText().split("");
        System.out.println("Bulunan sonuc sayisi="+sonuc[2]);


    // lambda ile yazdiralim

        //1-16 of 223 results for samsungheadphones
        Arrays.stream(sonucSayisi.getText().split("")).skip(2).limit(1).forEach(t-> System.out.println("sonuc sayisi"+t));
        Arrays.stream(sonucSayisi.getText().split("")).limit(3).skip(2).
                forEach(t-> System.out.println("sonuc sayisi2="+t));
        //ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='a-link-normal s-underline-text"+
                "s-inderline-link-text s-link-style a-text-normal'])")).click();


        //sayfadaki tum basliklari yazdiralim
        List<WebElement>sayfaBasliklari=driver.findElements(By.xpath("//h1"));
        for (WebElement w:sayfaBasliklari){
            System.out.println(w.getText());


           // lambda ile yazalim
          sayfaBasliklari.forEach(t-> System.out.println(t.getText()));

          //sayfayi kapatin
            driver.close();
        }


    }
}
