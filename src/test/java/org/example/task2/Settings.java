package org.example.task2;

import org.example.BaseSettings;
import org.junit.Before;

public class Settings extends BaseSettings {
    @Before
    public void openPage() {
        driver.get("https://lib.kherson.ua");
    }
}