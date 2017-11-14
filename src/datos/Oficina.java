/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Jose Daniel Yara Sepúlveda
 */
public class Oficina extends Inmueble{
    private String tipo;

    public Oficina(int code, String barrio, int estrato, int valorArriendo, double areaConstruida, String tipo) {
        super(code, barrio, estrato, valorArriendo, areaConstruida);
        this.tipo = tipo;
    }

    @Override
    public String darInformacion() {
        return "Oficina: " + super.toString() + ", tipo: " + this.tipo + ".\n";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String getBarrio() {
        return barrio;
    }
    @Override
    public int getCode() {
        return code;
    }
    @Override
    public void setCode(int code) {
        this.code = code;
    }
    @Override
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
    @Override
    public int getEstrato() {
        return estrato;
    }
    @Override
    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }
    @Override
    public int getValorArriendo() {
        return valorArriendo;
    }
    @Override
    public void setValorArriendo(int valorArriendo) {
        this.valorArriendo = valorArriendo;
    }
    @Override
    public double getAreaConstruida() {
        return areaConstruida;
    }
    @Override
    public void setAreaConstruida(double areaConstruida) {
        this.areaConstruida = areaConstruida;
    }
    
    
}
