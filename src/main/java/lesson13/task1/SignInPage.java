package lesson13.task1;

import lesson13.BasePage;
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

    public SignInPage enterLogin(String login) {
        waitUntilVisible(inputLogin).sendKeys(login);
        return this;
    }

    public SignInPage enterPassword(String password) {
        waitUntilVisible(inputPassword).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        waitUntilVisible(buttonSignIn).click();
    }
}