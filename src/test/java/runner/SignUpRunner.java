package runner;

import environment.Setup;
import org.testng.annotations.Test;
import pages.SignUp;

public class SignUpRunner extends Setup {

    @Test
    public void runSignUp() throws InterruptedException {
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
        SignUp signUp = new SignUp(driver);
        signUp.doSignUp("abc");
        signUp.doSignUp("123");
        signUp.doSignUp("abcdefgh");
        signUp.doSignUp("password");
    }
}
