package comprador;

public class CompradorNegocio {
    
    public void inserirComprador(Comprador comprador) throws Exception {
        if (comprador == null) {
            throw new Exception("Insira os dados do comprador");
        }
        
        if (comprador.getCpfTitular() == null) {
            throw new Exception("Insira o CPF do comprador");   
        }
        if (comprador.getNomeCompleto() == null) {
            throw new Exception("Insira o nome do comprador");   
        }
        if (comprador.getTelefone() == null) {
            throw new Exception("Insira o telefone do comprador");   
        }
        if (comprador.getEndereco() == null) {
            throw new Exception("Insira o endereço do comprador");   
        }
        
        if (comprador.getCpfTitular().replaceAll("\\D+","").length() != 11) {
            throw new Exception("O CPF deve ter 11 números.");   
        }
        
        if (comprador.getNomeCompleto().length() < 5) {
            throw new Exception("O nome não pode conter menos de 5 caracteres.");
        }
        if (comprador.getNomeCompleto().length() > 40) {
            throw new Exception("O nome não pode conter mais de 40 caracteres.");
        }
        
        if (comprador.getTelefone().replaceAll("\\D+","").length() != 11) {
            throw new Exception("O telefone deve ter DDD e 9 números.");   
        }
        
        if (comprador.getEndereco().length() < 5) {
            throw new Exception("O endereço não pode conter menos de 5 caracteres.");
        }
        if (comprador.getEndereco().length() > 50) {
            throw new Exception("O endereço não pode conter mais de 50 caracteres.");
        }
        
        CompradorDados dadosC = new CompradorDados();
        dadosC.cadastrarComprador(comprador);
    }
    
    public void atualizarComprador(Comprador comprador) throws Exception {
        if (comprador == null) {
            throw new Exception("Insira os dados do comprador");
        }
        
        if (comprador.getCpfTitular() == null) {
            throw new Exception("Insira o CPF do comprador");   
        }
        if (comprador.getNomeCompleto() == null) {
            throw new Exception("Insira o nome do comprador");   
        }
        if (comprador.getTelefone() == null) {
            throw new Exception("Insira o telefone do comprador");   
        }
        if (comprador.getEndereco() == null) {
            throw new Exception("Insira o endereço do comprador");   
        }
        
        if (comprador.getCpfTitular().replaceAll("\\D+","").length() != 11) {
            throw new Exception("O CPF deve ter 11 números.");   
        }
        
        if (comprador.getNomeCompleto().length() < 5) {
            throw new Exception("O nome não pode conter menos de 5 caracteres.");
        }
        if (comprador.getNomeCompleto().length() > 40) {
            throw new Exception("O nome não pode conter mais de 40 caracteres.");
        }
        
        if (comprador.getTelefone().replaceAll("\\D+","").length() != 11) {
            throw new Exception("O telefone deve ter DDD e 9 números.");   
        }
        
        if (comprador.getEndereco().length() < 5) {
            throw new Exception("O endereço não pode conter menos de 5 caracteres.");
        }
        if (comprador.getEndereco().length() > 50) {
            throw new Exception("O endereço não pode conter mais de 50 caracteres.");
        }
        
        CompradorDados dadosC = new CompradorDados();
        dadosC.atualizarComprador(comprador);
    }
        
    public void removerComprador(Comprador comprador) throws Exception {
        if (comprador.getIdComprador() <= 0) {
            throw new Exception("Digite um código válido");
        }
        
        CompradorDados dadosC = new CompradorDados();
        dadosC.removerComprador(comprador);
    }
}
