/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;

/**
 *
 * @author Jose Daniel Yara Sepúlveda
 */
public class Edificio extends Inmueble{
    private ArrayList<Local> locales;
    private ArrayList<Piso> pisos;
    private Persona propietario = null;
    private int numPisosLibre;
    private int numLocalesLibre;
    private int aux;
    private int aux2;
    
    public Edificio(int code, String barrio, int estrato, int valorArriendo, double areaConstruida,  
            int numPisos, int numLocales, Persona propietario) {
        super(code, barrio, estrato, valorArriendo, areaConstruida);
        this.propietario = propietario;
        this.locales = new ArrayList<>();
        this.pisos = new ArrayList<>();
        this.numPisosLibre = numPisos;
        this.numLocalesLibre = numLocales;
        this.aux = numLocales;
        this.aux2 = numPisos;
    }
    
    public boolean añadLocal(Local local){
       if(this.numLocalesLibre > 0 && this.numLocalesLibre <= this.aux){
            this.numLocalesLibre--;
            this.locales.add(local);
            return true;
       } else
           return false;
    }
    
    public boolean elimLocal(Local local){
        if(this.numLocalesLibre >= 0 && this.numLocalesLibre < this.aux){
            this.numLocalesLibre++;
            this.locales.remove(local);
            return true;
        } else
            return false;
    }
    
    public boolean añadPiso(Piso piso){
        if(this.numPisosLibre > 0 && this.numPisosLibre <= this.aux2){
            this.numPisosLibre--;
            this.pisos.add(piso);
            return true;
       } else
           return false;
    }
    
    public boolean elimPiso(Piso piso){
        if(this.numPisosLibre >= 0 && this.numPisosLibre <= this.aux2){
            this.numPisosLibre++;
            this.pisos.remove(piso);
            return true;
        } else
            return false;
    }
    
    public String darPisosLocalesDisp(){
        return "Hay " + this.numLocalesLibre + " locales y " + this.numPisosLibre + " pisos disponibles";
    }
    

    @Override
    public String darInformacion() {
        String info1 = "Locales:\n";
        for(Local l : this.locales){
            info1 += l.darInformacion().replaceFirst("Local:", ("Local " + (this.locales.indexOf(l) +1) + ":"));
        }
        String info2 = "Pisos:\n";
        for(Piso p : this.pisos){
            info2 += p.darInformacion().replaceFirst("Piso:", ("Piso " + (this.pisos.indexOf(p) + 1) + ":"));
        }
        String informacion = "Edificio:  Propietario: " + this.propietario.getNombre() + ", " + super.toString() + ",\n" + info1 + info2;
        return informacion;
    }

    public ArrayList<Local> getLocales() {
        return locales;
    }

    public void setLocales(ArrayList<Local> locales) {
        this.locales = locales;
    }

    public ArrayList<Piso> getPisos() {
        return pisos;
    }

    public void setPisos(ArrayList<Piso> pisos) {
        this.pisos = pisos;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public int getNumPisosLibre() {
        return numPisosLibre;
    }

    public void setNumPisosLibre(int numPisosLibre) {
        this.numPisosLibre = numPisosLibre;
    }

    public int getNumLocalesLibre() {
        return numLocalesLibre;
    }

    public void setNumLocalesLibre(int numLocalesLibre) {
        this.numLocalesLibre = numLocalesLibre;
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
