package lesson15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement waitUntilVisible(WebElement element) {
        return new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitTextToBe(WebElement element, String value) {
        new WebDriverWait(driver, 40).until(ExpectedConditions.textToBePresentInElement(element, value));
    }

    public void assertEqualsByGetAttribute(WebElement element, String value) {
        assertEquals(element.getAttribute("value"), value);
    }

    public void assertEqualsByGetText(WebElement element, String value) {
        assertEquals(element.getText(), value);
    }

    public void moveToElem(WebElement element) {
        new Actions(driver).moveToElement(element).build().perform();
    }

}