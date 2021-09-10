package lesson13.task1.createProject;

import lesson13.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class CreateProjectPage extends BasePage {
    @FindBy(className = "user-name")
    private WebElement subtitlePage;

    @FindBy(xpath = "//input[contains(@id,'crm_project_name')]")
    private WebElement inputProjectName;

    @FindBy(xpath = "//span[@class='select2-chosen']")
    private WebElement fieldOrganization;

    @FindBy(xpath = "(//div[@class='select2-search']/input)[2]")
    private WebElement inputOrganization;

    @FindBy(xpath = "//span[text()='1234']")
    private WebElement chooseOrganization;

    @FindBy(xpath = "//select[contains(@id,'crm_project_businessUnit')]")
    private WebElement selectSubdivision;

    @FindBy(xpath = "//select[contains(@id,'crm_project_curator')]")
    private WebElement selectProjectCurator;

    @FindBy(xpath = "//select[contains(@id,'crm_project_rp')]")
    private WebElement selectProjectManager;

    @FindBy(xpath = "//select[contains(@id,'crm_project_administrator')]")
    private WebElement selectProjectAdministrator;

    @FindBy(xpath = "//select[contains(@id,'crm_project_manager')]")
    private WebElement selectManager;

    @FindBy(css = ".btn-group:nth-child(4) > .btn")
    private WebElement buttonSaveAndClose;

    public CreateProjectPage(WebDriver driver){
        super(driver);
    }

    public CreateProjectPage checkLabelPage(String value){
        waitTextToBe(subtitlePage, value);
        return this;
    }

    public CreateProjectPage enterProjectName(String projectName){
        waitUntilVisible(inputProjectName).sendKeys(projectName);
        return this;
    }

    public CreateProjectPage checkEnteredProjectName(String projectName){
        assertEqualsByGetAttribute(inputProjectName, projectName);
        return this;
    }

    public CreateProjectPage clickFieldOrganization(){
        waitUntilVisible(fieldOrganization).click();
        return this;
    }

    public CreateProjectPage enterOrganization(String organization){
        waitUntilVisible(inputOrganization).sendKeys(organization);
        return this;
    }

    public CreateProjectPage checkEnteredOrganization(String organization){
        assertEqualsByGetAttribute(inputOrganization, organization);
        return this;
    }

    public CreateProjectPage clickChooseOrganization(){
        waitUntilVisible(chooseOrganization).click();
        return this;
    }

    public CreateProjectPage selectSubdivision(String subdivision){
        new Select(selectSubdivision).selectByVisibleText(subdivision);
        return this;
    }

    public CreateProjectPage checkSelectedSubdivision(String subdivision){
        assertEquals(subdivision, new Select(selectSubdivision).getFirstSelectedOption().getText());
        return this;
    }

    public CreateProjectPage selectProjectCurator(String projectCurator){
        new Select(selectProjectCurator).selectByVisibleText(projectCurator);
        return this;
    }

    public CreateProjectPage checkSelectedProjectCurator(String projectCurator){
        assertEquals(projectCurator, new Select(selectProjectCurator).getFirstSelectedOption().getText());
        return this;
    }

    public CreateProjectPage selectProjectManager(String projectManager){
        new Select(selectProjectManager).selectByVisibleText(projectManager);
        return this;
    }

    public CreateProjectPage checkSelectedProjectManager(String projectManager){
        assertEquals(projectManager, new Select(selectProjectManager).getFirstSelectedOption().getText());
        return this;
    }

    public CreateProjectPage selectProjectAdministrator(String projectAdministrator){
        new Select(selectProjectAdministrator).selectByVisibleText(projectAdministrator);
        return this;
    }

    public CreateProjectPage checkSelectedProjectAdministrator(String projectAdministrator){
        assertEquals(projectAdministrator, new Select(selectProjectAdministrator).getFirstSelectedOption().getText());
        return this;
    }

    public CreateProjectPage selectManager(String manager){
        new Select(selectManager).selectByVisibleText(manager);
        return this;
    }

    public CreateProjectPage checkSelectedManager(String manager){
        assertEquals(manager, new Select(selectManager).getFirstSelectedOption().getText());
        return this;
    }

    public AllProjectPage clickButtonSaveAndClose(){
        waitUntilVisible(buttonSaveAndClose).click();
        return new AllProjectPage(driver);
    }
}