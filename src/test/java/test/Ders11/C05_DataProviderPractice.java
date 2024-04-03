package test.Ders11;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_DataProviderPractice {

    @DataProvider
    public static Object[][] loginTest() {
        return new Object[][]{{"user@gmail.com","1234"},{"user12@gmail.com","1122"},{"user22@gmail.com","3344"}};
    }

    @Test(dataProvider = "loginTest")
    public void test(String mail, String password) {
        BrcPage brcPage = new BrcPage();

        //1- "https://bluerentalcars.com" adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("brcURL"));

        //2- "Login" butonuna tiklanir.
        brcPage.loginButonInHomePage.click();

        //3- Data provider ile 3 farkli username ve 3 farkli password girilir.
        brcPage.emailEditT.sendKeys(mail);
        brcPage.passwordEditT.sendKeys(password);

        //4- "Login" butonuna tiklanir.
        brcPage.loginButonInForm.click();

        //5- Degerler girildiginde sayfaya basarili sekilde girilmedigi gorulur.
        Assert.assertTrue(brcPage.loginButonInHomePage.isDisplayed());

    }
}
