package test.Ders10;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;


public class C03_FacebookPageClass {

    Faker faker;
    @Test
    public void test01() throws InterruptedException {

        FacebookPage facebookPage = new FacebookPage();

        //1- "https://www.facebook.com/ adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("facebookURL"));
        Thread.sleep(1000);

        //2- POM'a uygun olarak email, sifre edit textleri ve giris yap butonu locate edilir.

        //3- Faker class kullanarak email ve sifre degerleri yazdirilip giris butonuna tiklanir.
        faker = new Faker();
        facebookPage.emailEditT.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordEditT.sendKeys(faker.internet().password());
        facebookPage.loginButton.click();
        Thread.sleep(2000);

        //4- Basarili giris yapilmadigi kontrol edilir.
        boolean nonLoginControl;
        nonLoginControl = !facebookPage.wrongEmailOrPasswordText.isDisplayed() && !facebookPage.wrongPasswordText.isDisplayed() && !facebookPage.isThisYourAccountTitle.isDisplayed();

        Assert.assertFalse(nonLoginControl);

    }

}
