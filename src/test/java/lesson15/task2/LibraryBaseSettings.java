package lesson15.task2;

import lesson15.BaseSettings;
import org.junit.jupiter.api.BeforeEach;

public class LibraryBaseSettings extends BaseSettings {

    @BeforeEach
    public void openPage() {
        driver.get("https://lib.kherson.ua");
    }
}