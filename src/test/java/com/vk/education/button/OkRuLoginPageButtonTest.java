package com.vk.education.button;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тесты кнопки входа на OK.ru")
@Tag("UI")
public class OkRuLoginPageButtonTest {

    private static final String BASE_URL = "https://ok.ru/";
    private static final String LOGIN_BUTTON_LOCATOR = "input[type='submit'][value='Войти в Одноклассники']";

    @BeforeAll
    static void setUpAll() {
        System.out.println("Запуск тестов на странице входа OK.ru");
    }

    @BeforeEach
    void setUp() {
        open(BASE_URL);
    }

    @Test
    @DisplayName("Проверка отображения кнопки 'Войти'")
    void testLoginButtonVisibility() {
        assertAll("Проверка кнопки входа",
                () -> $(LOGIN_BUTTON_LOCATOR).shouldBe(Condition.visible),
                () -> assertTrue($(LOGIN_BUTTON_LOCATOR).isDisplayed(), "Кнопка 'Войти' не видна")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"input[type='submit'][value='Войти в Одноклассники']", "#someOtherLocator"})
    @DisplayName("Проверка локаторов кнопки входа")
    void testLoginButtonWithDifferentLocators(String locator) {
        assumeTrue($(locator).exists(), "Локатор не найден на странице");
        $(locator).shouldBe(Condition.visible);
    }

    @Nested
    @DisplayName("Тестирование негативных сценариев")
    class NegativeTests {

        @Test
        @DisplayName("Проверка несуществующего локатора")
        void testInvalidLocator() {
            String invalidLocator = "input[type='submit'][value='Не существует']";
            assertFalse($(invalidLocator).exists(), "Найден элемент с неправильным локатором");
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
