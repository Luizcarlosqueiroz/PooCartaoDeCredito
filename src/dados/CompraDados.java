package dados;

import basicas.Compra;
import connection.ConnectionBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompraDados extends ConnectionBD {
    
    public void cadastrarCompra(Compra c) throws SQLException, Exception {

        String sql = "INSERT INTO COMPRA (valorBruto,totalItens,horarioCompra,modalidadePagamento,id_comprador,id_vendedor) ";
        sql += " VALUES (?,?,CURRENT_TIMESTAMP,?,?,?)";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        
        preparedStatement.setDouble(1, c.getValorBruto());
        preparedStatement.setInt(2, c.getTotalItens());
        //preparedStatement.setDate(3, () c.getHorarioCompra());
        preparedStatement.setString(4, c.getModalidadePagamento());
        preparedStatement.setInt(5, c.getComprador().getIdComprador());
        preparedStatement.setInt(6, c.getVendedor().getIdVendedor());

        preparedStatement.executeUpdate();

        super.desconectar();
    }
    
    public void removerCompra(Compra c) throws SQLException, Exception {

        String sql = "DELETE FROM COMPRA WHERE id_compra = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setInt(1, c.getIdCompra());

        preparedStatement.executeUpdate();

        super.desconectar();
    }
     
    public void atualizarCompra(Compra c) throws SQLException, Exception {
        String sql = "UPDATE COMPRA SET valorBruto = ?, totalItens = ?, horarioCompra = CURRENT_TIMESTAMP, modalidadePagamento = ?, id_comprador = ?, id_vendedor = ? WHERE id_compra = ? ";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        preparedStatement.setDouble(1, c.getValorBruto());
        preparedStatement.setInt(2, c.getTotalItens());
        //preparedStatement.setDate(3, c.getHorarioCompra());
        preparedStatement.setString(4, c.getModalidadePagamento());
        preparedStatement.setInt(5, c.getComprador().getIdComprador());
        preparedStatement.setInt(6, c.getVendedor().getIdVendedor());
        
        preparedStatement.executeUpdate();

        super.desconectar();
    }
     
    public ArrayList<Compra> listar(Compra filtro) throws Exception {
        ArrayList<Compra> retorno = new ArrayList<>();

        String sql = " select cc.id_compra, cc.valorBruto, cc.totalItens, cc.horarioCompra, cc.modalidadePagamento, cc.id_comprador, cc.id_vendedor";
        sql += " from COMPRA as c ";
        sql += " where c.id_compra > 0 ";
        if (filtro.getIdCompra()> 0) {
            sql += " and c.id_compra = ? ";
        }
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        if (filtro.getIdCompra()> 0) {
            preparedStatement.setInt(1, filtro.getIdCompra());
        }

        ResultSet leitor = preparedStatement.executeQuery();

        while (leitor.next()) {
            Compra c = new Compra();
            
            c.setIdCompra(leitor.getInt("id_compra"));
            
            c.setValorBruto(leitor.getDouble("valorBruto"));
            c.setTotalItens(leitor.getInt("totalItens"));
            
            //c.setHorarioCompra(leitor.getDate("horarioCompra"));
            
            c.setModalidadePagamento(leitor.getString("modalidadePagamento"));
            c.getComprador().setIdComprador(leitor.getInt("id_comprador"));
            c.getVendedor().setIdVendedor(leitor.getInt("id_vendedor"));
           
            retorno.add(c);
        }
        super.desconectar();
        return retorno;
    }
}
