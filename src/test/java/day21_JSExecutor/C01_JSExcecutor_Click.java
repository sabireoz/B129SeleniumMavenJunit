package day21_JSExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

public class C01_JSExcecutor_Click extends TestBase {
WebDriver driver;
//Faker faker;
    @Test
    public void clickByJSTest() {
        /*
        eger bir web sayfasinin HTML kodlari tamamen yada kismen JavaScript kullanarak olusturulduysa o sayfaya mudahale
        etmek icin genellikle JavaScriptExecutor arayuzunu kulllnmak gerekir.
        bu durumda sayfayi manipule etmek veya etkilesimde bulunmak icin standart WebDriver komutlari yetersiz kalabilir
        bu nedenle JSExecutor arayuzu,sayfanin JSkodlarina dogrudan erisebilir.
        Ancak mumkunse WebDriverin sundugu standart yontemlerle sorunlari cozmek daha iyidir cunku JS kullanimi,sayfanin
        daha yavas yuklenmesine neden olabilir.
         */

        //   http://www.uitestpractice.com/Students/Form sayfasına git

        driver.get(" http://www.uitestpractice.com/Students/Form ");
   // Formu doldur
       // Faker faker = new Faker();
       // WebElement firstName = driver.findElement(By.id("firstname"));
       // firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,Keys.TAB,Keys.TAB,
              //  Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,faker.phoneNumber().cellPhone());

   // Submit tuşuna tıkla
        WebElement submit=driver.findElement(By.xpath("//*[text()='Submit']"));
        submit.click();
        //org.openqa.selenium.ElementClickInterceptedException: Eğer JS kodlarıyla bir web element oluşturulmuşsa
        //normal click() methodunda bu exception'ı alırız

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",submit);

  /*
        org.openqa.selenium.ElementClickInterceptedException: Eğer JS kodlarıyla bir web element oluşturulmuşsa
        normal click() methodunda bu exception'ı alırız
         */
      //  WebElement submit = driver.findElement(By.xpath("//*[text()='Submit']"));
        /*
        try {
            submit.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",submit);
        }
         */
        submit.click();
        //Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
        Assert.assertNotEquals("http://www.uitestpractice.com/Students/Form?optradio=on",driver.getCurrentUrl());
 //   Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.


    }
}
