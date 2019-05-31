package database;

import java.sql.*;

public class UpdateInformation {
    public static void updateOnline(int id, int online) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET online=" + online + " WHERE id=" + id;

        int rowCount = statement.executeUpdate(sql);

        //System.out.println("update online = " + rowCount + " from " + id);

    }

    public static void updateMe_Invite(int who, String invite) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET me_invite=" + who + " WHERE login='" + invite + "'";

        int rowCount = statement.executeUpdate(sql);

        //System.out.println("updateMe_Invite = " + rowCount + " from " + invite);

    }

    public static void updateI_Invite(String mylogin, int who) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET i_invite=" + who + " WHERE login='" + mylogin + "'";

        int rowCount = statement.executeUpdate(sql);

        //System.out.println("updateMe_Invite = " + rowCount + " from " + mylogin);

    }

    public static void updatePlay(String login, int play) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET play=" + play + " WHERE login='" + login + "'";

        int rowCount = statement.executeUpdate(sql);

        //System.out.println("updatePlay = " + rowCount + " from " + login);

    }

    public static void updateTrs(String login, String trs) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET trs='" + trs + "' WHERE login='" + login + "'";

        int rowCount = statement.executeUpdate(sql);

        //System.out.println("updatePlay = " + rowCount + " from " + login);

    }

    public static void updateDoors(String login, String doors) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET doors='" + doors + "' WHERE login='" + login + "'";

        int rowCount = statement.executeUpdate(sql);

        //System.out.println("updatePlay = " + rowCount + " from " + login);

    }

    public static void updateLvl(String login, int lvl) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET lvl=" + lvl + " WHERE login='" + login + "'";

        int rowCount = statement.executeUpdate(sql);

        //System.out.println("updatePlay = " + rowCount + " from " + login);

    }

    public static void updatePower(String login, int power) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET power=" + power + " WHERE login='" + login + "'";

        int rowCount = statement.executeUpdate(sql);

        //System.out.println("updatePlay = " + rowCount + " from " + login);

    }

    public static void updateEndTurn(String login, int endturn) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET endturn=" + endturn + " WHERE login='" + login + "'";

        int rowCount = statement.executeUpdate(sql);

        //System.out.println("updatePlay = " + rowCount + " from " + login);

    }

    public static void updateNumber(String login, int number) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET number=" + number +" WHERE login='" + login + "'";

        int rowCount = statement.executeUpdate(sql);

        //System.out.println("updatePlay = " + rowCount + " from " + login);

    }

    public static void updateNDoors(String login, int ndoors) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET ndoors=" + ndoors +" WHERE login='" + login + "'";

        int rowCount = statement.executeUpdate(sql);

        //System.out.println("updatePlay = " + rowCount + " from " + login);

    }

    public static void updateNTrs(String login, int ntrs) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET ntrs=" + ntrs +" WHERE login='" + login + "'";

        int rowCount = statement.executeUpdate(sql);

        //System.out.println("updatePlay = " + rowCount + " from " + login);

    }
}
