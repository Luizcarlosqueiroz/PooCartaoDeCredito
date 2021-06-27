package compra;

import java.util.Date;
import comprador.Comprador;
import vendedor.Vendedor;
import java.time.LocalDateTime;

public class Compra {
    
    private int idCompra;
    private double valorBruto;
    private Date diaCompra;
    private Comprador comprador;
    private Vendedor vendedor;

    //public Compra(double valorBruto, int totalItens, Comprador comprador, Vendedor vendedor, LocalDateTime horarioCompra) {
    //    this.valorBruto = valorBruto;
    //    this.totalItens = totalItens;
    //    this.comprador = comprador;
    //    this.vendedor = vendedor;
    //    this.horarioCompra=LocalDateTime.now();
    //}

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Date getDiaCompra() {
        return diaCompra;
    }

    public void setDiaCompra(Date diaCompra) {
        this.diaCompra = diaCompra;
    }
}
