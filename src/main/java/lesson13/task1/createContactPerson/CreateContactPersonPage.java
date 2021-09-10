package lesson13.task1.createContactPerson;

import lesson13.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateContactPersonPage extends BasePage {
    @FindBy(className = "user-name")
    private WebElement subtitlePage;

    @FindBy(xpath = "//input[contains(@id,'crm_contact_lastName')]")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[contains(@id,'crm_contact_firstName')]")
    private WebElement inputFirstName;

    @FindBy(xpath = "//span[@class='select2-chosen']")
    private WebElement fieldOrganization;

    @FindBy(xpath = "//div[@class='select2-search']/input")
    private WebElement inputOrganization;

    @FindBy(xpath = "//span[text()='1234']")
    private WebElement chooseOrganization;

    @FindBy(xpath = "//input[contains(@id,'crm_contact_jobTitle')]")
    private WebElement inputPosition;

    @FindBy(css = ".btn-group:nth-child(4) > .btn")
    private WebElement buttonSaveAndClose;

    public CreateContactPersonPage(WebDriver driver) {
        super(driver);
    }

    public CreateContactPersonPage checkLabelPage(String value) {
        waitTextToBe(subtitlePage, value);
        return this;
    }

    public CreateContactPersonPage enterLastName(String lastName) {
        waitUntilVisible(inputLastName).sendKeys(lastName);
        return this;
    }

    public CreateContactPersonPage checkEnteredLastName(String lastName) {
        assertEqualsByGetAttribute(inputLastName, lastName);
        return this;
    }

    public CreateContactPersonPage enterFirstName(String firstName) {
        waitUntilVisible(inputFirstName).sendKeys(firstName);
        return this;
    }

    public CreateContactPersonPage checkEnteredFirstName(String firstName) {
        assertEqualsByGetAttribute(inputFirstName, firstName);
        return this;
    }

    public CreateContactPersonPage clickFieldOrganization() {
        waitUntilVisible(fieldOrganization).click();
        return this;
    }

    public CreateContactPersonPage enterOrganization(String organization) {
        waitUntilVisible(inputOrganization).sendKeys(organization);
        return this;
    }

    public CreateContactPersonPage checkEnteredOrganization(String organization) {
        assertEqualsByGetAttribute(inputOrganization, organization);
        return this;
    }

    public CreateContactPersonPage clickChooseOrganization() {
        waitUntilVisible(chooseOrganization).click();
        return this;
    }

    public CreateContactPersonPage enterPosition(String position) {
        waitUntilVisible(inputPosition).sendKeys(position);
        return this;
    }

    public CreateContactPersonPage checkEnteredPosition(String position) {
        assertEqualsByGetAttribute(inputPosition, position);
        return this;
    }

    public AllContactPersonsPage clickButtonSaveAndClose() {
        waitUntilVisible(buttonSaveAndClose).click();
        return new AllContactPersonsPage(driver);
    }
}