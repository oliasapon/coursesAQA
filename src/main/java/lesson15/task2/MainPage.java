package lesson15.task2;

import io.qameta.allure.Step;
import lesson15.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    //@FindBy(xpath = "//h1[text()='Кабінет читача']")
    @FindBy(xpath = "//div[@class='page-title']//h1")
    private WebElement titleMainPage;

    @FindBy(xpath = "//div[@class='page oh']//div[@class='col-panel-content sub-menu']//a[text()='Електронний каталог']")
    private WebElement titleElectronicCatalog;

    @FindBy(xpath = "(//a[contains(text(),'Ресурси бібліотеки')])[2]")
    private WebElement linkLibraryResources;

    @FindBy(xpath = "(//li/a[text()='Електронний каталог'])[3]")
    private WebElement linkElectronicCatalog;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка подзаголовка главной страницы.")
    public void checkTitlePage(String value) {
        waitUntilVisible(titleMainPage);
        assertEqualsByGetText(titleMainPage, value);
    }

    @Step("Проверка видимости ссылки \"Электронный каталог\".")
    public MainPage checkLinkElectronicCatalog() {
        waitUntilVisible(titleElectronicCatalog);
        return this;
    }

    @Step("Нажатие на пункт \"Ресурсы библиотеки\" главного меню.")
    public MainPage clickLinkLibraryResources() {
        waitUntilVisible(linkLibraryResources).click();
        return this;
    }

    @Step("Нажатие на пункт \"Электронный каталог\" с выпадающего меню.")
    public ElectronicCatalogPage clickLinkElectronicCatalog() {
        waitUntilVisible(linkElectronicCatalog).click();
        return new ElectronicCatalogPage(driver);
    }
}