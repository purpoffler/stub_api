package example.stubapi.controller;
import java.sql.*;

public class DataBase {
    private  final String url = "jdbc:postgresql://192.168.1.78:5432/postgresdb";
    private  final String user_db = "postgres";
    private  final String password_db = "password";


    public User select(String login) throws Exception{
        String query = "SELECT  * FROM t1 JOIN t2 using(login) WHERE t1.login = '" + login + "'";
        User user = null;
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user_db, password_db);
            st = con.createStatement();
            rs = st.executeQuery(query);

            System.out.println("Подключение успешно, метод select выполняется");

                if (rs.next()) {
                    user = new User(
                            rs.getString("login"),
                            rs.getString("password"),
                            rs.getTimestamp("date"),
                            rs.getString("email")
                    );
                }else{
                    throw new Exception();
                }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public int insert(User user) throws SQLException{

        int numb = 0;

        String query = "INSERT INTO t1 (login, password, date) VALUES (?, ?, ?); \n INSERT INTO  t2 (login, email) VALUES (?, ?)";


     try(Connection connection = DriverManager.getConnection(url, user_db, password_db);
         PreparedStatement ps = connection.prepareStatement(query)
         ){
             System.out.println("Подключение успешно, метод insert выполняется");

                 ps.setString(1, user.login);
                 ps.setString(2, user.password);
                 ps.setTimestamp(3, user.date);
                 ps.setString(4, user.login);
                 ps.setString(5, user.email);
             try {
                 numb = ps.executeUpdate();
             } catch (SQLException e) {
                 throw new SQLException("Ошибка при выполнении запроса - неправильные данные или такой пользователь уже существует");
             }
         }catch (SQLException e) {
             throw new SQLException("Ошибка при подключении к БД");
         }

        return numb;
    }





}
