package lesson15.task1;

import io.qameta.allure.Step;
import lesson15.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id = "prependedInput")
    private WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    private WebElement inputPassword;

    @FindBy(id = "_submit")
    private WebElement buttonSignIn;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод логина пользователя.")
    public SignInPage enterLogin(String login) {
        waitUntilVisible(inputLogin).sendKeys(login);
        return this;
    }

    @Step("Ввод пароля пользователя.")
    public SignInPage enterPassword(String password) {
        waitUntilVisible(inputPassword).sendKeys(password);
        return this;
    }

    @Step("Нажатие на кнопку \"Войти\".")
    public void clickLoginButton() {
        waitUntilVisible(buttonSignIn).click();
    }
}