package dbService;

import accounts.AccountService;
import accounts.UserProfile;
import dbService.dao.UsersDAO;
import dbService.dataSets.UsersDataSet;
import org.h2.jdbcx.JdbcDataSource;

import java.sql.*;
import java.util.List;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class DBService {
    private final Connection connection;

    public DBService() {
        this.connection = getH2Connection();
    }

    public UsersDataSet getUser(long id) throws DBException {
        try {
            return (new UsersDAO(connection).get(id));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void getAllUsers(AccountService accountService) throws DBException {

        try {
            UsersDAO dao = new UsersDAO(connection);
            dao.createTable();
            dao.getAllUsers(accountService);

        } catch (SQLException e) {
            e.printStackTrace();
        }

/*
        try {
            UsersDAO dao = new UsersDAO(connection);
            dao.createTable();

            System.out.println("Список зарегестрированных пользователей в базе:");
            Statement stmt = connection.createStatement();
            stmt.execute("select * from users;");
            ResultSet result = stmt.getResultSet();
            while (result.next()){
                System.out.print("id=");
                System.out.print(result.getLong("id"));
                System.out.print(", login=");
                System.out.print(result.getString("login"));
                System.out.print(", password=");
                System.out.println(result.getString("password"));

                accountService.addNewUser(new UserProfile(
                        result.getString("login"),
                        result.getString("password"),
                        ""));
            }
            result.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
    }

    public long addUser(String login, String password) throws DBException {
        try {
            connection.setAutoCommit(false);
            UsersDAO dao = new UsersDAO(connection);
            dao.createTable();
            dao.insertUser(login, password);
            connection.commit();
            return dao.getUserId(login);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
            }
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    public void cleanUp() throws DBException {
        UsersDAO dao = new UsersDAO(connection);
        try {
            dao.dropTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void printConnectInfo() {
        try {
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + connection.getMetaData().getDriverName());
            System.out.println("Autocommit: " + connection.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("UnusedDeclaration")
    public static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("db_example?").          //db name
                    append("user=tully&").          //login
                    append("password=tully");       //password

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getH2Connection() {
        try {
            String url = "jdbc:h2:./h2db";
            String name = "test";
            String pass = "test";

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(url);
            ds.setUser(name);
            ds.setPassword(pass);

            Connection connection = DriverManager.getConnection(url, name, pass);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
