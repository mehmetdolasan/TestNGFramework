package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BrcPage {

    public BrcPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//*[@class='btn btn-primary btn-sm']")
    public WebElement loginButonInHomePage;
    @FindBy(id = "formBasicEmail")
    public WebElement emailEditT;

    @FindBy(id = "formBasicPassword")
    public WebElement passwordEditT;
    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement loginButonInForm;
}
