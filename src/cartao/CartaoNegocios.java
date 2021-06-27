package cartao;



public class CartaoNegocios {
    
    public void CadastrarCartao(CartaoDeCredito cartao) throws Exception {
        if (cartao == null) {
            throw new Exception("Insira os dados do cartao.");
        }
        
        if (cartao.getValidade() == null) {
            throw new Exception("Insira a validade do cartão.");
        }
        if (cartao.getNumbCartao() == null) {
            throw new Exception("Insira o número do cartão.");
        }
        if (cartao.getNomeImpressoCartao() == null) {
            throw new Exception("Insira o nome impresso no cartão.");
        }
        if (cartao.getCvv() == null) {
            throw new Exception("Insira o CVV.");
        }
        if (cartao.getBandeira() == null) {
            throw new Exception("Insira a bandeira do cartão.");
        }
        if (cartao.getComprador() == null) {
            throw new Exception("Insira o comprador do cartão.");
        }
        if (cartao.getInstituicaoFinanceira() == null) {
            throw new Exception("Insira a instituição financeira do cartão.");
        }
        
        if (cartao.getNumbCartao().replaceAll("\\D+","").length() != 16) {
            throw new Exception("O número do cartão deve conter 16 digitos.");
        }
        if (cartao.getNumbCartao().matches("[0-9]+") != true) {
            throw new Exception("O campo de número de cartão deve contar apenas números.");
        }
        
        if (cartao.getNomeImpressoCartao().trim().length() < 8 || cartao.getNomeImpressoCartao().trim().length() >= 26) {
            throw new Exception("O nome impresso no cartao deve conter entre 8 e 25 caracteres.");
        }
        
        if (cartao.getCvv().length() != 3){
            throw new Exception("O CVV tem apenas 3 dígitos.");
        }
        if (cartao.getCvv().matches("[0-9]+") != true) {
            throw new Exception("O campo de CVV deve contar apenas números.");
        }
        
        if (cartao.getBandeira().trim().length() < 3 || cartao.getBandeira().trim().length() >= 20) {
            throw new Exception("Insira uma bandeira válida.");
        }
        
        if (cartao.getSenha().matches("[0-9]+") != true){
            throw new Exception("A senha de cartão deve contar apenas números.");
        }
        if (cartao.getSenha().trim().length() >= 10) {
            throw new Exception("O de senha deve ter até 10 números.");
        }
        
        CartaoDeCreditoDados dados = new CartaoDeCreditoDados();
        dados.cadastrarCartaoDeCredito(cartao);
    }
    
    public void atualizarCartao(CartaoDeCredito cartao) throws Exception {
        if (cartao == null) {
            throw new Exception("Insira os dados do cartao.");
        }
        
        if (cartao.getValidade() == null) {
            throw new Exception("Insira a validade do cartão.");
        }
        if (cartao.getNumbCartao() == null) {
            throw new Exception("Insira o número do cartão.");
        }
        if (cartao.getNomeImpressoCartao() == null) {
            throw new Exception("Insira o nome impresso no cartão.");
        }
        if (cartao.getCvv() == null) {
            throw new Exception("Insira o CVV.");
        }
        if (cartao.getBandeira() == null) {
            throw new Exception("Insira a bandeira do cartão.");
        }
        if (cartao.getComprador() == null) {
            throw new Exception("Insira o comprador do cartão.");
        }
        if (cartao.getInstituicaoFinanceira() == null) {
            throw new Exception("Insira a instituição financeira do cartão.");
        }
        
        if (cartao.getNumbCartao().replaceAll("\\D+","").length() != 16) {
            throw new Exception("O número do cartão deve conter 16 digitos.");
        }
        if (cartao.getNumbCartao().matches("[0-9]+") != true) {
            throw new Exception("O campo de número de cartão deve contar apenas números.");
        }
        
        if (cartao.getNomeImpressoCartao().trim().length() < 8 || cartao.getNomeImpressoCartao().trim().length() >= 26) {
            throw new Exception("O nome impresso no cartao deve conter entre 8 e 25 caracteres.");
        }
        
        if (cartao.getCvv().length() != 3){
            throw new Exception("O CVV tem apenas 3 dígitos.");
        }
        if (cartao.getCvv().matches("[0-9]+") != true) {
            throw new Exception("O campo de CVV deve contar apenas números.");
        }
        
        if (cartao.getBandeira().trim().length() < 3 || cartao.getBandeira().trim().length() >= 20) {
            throw new Exception("Insira uma bandeira válida.");
        }
        
        if (cartao.getSenha().matches("[0-9]+") != true){
            throw new Exception("A senha de cartão deve contar apenas números.");
        }
        if (cartao.getSenha().trim().length() >= 10) {
            throw new Exception("O de senha deve ter até 10 números.");
        }
        CartaoDeCreditoDados dadosC = new CartaoDeCreditoDados();
        dadosC.atualizarCartaoDeCredito(cartao);
    }
    
    public void removerCartao (CartaoDeCredito cartao) throws Exception {
        if (cartao.getIdCartaoDeCredito() <= 0) {
            throw new Exception("Digite um código válido.");
        }
        
        CartaoDeCreditoDados dadosC = new CartaoDeCreditoDados();
        dadosC.removerCartaoDeCredito(cartao);
    }
}
