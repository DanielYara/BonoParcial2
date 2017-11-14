/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.*;

/**
 *
 * @author Jose Daniel Yara Sepúlveda
 */
public class Piso extends Inmueble{
    private ArrayList<Oficina> oficinas;
    private int numOficinas;
    private int aux;

    public Piso(int code, String barrio, int estrato, int valorArriendo, double areaConstruida, int numOficinas) {
        super(code, barrio, estrato, valorArriendo, areaConstruida);
        this.oficinas = new ArrayList<>();
        this.numOficinas = numOficinas;
        this.aux = numOficinas;
    }
    
    public boolean añadOficinas(Oficina o){
        if(this.numOficinas > 0 && this.numOficinas <= this.aux){
            this.numOficinas--;
            this.oficinas.add(o);
            return true;
       } else
           return false;
    }
    
    public boolean elimOficina(Oficina o){
        if(this.numOficinas >= 0 && this.numOficinas < this.aux){
            this.numOficinas++;
            this.oficinas.remove(o);
            return true;
        } else
            return false;
    }

    @Override
    public String darInformacion() {
        String info = "";
        for(Oficina of : this.oficinas){
            info += of.darInformacion().replaceFirst("Oficina:", ("Oficina " + (this.oficinas.indexOf(of) + 1) + ":"));
        }
        return "Piso: "+ super.toString()+ ",\nOficinas:\n" + info;
    }

    public ArrayList<Oficina> getOficinas() {
        return oficinas;
    }

    public void setOficinas(ArrayList<Oficina> oficinas) {
        this.oficinas = oficinas;
    }

    public int getNumOficinas() {
        return numOficinas;
    }

    public void setNumOficinas(int numOficinas) {
        this.numOficinas = numOficinas;
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
