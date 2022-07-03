import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class PersonalCabinetPage {

    private final static String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(how = How.XPATH, using = "//button[@class= 'Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    private SelenideElement exitButton;

    @Step("Клик на кнопку Выход в личном кабинете")
    public LoginPage clickExitButton() {
        exitButton.click();
        return page(LoginPage.class);
    }

    @Step("Проверка отображения кнопки Выход")
    public boolean isExitButtonVisible() {
        return exitButton.shouldBe(Condition.visible).isDisplayed();
    }
}
