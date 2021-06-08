
package poocartaodecredito;

public class Cliente {
    
    private String nome;
    private String cpf;
    private String cidade;
    private String endereco;
    private int idade;
    private int telefone;
    private int numeroCartaoCredito;
    private String bancoConta;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdade() {
        return idade;
    }

    public int getTelefone() {
        return telefone;
    }

    public int getNumeroCartaoCredito() {
        return numeroCartaoCredito;
    }

    public String getBancoConta() {
        return bancoConta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setNumeroCartaoCredito(int numeroCartaoCredito) {
        this.numeroCartaoCredito = numeroCartaoCredito;
    }

    public void setBancoConta(String bancoConta) {
        this.bancoConta = bancoConta;
    }
    
}
