package api;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.qameta.allure.model.Parameter.Mode.HIDDEN;

public class UserClient extends Base {
    public static final String API_REG = "/register";
    public static final String API_DATA = "/user";

    /**
     * Запрос на создание пользователя
     * @param user данные пользователя
     * @return запрос на создание пользователя
     */
    @Step("Создание пользователя")
    public ValidatableResponse createUser(User user) {
        return
                spec()
                        .body(user)
                        .when()
                        .post(API_REG)
                        .then().log().all();
    }

    /**
     * Удаление пользователя
     * @param userAutToken токен авторизации
     */
    @Step("Удаление пользователя")
    public void delete(@Param(mode=HIDDEN)String userAutToken) {
        spec()
                .auth().oauth2(userAutToken)
                .when()
                .delete(API_DATA)
                .then().log().all();
    }
}