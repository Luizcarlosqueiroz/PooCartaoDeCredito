package pagamento;

public class ModalCredito extends Pagamento {

    private double taxaOperacao = 0.0199;
    
    public double getTaxaOperacao() {
        return taxaOperacao;
    }
}
