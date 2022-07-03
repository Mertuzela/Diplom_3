import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class RecoveryPasswordPage {

    public final static String RECOVERY_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.XPATH,using = "//*[@href= '/login']")
    private SelenideElement loginLink;

    @Step("Клик на ссылку \"Войти\"")
    public LoginPage clickLoginLink() {
        loginLink.click();
        return page(LoginPage.class);
    }
}
