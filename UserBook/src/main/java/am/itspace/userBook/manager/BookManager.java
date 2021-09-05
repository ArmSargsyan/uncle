package am.itspace.userBook.manager;

import am.itspace.userBook.db.DBConnectionProvider;
import am.itspace.userBook.maodel.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private Connection connection = DBConnectionProvider.grtProvider().getConnection();
    private UserManager userManager = new UserManager();
    public void addBook(Book book) {
        try {
            String query = "INSERT INTO `book` (`title`,`author_name`,`price`,`created_date`,`pic_url`,`user_id`)" +
                    "VALUES(?,?,?,?,?,?);";
            PreparedStatement pStatment = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pStatment.setString(1, book.getTitle());
            pStatment.setString(2, book.getAuthorName());
            pStatment.setDouble(3, book.getPrice());
            pStatment.setString(4, book.getCreatedDate().toString());
            pStatment.setString(5, book.getPicUrl());
            pStatment.setInt(6, book.getUser().getId());
            System.out.println(query);
            pStatment.executeUpdate();
            ResultSet generatedKeys = pStatment.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                book.setId(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateBook(Book book) throws SQLException {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE book SET title = '%s', author_name = '%s', price = '%s', pic_url = '%s' WHERE id=" + book.getId(),
                    book.getTitle(), book.getAuthorName(), book.getPrice(), book.getPicUrl());
            System.out.println(query);
            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Book> getBooks() {
        String sql = "SELECT * FROM book";
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = Book.builder()
                        .id(resultSet.getInt(1))
                        .title(resultSet.getString(2))
                        .authorName(resultSet.getString(3))
                        .price(resultSet.getDouble(4))
                        .createdDate(resultSet.getDate(5))
                        .picUrl(resultSet.getString(6))
                        .user(userManager.getUserById(resultSet.getInt(7)))
                        .build();
                result.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Book getBookById(int id) {
        String sql = "SELECT * FROM book WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Book.builder()
                        .id(resultSet.getInt(1))
                        .title(resultSet.getString(2))
                        .authorName(resultSet.getString(3))
                        .price(resultSet.getDouble(4))
                        .createdDate(resultSet.getDate(5))
                        .picUrl(resultSet.getString(6))
                        .user(userManager.getUserById(resultSet.getInt(7)))
                        .build();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteBook(int id) {
        String sql = "DELETE from book where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
