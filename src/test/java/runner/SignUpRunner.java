package runner;

import environment.Setup;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.SignUp;
import utilities.Utils;

import java.io.IOException;


public class SignUpRunner extends Setup {
    Utils utils;

    @Test
    public void runSignUp() throws InterruptedException, IOException, ParseException {
        for (int i = 0; i <= 3; i++) {
            driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
            utils = new Utils(driver);
            SignUp signUp = new SignUp(driver);
            String password = utils.readFromJSON(i, "password");
            signUp.doSignUp(password);
        }
    }
}
