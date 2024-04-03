package test.Ders09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;
import utilities.TestBaseCross;

public class C06_SoftAssert extends TestBaseCross {

    @Test
    public void test01() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        //1- "https://www.amazon.com.tr" adresine gidilir.
        driver.get("https://www.amazon.com.tr");
        WebElement rejectCookie = driver.findElement(By.id("sp-cc-rejectall-link"));
        Thread.sleep(1000);
        rejectCookie.click();

        //2- Title in "Amazon" icerdigi kontrol edilir.
        softAssert.assertTrue(driver.getTitle().contains("Amazon"),"Girilen kelimeyi icermemektedir.");

        //3- Arama kutusunun erisilebilir oldugu kontrol edilir.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(searchBox.isEnabled(),"aradiginiz web elemente erisilememektedir.");

        //4- Arama kutusuna "Iphone" yazilip aratilir.
        searchBox.sendKeys("Iphone", Keys.ENTER);

        //5- Arama yapildigi kontrol edilir.
        WebElement resultText = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(resultText.isDisplayed(),"element goruntulenmedi.");

        //6- Arama sonucunun "Iphone" icerdigi kontrol edilir.
        String expectedText = "Iphone";
        softAssert.assertTrue(resultText.getText().contains(expectedText),expectedText + "kelimesi icermemektedir.");
        softAssert.assertAll();

    }

}
