package org.example.task1;

import org.example.BaseSettings;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class Settings extends BaseSettings {

    @Before
    public void openPage() {
        driver.get("https://crm.geekbrains.space/user/login");
    }

    public void selectByText(By locator, String value) {
        Select item = new Select(driver.findElement(locator));
        item.selectByVisibleText(value);
        assertEquals(value, item.getFirstSelectedOption().getText());
    }
}