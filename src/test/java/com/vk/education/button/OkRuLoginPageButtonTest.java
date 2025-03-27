package com.vk.education.button;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class OkRuLoginPageButtonTest {

    @Test
    public void testLoginButtonVisibility() {
        open("https://ok.ru/");

        boolean isLoginButtonVisible = $("input[type='submit'][value='Войти в Одноклассники']").isDisplayed();

        assertTrue(isLoginButtonVisible, "Кнопка 'Войти' не видна");
    }
}
