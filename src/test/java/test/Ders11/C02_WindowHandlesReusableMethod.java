package test.Ders11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_WindowHandlesReusableMethod {

    @Test
    public void test01(){

        //1- "https://the-internet.herokuapp.com/windows" adresine gidilir.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        ReusableMethods.waitFor(2);

        //2- "Click Here" butonuna tiklanir.
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();

        //3- Acilan yeni tab in title inin "New Window" oldugu test edilir.
        ReusableMethods.switchToWindow("New Window");
        Assert.assertEquals(Driver.getDriver().getTitle(),"New Window");
        Driver.quitDriver();
    }

}
