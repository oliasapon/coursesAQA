package lesson15.task3;

import io.qameta.allure.Step;
import lesson15.BasePage;
import lesson15.task2.ElectronicCatalogPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Step("Проверка названия страницы \"Реєстрація\".")
    public RegistrationPage checkTitleRegistrationPage(String title) {
        waitTextToBe(titleRegistrationPage, title);
        return this;
    }

    @Step("Переход к кнопке \"Зареєструватися\".")
    public RegistrationPage moveToButtonRegistration() {
        moveToElem(buttonRegistration);
        return this;
    }

    @Step("Ввод фамилии.")
    public RegistrationPage enterLastName(String lastName) {
        waitUntilVisible(inputLastName).sendKeys(lastName);
        return this;
    }

    @Step("Проверка введенного значения фамилии.")
    public RegistrationPage checkEnteredLastName(String lastName) {
        assertEqualsByGetAttribute(inputLastName, lastName);
        return this;
    }

    @Step("Ввод имени.")
    public RegistrationPage enterFirstName(String firstName) {
        waitUntilVisible(inputFirstName).sendKeys(firstName);
        return this;
    }

    @Step("Проверка введенного значения имени.")
    public RegistrationPage checkEnteredFirstName(String firstName) {
        assertEqualsByGetAttribute(inputFirstName, firstName);
        return this;
    }

    @Step("Выбор женского пола.")
    public RegistrationPage clickFemaleGender() {
        waitUntilVisible(femaleGender).click();
        return this;
    }

    @Step("Выбор дня рождения.")
    public RegistrationPage selectBirthDay(String birthDay) {
        new Select(selectBirthDay).selectByVisibleText(birthDay);
        return this;
    }

    @Step("Проверка выбранного дня рождения.")
    public RegistrationPage checkSelectedBirthDay(String birthDay) {
        assertEquals(birthDay, new Select(selectBirthDay).getFirstSelectedOption().getText());
        return this;
    }

    @Step("Выбор месяца рождения.")
    public RegistrationPage selectBirthMonth(String birthMonth) {
        new Select(selectBirthMonth).selectByVisibleText(birthMonth);
        return this;
    }

    @Step("Проверка выбранного месяца рождения.")
    public RegistrationPage checkSelectedBirthMonth(String birthMonth) {
        assertEquals(birthMonth, new Select(selectBirthMonth).getFirstSelectedOption().getText());
        return this;
    }

    @Step("Выбор года рождения.")
    public RegistrationPage selectBirthYear(String birthYear) {
        new Select(selectBirthYear).selectByVisibleText(birthYear);
        return this;
    }

    @Step("Проверка выбранного года рождения.")
    public RegistrationPage checkSelectedBirthYear(String birthYear) {
        assertEquals(birthYear, new Select(selectBirthYear).getFirstSelectedOption().getText());
        return this;
    }

    @Step("Ввод мейла.")
    public RegistrationPage enterMail(String mail) {
        waitUntilVisible(inputMail).sendKeys(mail);
        return this;
    }

    @Step("Проверка введенного значения email.")
    public RegistrationPage checkEnteredMail(String mail) {
        assertEqualsByGetAttribute(inputMail, mail);
        return this;
    }

    @Step("Ввод пароля.")
    public RegistrationPage enterPass(String pass) {
        waitUntilVisible(inputPass).sendKeys(pass);
        return this;
    }

    @Step("Проверка введенного значения пароля.")
    public RegistrationPage checkEnteredPass(String pass) {
        assertEqualsByGetAttribute(inputPass, pass);
        return this;
    }

    @Step("Повторный ввод пароля.")
    public RegistrationPage enterRepeatPass(String repeatPass) {
        waitUntilVisible(inputRepeatPass).sendKeys(repeatPass);
        return this;
    }

    @Step("Проверка повторного введенного значения пароля.")
    public RegistrationPage checkEnteredRepeatPass(String repeatPass) {
        assertEqualsByGetAttribute(inputRepeatPass, repeatPass);
        return this;
    }

    @Step("Нажатие на кнопку \"Реєстрація\".")
    public RegistrationPage clickButtonRegistration() {
        waitUntilVisible(buttonRegistration).click();
        return this;
    }

    @Step("Проверка сообщения об ошибки (о правильности введенных данных).")
    public RegistrationPage checkAlertText(String text) {
        assertEqualsByGetText(alertText, text);
        return this;
    }

    @Step("Проверка сообщения об ошибки (об уже использование заданного мейла).")
    public void checkMailMessageError(String text) {
        assertEqualsByGetText(mailMessageError, text);
    }
}