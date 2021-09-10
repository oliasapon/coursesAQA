package lesson13.task2;

import lesson13.BasePage;
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

    public ElectronicCatalogPage checkTitleElectronicCatalog() {
        waitUntilVisible(titleElectronicCatalogPage);
        return this;
    }

    public ElectronicCatalogPage clearBookName() {
        waitUntilVisible(inputBookName).clear();
        return this;
    }

    public ElectronicCatalogPage enterBookName(String bookName) {
        inputBookName.sendKeys(bookName);
        return this;
    }

    public ElectronicCatalogPage clickButtonSearch() {
        waitUntilVisible(buttonSearch).click();
        return this;
    }

    public void checkFoundValue(String value) {
        waitTextToBe(foundValue, value);
    }
}