package basicas;

public class ModalParcelado extends Pagamento {
    
    private final double taxaOperacao = 0.0499;
    private int quantidadeParcelas;
    private double valorParcela;
    private double valorAcrescimoParcela;

    public double calcularValorParcelas (double valorBruto, int quantidadeParcelas) {
        valorParcela = valorBruto / quantidadeParcelas;
        return valorParcela;
    }
    
    public double acrescimoPorParcela (double valorParcela, int quantidadeParcelas) {
        if (quantidadeParcelas > 1) {
            valorAcrescimoParcela = valorParcela * 0.0299;
        } else {
            valorAcrescimoParcela = 0;
        }
        return valorAcrescimoParcela;
    }
}
