package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;

import java.sql.*;

public class DataBase {
    public void mySQL(){
        Connect();
    }
    private boolean Connect(){
        String host = Global.config.getString("mysql.host");
        String database = Global.config.getString("mysql.database");
        String username = Global.config.getString("mysql.username");
        String password = Global.config.getString("mysql.password");
        String port = Global.config.getString("mysql.port");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
            Bukkit.getConsoleSender().sendMessage("§aMYSQL CONNECTED");
            Global.playable = true;
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            Global.playable = false;
            e.printStackTrace();
            return false;
        }
    }
}
