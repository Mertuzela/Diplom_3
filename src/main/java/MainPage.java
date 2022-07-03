import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public final static String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.LINK_TEXT,using = "Конструктор")
    private SelenideElement constructorButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement centralLogo;

    @FindBy(how = How.XPATH, using = "//*[@href= '/account']")
    private SelenideElement personalCabinetButton;

    @FindBy(how = How.XPATH,using = "//button[@class= 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement enterAccountButton;

    @FindBy(how = How.XPATH,using = "//button[@class= 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg'][text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    @FindBy(how = How.XPATH,using = "//span[@class='text text_type_main-default'][text()='Булки']")
    private SelenideElement bunMenu;

    @FindBy(how = How.XPATH,using = "//span[@class='text text_type_main-default'][text()='Соусы']")
    private SelenideElement sauceMenu;

    @FindBy(how = How.XPATH,using = "//span[@class='text text_type_main-default'][text()='Начинки']")
    private SelenideElement fillingMenu;

    @FindBy(how = How.XPATH,using = "//p[@class= 'BurgerIngredient_ingredient__text__yp3dH'][text()= 'Мясо бессмертных моллюсков Protostomia']")
    private SelenideElement descriptionFillingMenu;

    @FindBy(how = How.XPATH,using = "//h2[@class= 'text text_type_main-medium mb-6 mt-10'][text()= 'Соусы']")
    private SelenideElement descriptionSauceMenu;

    @FindBy(how = How.XPATH,using = "//h2[@class= 'text text_type_main-medium mb-6 mt-10'][text()= 'Булки']")
    private SelenideElement descriptionBunMenu;

    @Step("Проверка отображения кнопки \"Оформить заказ\"")
    public boolean isCreateOrderButtonDisplayed() {
        return createOrderButton.shouldBe(Condition.visible).isDisplayed();
    }

    @Step("Проверка отображения раздела Соусы")
    public boolean isDescriptionSauceMenuVisible() {
        return descriptionSauceMenu.isDisplayed();
    }

    @Step("Проверка отображения раздела Булки")
    public boolean isDescriptionBunMenuVisible() {
        return descriptionBunMenu.isDisplayed();
    }

    @Step("Проверка отображения раздела Начинки")
    public boolean isDescriptionFillingMenuVisible() {
        return descriptionFillingMenu.isDisplayed();
    }

    @Step("Клик на раздел Булки")
    public MainPage clickBunMenu() {
        bunMenu.click();
        return this;
    }

    @Step("Клик на раздел Начинки")
    public MainPage clickFillingMenu() {
        fillingMenu.click();
        return this;
    }

    @Step("Клик на раздел Соусы")
    public MainPage clickSauceMenu(){
        sauceMenu.click();
        return this;
    }

    @Step("Клик на кнопку Конструктор")
    public MainPage clickConstructorButton(){
        constructorButton.click();
        return this;
    }

    @Step("Клик на логотип Stellar Burgers")
    public MainPage clickCentralLogo() {
        centralLogo.click();
        return this;
    }

    @Step("Клик на кнопку \"Личный кабинет\"")
    public LoginPage clickPersonalCabinetButton() {
        personalCabinetButton.click();
        return page(LoginPage.class);
    }

    @Step("Переход в Личный кабинет")
    public PersonalCabinetPage goToPersonalCabinet() {
        personalCabinetButton.click();
        return page(PersonalCabinetPage.class);
    }

    @Step("Клик на кнопку Войти в аккаунт")
    public LoginPage clickEnterAccountButton() {
        enterAccountButton.click();
        return page(LoginPage.class);
    }
}