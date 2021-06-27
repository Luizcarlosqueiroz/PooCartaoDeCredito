package comprador;

import connection.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompradorDados extends ConnectionBD {
    
     public void cadastrarComprador(Comprador c) throws SQLException, Exception {
        String sql = "INSERT INTO COMPRADOR (cpf,nomeCompleto,telefone,endereco) ";
        sql += " VALUES (?,?,?,?)";
        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        
        preparedStatement.setString(1, c.getCpfTitular());
        preparedStatement.setString(2, c.getNomeCompleto());
        preparedStatement.setString(3, c.getTelefone());
        preparedStatement.setString(4, c.getEndereco());
        
        preparedStatement.executeUpdate();

        super.desconectar();
    }
}
