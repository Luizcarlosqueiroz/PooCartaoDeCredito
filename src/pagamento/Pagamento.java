package pagamento;

public class Pagamento {
    
    private double taxaOperacao;
    private int quantidadeParcelas;
    private double valorLiquido;
    private double valorParcela;
    
    public double calcularValorLiquido(double valorBruto, double taxaOperacao){
        return valorBruto * (1 - taxaOperacao);
    };
    
}
