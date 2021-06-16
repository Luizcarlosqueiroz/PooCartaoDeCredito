package dados;

import basicas.Vendedor;
import connection.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class vendedorDados extends ConnectionBD {
    
     public void cadastrarVendedor(Vendedor v) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO VENDEDOR (cnpj,nomeFantasia,endereco) ";
        sql += " VALUES (?,?,?)";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
       
        preparedStatement.setString(1, v.getCnpj());
        preparedStatement.setString(2, v.getNomeFantasia());
        preparedStatement.setString(3, v.getEndereco());
    
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }
    
    public void removerCLiente(Vendedor v) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "DELETE FROM VENDEDOR WHERE id_vendedor = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, v.getIdVendedor());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }
    
    public void atualizarCLiente(Vendedor v) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "UPDATE VENDEDOR SET cnpj = ?, nomeFantasia =?, endereco = ? WHERE id_Vendedor = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, v.getCnpj());
        preparedStatement.setString(2, v.getNomeFantasia());
        preparedStatement.setString(3, v.getEndereco());
        preparedStatement.setInt(4, v.getIdVendedor());
        
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }
    
     public ArrayList<Vendedor> listar(Vendedor filtro) throws Exception {
        ArrayList<Vendedor> retorno = new ArrayList<>();

        //instrução sql correspondente a inserção do aluno
        String sql = " select v.id_Vendedor,v.cnpj,v.nomeFantasia,v.endereco ";
        sql += " from vendedor as v ";
        sql += " where v.id_Vendedor > 0 ";
        if (filtro.getIdVendedor()> 0) {
            sql += " and v.id_Vendedor = ? ";
        }

        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        if (filtro.getIdVendedor()> 0) {
            preparedStatement.setInt(1, filtro.getIdVendedor());
        }
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
 
        while (leitor.next()) {
            Vendedor v = new Vendedor();
            v.setIdVendedor(leitor.getInt("idVendedor"));
            v.setCnpj(leitor.getString("cnpj"));
            v.setNomeFantasia(leitor.getString("nomeFantasia"));
            v.setEndereco(leitor.getString("endereco"));
           
            retorno.add(v);
        }
        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }
}
