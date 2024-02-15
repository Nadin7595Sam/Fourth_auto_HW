package third_home.task_1;

import com.codeborne.selenide.Configuration;

import static jdk.internal.misc.ThreadFlock.open;

public class FirstTask {
    public static void main(String[] args) {
        // Установка пути к драйверу браузера и другие настройки
        Configuration.browser = "chrome"; // Устанавливаем браузер
        Configuration.browserSize = "1920x1080"; // Максимизируем окно браузера

        // Открываем страницу в браузере
        open("http://google.com");
    }
}
