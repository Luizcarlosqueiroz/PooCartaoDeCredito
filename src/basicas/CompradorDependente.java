package basicas;

public class CompradorDependente extends Comprador {

    private String cpfDependente;
    
     public CompradorDependente(String cpfTitular, String nomeCompleto, String telefone, String endereco, String cpfDependente) {
        super(cpfTitular, nomeCompleto, telefone, endereco);
        this.cpfDependente = cpfDependente;
    }
    
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

    public String getCpfDependente() {
        return cpfDependente;
    }

    public void setCpfDependente(String cpfDependente) {
        this.cpfDependente = cpfDependente;
    }
    
}
