package org.example.task1;

import org.example.BaseSettings;
import org.junit.Before;

public class Settings1 extends BaseSettings {
    @Before
    public void openPage() {
        driver.get("https://crm.geekbrains.space/user/login");
    }
}