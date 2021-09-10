package org.example.task1;

import lesson13.task1.MainPage;
import lesson13.task1.SignInPage;
import org.example.Randoms;
import org.junit.Test;

public class AppTest1 extends Settings1 {

    public void signIn() {
        new SignInPage(driver)
                .enterLogin("Applanatest1")
                .enterPassword("Student2020!")
                .clickLoginButton();
    }

    @Test
    public void createContactPersonTest() {
        signIn();
        new MainPage(driver)
                .checkLabelPage("Панели инструментов:")
                .clickContractors()
                .clickContactPersons()
                .checkSubtitlePage("Все Контактные лица")
                .clickButtonCreateContactPerson()
                .checkLabelPage("Создать контактное лицо")
                .enterLastName("Иванова")
                .checkEnteredLastName("Иванова")
                .enterFirstName("Анна")
                .checkEnteredFirstName("Анна")
                .clickFieldOrganization()
                .enterOrganization("1234")
                .checkEnteredOrganization("1234")
                .clickChooseOrganization()
                .enterPosition("Эколог")
                .checkEnteredPosition("Эколог")
                .clickButtonSaveAndClose()
                .checkSubtitlePage("Все Контактные лица")
                .checkMessageContactPersonSaved();
    }

    @Test
    public void creationProjectTest() {
        String projectNameString = Randoms.randomString(20);
        signIn();
        new MainPage(driver)
                .checkLabelPage("Панели инструментов:")
                .clickProject()
                .clickMyProject()
                .checkSubtitlePage("Все Мои проекты")
                .clickButtonCreateProject()
                .checkLabelPage("Создать проект")
                .enterProjectName(projectNameString)
                .checkEnteredProjectName(projectNameString)
                .clickFieldOrganization()
                .enterOrganization("1234")
                .checkEnteredOrganization("1234")
                .clickChooseOrganization()
                .selectSubdivision("Research & Development")
                .checkSelectedSubdivision("Research & Development")
                .selectProjectCurator("Коблев Евгений")
                .checkSelectedProjectCurator("Коблев Евгений")
                .selectProjectManager("Андреев Сергей")
                .checkSelectedProjectManager("Андреев Сергей")
                .selectProjectAdministrator("Исаева Анастасия")
                .checkSelectedProjectAdministrator("Исаева Анастасия")
                .selectManager("Антонов Дмитрий")
                .checkSelectedManager("Антонов Дмитрий")
                .clickButtonSaveAndClose()
                .checkSubtitlePage("Все Проекты")
                .checkMessageProjectSaved();
    }
}