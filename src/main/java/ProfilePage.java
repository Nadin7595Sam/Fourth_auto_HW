package third_home.task_1;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    public void open() {
        Selenide.open("https://test-stand.gb.ru/login");
    }

    public void editBirthDate(String newDate) {
        // Находим поле для ввода даты рождения и изменяем значение на новое
        Selenide.element(By.xpath("(//*[@class='mdc-text-field__input'])[3]"))
                .setValue(newDate.replaceAll("\\.", "-"));
    }

    public void saveChanges() {
        // Нажимаем кнопку "SAVE" после изменения даты рождения
        $(By.xpath("//*[@class='submit svelte-vyyzan']")).click();
    }

    public void closeDialog() {
        // Нажимаем кнопку "Закрыть" в диалоговом окне
        $(By.xpath("(//button[@class='material-icons mdc-icon-button mdc-icon-button--display-flex mdc-dialog__close mdc-ripple-upgraded--unbounded mdc-ripple-upgraded'])[1]")).click();
    }

    public void verifyBirthDate(String expectedDate) {
        // Проверяем, содержит ли элемент текст с ожидаемой датой
        $(By.xpath("(//*[@class='content svelte-vyyzan'])[2]")).shouldHave(text(expectedDate));
    }
}
