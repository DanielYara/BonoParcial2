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
public class Local extends Inmueble{
    private String descripcion;
    private boolean viaPrincipal;

    public Local(int code, String barrio, int estrato, int valorArriendo, double areaConstruida, String descripcion, boolean viaPrincipal) {
        super(code, barrio, estrato, valorArriendo, areaConstruida);
        this.descripcion = descripcion;
        this.viaPrincipal = viaPrincipal;
    }

    @Override
    public String darInformacion() {
        if(viaPrincipal)
            return "Local: " + this.descripcion + ", ubicado en una via principal, " + super.toString() + ".\n";
        else
            return "Local: " + this.descripcion + ", " + super.toString() + ".\n";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isViaPrincipal() {
        return viaPrincipal;
    }

    public void setViaPrincipal(boolean viaPrincipal) {
        this.viaPrincipal = viaPrincipal;
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
    public String getBarrio() {
        return barrio;
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
