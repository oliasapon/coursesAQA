package org.example.task2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AppTest extends Settings {

    public void signIn() {
        waitUntilVisible(By.linkText("Увійти")).click();
        waitUntilVisible(By.cssSelector("#dialog-content > .content > .a-center"));
        waitTextToBe(By.cssSelector("#dialog-content > .content > .a-center"), "Вхід");
        waitUntilVisible(By.xpath("//input[@id='mail_input']")).sendKeys("olia.sapon@gmail.com");
        waitUntilVisible(By.id("pass_input")).sendKeys("lesson9_task2");
        waitUntilVisible(By.id("submit-form-login")).click();
    }

    @Test
    public void successfulAuthorization() {
        signIn();
        waitUntilVisible(By.xpath("//h1[text()='Кабінет читача']"));
    }

    @Test
    public void successfulBookSearch() {
        signIn();
        waitUntilVisible(By.xpath("//div[@class='page oh']//div[@class='col-panel-content sub-menu']//a[text()='Електронний каталог']"));
        waitUntilVisible(By.xpath("(//a[contains(text(),'Ресурси бібліотеки')])[2]")).click();
        waitUntilVisible(By.xpath("(//li/a[text()='Електронний каталог'])[3]")).click();
        waitUntilVisible(By.xpath("//h1[text()='Електронний каталог']"));
        WebElement inputBookName = waitUntilVisible(By.name("form[search_0][0]"));
        inputBookName.clear();
        inputBookName.sendKeys("Кобзар");
        waitUntilVisible(By.cssSelector(".a-right > .button")).click();
        waitTextToBe(By.cssSelector(".book-panel:nth-child(6) .red"), "Кобзар");
    }
}