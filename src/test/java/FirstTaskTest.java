package third_home.task_1;

import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FirstTaskTest extends AbstractTest {

    @Test
    void test() throws InterruptedException {
        Thread.sleep(5000L);
    }

    @Test
    void authorization() throws InterruptedException, IOException {
        // Вводим логин и пароль
        $(By.xpath("//*[@type='text']")).setValue("GB202212c8b3e9");
        $(By.xpath("//*[@type='password']")).setValue("b3b37b4d9c");

        // Нажимаем кнопку LOGIN
        $(By.className("mdc-button__label")).click();

        // Ожидаем появления страницы с текстом "Student Page"
        $(By.xpath("//h1[text()='Student Page']")).shouldBe(visible);

        // Нажимаем кнопку '+' для добавления имени
        $(By.xpath("//*[@class='material-icons mdc-icon-button mdc-icon-button--display-flex mdc-ripple-upgraded--unbounded mdc-ripple-upgraded']")).click();

        // Дожидаемся появления модального окна с текстом "Creating Dummy" в заголовке
        $(By.xpath("//span[@slot='title' and text()='Creating Dummy']")).shouldBe(visible);

        // Генерируем уникальное имя на основе текущего времени
        String dummyName = "Колян" + System.currentTimeMillis();

        // Вводим имя
        $(By.xpath("(//input[@class='mdc-text-field__input' and @type='text' and @placeholder=' '])[1]")).setValue(dummyName);

        // Генерируем случайный логин
        String randomLogin = "user_" + RandomStringUtils.randomAlphanumeric(8); // Генерируем логин из 8 случайных символов

        // Вводим логин
        $(By.xpath("(//input[@class='mdc-text-field__input' and @type='text' and @placeholder=' '])[3]")).setValue(randomLogin);

        // Нажимаем кнопку "SAVE" после ввода имени и логина
        $(By.xpath("//span[@class='mdc-button__label' and text()='Save']")).click();

        // Дожидаемся появления искомого элемента после сохранения Dummy в таблице
        $(By.xpath("//td[@class='mdc-data-table__cell' and text()='" + dummyName + "']")).shouldBe(visible);

        // Проверяем, что Dummy с указанным именем появился в таблице
        $(By.xpath("//td[@class='mdc-data-table__cell' and text()='" + dummyName + "']")).shouldBe(visible);

        // Теперь создаем скриншот окна браузера
        File screenshot = new File(screenshot("screenshot"));

        // Путь для сохранения скриншота в ресурсы
        String resourcesPath = "src/test/resources/";

        // Копируем скриншот в ресурсы
        screenshot.renameTo(new File(resourcesPath + "screenshot.png"));
    }
}
