package lesson13.task1.createContactPerson;

import lesson13.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllContactPersonsPage extends BasePage {

    @FindBy(className = "oro-subtitle")
    private WebElement subtitlePage;

    @FindBy(linkText = "Создать контактное лицо")
    private WebElement buttonCreateContactPerson;

    @FindBy(xpath = "//div[@class='message' and text()='Контактное лицо сохранено']")
    private WebElement messageContactPersonSaved;

    public AllContactPersonsPage(WebDriver driver) {
        super(driver);
    }

    public AllContactPersonsPage checkSubtitlePage(String value) {
        waitTextToBe(subtitlePage, value);
        return this;
    }

    public CreateContactPersonPage clickButtonCreateContactPerson() {
        waitUntilVisible(buttonCreateContactPerson).click();
        return new CreateContactPersonPage(driver);
    }

    public void checkMessageContactPersonSaved() {
        waitUntilVisible(messageContactPersonSaved);
    }
}