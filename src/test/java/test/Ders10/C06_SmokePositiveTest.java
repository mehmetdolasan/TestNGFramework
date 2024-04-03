package test.Ders10;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_SmokePositiveTest {

    @Test(groups = "grup1")
    public void positiveTest() throws InterruptedException {

        BrcPage brcPage = new BrcPage();

        //1- "https://www.bluerentalcars.com/" adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("brcURL"));
        Thread.sleep(2000);

        //2- Login butonuna tiklanir.
        brcPage.loginButonInHomePage.click();
        Thread.sleep(1000);

        //3- Email ve password degerleri girilir.
        brcPage.emailEditT.sendKeys(ConfigReader.getProperty("brcUser"), Keys.ENTER);
        brcPage.passwordEditT.sendKeys(ConfigReader.getProperty("brcPass"),Keys.ENTER);

        //4- Login butonuna tiklandiginda basarili bir sekilde giris yapildigi gorulur.
        brcPage.loginButonInForm.click();


    }


}
