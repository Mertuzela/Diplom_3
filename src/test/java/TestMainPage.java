import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestMainPage{

    @Before
    public void openFullScreen() {
        // Запуск тестов в браузере Firefox
        // Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Check filling menu")
    @Description("Проверка отображения раздела \"Начинки\"")
    public void checkFillingMenu() {
       boolean isFillingMenuOpen = Selenide.open(MainPage.URL,MainPage.class)
                .clickFillingMenu()
                .isDescriptionFillingMenuVisible();
       assertTrue(isFillingMenuOpen);
    }

    @Test
    @DisplayName("Check bun menu")
    @Description("Проверка отображения раздела \"Булки\"")
    public void checkBunMenu() {
        boolean isBunMenuOpen = Selenide.open(MainPage.URL,MainPage.class)
                .isDescriptionBunMenuVisible();
        assertTrue(isBunMenuOpen);
    }

    @Test
    @DisplayName("Check sauce menu")
    @Description("Проверка отображения раздела \"Соусы\"")
    public void checkSauceMenu() {
        boolean isSauceMenuOpen = Selenide.open(MainPage.URL,MainPage.class)
                .clickSauceMenu()
                .isDescriptionSauceMenuVisible();
        assertTrue(isSauceMenuOpen);
    }
}