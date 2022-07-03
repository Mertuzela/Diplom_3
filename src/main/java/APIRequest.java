import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import static io.restassured.RestAssured.given;

public class APIRequest {
    
    private String API_URL = "https://stellarburgers.nomoreparties.site/api";

    private final String name = RandomStringUtils.randomAlphabetic(7);
    private final String email = RandomStringUtils.randomAlphanumeric(7)+"@ya.ru";
    private final String password = RandomStringUtils.randomAlphanumeric(7);
    private final String incorrectPassword = RandomStringUtils.randomAlphanumeric(2);
    private String token;

    private final String request_body = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}";
    private final String create_user_body = "{\"email\":\""+email+"\",\"password\":\""+password+"\",\"name\":\""+name+"\"}";

    protected final RequestSpecification reqSpec = given()
            .header("Content-type","application/json")
            .baseUri(API_URL);

    @Step("Получить созданное имя")
    public String name(){
        return name;
    }

    @Step("Получить созданный email")
    public String email(){
        return email;
    }

    @Step("Получить созданный пароль")
    public String password(){
        return password;
    }

    @Step("Получить некорректный пароль")
    public String incorrectPassword(){
        return incorrectPassword;
    }

    @Step("Создание клиента через API")
    public void createUser() {
       token = reqSpec
                .body(create_user_body)
                .when()
                .post("/auth/register")
                .then().log().all()
                .extract()
                .path("accessToken");
    }

    @Step("Авторизация клиента")
    public void loginUser(){
        token =  reqSpec
                .body(request_body)
                .when()
                .post("/auth/login")
                .then().log().all()
                .extract()
                .path("accessToken");
    }

    @Step("Удаление клиент")
    public void deleteUser() {
        reqSpec
                .auth().oauth2(token.substring(7))
                .when()
                .delete("/auth/user")
                .then().log().all();
    }
}