package lesson13.task2;

import lesson13.BasePage;
import lesson13.task3.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(linkText = "Увійти")
    private WebElement linkSignIn;

    @FindBy(css = "#dialog-content > .content > .a-center")
    private WebElement titleSignIn;

    @FindBy(xpath = "//input[@id='mail_input']")
    private WebElement inputMail;

    @FindBy(id = "pass_input")
    private WebElement inputPassword;

    @FindBy(id = "submit-form-login")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//div[@id='login-footer']//a")
    private WebElement linkRegistration;

    @FindBy(id = "login-error")
    private WebElement messageLoginPassError;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage clickLinkSignIn() {
        waitUntilVisible(linkSignIn).click();
        return this;
    }

    public SignInPage checkTitleSignIn(String title) {
        waitTextToBe(titleSignIn, title);
        return this;
    }

    public SignInPage enterMail(String mail) {
        waitUntilVisible(inputMail).sendKeys(mail);
        return this;
    }

    public SignInPage enterPassword(String password) {
        waitUntilVisible(inputPassword).sendKeys(password);
        return this;
    }

    public SignInPage clickButtonSignIn() {
        waitUntilVisible(buttonSignIn).click();
        return this;
    }

    public RegistrationPage clickLinkRegistration() {
        waitUntilVisible(linkRegistration).click();
        return new RegistrationPage(driver);
    }

    public void checkMessageLoginPassError(String text) {
        waitTextToBe(messageLoginPassError, text);
    }
}