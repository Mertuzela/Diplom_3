import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ForgotPassword {

    public final static String RECOVERY_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.XPATH,using = "//*[@href= '/login']")
    private SelenideElement loginLink;

    public LoginPage clickLoginLink() {
        loginLink.click();
        return page(LoginPage.class);
    }
}
