package cartao;

import comprador.Comprador;
import instituicaoFinanceira.InstituicaoFinanceira;
import java.util.Date;

public class CartaoDeCredito {
    
    private int idCartaoDeCredito;
    private Date validade;
    private String numbCartao;
    private String nomeImpressoCartao;
    private String cvv;
    private String bandeira;
    private String senha;
    private Comprador comprador;
    private InstituicaoFinanceira instituicaoFinanceira;

    //public CartaoDeCredito(Date validade, String numbCartao, String nomeImpressoCartao, String cvv, String bandeira, int senha, Comprador comprador, InstituicaoFinanceira instituicaoFinanceira) {
    //    this.validade = validade;
    //    this.numbCartao = numbCartao;
    //    this.nomeImpressoCartao = nomeImpressoCartao;
    //    this.cvv = cvv;
    //    this.bandeira = bandeira;
    //    this.senha = senha;
    //    this.comprador = comprador;
    //    this.instituicaoFinanceira = instituicaoFinanceira;
    //}

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getNumbCartao() {
        return numbCartao;
    }

    public void setNumbCartao(String numbCartao) {
        this.numbCartao = numbCartao;
    }

    public String getNomeImpressoCartao() {
        return nomeImpressoCartao;
    }

    public void setNomeImpressoCartao(String nomeImpressoCartao) {
        this.nomeImpressoCartao = nomeImpressoCartao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public InstituicaoFinanceira getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(InstituicaoFinanceira instituicaoFinanceira) {
        this.instituicaoFinanceira = instituicaoFinanceira;
    }

    public int getIdCartaoDeCredito() {
        return idCartaoDeCredito;
    }

    public void setIdCartaoDeCredito(int idCartaoDeCredito) {
        this.idCartaoDeCredito = idCartaoDeCredito;
    }
            
}
