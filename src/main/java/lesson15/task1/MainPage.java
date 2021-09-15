package lesson15.task1;

import io.qameta.allure.Step;
import lesson15.BasePage;
import lesson15.task1.createContactPerson.AllContactPersonsPage;
import lesson15.task1.createProject.AllMyProjectPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(css = "label")
    private WebElement labelToolbar;

    @FindBy(linkText = "Контрагенты")
    private WebElement contractors;

    @FindBy(linkText = "Контактные лица")
    private WebElement contactFaces;

    @FindBy(linkText = "Проекты")
    private WebElement project;

    @FindBy(linkText = "Мои проекты")
    private WebElement myProject;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка подзаголовка страницы.")
    public MainPage checkLabelPage(String label) {
        assertEqualsByGetText(labelToolbar, label);
        return this;
    }

    @Step("Нажатие на пункт \"Контрагенты\" на панели инструментов.")
    public MainPage clickContractors() {
        waitUntilVisible(contractors).click();
        return this;
    }

    @Step("Нажатие на пункт \"Контактные лица\" с выпадающего меню.")
    public AllContactPersonsPage clickContactPersons() {
        waitUntilVisible(contactFaces).click();
        return new AllContactPersonsPage(driver);
    }

    @Step("Нажатие на пункт \"Проекты\" на панели инструментов.")
    public MainPage clickProject() {
        waitUntilVisible(project).click();
        return this;
    }

    @Step("Нажатие на пункт \"Мои проекты\" с выпадающего меню.")
    public AllMyProjectPage clickMyProject() {
        waitUntilVisible(myProject).click();
        return new AllMyProjectPage(driver);
    }
}
