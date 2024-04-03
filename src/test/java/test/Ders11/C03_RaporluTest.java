package test.Ders11;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C03_RaporluTest extends TestBaseRapor {

    @Test
    public void test01() {

        BrcPage brcPage = new BrcPage();

        extentTest = extentReports.createTest("Brc Login Test","Login Control");

        //1- "https://www.bluerentalcars.com" adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("brcURL"));
        extentTest.info("Blue rental cars sayfasina gidildi.");
        ReusableMethods.waitFor(2);

        //2- "Login" butonuna tiklanir.
        brcPage.loginButonInHomePage.click();
        extentTest.info("login butonuna tiklandi.");

        //3- Test Data --> user email: user@gmail.com
        brcPage.emailEditT.sendKeys(ConfigReader.getProperty("brcUser"));
        extentTest.info("email girildi.");

        //4- Test Data --> password: 1234 datalari ile login butonuna tiklanir.
        brcPage.passwordEditT.sendKeys(ConfigReader.getProperty("brcPass"));
        extentTest.info("password degeri girildi.");

        brcPage.loginButonInForm.click();
        extentTest.info("giris login butonuna tiklandi.");

        //5- Girisin basarili oldugu test edilir.
        extentTest.pass("Test basarili bir sekilde gerceklestirildi.");

    }
}
