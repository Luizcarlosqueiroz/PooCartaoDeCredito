package basicas;

public class InstituicaoFinanceira {
    
    private String cnpj;
    private String nomeFantasia;
    private String endereco;

    public InstituicaoFinanceira(String cnpj, String nomeFantasia, String endereco) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
