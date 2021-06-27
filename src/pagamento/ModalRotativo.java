package pagamento;

import pagamento.Pagamento;

public class ModalRotativo extends Pagamento {
    
    private final double taxaOperacao = 0.0499;

    public double getTaxaOperacao() {
        return taxaOperacao;
    }
    
}
