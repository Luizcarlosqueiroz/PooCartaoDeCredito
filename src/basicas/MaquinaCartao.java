package basicas;

import java.util.List;

public class MaquinaCartao {
    
    private int id;
    private String modelo;
    private String marca;
    private List<String> bandeirasAceitas;

    public MaquinaCartao(int id, String modelo, String marca, List<String> bandeirasAceitas) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.bandeirasAceitas = bandeirasAceitas;
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

    
    
}
