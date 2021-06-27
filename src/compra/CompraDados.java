package compra;

import connection.ConnectionBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompraDados extends ConnectionBD {
    
    public void cadastrarCompra(Compra c) throws SQLException, Exception {

        String sql = "INSERT INTO COMPRA (valorBruto,horarioCompra,id_comprador,id_vendedor) ";
        sql += " VALUES (?,?,?,?)";

        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        
        preparedStatement.setDouble(1, c.getValorBruto());
        preparedStatement.setDate(2, (Date) c.getDiaCompra());
        preparedStatement.setInt(3, c.getComprador().getIdComprador());
        preparedStatement.setInt(4, c.getVendedor().getIdVendedor());

        preparedStatement.executeUpdate();

        super.desconectar();
    }
}
