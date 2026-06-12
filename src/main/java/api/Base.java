package api;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class Base {

    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    public static final String BASE_PATH_USER = "/api/auth";

    /**
     * Спецификация для POST запросов работы с пользователями
     * @return общая часть запросов для работы с пользователями
     */
    public RequestSpecification spec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(BASE_PATH_USER);
    }
}