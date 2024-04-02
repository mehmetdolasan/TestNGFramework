package test.Ders10;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AloTechPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SmokeNegativeTest {

    AloTechPage aloTechPage = new AloTechPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void wrongUser() throws InterruptedException {

        //1- "https://demo1.alo-tech.com/" adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("aloTechURL"));
        Thread.sleep(1000);
        //2- Email, password, login elementleri locate edilir.
        //3- Email,password degerleri girildiginde sayfaya girilemedigi test edilir.
        aloTechPage.emailEditT.sendKeys(ConfigReader.getProperty("wrongUser"), Keys.ENTER);
        aloTechPage.passwordEditT.sendKeys(ConfigReader.getProperty("password"),Keys.ENTER);
        Thread.sleep(1000);
        actions.doubleClick(aloTechPage.loginButton);
        Assert.assertTrue(aloTechPage.loginTitle.isDisplayed());
        //4- Sayfa kapatilir.
        Driver.closeDriver();

    }

    @Test
    public void wrongPassword() throws InterruptedException {

        //1- "https://demo1.alo-tech.com/" adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("aloTechURL"));
        Thread.sleep(1000);
        //2- Email, password, login elementleri locate edilir.
        //3- Email,password degerleri girildiginde sayfaya girilemedigi test edilir.
        aloTechPage.emailEditT.sendKeys(ConfigReader.getProperty("user"), Keys.ENTER);
        aloTechPage.passwordEditT.sendKeys(ConfigReader.getProperty("wrongPassword"),Keys.ENTER);
        Thread.sleep(1000);
        actions.doubleClick(aloTechPage.loginButton);
        Assert.assertTrue(aloTechPage.loginTitle.isDisplayed());
        //4- Sayfa kapatilir.
        Driver.closeDriver();

    }

    @Test
    public void wrongUserAndPassword() throws InterruptedException {

        //1- "https://demo1.alo-tech.com/" adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("aloTechURL"));
        Thread.sleep(1000);
        //2- Email, password, login elementleri locate edilir.
        //3- Email,password degerleri girildiginde sayfaya girilemedigi test edilir.
        aloTechPage.emailEditT.sendKeys(ConfigReader.getProperty("wrongUser"), Keys.ENTER);
        aloTechPage.passwordEditT.sendKeys(ConfigReader.getProperty("wrongPassword"),Keys.ENTER);
        Thread.sleep(1000);
        actions.doubleClick(aloTechPage.loginButton);
        Assert.assertTrue(aloTechPage.loginTitle.isDisplayed());
        //4- Sayfa kapatilir.
        Driver.closeDriver();

    }


}
