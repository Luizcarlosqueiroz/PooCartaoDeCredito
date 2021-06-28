package pagamento;

public class ModalCredito extends Pagamento {

    private double taxaOperacao = 0.0499;
    
    public double getTaxaOperacao() {
        return taxaOperacao;
    }
}
