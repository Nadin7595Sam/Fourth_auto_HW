package third_home.task_1;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public abstract class AbstractTest {

    @BeforeEach
    void setUp() {
        Configuration.remote = "http://localhost:4444/wd/hub";

        Map<String, Object> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableLog", true);
        Configuration.browserCapabilities.setCapability("selenoid:options", options);

        Configuration.browserSize = "1920x1080";
        Selenide.open("https://test-stand.gb.ru/login");
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
