package org.example.task3;

import org.example.task2.Settings;
import org.junit.Test;
import org.openqa.selenium.By;

public class AutomatedChecksTest extends Settings {

    @Test
    public void RegistrationWithRegisteredData() {
        waitUntilVisible(By.linkText("Увійти")).click();
        waitUntilVisible(By.cssSelector("#dialog-content > .content > .a-center"));
        waitTextToBe(By.cssSelector("#dialog-content > .content > .a-center"), "Вхід");
        waitUntilVisible(By.xpath("//div[@id='login-footer']//a")).click();
        waitTextToBe(By.xpath("//div[@class='page-title']//h1"), "РЕЄСТРАЦІЯ");
        moveToElem(By.xpath("//div[@class='a-center row-form w-100']//button"));
        waitUntilVisible(By.name("form[f_name]")).sendKeys("Петренко");
        waitUntilVisible(By.name("form[i_name]")).sendKeys("Яна");
        waitUntilVisible(By.id("sex_0")).click();
        selectByText(By.name("form[birth][day]"), "4");
        selectByText(By.name("form[birth][month]"), "Березень");
        selectByText(By.name("form[birth][year]"), "1998");
        waitUntilVisible(By.name("form[mail]")).sendKeys("ya.petrenko@gmail.com");
        waitUntilVisible(By.name("form[pass]")).sendKeys("test1234");
        waitUntilVisible(By.name("form[pass1]")).sendKeys("test1234");
        waitUntilVisible(By.xpath("//div[@class='a-center row-form w-100']//button")).click();
        waitTextToBe(By.className("alertText"), "Помилка! Перевірте правильність заповнення полів");
        moveToElem(By.xpath("//div[@class='a-center row-form w-100']//button"));
        waitTextToBe(By.xpath("//div[@class='row-form w-100']//div[@class='form-note small a-left err']"), "Цей e-mail вже використовується. Вкажіть інший");
    }

    @Test
    public void LoginWithIncorrectPasswordTest() {
        waitUntilVisible(By.linkText("Увійти")).click();
        waitUntilVisible(By.cssSelector("#dialog-content > .content > .a-center"));
        waitTextToBe(By.cssSelector("#dialog-content > .content > .a-center"), "Вхід");
        waitUntilVisible(By.xpath("//input[@id='mail_input']")).sendKeys("ya.petrenko@gmail.com");
        waitUntilVisible(By.id("pass_input")).sendKeys("test1243");
        waitUntilVisible(By.id("submit-form-login")).click();
        waitTextToBe(By.id("login-error"), "Невірно вказана адреса пошти, логін або пароль");
    }
}
