package lesson13.task2;

import lesson13.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//h1[text()='Кабінет читача']")
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

    public void checkTitlePage() {
        waitUntilVisible(titleMainPage);
    }

    public MainPage checkLinkElectronicCatalog() {
        waitUntilVisible(titleElectronicCatalog);
        return this;
    }

    public MainPage clickLinkLibraryResources() {
        waitUntilVisible(linkLibraryResources).click();
        return this;
    }

    public ElectronicCatalogPage clickLinkElectronicCatalog() {
        waitUntilVisible(linkElectronicCatalog).click();
        return new ElectronicCatalogPage(driver);
    }
}