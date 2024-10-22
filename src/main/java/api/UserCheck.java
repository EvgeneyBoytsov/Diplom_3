package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import java.util.Map;
import java.util.Set;
import static java.net.HttpURLConnection.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class UserCheck {

    /**
     * Проверка создания пользователя
     * @param createdResponse - тело ответа на запрос создание пользователя
     * @return - токен авторизации
     */
    @Step("Проверка создания пользователя")
    public String checkCreatedUser(ValidatableResponse createdResponse) {
        var body = createdResponse
                .assertThat()
                .statusCode(HTTP_OK)
                .extract()
                .body().as(Map.class);
        assertEquals("Неверное тело ответа", Set.of("success", "user", "accessToken", "refreshToken"), body.keySet());
        assertEquals("Поле success false", true, body.get("success"));
        assertNotEquals("Поле user пустое", null, body.get("user"));
        assertNotEquals("Поле refreshToken пустое", null, body.get("refreshToken"));

        Map<String, String> user = (Map<String, String>) body.get("user");
        assertEquals("Неверное тело ответа", Set.of("email", "name"), user.keySet());
        assertNotEquals("Поле email пустое", null, user.get("email"));
        assertNotEquals("Поле name пустое", null, user.get("name"));

        return (String) body.get("accessToken");
    }
}
