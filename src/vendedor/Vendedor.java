package vendedor;

public class Vendedor {
    
    private int idVendedor;
    private String cnpj;
    private String nomeFantasia;
    private String endereco;

    //public Vendedor(int idVendedor, String cnpj, String nomeFantasia, String endereco) {
    //    this.idVendedor = idVendedor;
    //    this.cnpj = cnpj;
    //    this.nomeFantasia = nomeFantasia;
    //    this.endereco = endereco;
    //}

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

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
