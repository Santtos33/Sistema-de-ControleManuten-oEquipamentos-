package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoUtil {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/sistemamanutencao";
        String user = "root";
        String password = "sua_senha";
        return DriverManager.getConnection(url, user, password);
    }
}
