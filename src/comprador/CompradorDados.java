package comprador;

import connection.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
     
     public void atualizarComprador(Comprador c) throws SQLException, Exception {

        String sql = "UPDATE COMPRADOR SET cpfTitular = ?, nomeCompleto = ?, telefone = ?, endereco = ? WHERE id_Comprador = ? ";

                
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, c.getCpfTitular());
        preparedStatement.setString(2, c.getNomeCompleto());
        preparedStatement.setString(3, c.getTelefone());
        preparedStatement.setString(4, c.getEndereco());
        preparedStatement.setInt(5, c.getIdComprador());
        
        preparedStatement.executeUpdate();

        super.desconectar();
    }
     
    public void removerComprador(Comprador c) throws SQLException, Exception {

        String sql = "DELETE FROM COMPRADOR WHERE id_comprador = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setInt(1, c.getIdComprador());

        preparedStatement.executeUpdate();

        super.desconectar();
    }
    
     public ArrayList<Comprador> listar(Comprador filtro) throws Exception {
        ArrayList<Comprador> retorno = new ArrayList<>();

        String sql = " select c.id_comprador, c.cpfTitular, c.nomeCompleto, c.telefone, c.endereco ";
        sql += " from comprador as c ";
        sql += " where c.id_comprador > 0 ";
        if (filtro.getIdComprador() > 0) {
            sql += " and c.id_comprador = ? ";
        }

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        if (filtro.getIdComprador()> 0) {
            preparedStatement.setInt(1, filtro.getIdComprador());
        }

        ResultSet leitor = preparedStatement.executeQuery();
 
        while (leitor.next()) {
            Comprador c = new Comprador();
            
            c.setIdComprador(leitor.getInt("idComprador"));
            c.setCpfTitular(leitor.getString("cpfTitular"));
            c.setNomeCompleto(leitor.getString("nomeCompleto"));
            c.setTelefone(leitor.getString("telefone"));
            c.setEndereco(leitor.getString("endereco"));

            retorno.add(c);
        }

        super.desconectar();
        return retorno;
    }
}
