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
public class SistemaInformacion {
    private ArrayList<Persona> propietarios;
    private ArrayList<Persona> clientes;

    public SistemaInformacion() {
        this.propietarios = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }
    
    public void añadCliente(String nombre, int DNI, int edad, String sexo){
        Persona cliente = new Persona(nombre, DNI, edad, sexo);
        this.clientes.add(cliente);
    }
    
    public boolean modDatosCliente(int i, int DNI, String type, String change){
        boolean r = false;
        if(type.equals("N")){
            this.clientes.get(i).setNombre(change);
            for(int k = 0; k < this.propietarios.size(); k++){
                if(this.propietarios.get(k).getDNI() == DNI){
                    this.propietarios.get(k).setNombre(change);
                }
            }
            r = true;
        } else if(type.equals("E")){
            int edad = Integer.parseInt(change);
            this.clientes.get(i).setEdad(edad);
            for(int k = 0; k < this.propietarios.size(); k++){
                if(this.propietarios.get(k).getDNI() == DNI){
                    this.propietarios.get(k).setEdad(edad);
                }
            }
            r = true;
        } else if(type.equals("S")){
            this.clientes.get(i).setSexo(change);
            for(int k = 0; k < this.propietarios.size(); k++){
                if(this.propietarios.get(k).getDNI() == DNI){
                    this.propietarios.get(k).setSexo(change);
                }
            }
            r = true;
        } else if(type.equals("ID")){
            int dni = Integer.parseInt(change);
            this.clientes.get(i).setDNI(dni);
            for(int k = 0; k < this.propietarios.size(); k++){
                if(this.propietarios.get(k).getDNI() == DNI){
                    this.propietarios.get(k).setDNI(dni);
                }
            }
            r = true;
        } else
            r = false;
        return r;
    }
    
    public boolean elimC(int DNI){
        boolean r = false;
        for(int i = 0; i < this.clientes.size(); i++){
            if(this.clientes.get(i).getDNI() == DNI){
                this.clientes.remove(i);
                for(int k = 0; k < this.propietarios.size(); k++){
                    if(this.propietarios.get(k).getDNI() == DNI){
                        this.propietarios.remove(k);
                    }
                }
                r = true;
            } else 
                r = false;
        }
        return r;
    }
    
    public boolean añadPropietario(int DNI){
        boolean r = false;
        for(int i = 0; i < this.clientes.size(); i++){
            if(this.clientes.get(i).getDNI() == DNI){
                this.propietarios.add(this.clientes.get(i));
                r = true;
            } else
                r = false;
        }
        return r;
    }
    
    public boolean clienteAlquiler(int dni, Inmueble inmueble){
        boolean f = false;
        for(int i = 0; i < this.clientes.size(); i++){
            if(this.clientes.get(i).getDNI() == dni){
                this.clientes.get(i).alquilarInmueble(inmueble);
                f = true;
            } else f = false;
        }
        return f;
    }
    
    public boolean clientenoAlquiler(int dni, Inmueble inmueble){
        boolean c = false;
        for(int i = 0; i < this.clientes.size(); i++){
            if(this.clientes.get(i).getDNI() == dni){
                this.clientes.get(i).quitarInmueble(inmueble);
                c = true;
            } else c = false;
        }
        return c;
    }

    public ArrayList<Persona> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(ArrayList<Persona> propietarios) {
        this.propietarios = propietarios;
    }

    public ArrayList<Persona> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Persona> clientes) {
        this.clientes = clientes;
    }
            
           
    
}
