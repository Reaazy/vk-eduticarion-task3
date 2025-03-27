package com.vk.education.loginpass;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class VisabilityLoginPassTest {

    @Test
    public void testLoginFieldsVisibility() {
        open("https://ok.ru/");

        // Проверяем, что поле для ввода логина и пароля видны
        boolean isEmailFieldVisible = $("#field_email").isDisplayed();
        boolean isPasswordFieldVisible = $("#field_password").isDisplayed();

        assertTrue(isEmailFieldVisible, "Поле для ввода логина не видно");
        assertTrue(isPasswordFieldVisible, "Поле для ввода пароля не видно");
    }
}
