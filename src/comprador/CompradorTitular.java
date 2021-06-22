package comprador;

public class CompradorTitular extends Comprador{
    

    //public CompradorTitular(String cpfTitular, String nomeCompleto, String telefone, String endereco) {
    //    super(cpfTitular, nomeCompleto, telefone, endereco);
    //}
    
    @Override
    public String getCpfTitular() {
        return cpfTitular;
    }

    @Override
    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    @Override
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    @Override
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int getIdComprador() {
        return idComprador;
    }

    @Override
    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }
}
