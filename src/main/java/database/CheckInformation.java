package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckInformation {

    public static String idToName(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT login FROM player WHERE id=" +id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {
            return rs.getString("login");
        } else return "0";
    }

    public static int nameToId(String login) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT id FROM player WHERE login='" + login + "'";

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {
            return rs.getInt("id");
        } else return 0;
    }


    public static int checkLogin(String searchLogin) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT id FROM player WHERE login = '" + searchLogin + "'";

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {
            return -1;
        } else return 1;

    }

    public static boolean checkOnline(String searchLogin) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT id FROM player WHERE login = '" + searchLogin + "' AND online=1";

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("Check online = " + rs.getInt("id") + " return true");

            return true;

        } else return false;

    }

    public static int checkPlayer(String searchLogin, String searchPassword) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT id FROM player WHERE login =  '" + searchLogin + "' AND password = '" + searchPassword + "'";

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("Result set = " + rs.getInt("id"));

            return rs.getInt("id");

        } else return -1;

    }

    public static int checkMeInvite(String searchLogin) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT id FROM player WHERE login= '" + searchLogin + "' AND me_invite<0 AND i_invite<0";

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("checkmeInvite = " + rs.getInt("id") + " return 1");

            return 1;

        } else return 0;
    }


    public static int searchWhoInvite(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT id FROM player WHERE i_invite=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("searchW = " + rs.getInt("id"));

            return rs.getInt("id");

        } else return 0;
    }

    public static int getMeInvite(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT me_invite FROM player WHERE id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("getMeInvite = " + rs.getInt("me_invite"));

            return rs.getInt("me_invite");

        } else return -2;
    }

    public static int getIInvite(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT i_invite FROM player WHERE id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("getIInvite = " + rs.getInt("i_invite"));

            return rs.getInt("i_invite");

        } else return -2;
    }

    public static int getPlay(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT play FROM player WHERE id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("getPlay = " + rs.getInt("play"));

            return rs.getInt("play");

        } else return -2;
    }

}


