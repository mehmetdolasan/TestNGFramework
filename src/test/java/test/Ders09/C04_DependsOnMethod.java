package test.Ders09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C04_DependsOnMethod extends TestBaseBeforeClassAfterClass {

    @Test
    public void test01() throws InterruptedException {
        //1- "https://www.amazon.com.tr" adresine gidilir.
        driver.get("https://www.amazon.com.tr");
        WebElement rejectCookie = driver.findElement(By.id("sp-cc-rejectall-link"));
        Thread.sleep(1000);
        rejectCookie.click();
    }

    @Test(dependsOnMethods = "test01")
    public void test02(){
        //2- "Iphone" kelimesi aratilir.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Iphone", Keys.ENTER);

    }

    @Test(dependsOnMethods = "test02")
    public void test03(){
        //3- Sonuc yazisinin "Iphone" icerdigi kontrol edilir.
        WebElement sonucText = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucText.getText().contains("Iphone"));

    }

}
