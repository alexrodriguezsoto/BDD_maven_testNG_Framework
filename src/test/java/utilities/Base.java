package utilities;

import org.openqa.selenium.support.PageFactory;
import pages.*;

public class Base {

    protected static _1_loginPage login;

    public static Base instantiatePages(){
        login = PageFactory.initElements(Driver.getInstance(), _1_loginPage.class);
        return new Base();
    }
}
