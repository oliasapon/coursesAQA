package lesson15.task2;

import io.qameta.allure.Step;
import lesson15.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicCatalogPage extends BasePage {

    @FindBy(xpath = "//h1[text()='Електронний каталог']")
    private WebElement titleElectronicCatalogPage;

    @FindBy(name = "form[search_0][0]")
    private WebElement inputBookName;

    @FindBy(css = ".a-right > .button")
    private WebElement buttonSearch;

    @FindBy(css = ".book-panel:nth-child(6) .red")
    private WebElement foundValue;

    public ElectronicCatalogPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка видимости подзаголовка страницы \"Электронный каталог\".")
    public ElectronicCatalogPage checkTitleElectronicCatalog() {
        waitUntilVisible(titleElectronicCatalogPage);
        return this;
    }

    @Step("Очищение поле для поиска по каталогу.")
    public ElectronicCatalogPage clearBookName() {
        waitUntilVisible(inputBookName).clear();
        return this;
    }

    @Step("Ввод значение для поиска по каталогу.")
    public ElectronicCatalogPage enterBookName(String bookName) {
        inputBookName.sendKeys(bookName);
        return this;
    }

    @Step("Проверка введенного значения для поиска по каталогу.")
    public ElectronicCatalogPage checkEnteredBookName(String password) {
        assertEqualsByGetAttribute(inputBookName, password);
        return this;
    }

    @Step("Нажатие на кнопку \"Шукати\".")
    public ElectronicCatalogPage clickButtonSearch() {
        waitUntilVisible(buttonSearch).click();
        return this;
    }

    @Step("Проверка найденного значения.")
    public void checkFoundValue(String value) {
        assertEqualsByGetText(foundValue, value);
    }
}