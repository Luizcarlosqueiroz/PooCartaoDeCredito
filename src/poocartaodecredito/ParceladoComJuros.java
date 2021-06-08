
package poocartaodecredito;

public class ParceladoComJuros extends ModalidadeCompra{

    private double juros;
    private int quantidadeParcelas;
    
    /**
     *
     * @return
     */
    @Override
    public double totalPagamento(){
        return 0;
    };
    
    public double valorPorParcela(int quantidadeParcelas, double valorCompra, double juros){
        return 0;
    };
}
