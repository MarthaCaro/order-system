package com.example.order.model.persistencia;
import com.example.order.model.entidad.Orden;
import org.springframework.core.annotation.Order;

import java.sql.*;

public class ConfiguracionJDBC {
    private static Connection connection = null;

    static {
        String jdbcDriver = "org.h2.Driver";
        String dbUrl = "jdbc:h2:~/db_farmacia;INIT=RUNSCRIPT FROM 'classpath:create.sql'";
        String nombreUsuario = "sa";
        String contrasenaUsuario = "";
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(dbUrl, nombreUsuario, contrasenaUsuario);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return connection;
    }

}
