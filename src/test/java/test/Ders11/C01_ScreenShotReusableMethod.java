package test.Ders11;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {

    @Test
    public void testAll() throws IOException {
        //1- "https://www.hepsiburada.com" adresine gidilir.
        Driver.getDriver().get("https://www.hepsiburada.com");
        //2- Sayfanin ekran goruntusu alinir.
        ReusableMethods.getScreenshot("hepsiburada-home-page");

        //3- Sayfa kapatilir.
        Driver.closeDriver();
    }

    @Test
    public void testWebElement() throws IOException {
        AmazonPage amazonPage = new AmazonPage();
        //1- "https://www.amazon.com.tr" adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        ReusableMethods.waitFor(1);
        amazonPage.rejectCookie.click();

        //2- "Iphone" aratilir.
        amazonPage.searchBox.sendKeys("Iphone", Keys.ENTER);

        //3- Arama sonuc yazisi WebElementinin resmini aliniz.
        ReusableMethods.getScreenshotWebElement("amazon-result-text",amazonPage.resultText);

    }

}
