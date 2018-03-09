package dbService.dao;

import accounts.AccountService;
import accounts.UserProfile;
import dbService.dataSets.UsersDataSet;
import dbService.executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class UsersDAO {

    private Executor executor;

    public UsersDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public UsersDataSet get(long id) throws SQLException {
        return executor.execQuery("select * from users where id=" + id, result -> {
            result.next();
            return new UsersDataSet(result.getLong(1), result.getString(2));
        });
    }

    public long getUserId(String login) throws SQLException {
        return executor.execQuery("select * from users where login='" + login + "'", result -> {
            result.next();
            return result.getLong(1);
        });
    }

/*
    public List<UserProfile> getAllUsers() throws  SQLException{
        return executor.execQuery("select * from users;", result -> {
            List<UserProfile> list = new ArrayList<>();
            while (result.next()){
                list.add(new UserProfile(
                                result.getString("login"),
                                result.getString("password"),
                                ""));
            }
            return list;
        });
    }
*/
    public void getAllUsers(AccountService accountService) throws  SQLException{
        executor.execQuery("select * from users;", result -> {
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
            return null;
        });
    }

    public void insertUser(String login, String password) throws SQLException {
        executor.execUpdate("insert into users (login, password) values ('" + login + "', '" + password + "')");
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users (id bigint auto_increment, login varchar(256), password varchar(256), primary key (id));");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }
}
