package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public String driver = "com.mysql.cj.jdbc.Driver";
    public String database = "ferre";
    public String hostname = "localhost";
    public String url = "jdbc:mysql://" + hostname + "/" + database + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public String username = "root";
    public String password = "Fabricio3118328319";
    
    public Connection conectarMySQL() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("conectado");
        } catch (ClassNotFoundException | SQLException e) {
        	System.out.println("Error");
            e.printStackTrace();
        }

        return conn;
    }
}

