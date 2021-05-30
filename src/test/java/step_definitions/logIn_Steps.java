package step_definitions;

import cucumber.api.java.en.Given;
import utilities.Base;

public class logIn_Steps extends Base {

    @Given("user logs into {string} account")
    public void user_logs_into_account(String type_of_account) throws InterruptedException {
        login.loginPage(type_of_account);
    }
}
