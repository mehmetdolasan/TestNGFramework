package test.Ders11;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DataProvider {

    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"java"},{"selenium"},{"samsung"},{"iphone"}};
    }

    @Test(dataProvider = "aranacakKelimeler")
    public void test(String kelimeler) {

        AmazonPage amazonPage = new AmazonPage();

        //1- Amazon anasayfasina gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        ReusableMethods.waitFor(1);

        //2- "java", "selenium", "samsung" ve "iphone" icin arama yapilir.
        amazonPage.searchBox.sendKeys(kelimeler, Keys.ENTER);

        //3- Sonuclarin aranan kelimeyi icerdigi kontrol edilir.
        String actualData = amazonPage.resultText.getText();
        Assert.assertTrue(actualData.contains(kelimeler));

    }
}
