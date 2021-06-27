package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionBD {
    
    private Statement stmt;
    public Connection conn;
    private final String DRIVER_SQLSERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String LOCAL_SERVIDOR = "LAPTOP-DAEMNS48";
    private final String BANCO_DE_DADOS = "PAGAMENTO3";
    private final String PORTA_BANCO = "1433";
    private final String USUARIO = "lc";
    private final String SENHA = "luiz1234";
 
   public Connection conectar() throws Exception {
        return this.conectarSqlServer();
    }

    public void desconectar() throws SQLException {
        conn.close();
    }

    private Connection conectarSqlServer() throws Exception {
        Class.forName(DRIVER_SQLSERVER);
        String url = "jdbc:sqlserver://"+LOCAL_SERVIDOR+":"+PORTA_BANCO+";DatabaseName="+BANCO_DE_DADOS;
        conn = DriverManager.getConnection(url, USUARIO, SENHA);
        return conn;
    }
}