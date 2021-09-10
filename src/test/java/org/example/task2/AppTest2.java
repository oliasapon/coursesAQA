package org.example.task2;

import lesson13.task2.MainPage;
import lesson13.task2.SignInPage;
import org.junit.Test;

public class AppTest2 extends Settings2 {

    public void signIn() {
        new SignInPage(driver)
                .clickLinkSignIn()
                .checkTitleSignIn("Вхід")
                .enterMail("ya.petrenko@gmail.com")
                .enterPassword("test1234")
                .clickButtonSignIn();
    }

    @Test
    public void successfulAuthorizationTest() {
        signIn();
        new MainPage(driver)
                .checkTitlePage();
    }

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
                .clickButtonSearch()
                .checkFoundValue("Кобзар");
    }
}