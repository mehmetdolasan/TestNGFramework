package test.Ders10;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_AmazonPageClass {

    @Test
    public void test01() throws InterruptedException {

        AmazonPage amazonPage = new AmazonPage();

        //1- "https://www.amazon.com.tr" adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        Thread.sleep(1000);
        amazonPage.rejectCookie.click();

        //2- "Selenium" aratilir.
        amazonPage.searchBox.sendKeys("Selenium", Keys.ENTER);

        //3- Sonuc yazisinin "Selenium" icerdigi kontrol edilir.
        String expectedData = "Selenium";
        String actualData = amazonPage.resultText.getText();

        Assert.assertTrue(actualData.contains(expectedData));
        Driver.closeDriver();

    }

}
