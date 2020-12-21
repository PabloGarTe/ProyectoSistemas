package mx.uv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Librería de MySQL
    public String driver = "com.mysql.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "dbtiendaenlinea";
    
    // Host
    public String hostname = "db4free.net";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // Nombre de usuario
    public String username = "usersistemasweb";

    // Clave de usuario
    public String password = "12345678";

    public Connection conectarMySQL()throws Exception {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conexion realizada .................................");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexion de la base de datos");
            System.out.println("Error en conexion la cuasa es "+e.getCause().toString());
            e.printStackTrace();
        } //catch 

        return conn;
    }

}