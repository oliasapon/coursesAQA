package lesson15.task1.createProject;

import io.qameta.allure.Step;
import lesson15.BasePage;
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

    @Step("Проверка подзаголовка страницы \"Все проекты\".")
    public AllMyProjectPage checkSubtitlePage(String value) {
        waitTextToBe(subtitlePage, value);
        return this;
    }

    @Step("Нажатие на кнопку \"Создать проект\".")
    public CreateProjectPage clickButtonCreateProject() {
        waitUntilVisible(buttonCreateProject).click();
        return new CreateProjectPage(driver);
    }
}
