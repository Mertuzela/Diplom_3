import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class TestPersonalCabinet extends APIRequest {

    boolean isMainPageDisplayed;

    @Before
    public void setUp() {
        // Запуск тестов в браузере Firefox
        // Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        createUser();
    }

    @After
    public void deleteData() {
        deleteUser();
    }

    @Test
    @DisplayName("Sign In using personal cabinet button")
    @Description("Вход в личный кабинет через кнопку \"Личный кабинет\"")
    public void goToAccountUsingPersonalCabinetButton() {
      boolean isExitButtonDisplayed = Selenide.open(MainPage.URL,MainPage.class)
                .clickPersonalCabinetButton()
                .setEmail(email())
                .setPassword(password())
                .clickEnterToAccountButton()
                .goToPersonalCabinet()
               .isExitButtonVisible();
       assertTrue(isExitButtonDisplayed);
    }

    @Test
    @DisplayName("go to constructor page from personal cabinet")
    @Description("Переход из личного кабинета на страницу конструктор, через кнопку \"Конструктор\"")
    public void goToMainPageFromPersonalCabinet() {
        Selenide.open(MainPage.URL,MainPage.class)
                .clickEnterAccountButton()
                .setEmail(email())
                .setPassword(password())
                .clickEnterToAccountButton()
                .goToPersonalCabinet();
         isMainPageDisplayed = page(MainPage.class)
                .clickConstructorButton()
                .isCreateOrderButtonDisplayed();
        assertTrue(isMainPageDisplayed);
    }

    @Test
    @DisplayName("Check logo button click from personal cabinet")
    @Description("Переход из личного кабинета на страницу конструктор, через логотип компании")
    public void checkLogoButtonClickFromPersonalCabinet() {
        Selenide.open(MainPage.URL,MainPage.class)
                .clickPersonalCabinetButton()
                .setEmail(email())
                .setPassword(password())
                .clickEnterToAccountButton()
                .goToPersonalCabinet();
         isMainPageDisplayed = page(MainPage.class)
                .clickCentralLogo()
                .isCreateOrderButtonDisplayed();
        assertTrue(isMainPageDisplayed);
    }

    @Test
    @DisplayName("Exit from account")
    @Description("Выход из аккаунта")
    public void exitFromAccount() {
        boolean isLoginPageDisplayed = Selenide.open(MainPage.URL,MainPage.class)
                .clickPersonalCabinetButton()
                .setEmail(email())
                .setPassword(password())
                .clickEnterToAccountButton()
                .goToPersonalCabinet()
                .clickExitButton()
                .isEnterButtonVisible();
        assertTrue(isLoginPageDisplayed);
    }
}