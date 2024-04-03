package test.Ders09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;
import utilities.TestBaseCross;

public class C05_HardAssert extends TestBaseCross {

    @Test
    public void test01() throws InterruptedException {

        //1- "https://www.amazon.com.tr" adresine gidilir.
        driver.get("https://www.amazon.com.tr");
        WebElement rejectCookie = driver.findElement(By.id("sp-cc-rejectall-link"));
        Thread.sleep(1000);
        rejectCookie.click();

        //2- Title in "Amazon" icerdigi kontrol edilir.
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //3- Arama kutusunun erisilebilir oldugu kontrol edilir.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled());

        //4- Arama kutusuna "Iphone" yazilip aratilir.
        searchBox.sendKeys("Iphone", Keys.ENTER);

        //5- Arama yapildigi kontrol edilir.
        WebElement resultText = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resultText.isDisplayed());

        //6- Arama sonucunun "Iphone" icerdigi kontrol edilir.
        Assert.assertTrue(resultText.getText().contains("Iphone"));

    }

}
