package compra;

import compra.Compra;
import compra.CompraDados;

public class CompraNegocios {
    
    public void inserirCompra(Compra compra) throws Exception {
        if (compra == null) {
            throw new Exception("Insira dos dados da compra.");
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
        
        CompraDados dadosC = new CompraDados();
        dadosC.cadastrarCompra(compra);
    }
}
