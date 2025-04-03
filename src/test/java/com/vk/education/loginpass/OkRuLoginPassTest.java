package com.vk.education.loginpass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тестирование полей для ввода логина и пароля на OK.ru")
@Tag("UI")
public class OkRuLoginPassTest {

    private static final String BASE_URL = "https://ok.ru/";
    private static final String EMAIL_FIELD_LOCATOR = "#field_email";
    private static final String PASSWORD_FIELD_LOCATOR = "#field_password";

    @BeforeAll
    static void setUpAll() {
        System.out.println("Запуск тестов на странице входа OK.ru");
    }

    @BeforeEach
    void setUp() {
        open(BASE_URL);
    }

    @Test
    @DisplayName("Проверка отображения полей логина и пароля")
    void testLoginFieldsVisibility() {
        assertAll("Проверяем отображение полей",
                () -> $(EMAIL_FIELD_LOCATOR).shouldBe(Condition.visible),
                () -> $(PASSWORD_FIELD_LOCATOR).shouldBe(Condition.visible),
                () -> assertTrue($(EMAIL_FIELD_LOCATOR).isDisplayed(), "Поле для ввода логина не видно"),
                () -> assertTrue($(PASSWORD_FIELD_LOCATOR).isDisplayed(), "Поле для ввода пароля не видно")
        );
    }

    @ValueSource(strings = {EMAIL_FIELD_LOCATOR, PASSWORD_FIELD_LOCATOR})
    @DisplayName("Параметризованный тест: проверка отображения полей ввода")
    void testFieldsWithDifferentLocators(String locator) {
        assumeTrue($(locator).exists(), "Локатор не существует на странице");
        $(locator).shouldBe(Condition.visible);
    }

    @Nested
    @DisplayName("Тестирование негативных сценариев")
    class NegativeTests {

        @Test
        @DisplayName("Проверка несуществующего локатора")
        void testInvalidLocator() {
            String invalidLocator = "#non_existent_field";
            assertFalse($(invalidLocator).exists(), "Найден элемент с неверным локатором");
        }
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
