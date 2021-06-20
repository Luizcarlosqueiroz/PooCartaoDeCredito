package model;

import basicas.Compra;
import dados.CompraDados;

public class CompraNegocios {
    
    public void inserirCompra(Compra compra) throws Exception {
        if (compra == null) {
            throw new Exception("Insira dos dados da compra.");
        }
        
        if (compra.getHorarioCompra() == null){
            throw new Exception("Verificar data.");
        }
        if (compra.getModalidadePagamento() == null) {
            throw new Exception("Insira a modalidade de pagamento");
        }
        if (compra.getComprador() == null) {
            throw new Exception("Insira o comprador.");
        }
        if (compra.getVendedor() == null) {
            throw new Exception("Insira o vendedor");
        }
        
        if (compra.getValorBruto() <= 0) {
            throw new Exception("Insira o valor maior que R$ 0,00.");
        }
        
        if (compra.getTotalItens() <= 0) {
            throw new Exception("Insira uma quantidade de itens");
        }
        
        CompraDados dadosC = new CompraDados();
        dadosC.cadastrarCompra(compra);
    }
    
    public void atualizarCompra(Compra compra) throws Exception {
        if (compra == null) {
            throw new Exception("Insira dos dados da compra.");
        }
        
        if (compra.getHorarioCompra() == null){
            throw new Exception("Verificar data.");
        }
        if (compra.getModalidadePagamento() == null) {
            throw new Exception("Insira a modalidade de pagamento");
        }
        if (compra.getComprador() == null) {
            throw new Exception("Insira o comprador.");
        }
        if (compra.getVendedor() == null) {
            throw new Exception("Insira o vendedor");
        }
        
        if (compra.getValorBruto() <= 0) {
            throw new Exception("Insira o valor maior que R$ 0,00.");
        }
        
        if (compra.getTotalItens() <= 0) {
            throw new Exception("Insira uma quantidade de itens");
        }
        
        CompraDados dadosC = new CompraDados();
        dadosC.atualizarCompra(compra);
    }
    
    public void removerCompra(Compra compra) throws Exception {
        if (compra.getIdCompra() <= 0) {
            throw new Exception("Digite um código válido");
        }
        
        CompraDados dadosC = new CompraDados();
        dadosC.removerCompra(compra);
    }
}
