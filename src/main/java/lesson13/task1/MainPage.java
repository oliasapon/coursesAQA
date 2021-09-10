package lesson13.task1;

import lesson13.BasePage;
import lesson13.task1.createContactPerson.AllContactPersonsPage;
import lesson13.task1.createProject.AllMyProjectPage;
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

    public MainPage checkLabelPage(String label) {
        waitTextToBe(labelToolbar, label);
        return this;
    }

    public MainPage clickContractors() {
        waitUntilVisible(contractors).click();
        return this;
    }

    public AllContactPersonsPage clickContactPersons() {
        waitUntilVisible(contactFaces).click();
        return new AllContactPersonsPage(driver);
    }

    public MainPage clickProject() {
        waitUntilVisible(project).click();
        return this;
    }

    public AllMyProjectPage clickMyProject() {
        waitUntilVisible(myProject).click();
        return new AllMyProjectPage(driver);
    }
}
