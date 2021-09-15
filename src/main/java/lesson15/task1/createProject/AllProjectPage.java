package lesson15.task1.createProject;

import io.qameta.allure.Step;
import lesson15.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProjectPage extends BasePage {

    @FindBy(className = "oro-subtitle")
    private WebElement subtitlePage;

    @FindBy(xpath = "//div[@class='message']")
    private WebElement messageProjectSaved;

    public AllProjectPage(WebDriver driver){
        super(driver);
    }

    @Step("Проверка подзаголовка страницы \"Все проекты\".")
    public AllProjectPage checkSubtitlePage(String value){
        waitTextToBe(subtitlePage, value);
        assertEqualsByGetText(subtitlePage, value);
        return this;
    }

    @Step("Проверка сообщения о создании проекта.")
    public void checkMessageProjectSaved(String message){
        waitUntilVisible(messageProjectSaved);
        assertEqualsByGetText(messageProjectSaved, message);
    }
}
