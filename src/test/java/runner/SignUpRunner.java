package runner;

import environment.Setup;
import org.testng.annotations.Test;
import pages.SignUp;

public class SignUpRunner extends Setup {

    @Test
    public void runSignUp() throws InterruptedException {
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
        SignUp signUp = new SignUp(driver);
        signUp.doSignUp1("abc");
        signUp.doSignUp1("123");
        signUp.doSignUp2("abcdefgh");
        signUp.doSignUp2("password");
    }
}
