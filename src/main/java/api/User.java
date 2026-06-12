package api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@AllArgsConstructor
@Data
public class User {
    private String email;
    private String password;
    private String name;

    /**
     * Создание пользователя с рандомными данными
     * @return нового пользователя
     */
    public static User randomCreatedUser() {
        String email = RandomStringUtils.randomAlphanumeric(5, 10) + "-data@mail.ru";
        String password = RandomStringUtils.randomAlphanumeric(7, 10);
        String name = RandomStringUtils.randomAlphanumeric(5, 10);

        return new User(email, password, name);
    }
}
