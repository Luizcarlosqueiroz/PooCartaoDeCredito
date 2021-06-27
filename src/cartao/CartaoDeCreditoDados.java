package cartao;


import connection.ConnectionBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartaoDeCreditoDados extends ConnectionBD {
    
     public void cadastrarCartaoDeCredito(CartaoDeCredito c) throws SQLException, Exception {

        String sql = "INSERT INTO CARTAODECREDITO (validade, numbCartao, nomeImpressoCartao, cvv, bandeira, senha, id_intfinanceira, id_comprador) ";
        sql += " VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setDate(1, (Date) c.getValidade());
        preparedStatement.setString(2, c.getNumbCartao());
        preparedStatement.setString(3, c.getNomeImpressoCartao());
        preparedStatement.setString(4, c.getCvv());
        preparedStatement.setString(5, c.getBandeira());
        preparedStatement.setString(6, c.getSenha());
        preparedStatement.setInt(7, c.getInstituicaoFinanceira().getIdInstituicaoFinanceira());
        preparedStatement.setInt(8, c.getComprador().getIdComprador());

        preparedStatement.executeUpdate();

        super.desconectar();
    }
    
     public void removerCartaoDeCredito(CartaoDeCredito cc) throws SQLException, Exception {

        String sql = "DELETE FROM CARTAODECREDITO WHERE id_cartaodecredito = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setInt(1, cc.getIdCartaoDeCredito());

        preparedStatement.executeUpdate();

        super.desconectar();
    }
     
     public void atualizarCartaoDeCredito(CartaoDeCredito cc) throws SQLException, Exception {
        String sql = "UPDATE CARTAODECREDITO SET validade = ?, numbCartao = ?, nomeImpressoCartao = ?, cvv = ?, bandeira = ?, senha = ?, id_intfinanceira = ?, id_comprador = ?  WHERE id_cartaodecredito = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setDate(1, (Date) cc.getValidade());
        preparedStatement.setString(2, cc.getNumbCartao());
        preparedStatement.setString(3, cc.getNomeImpressoCartao());
        preparedStatement.setString(4, cc.getCvv());
        preparedStatement.setString(5, cc.getBandeira());
        preparedStatement.setString(6, cc.getSenha());
        preparedStatement.setInt(7, cc.getInstituicaoFinanceira().getIdInstituicaoFinanceira());
        preparedStatement.setInt(8, cc.getComprador().getIdComprador());
        
        preparedStatement.executeUpdate();

        super.desconectar();
    }
     public ArrayList<CartaoDeCredito> listar(CartaoDeCredito filtro) throws Exception {
        ArrayList<CartaoDeCredito> retorno = new ArrayList<>();

        String sql = " select cc.id_cartaodecredito, cc.validade, cc.numbCartao, cc.nomeImpressoCartao, cc.cvv, cc.bandeira, cc.senha, cc.id_intfinanceira, cc.id_comprador";
        sql += " from CARTAODECREDITO as cc ";
        sql += " where cc.id_cartaodecredito > 0 ";
        if (filtro.getIdCartaoDeCredito()> 0) {
            sql += " and cc.id_cartaodecredito = ? ";
        }
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        if (filtro.getIdCartaoDeCredito()> 0) {
            preparedStatement.setInt(1, filtro.getIdCartaoDeCredito());
        }

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            CartaoDeCredito cc = new CartaoDeCredito();
            
            cc.setIdCartaoDeCredito(leitor.getInt("id_cartaodecredito"));
            
            cc.setValidade(leitor.getDate("validade"));
            cc.setNumbCartao(leitor.getString("numbCartao"));
            cc.setNomeImpressoCartao(leitor.getString("nomeImpressoCartao"));
            cc.setCvv(leitor.getString("cvv"));
            cc.setBandeira(leitor.getString("bandeira"));
            cc.setSenha(leitor.getString("senha"));
            
            cc.getInstituicaoFinanceira().setIdInstituicaoFinanceira(leitor.getInt("id_intfinanceira"));
            cc.getComprador().setIdComprador(leitor.getInt("id_comprador"));
           
            retorno.add(cc);
        }
        super.desconectar();
        return retorno;
    }
}
