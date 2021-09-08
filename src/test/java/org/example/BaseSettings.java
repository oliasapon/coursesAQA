package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class BaseSettings {
    protected static WebDriver driver;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    public WebElement waitUntilVisible(By locator) {
        return new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitTextToBe(By locator, String value) {
        new WebDriverWait(driver, 40).until(ExpectedConditions.textToBe(locator, value));
    }

    public void assertEqualsByGetAttribute(WebElement element, String value) {
        assertEquals(element.getAttribute("value"), value);
    }

    public void moveToElem(By locator) {
        Actions action = new Actions(driver);
        WebElement position = driver.findElement(locator);
        action.moveToElement(position).build().perform();
    }

    public void selectByText(By locator, String value) {
        Select item = new Select(driver.findElement(locator));
        item.selectByVisibleText(value);
        assertEquals(value, item.getFirstSelectedOption().getText());
    }
}