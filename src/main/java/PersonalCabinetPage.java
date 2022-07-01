import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class PersonalCabinet {

    private final static String PC_URL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH, using = "//button[@type='button'][@text='Выход']")
    private SelenideElement exitButton;

    public LoginPage clickExitButton() {
        exitButton.shouldBe(Condition.visible,Condition.exactText("Выход")).click();
        return page(LoginPage.class);
    }
}
