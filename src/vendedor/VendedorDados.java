package vendedor;

import connection.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VendedorDados extends ConnectionBD {
    
     public void cadastrarVendedor(Vendedor v) throws SQLException, Exception {
        String sql = "INSERT INTO VENDEDOR (cnpj,nomeFantasia,endereco) ";
        sql += " VALUES (?,?,?)";
        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        
        preparedStatement.setString(1, v.getCnpj());
        preparedStatement.setString(2, v.getNomeFantasia());
        preparedStatement.setString(3, v.getEndereco());
        
        preparedStatement.executeUpdate();

        super.desconectar();
    }
    
    public void removerVendedor(Vendedor v) throws SQLException, Exception {

        String sql = "DELETE FROM VENDEDOR WHERE id_vendedor = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setInt(1, v.getIdVendedor());

        preparedStatement.executeUpdate();

        super.desconectar();
    }
    
    public void atualizarVendedor(Vendedor v) throws SQLException, Exception {

        String sql = "UPDATE VENDEDOR SET cnpj = ?, nomeFantasia =?, endereco = ? WHERE id_Vendedor = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, v.getCnpj());
        preparedStatement.setString(2, v.getNomeFantasia());
        preparedStatement.setString(3, v.getEndereco());
        preparedStatement.setInt(4, v.getIdVendedor());
        
        preparedStatement.executeUpdate();

        super.desconectar();
    }
    
     public ArrayList<Vendedor> listar(Vendedor filtro) throws Exception {
        ArrayList<Vendedor> retorno = new ArrayList<>();

        String sql = " select v.id_Vendedor,v.cnpj,v.nomeFantasia,v.endereco ";
        sql += " from vendedor as v ";
        sql += " where v.id_Vendedor > 0 ";
        if (filtro.getIdVendedor()> 0) {
            sql += " and v.id_Vendedor = ? ";
        }

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        if (filtro.getIdVendedor()> 0) {
            preparedStatement.setInt(1, filtro.getIdVendedor());
        }

        ResultSet leitor = preparedStatement.executeQuery();
 
        while (leitor.next()) {
            Vendedor v = new Vendedor();
            v.setIdVendedor(leitor.getInt("idVendedor"));
            v.setCnpj(leitor.getString("cnpj"));
            v.setNomeFantasia(leitor.getString("nomeFantasia"));
            v.setEndereco(leitor.getString("endereco"));
           
            retorno.add(v);
        }

        super.desconectar();
        return retorno;
    }
}
