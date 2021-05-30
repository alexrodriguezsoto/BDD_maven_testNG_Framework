package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.*;
import utilities.Driver;

import static utilities.SeleniumUtilities.*;

public class _1_loginPage {

    public _1_loginPage(){
        PageFactory.initElements(Driver.getInstance(), this);
    }

//    private WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 15);

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement logInButton;

    @FindBy(xpath = "//a[contains(text(),'Forgot password')]")
    private WebElement forgotpassword;

    public void pressButton(String button_name) throws InterruptedException {
        switch(button_name){
            case "LOG IN":
                clickButton(logInButton, button_name);
                break;
            case "forgot password":
                clickButton(forgotpassword, button_name);
                break;
            default:
                CucumberLogUtils.logFail("button not present in page", true);
        }
    }

    public void loginPage(String type_of_account) throws InterruptedException {
        if(type_of_account.equals("user")){
            enterValueFromPropertyFile(email, "user_email");
        }else{
            enterValueFromPropertyFile(email, "email");
        }
        enterValueFromPropertyFile(password, "password");
        pressButton("LOG IN");
    }
}
