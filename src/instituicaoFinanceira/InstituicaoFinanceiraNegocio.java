package instituicaoFinanceira;

import instituicaoFinanceira.InstituicaoFinanceira;
import instituicaoFinanceira.InstituicaoFinanceiraDados;

public class InstituicaoFinanceiraNegocio {
    
    public void inserirInstituicaoFinanceira(InstituicaoFinanceira instituicaoFinanceira) throws Exception{
        if (instituicaoFinanceira == null) {
            throw new Exception("Insira os dados da instituição financeira.");
        }
        
        if (instituicaoFinanceira.getCnpj() == null) {
            throw new Exception("Insira o CNPJ.");
        }
        if (instituicaoFinanceira.getNomeFantasia() == null) {
            throw new Exception("Insira o nome fantasia.");
        }
        if (instituicaoFinanceira.getEndereco() == null) {
            throw new Exception("Insira o endereço da instituição financeira.");
        }
                
        if (instituicaoFinanceira.getCnpj().replaceAll("\\D+","").length() != 14){
            throw new Exception("O CNPJ deve ter 14 números.");
        }
        
        if (instituicaoFinanceira.getNomeFantasia().length() < 5) {
            throw new Exception("O nome não pode conter menos de 5 caracteres.");
        }
        if (instituicaoFinanceira.getNomeFantasia().length() > 40) {
            throw new Exception("O nome não pode conter mais de 40 caracteres.");
        }
        
        if (instituicaoFinanceira.getEndereco().length() < 5) {
            throw new Exception("O endereço não pode conter menos de 5 caracteres.");
        }
        if (instituicaoFinanceira.getEndereco().length() > 50) {
            throw new Exception("O endereço não pode conter mais de 50 caracteres.");
        }
        
        InstituicaoFinanceiraDados dadosIF = new InstituicaoFinanceiraDados();
        dadosIF.cadastrarInstituicaoFinanceira(instituicaoFinanceira);
    }
    
    public void atualizarInstituicaoFinanceira(InstituicaoFinanceira instituicaoFinanceira) throws Exception {
        if (instituicaoFinanceira == null) {
            throw new Exception("Insira os dados da instituição financeira.");
        }
        
        if (instituicaoFinanceira.getCnpj() == null) {
            throw new Exception("Insira o CNPJ.");
        }
        if (instituicaoFinanceira.getNomeFantasia() == null) {
            throw new Exception("Insira o nome fantasia.");
        }
        if (instituicaoFinanceira.getEndereco() == null) {
            throw new Exception("Insira o endereço do lojista.");
        }
                
        if (instituicaoFinanceira.getCnpj().replaceAll("\\D+","").length() != 14){
            throw new Exception("O CNPJ deve ter 14 números.");
        }
        
        if (instituicaoFinanceira.getNomeFantasia().length() < 5) {
            throw new Exception("O nome não pode conter menos de 5 caracteres.");
        }
        if (instituicaoFinanceira.getNomeFantasia().length() > 40) {
            throw new Exception("O nome não pode conter mais de 40 caracteres.");
        }
        
        if (instituicaoFinanceira.getEndereco().length() < 5) {
            throw new Exception("O endereço não pode conter menos de 5 caracteres.");
        }
        if (instituicaoFinanceira.getEndereco().length() > 50) {
            throw new Exception("O endereço não pode conter mais de 50 caracteres.");
        }
        
        InstituicaoFinanceiraDados dadosIF = new InstituicaoFinanceiraDados();
        dadosIF.atualizarInstituicaoFinanceira(instituicaoFinanceira);
    }
    
    public void removerInstituicaoFinanceira(InstituicaoFinanceira instituicaoFinanceira) throws Exception {
        if (instituicaoFinanceira.getIdInstituicaoFinanceira() <= 0){
            throw new Exception("Digite um código váilido");
        }
        
        InstituicaoFinanceiraDados dadosIF = new InstituicaoFinanceiraDados();
        dadosIF.removerInstituicaoFinanceira(instituicaoFinanceira);
    }
}
