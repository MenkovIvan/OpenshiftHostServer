package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetInformation {
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

    public static String getTrs(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT trs FROM player WHERE id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("getPlay = " + rs.getInt("play"));

            return rs.getString("trs");

        } else return "-1";
    }

    public static String getDoors(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT doors FROM player WHERE id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("getPlay = " + rs.getInt("play"));

            return rs.getString("doors");

        } else return "-1";
    }

    public static int getPower(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT power FROM player WHERE id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("getPlay = " + rs.getInt("play"));

            return rs.getInt("power");

        } else return -1;
    }

    public static int getLvl(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT lvl FROM player WHERE id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("getPlay = " + rs.getInt("play"));

            return rs.getInt("lvl");

        } else return -1;
    }

    public static int getEndTurn(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT endturn FROM player WHERE id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("getPlay = " + rs.getInt("play"));

            return rs.getInt("endturn");

        } else return -1;
    }

    public static int getOnline(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT online FROM player WHERE id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("getPlay = " + rs.getInt("play"));

            return rs.getInt("online");

        } else return -1;

    }

    public static int getNumber(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT number FROM player WHERE id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("getPlay = " + rs.getInt("play"));

            return rs.getInt("number");

        } else return -1;

    }

    public static int getNDoors(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT ndoors FROM player WHERE id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("getPlay = " + rs.getInt("play"));

            return rs.getInt("ndoors");

        } else return -1;

    }

    public static int getNTrs(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT ntrs FROM player WHERE id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            //System.out.println("getPlay = " + rs.getInt("play"));

            return rs.getInt("ntrs");

        } else return -1;

    }
}
