package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignUp {
    WebDriver driver;
    WebDriverWait wait;

    public SignUp(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "username")
    WebElement userName;
    @FindBy(name = "Passwd")
    WebElement pass;
    @FindBy(name = "ConfirmPasswd")
    WebElement confirmPass;
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    WebElement btnNext;
    @FindBy(xpath = "//span[contains(text(),'Use 8 characters or more for your password')]")
    WebElement firstError;
    @FindBy(xpath = "//span[contains(text(),'Please choose a stronger password. Try a mix of le')]")
    WebElement secondError;

    public void doSignUp1(String pass1) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        firstName.clear();
        firstName.sendKeys("Jon");
        lastName.clear();
        lastName.sendKeys("Doe");
        userName.clear();
        userName.sendKeys("djon84729");
        pass.clear();
        pass.sendKeys(pass1);
        confirmPass.clear();
        confirmPass.sendKeys(pass1);
        wait.until(ExpectedConditions.elementToBeClickable(btnNext)).click();
        String s = firstError.getText();
        Assert.assertTrue(s.contains("Use 8 characters or more for your password"));
    }

    public void doSignUp2(String pass2) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        firstName.clear();
        firstName.sendKeys("Jon");
        lastName.clear();
        lastName.sendKeys("Doe");
        userName.clear();
        userName.sendKeys("djon84729");
        pass.clear();
        pass.sendKeys(pass2);
        confirmPass.clear();
        confirmPass.sendKeys(pass2);
        wait.until(ExpectedConditions.elementToBeClickable(btnNext)).click();
        String s = secondError.getText();
        Assert.assertTrue(s.contains("Please choose a stronger password. Try a mix of letters, numbers, and symbols"));
    }

}
