package basicas;

public abstract class Comprador {

    protected int idComprador;
    protected String cpfTitular;
    protected String nomeCompleto;
    protected String telefone;
    protected String endereco;

    //public Comprador(String cpfTitular, String nomeCompleto, String telefone, String endereco) {
    //    this.cpfTitular = cpfTitular;
    //    this.nomeCompleto = nomeCompleto;
    //    this.telefone = telefone;
    //    this.endereco = endereco;
    //}
    
    public abstract int getIdComprador();

    public abstract void setIdComprador(int idComprador);
    
    public abstract String getCpfTitular();

    public abstract void setCpfTitular(String cpfTitular);

    public abstract String getNomeCompleto();

    public abstract void setNomeCompleto(String nomeCompleto);

    public abstract String getTelefone();

    public abstract void setTelefone(String telefone);

    public abstract String getEndereco();

    public abstract void setEndereco(String endereco);



}
