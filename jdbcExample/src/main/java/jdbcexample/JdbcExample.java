package jdbcexample;

import jdbcexample.manajer.UserManajer;
import jdbcexample.model.User;

public class JdbcExample {

    public static void main(String[] args) {

        UserManajer userManajer = new UserManajer();

        User user = User.builder()
                .name("nerviDex")
                .surname("dalbayob")
                .email("@nadaell")
                .password("123456")
                .build();

        userManajer.addUser(user);

    }
}
