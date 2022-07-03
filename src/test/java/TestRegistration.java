import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class TestRegistration extends APIRequest {

    @Before
    public void setUp() {
        // Запуск тестов в браузере Firefox
        // Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Registration User")
    @Description("Полный путь регистрации клиента с главной страницы")
    public void registrationUser() {
       boolean isLoginFormDisplayed = Selenide.open(MainPage.URL,MainPage.class)
               .clickPersonalCabinetButton()
               .clickRegistrationLink()
                .setUserName(name())
                .setUserEmail(email())
                .setUserPassword(password())
                .clickFinishRegistrationButton()
                .checkLoginFormVisible();
        assertTrue(isLoginFormDisplayed);
        loginUser();
        deleteUser();
    }

    @Test
    @DisplayName("Check password error in registration page")
    @Description("Проверка отображения ошибки пароля при регистрации")
    public void checkPasswordErrorInRegistration() {
        Selenide.open(RegisterPage.REGISTER_URL,RegisterPage.class)
                .setUserName(name())
                .setUserEmail(email())
                .setUserPassword(incorrectPassword())
                .clickFinishRegistrationButton();
        RegisterPage registerPage = page(RegisterPage.class);
        assertTrue(registerPage.checkErrorMessageIsDisplayed());
    }
}