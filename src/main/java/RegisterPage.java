import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {
    public final static String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH,using = "(//input[@class= 'text input__textfield text_type_main-default'])[1]")
    private SelenideElement placeInputName;

    @FindBy(how = How.XPATH,using = "(//input[@class= 'text input__textfield text_type_main-default'])[2]")
    private SelenideElement placeInputEmail;

    @FindBy(how = How.XPATH,using = "//input[@class = 'text input__textfield text_type_main-default'][@name='Пароль']")
    private SelenideElement placeInputPassword;

    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement finishRegistrationButton;

    @FindBy(how = How.XPATH, using = "//*[@href= '/login']")
    private SelenideElement loginLink;

    @FindBy(how = How.XPATH,using = "//*[@class='input__error text_type_main-default']")
    private SelenideElement errorMessage;

    @Step("Ввести имя")
    public RegisterPage setUserName(String name) {
        placeInputName.setValue(name);
        return this;
    }

    @Step("Ввести email")
    public RegisterPage setUserEmail(String email) {
        placeInputEmail.setValue(email);
        return this;
    }

    @Step("Ввести пароль")
    public RegisterPage setUserPassword(String password) {
        placeInputPassword.setValue(password);
        return this;
    }

    @Step("Клик на кнопку \"Зарегистрироваться\"")
    public LoginPage clickFinishRegistrationButton() {
        finishRegistrationButton.click();
        return page(LoginPage.class);
    }

    @Step("Клик на ссылку \"Войти\"")
    public LoginPage clickLoginLink() {
        loginLink.click();
        return page(LoginPage.class);
    }

    @Step("Проверка отображения ошибки пароля")
    public boolean checkErrorMessageIsDisplayed(){
        return errorMessage.isDisplayed();
    }
}