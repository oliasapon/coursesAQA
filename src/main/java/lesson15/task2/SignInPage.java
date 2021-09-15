package lesson15.task2;

import io.qameta.allure.Step;
import lesson15.BasePage;
import lesson15.task1.createContactPerson.CreateContactPersonPage;
import lesson15.task3.RegistrationPage;
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

    @Step("Нажатие на ссылку \"Увійти\" главного меню.")
    public SignInPage clickLinkSignIn() {
        waitUntilVisible(linkSignIn).click();
        return this;
    }

    @Step("Проверка заглавия страницы \"Увійти\".")
    public SignInPage checkTitleSignIn(String title) {
        waitTextToBe(titleSignIn, title);
        return this;
    }

    @Step("Введение электронной почты.")
    public SignInPage enterMail(String mail) {
        waitUntilVisible(inputMail).sendKeys(mail);
        return this;
    }

    @Step("Проверка введенного e-mail.")
    public SignInPage checkEnteredMail(String mail) {
        assertEqualsByGetAttribute(inputMail, mail);
        return this;
    }

    @Step("Введение пароля.")
    public SignInPage enterPassword(String password) {
        waitUntilVisible(inputPassword).sendKeys(password);
        return this;
    }

    @Step("Проверка введенного пароля.")
    public SignInPage checkEnteredPassword(String password) {
        assertEqualsByGetAttribute(inputPassword, password);
        return this;
    }

    @Step("Нажатие на кнопку \"Увійти\".")
    public SignInPage clickButtonSignIn() {
        waitUntilVisible(buttonSignIn).click();
        return this;
    }

    @Step("Нажатие на кнопку \"Реєстрація\".")
    public RegistrationPage clickLinkRegistration() {
        waitUntilVisible(linkRegistration).click();
        return new RegistrationPage(driver);
    }

    @Step("Проверка сообщения о неправильном вводе мейла/пароля.")
    public void checkMessageLoginPassError(String text) {
        waitUntilVisible(messageLoginPassError);
        assertEqualsByGetText(messageLoginPassError, text);
    }
}