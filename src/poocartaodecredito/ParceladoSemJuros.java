
package poocartaodecredito;

public class ParceladoSemJuros extends ModalidadeCompra{
 
    private int quantidadeParcelas;
    
    /**
     *
     * @return
     */
    @Override
    public double totalPagamento(){
        return 0;
    };
    
    public double valorPorParcela(int quantidadeParcelas, double valorCompra){
        return 0;
    };
}
