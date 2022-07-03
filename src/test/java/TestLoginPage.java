import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TestLoginPage extends APIRequest{

    private boolean isOrderButtonDisplayed;

    @Before
    public void setUp() {
        // Запуск тестов в браузере Firefox
        // Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        createUser();
    }

    @After
    public void deleteData(){
        deleteUser();
    }

    @Test
    @DisplayName("Login with personal cabinet button")
    @Description("Авторизация через кнопку \"Личный кабинет\"")
    public void loginWithPersonalCabinetButton() {
        isOrderButtonDisplayed = Selenide.open(MainPage.URL,MainPage.class)
                .clickPersonalCabinetButton()
                .setEmail(email())
                .setPassword(password())
                .clickEnterToAccountButton()
              .isCreateOrderButtonDisplayed();
      assertTrue(isOrderButtonDisplayed);
    }

    @Test
    @DisplayName("Login with enter account button")
    @Description("Авторизация через кнопку \"Войти в аккаунт\"")
    public void loginWithEnterAccountButton() {
         isOrderButtonDisplayed = Selenide.open(MainPage.URL,MainPage.class)
                .clickEnterAccountButton()
                .setEmail(email())
                .setPassword(password())
                .clickEnterToAccountButton()
        .isCreateOrderButtonDisplayed();
        assertTrue(isOrderButtonDisplayed);
    }

    @Test
    @DisplayName("Login on registration page")
    @Description("Авторизация на странице регистрации")
    public void loginOnRegistrationPage() {
         isOrderButtonDisplayed = Selenide.open(MainPage.URL,MainPage.class)
                .clickPersonalCabinetButton()
                .clickRegistrationLink()
                .clickLoginLink()
                .setEmail(email())
                .setPassword(password())
                .clickEnterToAccountButton()
                .isCreateOrderButtonDisplayed();
        assertTrue(isOrderButtonDisplayed);
    }

    @Test
    @DisplayName("Login on recovery password page")
    @Description("Авторизация на странице восстановления пароля")
    public void loginOnRecoveryPasswordPage() {
        isOrderButtonDisplayed =  Selenide.open(MainPage.URL,MainPage.class)
                .clickEnterAccountButton()
                .clickOnRecoveryPasswordLink()
                .clickLoginLink()
                .setEmail(email())
                .setPassword(password())
                .clickEnterToAccountButton()
                .isCreateOrderButtonDisplayed();
        assertTrue(isOrderButtonDisplayed);
    }
}