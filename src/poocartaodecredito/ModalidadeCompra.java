
package poocartaodecredito;

public class ModalidadeCompra {
    
    private boolean compraParcelada;
    private boolean compraParceladaJuros;
    private double valorCompra;
    
    public double totalPagamento(){
        return 0;  
    };

    public boolean isCompraParcelada() {
        return compraParcelada;
    }

    public void setCompraParcelada(boolean compraParcelada) {
        this.compraParcelada = compraParcelada;
    }

    public boolean isCompraParceladaJuros() {
        return compraParceladaJuros;
    }

    public void setCompraParceladaJuros(boolean compraParceladaJuros) {
        this.compraParceladaJuros = compraParceladaJuros;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }
}
