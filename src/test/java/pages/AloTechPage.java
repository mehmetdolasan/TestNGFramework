package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AloTechPage {

    public AloTechPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "data-email")
    public WebElement emailEditT;

    @FindBy(id = "password")
    public WebElement passwordEditT;
    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@class='LoginLayout_LoginTemplate_Title__2jTDU MuiBox-root css-0']")
    public WebElement loginTitle;
}
