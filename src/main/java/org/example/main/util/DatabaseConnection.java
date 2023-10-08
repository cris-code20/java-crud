package org.example.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//aqui vamos a crear la conexion y luego lo vamos a importar pormedio getInstance ejmplo:
// Connection con = DatabaseConnection.getInstante();
// ya con eso tendremos nuestra conexion
public class DatabaseConnection {

// es importante que los metodos sean staticos
    private static String url = "jdbc:mysql://localhost:3306/empresacris";
    private static String user = "root";
    private static String pass = "Metano04";
    private static Connection con;

//    aqui cremos una pequeña validacion para que cuando la connecion sea nula entonces se pueda connectar
    public static Connection getInstance() throws SQLException {
        if (con == null){
            con = DriverManager.getConnection(url,user,pass);
        }

        return con;
    }


}
