package org.example.task3;

import lesson13.task2.SignInPage;
import org.example.task2.Settings2;
import org.junit.Test;

public class AutomatedChecksTest extends Settings2 {

    @Test
    public void RegistrationWithRegisteredData() {
        new SignInPage(driver)
                .clickLinkSignIn()
                .checkTitleSignIn("Вхід")
                .clickLinkRegistration()
                .checkTitleRegistrationPage("РЕЄСТРАЦІЯ")
                .moveToButtonRegistration()
                .enterLastName("Петренко")
                .enterFirstName("Яна")
                .clickFemaleGender()
                .selectBirthDay("4")
                .checkSelectedBirthDay("4")
                .selectBirthMonth("Березень")
                .checkSelectedBirthMonth("Березень")
                .selectBirthYear("1998")
                .checkSelectedBirthYear("1998")
                .enterMail("ya.petrenko@gmail.com")
                .enterPass("test1234")
                .enterRepeatPass("test1243")
                .clickButtonRegistration()
                .checkAlertText("Помилка! Перевірте правильність заповнення полів")
                .moveToButtonRegistration()
                .checkMailMessageError("Цей e-mail вже використовується. Вкажіть інший");

    }

    @Test
    public void LoginWithIncorrectPasswordTest() {
        new SignInPage(driver)
                .clickLinkSignIn()
                .checkTitleSignIn("Вхід")
                .enterMail("ya.petrenko@gmail.com")
                .enterPassword("test1243")
                .clickButtonSignIn()
                .checkMessageLoginPassError("Невірно вказана адреса пошти, логін або пароль");
    }
}