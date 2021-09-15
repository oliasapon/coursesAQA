package lesson15.task1;

import lesson15.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CRMTest extends CRMBaseSettings {

    public void signIn() {
        new SignInPage(driver)
                .enterLogin("Applanatest1")
                .enterPassword("Student2020!")
                .clickLoginButton();
    }

    @DisplayName("Создание нового контактного лица.")
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
                .checkMessageContactPersonSaved("Контактное лицо сохранено");

    }

    @DisplayName("Создание нового проекта.")
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
                .checkMessageProjectSaved("Проект сохранен");
    }
}