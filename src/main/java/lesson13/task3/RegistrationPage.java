package lesson13.task3;

import lesson13.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//div[@class='page-title']//h1")
    private WebElement titleRegistrationPage;

    @FindBy(xpath = "//div[@class='a-center row-form w-100']//button")
    private WebElement buttonRegistration;

    @FindBy(name = "form[f_name]")
    private WebElement inputLastName;

    @FindBy(name = "form[i_name]")
    private WebElement inputFirstName;

    @FindBy(id = "sex_0")
    private WebElement femaleGender;

    @FindBy(name = "form[birth][day]")
    private WebElement selectBirthDay;

    @FindBy(name = "form[birth][month]")
    private WebElement selectBirthMonth;

    @FindBy(name = "form[birth][year]")
    private WebElement selectBirthYear;

    @FindBy(name = "form[mail]")
    private WebElement inputMail;

    @FindBy(name = "form[pass]")
    private WebElement inputPass;

    @FindBy(name = "form[pass1]")
    private WebElement inputRepeatPass;

    @FindBy(className = "alertText")
    private WebElement alertText;

    @FindBy(xpath = "//div[@class='row-form w-100']//div[@class='form-note small a-left err']")
    private WebElement mailMessageError;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage checkTitleRegistrationPage(String title) {
        waitTextToBe(titleRegistrationPage, title);
        return this;
    }

    public RegistrationPage moveToButtonRegistration() {
        moveToElem(buttonRegistration);
        return this;
    }

    public RegistrationPage enterLastName(String lastName) {
        waitUntilVisible(inputLastName).sendKeys(lastName);
        return this;
    }

    public RegistrationPage enterFirstName(String firstName) {
        waitUntilVisible(inputFirstName).sendKeys(firstName);
        return this;
    }

    public RegistrationPage clickFemaleGender() {
        waitUntilVisible(femaleGender).click();
        return this;
    }

    public RegistrationPage selectBirthDay(String birthDay) {
        new Select(selectBirthDay).selectByVisibleText(birthDay);
        return this;
    }

    public RegistrationPage checkSelectedBirthDay(String birthDay) {
        assertEquals(birthDay, new Select(selectBirthDay).getFirstSelectedOption().getText());
        return this;
    }

    public RegistrationPage selectBirthMonth(String birthMonth) {
        new Select(selectBirthMonth).selectByVisibleText(birthMonth);
        return this;
    }

    public RegistrationPage checkSelectedBirthMonth(String birthMonth) {
        assertEquals(birthMonth, new Select(selectBirthMonth).getFirstSelectedOption().getText());
        return this;
    }

    public RegistrationPage selectBirthYear(String birthYear) {
        new Select(selectBirthYear).selectByVisibleText(birthYear);
        return this;
    }

    public RegistrationPage checkSelectedBirthYear(String birthYear) {
        assertEquals(birthYear, new Select(selectBirthYear).getFirstSelectedOption().getText());
        return this;
    }

    public RegistrationPage enterMail(String mail) {
        waitUntilVisible(inputMail).sendKeys(mail);
        return this;
    }

    public RegistrationPage enterPass(String pass) {
        waitUntilVisible(inputPass).sendKeys(pass);
        return this;
    }

    public RegistrationPage enterRepeatPass(String repeatPass) {
        waitUntilVisible(inputRepeatPass).sendKeys(repeatPass);
        return this;
    }

    public RegistrationPage clickButtonRegistration() {
        waitUntilVisible(buttonRegistration).click();
        return this;
    }

    public RegistrationPage checkAlertText(String text) {
        waitTextToBe(alertText, text);
        return this;
    }

    public void checkMailMessageError(String text) {
        waitTextToBe(mailMessageError, text);
    }
}