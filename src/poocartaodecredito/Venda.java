
package poocartaodecredito;

import java.util.Date;

public class Venda {
    
    private int codigoCompra;
    private int quantidadeItens;
    private double valor;
    private String produtos;
    private Date horarioCompra;
    private ModalidadeCompra modalidadeCompra;

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    public Date getHorarioCompra() {
        return horarioCompra;
    }

    public void setHorarioCompra(Date horarioCompra) {
        this.horarioCompra = horarioCompra;
    }

    public Lojista getLojista() {
        return lojista;
    }

    public void setLojista(Lojista lojista) {
        this.lojista = lojista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    private Lojista lojista;
    private Cliente cliente;

    public ModalidadeCompra getModalidadeCompra() {
        return modalidadeCompra;
    }

    public void setModalidadeCompra(ModalidadeCompra modalidadeCompra) {
        this.modalidadeCompra = modalidadeCompra;
    }

}
