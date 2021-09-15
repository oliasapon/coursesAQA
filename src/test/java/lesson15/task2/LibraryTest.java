package lesson15.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LibraryTest extends LibraryBaseSettings {

    public void signIn() {
        new SignInPage(driver)
                .clickLinkSignIn()
                .checkTitleSignIn("Вхід")
                .enterMail("ya.petrenko@gmail.com")
                .checkEnteredMail("ya.petrenko@gmail.com")
                .enterPassword("test1234")
                .checkEnteredPassword("test1234")
                .clickButtonSignIn();
    }

    @DisplayName("Успешная авторизация в кабинете электронной библиотеки.")
    @Test
    public void successfulAuthorizationTest() {
        signIn();
        new MainPage(driver)
                .checkTitlePage("КАБІНЕТ ЧИТАЧА");
    }

    @DisplayName("Успешный поиск заданного значения в электронном каталоге библиотеки.")
    @Test
    public void successfulBookSearchTest() {
        signIn();
        new MainPage(driver)
                .checkLinkElectronicCatalog()
                .clickLinkLibraryResources()
                .clickLinkElectronicCatalog()
                .checkTitleElectronicCatalog()
                .clearBookName()
                .enterBookName("Кобзар")
                .checkEnteredBookName("Кобзар")
                .clickButtonSearch()
                .checkFoundValue("Кобзар");
    }
}