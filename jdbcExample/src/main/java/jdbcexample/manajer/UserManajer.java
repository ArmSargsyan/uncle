package jdbcexample.manajer;

import jdbcexample.db.DbConnectionProvider;
import jdbcexample.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManajer {
    private Connection connection = DbConnectionProvider.grtProvider().getConnection();
    public void addUser( User user){
        try {
            Statement statement = connection.createStatement();
            String query ="INSERT INTO user (name,surname,email,password) "+
                   " VALUES('"+user.getName()+"','"+user.getSurname()+"','"+user.getEmail()+"','"+
                    user.getPassword()+"')";
            System.out.println(query);
                    statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
