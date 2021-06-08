package basicas;

import java.time.LocalDateTime;

public class Compra {
    
    private double valorBruto;
    private int totalItens;
    private LocalDateTime horarioCompra;
    private Comprador comprador;
    private Vendedor vendedor;

    public Compra(double valorBruto, int totalItens, Comprador comprador, Vendedor vendedor, LocalDateTime horarioCompra) {
        this.valorBruto = valorBruto;
        this.totalItens = totalItens;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.horarioCompra=LocalDateTime.now();
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public int getTotalItens() {
        return totalItens;
    }

    public void setTotalItens(int totalItens) {
        this.totalItens = totalItens;
    }

    public LocalDateTime getHorarioCompra() {
        return horarioCompra;
    }

    public void setHorarioCompra(LocalDateTime horarioCompra) {
        this.horarioCompra = horarioCompra;
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
    
    
    
}
