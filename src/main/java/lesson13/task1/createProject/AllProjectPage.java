package lesson13.task1.createProject;

import lesson13.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProjectPage extends BasePage {

    @FindBy(className = "oro-subtitle")
    private WebElement subtitlePage;

    @FindBy(xpath = "//div[@class='message' and text()='Проект сохранен']")
    private WebElement messageProjectSaved;

    public AllProjectPage(WebDriver driver){
        super(driver);
    }

    public AllProjectPage checkSubtitlePage(String value){
        waitTextToBe(subtitlePage, value);
        return this;
    }

    public void checkMessageProjectSaved(){
        waitUntilVisible(messageProjectSaved);
    }
}
