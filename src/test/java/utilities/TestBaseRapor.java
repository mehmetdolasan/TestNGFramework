package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TestBaseRapor {

    protected static ExtentReports extentReports; //extent report'a ilk atamayi yapar
    protected static ExtentTest extentTest;
    // test pass veya failed gibi bilgileri kaydeder. Ayrica ekran resmi icin de kullaniriz.
    protected static ExtentHtmlReporter extentHtmlReporter; // Html raporu duzenler

    // Test islemine baslamadan hemen once (test methodundan once degil, tum test isleminden once)
    @BeforeTest(alwaysRun = true) //alwaysRun : her zaman calistir.
    public void setUpTest() {
        extentReports = new ExtentReports(); // Raporlamayi baslatir

        //rapor olustuktan sonra raporunuz nereye eklensin istiyorsaniz buraya yaziyorsunuz.
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());// Ustuste olusturmasin diye
        String filePath = System.getProperty("user.dir") + "/target/Rapor/rapor"+date+".html";
        //olusturmak istedigimiz raporu (html formatinda) baslatiyoruz, filePath ile dosya yolunu belirliyoruz.
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        // Istediginiz bilgileri buraya ekleyebiliyorsunuz.
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser")); // chrome, firefox
        extentReports.setSystemInfo("Automation Engineer", "Mehmet");
        extentHtmlReporter.config().setDocumentTitle("Rapor");
        extentHtmlReporter.config().setReportName("TestNG Reports");
    }
    // Her test methodundan sonra eger testte hata varsa, ekran goruntusu alip rapora ekliyor
    @AfterMethod(alwaysRun = true) //Her test methodundan sonra calisir
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) { // eger testin sonucu basarisizsa
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // eger test calistirilmadan gecilmezse
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignore olanlar
        }
        Driver.closeDriver();
    }
    // Raporlandirmayi sonlandirmak icin
    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        extentReports.flush();
    }
}

