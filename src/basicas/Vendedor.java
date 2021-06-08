package basicas;

public class Vendedor {
    
    private String cnjp;
    private String nomeFantasia;
    private String endereco;

    public Vendedor(String cnjp, String nomeFantasia, String endereco) {
        this.cnjp = cnjp;
        this.nomeFantasia = nomeFantasia;
        this.endereco = endereco;
    }

    public String getCnjp() {
        return cnjp;
    }

    public void setCnjp(String cnjp) {
        this.cnjp = cnjp;
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
