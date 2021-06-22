package maquinaCartao;

import cartao.CartaoDeCredito;
import pagamento.Pagamento;
import java.util.List;

public class MaquinaCartao {
    
    private int id;
    private String modelo;
    private String marca;
    private List<String> bandeirasAceitas;
    private Pagamento pagamento;
    private CartaoDeCredito cartaoCredito;

    public MaquinaCartao(int id, String modelo, String marca, List<String> bandeirasAceitas, Pagamento pagamento, CartaoDeCredito cartaoCredito) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.bandeirasAceitas = bandeirasAceitas;
        this.pagamento = pagamento;
        this.cartaoCredito = cartaoCredito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<String> getBandeirasAceitas() {
        return bandeirasAceitas;
    }

    public void setBandeirasAceitas(List<String> bandeirasAceitas) {
        this.bandeirasAceitas = bandeirasAceitas;
    }

    public Pagamento getModalidadePagamento() {
        return pagamento;
    }

    public void setModalidadePagamento(Pagamento modalidadePagamento) {
        this.pagamento = modalidadePagamento;
    }

    public CartaoDeCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoDeCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }
}
