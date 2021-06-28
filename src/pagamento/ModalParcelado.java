package pagamento;

import pagamento.Pagamento;

public class ModalParcelado extends Pagamento {
    
    private final double taxaOperacao = 0.0499;
    private int quantidadeMaxParcelas;
    private int quantidadeParcelas;
    private double valorParcela;
    private double taxaTotal;

    public double calcularValorParcelas (double valorBruto, int quantidadeParcelas) {
        valorParcela = valorBruto / quantidadeParcelas;
        return valorParcela;
    }
    
    public double getTaxaOperacao() {
        return taxaOperacao;
    }
 
    public void setQuantidadeMaxParcelas (double valorBruto) {
        int quantidade = 1;
        
        if (valorBruto>=100 && valorBruto<150){
            quantidade = 2;
        } 
        else if (valorBruto>=150){
            quantidade = 3;
        }
        
        this.quantidadeMaxParcelas = quantidade;
    }

    public int getQuantidadeMaxParcelas() {
        return quantidadeMaxParcelas;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public double getTaxaTotal() {
        return taxaTotal;
    }

    public void setTaxaTotal(int quantidadeParcelas) {
        this.taxaTotal = (quantidadeParcelas * 0.0299) + taxaOperacao;
    }
}
