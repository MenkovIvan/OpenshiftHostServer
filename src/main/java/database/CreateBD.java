package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateBD {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "CREATE TABLE Player (login VARCHAR(20) default '', password VARCHAR(20) default '', id INT NOT NULL AUTO_INCREMENT, PRIMARY KEY (id));";

        statement.executeUpdate(sql);


    }
}
