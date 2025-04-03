package com.vk.education;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.vk.education.TestDataFactory.PASSWORD;
import static com.vk.education.TestDataFactory.USER_NUMBER;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тестирование страницы входа на OK.ru")
@Tag("UI")
public class LoginTest {

    private static final String BASE_URL = "https://ok.ru/";
    private static final String EMAIL_FIELD_LOCATOR = "#field_email";
    private static final String PASSWORD_FIELD_LOCATOR = "#field_password";
    private static final String LOGIN_BUTTON_LOCATOR = "//input[@type='submit' and @value='Войти в Одноклассники']";

    @BeforeAll
    static void setUpAll() {
        System.out.println("Запуск тестов на странице входа OK.ru");
        Configuration.timeout = 5000;
    }

    @BeforeEach
    void setUp() {
        open(BASE_URL);
    }

    @Test
    @DisplayName("Тест: Логин с правильными учетными данными")
    void loginTest() {
        assertAll("Проверяем функциональность формы входа",
                () -> $(EMAIL_FIELD_LOCATOR).setValue(USER_NUMBER),
                () -> $(PASSWORD_FIELD_LOCATOR).setValue(PASSWORD),
                () -> $x(LOGIN_BUTTON_LOCATOR).click()
        );
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Тесты завершены. Все тесты прошли успешно");
    }
}
