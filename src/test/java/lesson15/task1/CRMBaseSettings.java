package lesson15.task1;

import lesson15.BaseSettings;
import org.junit.jupiter.api.BeforeEach;


public class CRMBaseSettings extends BaseSettings {
    @BeforeEach
    public void openPage() {
        driver.get("https://crm.geekbrains.space/user/login");
    }
}