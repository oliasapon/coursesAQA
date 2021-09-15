package lesson15.task3;

import lesson15.task2.SignInPage;
import lesson15.task2.LibraryBaseSettings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AutomatedChecksTest extends LibraryBaseSettings {

    @DisplayName("Регистрация с данными уже зарегистрированного пользователя.")
    @Test
    public void RegistrationWithRegisteredData() {
        new SignInPage(driver)
                .clickLinkSignIn()
                .checkTitleSignIn("Вхід")
                .clickLinkRegistration()
                .checkTitleRegistrationPage("РЕЄСТРАЦІЯ")
                .moveToButtonRegistration()
                .enterLastName("Петренко")
                .checkEnteredLastName("Петренко")
                .enterFirstName("Яна")
                .checkEnteredFirstName("Яна")
                .clickFemaleGender()
                .selectBirthDay("4")
                .checkSelectedBirthDay("4")
                .selectBirthMonth("Березень")
                .checkSelectedBirthMonth("Березень")
                .selectBirthYear("1998")
                .checkSelectedBirthYear("1998")
                .enterMail("ya.petrenko@gmail.com")
                .checkEnteredMail("ya.petrenko@gmail.com")
                .enterPass("test1234")
                .checkEnteredPass("test1234")
                .enterRepeatPass("test1243")
                .checkEnteredRepeatPass("test1243")
                .clickButtonRegistration()
                .checkAlertText("Помилка! Перевірте правильність заповнення полів")
                .moveToButtonRegistration()
                .checkMailMessageError("Цей e-mail вже використовується. Вкажіть інший");

    }

    @DisplayName("Ввод неверного пароля при авторизации.")
    @Test
    public void LoginWithIncorrectPasswordTest() {
        new SignInPage(driver)
                .clickLinkSignIn()
                .checkTitleSignIn("Вхід")
                .enterMail("ya.petrenko@gmail.com")
                .checkEnteredMail("ya.petrenko@gmail.com")
                .enterPassword("test1243")
                .checkEnteredPassword("test1243")
                .clickButtonSignIn()
                .checkMessageLoginPassError("Невірно вказана адреса пошти, логін або пароль");
    }
}