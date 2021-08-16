package itSpace.uncle.manager;

import itSpace.uncle.db.DBConnectionProvider;
import itSpace.uncle.model.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceManager {

    private Connection connection = DBConnectionProvider.getProvider().getConnection();
    private UserManager userManager = new UserManager();
    private int userId;

    public void addService(Service service) {
        try {
            String query = "INSERT INTO `service` (`title`,`description`,`date`,`visitor_name`,`user_id`) " +
                    "VALUES(?,?,?,?,?);";

            PreparedStatement pStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, service.getTitle());
            pStatement.setString(2, service.getDescription());
            pStatement.setString(3, service.getDate());
            pStatement.setString(4, service.getVisitorName());
            pStatement.setInt(5, service.getUser().getId());
            System.out.println(query);
            pStatement.executeUpdate();
            ResultSet generatedKeys = pStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                service.setId(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateService(Service service) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE service SET title = '%s', description = '%s', date ='%s', visitor_name='%s' WHERE id=" + service.getId(),
                    service.getTitle(), service.getDescription(), service.getDate(), service.getVisitorName());
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Service> getServices() {
         String sql = "SELECT * FROM service";
       // String sql = "SELECT * FROM service where user_id = '" + userId + "' ";
        List<Service> result = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Service service = Service.builder()
                        .id(resultSet.getInt(1))
                        .title(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .date(resultSet.getString(4))///////????????
                        .visitorName(resultSet.getString(5))
                        .build();
                result.add(service);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public void deleteService(int id) {
        String sql = "DELETE from service where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Service getServiceById(int id) {
        String sql = "SELECT * FROM service WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Service.builder()
                        .id(resultSet.getInt(1))
                        .title(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .date(resultSet.getString(4))
                        .visitorName(resultSet.getString(5))
                        .user(userManager.getUserById(resultSet.getInt(6)))
                        .build();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Service> getServiceByUserId(int userId) {
        String sql = "SELECT * FROM service WHERE user_id=" + userId;
        List<Service> userListService = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Service service =  Service.builder()
                        .id(resultSet.getInt(1))
                        .title(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .date(resultSet.getString(4))
                        .visitorName(resultSet.getString(5))
                        .user(userManager.getUserById(resultSet.getInt(6)))
                        .build();
                userListService.add(service);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userListService;
    }



}