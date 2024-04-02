package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='inputtext _55r1 _6luy']")
    public WebElement emailEditT;
    @FindBy(xpath = "//*[@class='inputtext _55r1 _6luy _9npi']")
    public WebElement passwordEditT;
    @FindBy(xpath = "//*[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@class='_9ay7']")
    public WebElement wrongEmailOrPasswordText;
    @FindBy(xpath = "//*[@class='UIPage_LoggedOut _-kb _605a b_c3pyn-ahh chrome webkit win x1 Locale_tr_TR cores-gte4 _19_u']")
    public WebElement wrongPasswordText;
    @FindBy(xpath = "//*[@class='fbIndex UIPage_LoggedOut _-kb _605a b_c3pyn-ahh chrome webkit win x1 Locale_tr_TR cores-gte4 _19_u']")
    public WebElement isThisYourAccountTitle;
}
