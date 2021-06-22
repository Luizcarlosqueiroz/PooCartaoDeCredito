package instituicaoFinanceira;

import instituicaoFinanceira.InstituicaoFinanceira;
import connection.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstituicaoFinanceiraDados extends ConnectionBD {
    
     public void cadastrarInstituicaoFinanceira(InstituicaoFinanceira inst) throws SQLException, Exception {
        String sql = "INSERT INTO INTFINANCEIRA (cnpj,nomeFantasia,endereco) ";
        sql += " VALUES (?,?,?)";
        
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        
        preparedStatement.setString(1, inst.getCnpj());
        preparedStatement.setString(2, inst.getNomeFantasia());
        preparedStatement.setString(3, inst.getEndereco());
        
        preparedStatement.executeUpdate();

        super.desconectar();
    }
    
    public void removerInstituicaoFinanceira(InstituicaoFinanceira inst) throws SQLException, Exception {

        String sql = "DELETE FROM INTFINANCEIRA WHERE id_intfinanceira = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setInt(1, inst.getIdInstituicaoFinanceira());

        preparedStatement.executeUpdate();

        super.desconectar();
    }
    
    public void atualizarInstituicaoFinanceira(InstituicaoFinanceira inst) throws SQLException, Exception {

        String sql = "UPDATE INTFINANCEIRA SET cnpj = ?, nomeFantasia =?, endereco = ? WHERE id_intfinanceira = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setString(1, inst.getCnpj());
        preparedStatement.setString(2, inst.getNomeFantasia());
        preparedStatement.setString(3, inst.getEndereco());
        preparedStatement.setInt(4, inst.getIdInstituicaoFinanceira());
        
        preparedStatement.executeUpdate();

        super.desconectar();
    }
    
     public ArrayList<InstituicaoFinanceira> listar(InstituicaoFinanceira filtro) throws Exception {
        ArrayList<InstituicaoFinanceira> retorno = new ArrayList<>();

        String sql = " select v.id_intfinanceira,v.cnpj,v.nomeFantasia,v.endereco ";
        sql += " from INTFINANCEIRA as inst ";
        sql += " where inst.id_intfinanceira > 0 ";
        if (filtro.getIdInstituicaoFinanceira()> 0) {
            sql += " and inst.id_intfinanceira = ? ";
        }

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        if (filtro.getIdInstituicaoFinanceira()> 0) {
            preparedStatement.setInt(1, filtro.getIdInstituicaoFinanceira());
        }

        ResultSet leitor = preparedStatement.executeQuery();
 
        while (leitor.next()) {
            InstituicaoFinanceira inst = new InstituicaoFinanceira();
            inst.setIdInstituicaoFinanceira(leitor.getInt("idInstituicaoFinanceira"));
            inst.setCnpj(leitor.getString("cnpj"));
            inst.setNomeFantasia(leitor.getString("nomeFantasia"));
            inst.setEndereco(leitor.getString("endereco"));
           
            retorno.add(inst);
        }

        super.desconectar();
        return retorno;
    }
}
