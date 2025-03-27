package com.vk.education;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.vk.education.TestDataFactory.PASSWORD;
import static com.vk.education.TestDataFactory.USER_NUMBER;

public class LoginTest {
    @Test
    public void LoginTest() throws InterruptedException {
        open("https://ok.ru/");

        Thread.sleep(2000);

        $("#field_email").setValue(USER_NUMBER);
        $("#field_password").setValue(PASSWORD);

        Thread.sleep(2000);

        $x("//input[@type='submit' and @value='Войти в Одноклассники']").click();

        HomePage homePage = new HomePage();
    }
}
