package lesson13.task1.createProject;

import lesson13.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllMyProjectPage extends BasePage {
    @FindBy(className = "oro-subtitle")
    private WebElement subtitlePage;

    @FindBy(linkText = "Создать проект")
    private WebElement buttonCreateProject;

    public AllMyProjectPage(WebDriver driver) {
        super(driver);
    }

    public AllMyProjectPage checkSubtitlePage(String value) {
        waitTextToBe(subtitlePage, value);
        return this;
    }

    public CreateProjectPage clickButtonCreateProject() {
        waitUntilVisible(buttonCreateProject).click();
        return new CreateProjectPage(driver);
    }
}
