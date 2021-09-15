package lesson15.task1.createContactPerson;

import io.qameta.allure.Step;
import lesson15.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllContactPersonsPage extends BasePage {

    @FindBy(className = "oro-subtitle")
    private WebElement subtitlePage;

    @FindBy(linkText = "Создать контактное лицо")
    private WebElement buttonCreateContactPerson;

    @FindBy(xpath = "//div[@class='message']")
    private WebElement messageContactPersonSaved;

    public AllContactPersonsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка подзаголовка страницы \"Все контактные лица\".")
    public AllContactPersonsPage checkSubtitlePage(String value) {
        waitTextToBe(subtitlePage, value);
        assertEqualsByGetText(subtitlePage, value);
        return this;
    }

    @Step("Нажатие на кнопку \"Создать контактное лицо\".")
    public CreateContactPersonPage clickButtonCreateContactPerson() {
        waitUntilVisible(buttonCreateContactPerson).click();
        return new CreateContactPersonPage(driver);
    }

    @Step("Проверка сообщения о создании контактного лица.")
    public void checkMessageContactPersonSaved(String message) {
        waitUntilVisible(messageContactPersonSaved);
        assertEqualsByGetText(messageContactPersonSaved,  message);
    }
}