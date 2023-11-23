package db;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BitLabShop",
                    "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUserByEmail(String email){
        User user = null; // Initialize to null
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users WHERE email=?");
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                user = new User(); // Only create a new User object if the email exists
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFullName(resultSet.getString("fullName"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public static Item getItem(Long id){
        Item item = new Item();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM items WHERE id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                item.setPhotoURL(resultSet.getString("photo"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return item;
    }

    public static void addUser(User user){
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO users (email, password, \"fullName\") " +
                    "VALUES (?, ?, ?)");
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFullName());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean addBlog(Blog blog){
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO blogs (userid, title, content, postdate)" +
                    "VALUES (?,?,?, NOW())");
            statement.setLong(1, blog.getUser().getId());
            statement.setString(2, blog.getTitle());
            statement.setString(3,blog.getContent());
            rows = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows>0;
    }

    public static ArrayList<Item> getAllItems(){
        ArrayList<Item> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM items");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                item.setPhotoURL(resultSet.getString("photo"));
                items.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    public static ArrayList<Blog> getAllBlogs(){
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM blogs");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Blog blog = new Blog();
                blog.setId(resultSet.getLong("id"));
                blog.setContent(resultSet.getString("content"));
                blog.setUser(DBManager.getUserById((Integer) resultSet.getObject("userid")));
                blog.setTitle(resultSet.getString("title"));
                blog.setPostDate(resultSet.getTimestamp("postdate"));
                blogs.add(blog);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return blogs;
    }

    public static User getUserById(Integer id){
        User user = null; // Initialize to null
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users WHERE id=?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                user = new User(); // Only create a new User object if the email exists
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFullName(resultSet.getString("fullName"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public static Blog getBlog(Long id){
        Blog blog = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("" +
                    "SELECT * FROM blogs WHERE id=?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                blog = new Blog();
                blog.setId(resultSet.getLong("id"));
                blog.setContent(resultSet.getString("content"));
                blog.setUser(DBManager.getUserById((Integer) resultSet.getObject("userid")));
                blog.setTitle(resultSet.getString("title"));
                blog.setPostDate(resultSet.getTimestamp("postdate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return blog;
    }
}