package third_home.task_1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;
import static com.codeborne.selenide.Condition.text;

public class ProfilePageTest extends AbstractTest {

    private final ProfilePage profilePage = new ProfilePage();

    @Test
    void test() throws InterruptedException {
        Thread.sleep(5000L);
    }

    @Test
    void authorization() throws InterruptedException, IOException {
        profilePage.open(); // Открываем страницу

        // Вводим логин и пароль
        $(By.xpath("//*[@type='text']")).setValue("annucka4");
        $(By.xpath("//*[@type='password']")).setValue("6ec1fae7f2");

        // Нажимаем кнопку LOGIN
        $(By.className("mdc-button__label")).click();

        // Ожидаем появления страницы с текстом "Blog"
        $(By.xpath("//h1[text()='Blog']")).shouldBe(visible);

        // Нажимаем на 'Hello, annucka4' для выбора одной из 3-х опций
        $(By.xpath("//li[@class='svelte-1rc85o5 mdc-menu-surface--anchor']")).click();

        // Нажимаем на 'Profile', чтобы перейти на страницу профиля
        $(By.xpath("//li[text()='Profile']")).click();

        // Ожидаем появления страницы с текстом "Profile Page"
        $(By.xpath("//h1[text()='Profile Page']")).shouldBe(visible);

        // Нажимаем на кнопку 'edit', чтобы перейти в модальное окно для редактирования профиля
        $(By.xpath("//button[text()='edit']")).click();

        // Получаем текущую дату в формате DD.MM.YYYY
        String newDate = "03.12.1995";

        // Изменяем дату рождения
        profilePage.editBirthDate(newDate);

        // Нажимаем кнопку "SAVE"
        profilePage.saveChanges();

        // Нажимаем кнопку "Закрыть"
        profilePage.closeDialog();

        // Проверяем, содержит ли элемент текст "03.12.1995"
        profilePage.verifyBirthDate(newDate);
    }
}
