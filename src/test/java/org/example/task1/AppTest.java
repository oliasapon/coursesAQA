package org.example.task1;

import org.example.Randoms;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AppTest extends Settings {

    public void signIn() {
        waitUntilVisible(By.id("prependedInput")).sendKeys("Applanatest1");
        waitUntilVisible(By.id("prependedInput2")).sendKeys("Student2020!");
        waitUntilVisible(By.id("_submit")).click();
        waitTextToBe(By.cssSelector("label"), "Панели инструментов:");
    }

    @Test
    public void createContactPerson() {
        signIn();
        waitUntilVisible(By.linkText("Контрагенты")).click();
        waitUntilVisible(By.linkText("Контактные лица")).click();
        waitTextToBe(By.className("oro-subtitle"), "Все Контактные лица");
        waitUntilVisible(By.linkText("Создать контактное лицо")).click();
        waitTextToBe(By.className("user-name"), "Создать контактное лицо");
        WebElement lastName = waitUntilVisible(By.xpath("//input[contains(@id,'crm_contact_lastName')]"));
        lastName.sendKeys("Иванова");
        assertEqualsByGetAttribute(lastName, "Иванова");
        WebElement firstName = waitUntilVisible(By.xpath("//input[contains(@id,'crm_contact_firstName')]"));
        firstName.sendKeys("Анна");
        assertEqualsByGetAttribute(firstName, "Анна");
        waitUntilVisible(By.xpath("//span[@class='select2-chosen']")).click();
        WebElement chooseOrganization = waitUntilVisible(By.xpath("//div[@class='select2-search']/input"));
        chooseOrganization.sendKeys("1234");
        assertEqualsByGetAttribute(chooseOrganization, "1234");
        waitUntilVisible(By.xpath("//span[text()='1234']")).click();
        WebElement position = waitUntilVisible(By.xpath("//input[contains(@id,'crm_contact_jobTitle')]"));
        position.sendKeys("Эколог");
        assertEqualsByGetAttribute(position, "Эколог");
        waitUntilVisible(By.cssSelector(".btn-group:nth-child(4) > .btn")).click();
        waitTextToBe(By.className("oro-subtitle"), "Все Контактные лица");
        waitUntilVisible(By.xpath("//div[@class='message' and text()='Контактное лицо сохранено']"));
    }

    @Test
    public void projectCreation() {
        String projectNameString = Randoms.randomString(20);
        signIn();
        waitUntilVisible(By.linkText("Проекты")).click();
        waitUntilVisible(By.linkText("Мои проекты")).click();
        waitTextToBe(By.className("oro-subtitle"), "Все Мои проекты");
        waitUntilVisible(By.linkText("Создать проект")).click();
        waitTextToBe(By.className("user-name"), "Создать проект");
        WebElement projectName = waitUntilVisible(By.xpath("//input[contains(@id,'crm_project_name')]"));
        projectName.sendKeys(projectNameString);
        assertEqualsByGetAttribute(projectName, projectNameString);
        waitUntilVisible(By.xpath("//span[@class='select2-chosen']")).click();
        WebElement organization = waitUntilVisible(By.xpath("(//div[@class='select2-search']/input)[2]"));
        organization.sendKeys("1234");
        assertEqualsByGetAttribute(organization, "1234");
        waitUntilVisible(By.xpath("//span[text()='1234']"));
        waitUntilVisible(By.xpath("//span[text()='1234']")).click();
        selectByText(By.xpath("//select[contains(@id,'crm_project_businessUnit')]"), "Research & Development");
        selectByText(By.xpath("//select[contains(@id,'crm_project_curator')]"), "Коблев Евгений");
        selectByText(By.xpath("//select[contains(@id,'crm_project_rp')]"), "Андреев Сергей");
        selectByText(By.xpath("//select[contains(@id,'crm_project_administrator')]"), "Исаева Анастасия");
        selectByText(By.xpath("//select[contains(@id,'crm_project_manager')]"), "Антонов Дмитрий");
        waitUntilVisible(By.cssSelector(".btn-group:nth-child(4) > .btn")).click();
        waitTextToBe(By.className("oro-subtitle"), "Все Проекты");
        waitUntilVisible(By.xpath("//div[@class='message' and text()='Проект сохранен']"));
    }
}