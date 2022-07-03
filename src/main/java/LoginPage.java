import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public final static String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH, using = "//input[@class= 'text input__textfield text_type_main-default'][@name= 'name']")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = "//input[@class= 'text input__textfield text_type_main-default'][@name= 'Пароль']")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement enterButton;

    //Кнопка Зарегистрироваться
    @FindBy(how = How.XPATH,using = "//*[@href= '/register']")
    private SelenideElement registrationLink;

    //Кнопка Восстановить пароль
    @FindBy(how = How.XPATH, using = "//*[@href= '/forgot-password']")
    private SelenideElement recoveryPasswordLink;

    @FindBy(how = How.CLASS_NAME,using = "Auth_login__3hAey")
    private SelenideElement loginForm;

    @Step("Открыта форма входа")
    public boolean checkLoginFormVisible() {
        return loginForm.isDisplayed();
    }

    @Step("Кнопка входа в аккаунт отображена")
    public boolean isEnterButtonVisible() {
        return enterButton.isDisplayed();
    }

    @Step("Ввести email")
    public LoginPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Кликнуть на кнопку \"Войти\"")
    public MainPage clickEnterToAccountButton() {
        enterButton.click();
        return page(MainPage.class);
    }

    @Step("Кликнуть на ссылку \"Зарегистрироваться\"")
    public RegisterPage clickRegistrationLink() {
        registrationLink.click();
        return page(RegisterPage.class);
    }

    @Step("Кликнуть на ссылку \"Восстановить пароль\"")
    public RecoveryPasswordPage clickOnRecoveryPasswordLink() {
        recoveryPasswordLink.click();
        return page(RecoveryPasswordPage.class);
    }
}