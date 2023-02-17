package io.github.uttmangosteen.dangoclicker;

import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    public String host, database, username, password, port;
    public void mySQL(){
        host = Global.config.getString("mysql.host");
        database = Global.config.getString("mysql.database");
        username = Global.config.getString("mysql.username");
        password = Global.config.getString("mysql.password");
        port = Global.config.getString("mysql.port");
        Connect();
    }

    private boolean Connect(){
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
