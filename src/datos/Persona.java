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
public class Persona {
    private String nombre;
    private int DNI;
    private int edad;
    private String sexo;
    private ArrayList<Inmueble> alquileres;

    public Persona(String nombre, int DNI, int edad, String sexo) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.sexo = sexo;
        this.alquileres = new ArrayList<>();
    }
    
    public boolean alquilarInmueble(Inmueble inmueble){
        return this.alquileres.add(inmueble);
    }
    
    public boolean inmueblesAlquilados(Inmueble inmueble){
        boolean r = false;
        for(Inmueble rev : this.alquileres){
            if(rev.equals(inmueble))
                r = true;
            else
                r = false;
        }
        return r;
    }
    
    public boolean quitarInmueble(Inmueble inmueble){
        return this.alquileres.remove(inmueble);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public ArrayList<Inmueble> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(ArrayList<Inmueble> alquileres) {
        this.alquileres = alquileres;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", DNI=" + DNI + ", edad=" + edad + ", sexo=" + sexo + ", alquileres=" + alquileres + '}';
    }
    
    
    
}
