/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.*;
import java.util.function.Predicate;

/**
 *
 * @author Jose Daniel Yara Sepúlveda
 */
public class FincaRaiz {
    private ArrayList<Inmueble> inmuebles;
    private SistemaInformacion sistema;

    public FincaRaiz() {
        this.inmuebles = new ArrayList<>();
        this.sistema = new SistemaInformacion();
    }
    
    public void añadInmueble(Oficina o){
        this.inmuebles.add(o);
    }
    
    public void añadInmueble(Local l){
        this.inmuebles.add(l);
    }
    
    public void añadInmueble(Piso p){
        this.inmuebles.add(p);
    }
    
    public void añadInmueble(Edificio ef){
            this.inmuebles.add(ef);
    }
    
    public boolean modDatosInmueble(int code, String type, String ntype, String change){
        boolean res = false;
        for(int i = 0; i < this.inmuebles.size(); i++){
            if(code == this.inmuebles.get(i).getCode()){
                //Para Oficina
                if(type.equals("O")){
                    //Datos Oficina
                    if(ntype.equals("B")){
                        this.inmuebles.get(i).setBarrio(change);
                        res = true;
                    } else if(ntype.equals("E")){
                        int c = Integer.parseInt(change);
                        this.inmuebles.get(i).setEstrato(c);
                        res = true;
                    } else if(ntype.equals("V")){
                        int v = Integer.parseInt(change);
                        this.inmuebles.get(i).setValorArriendo(v);
                        res = true;
                    } else if(ntype.equals("A")){
                        double c = Double.parseDouble(change);
                        this.inmuebles.get(i).setAreaConstruida(c);
                        res = true;
                    } else if(ntype.equals("T")){
                        Oficina o = (Oficina) this.inmuebles.get(i);
                        o.setTipo(change);
                        this.inmuebles.set(i, o);
                        res = true;
                    } else res = false;
                } //Para Local
                else if(type.equals("L")){
                    //Datos Local
                    if(ntype.equals("B")){
                        this.inmuebles.get(i).setBarrio(change);
                        res = true;
                    } else if(ntype.equals("E")){
                        int c = Integer.parseInt(change);
                        this.inmuebles.get(i).setEstrato(c);
                        res = true;
                    } else if(ntype.equals("V")){
                        int v = Integer.parseInt(change);
                        this.inmuebles.get(i).setValorArriendo(v);
                        res = true;
                    } else if(ntype.equals("A")){
                        double c = Double.parseDouble(change);
                        this.inmuebles.get(i).setAreaConstruida(c);
                        res = true;
                    } else if(ntype.equals("D")){
                        Local l = (Local) this.inmuebles.get(i);
                        l.setDescripcion(change);
                        this.inmuebles.set(i, l);
                        res = true;
                    } else if(ntype.equals("VP")){
                        Local l = (Local) this.inmuebles.get(i);
                        boolean r = Boolean.parseBoolean(change);
                        l.setViaPrincipal(r);
                        this.inmuebles.set(i, l);
                        res = true;
                    } else res = false;
                } //Para Piso
                else if(type.equals("P")){
                    //Datos Piso
                    if(ntype.equals("B")){
                        this.inmuebles.get(i).setBarrio(change);
                        res = true;
                    } else if(ntype.equals("E")){
                        int c = Integer.parseInt(change);
                        this.inmuebles.get(i).setEstrato(c);
                        res = true;
                    } else if(ntype.equals("V")){
                        int v = Integer.parseInt(change);
                        this.inmuebles.get(i).setValorArriendo(v);
                        res = true;
                    } else if(ntype.equals("A")){
                        double c = Double.parseDouble(change);
                        this.inmuebles.get(i).setAreaConstruida(c);
                        res = true;
                    } else if(ntype.equals("numO")){
                        Piso p = (Piso) this.inmuebles.get(i);
                        int num = Integer.parseInt(change);
                        p.setNumOficinas(num);
                        this.inmuebles.set(i, p);
                        res = true;
                    } else res = false;
                } //Para Edificio
                else if(type.equals("E")){
                    //Datos Edificio
                    if(ntype.equals("B")){
                        this.inmuebles.get(i).setBarrio(change);
                        res = true;
                    } else if(ntype.equals("E")){
                        int c = Integer.parseInt(change);
                        this.inmuebles.get(i).setEstrato(c);
                        res = true;
                    } else if(ntype.equals("V")){
                        int v = Integer.parseInt(change);
                        this.inmuebles.get(i).setValorArriendo(v);
                        res = true;
                    }  else if(ntype.equals("A")){
                        double c = Double.parseDouble(change);
                        this.inmuebles.get(i).setAreaConstruida(c);
                        res = true;
                    } else if(ntype.equals("P")){
                        Edificio e = (Edificio) this.inmuebles.get(i);
                        int c = Integer.parseInt(change);
                        Persona p = null;
                        for(int k = 0; k < this.sistema.getPropietarios().size(); k++){
                            if(this.sistema.getPropietarios().get(k).getDNI() == c){
                                p = this.sistema.getPropietarios().get(k);
                                e.setPropietario(p);
                                this.inmuebles.set(i, e);
                                res = true;
                            } else
                                res = false;
                        }
                    } else if(ntype.equals("numP")){
                        Edificio e = (Edificio) this.inmuebles.get(i);
                        int num = Integer.parseInt(change);
                        e.setNumPisosLibre(num);
                        this.inmuebles.set(i, e);
                        res = true;
                    }  else if(ntype.equals("numL")){
                        Edificio e = (Edificio) this.inmuebles.get(i);
                        int num = Integer.parseInt(change);
                        e.setNumLocalesLibre(num);
                        this.inmuebles.set(i, e);
                        res = true;
                    } else res = false;
                } 
            } else
                res = false;
        }
        return res;
    }
    
    public boolean elimInmueble(int code){
        boolean r = false;
        for(int i = 0; i < this.inmuebles.size(); i++){
            if(this.inmuebles.get(i).getCode() == code){
                //Para Oficina
                if(this.inmuebles.get(i) instanceof Oficina){
                    Oficina o = (Oficina) this.inmuebles.get(i);
                    this.inmuebles.remove(i);
                    r = true;
                } //Para Piso
                else if (this.inmuebles.get(i) instanceof Piso){
                    Piso p = (Piso) this.inmuebles.get(i);
                    this.inmuebles.remove(i);
                    ArrayList<Oficina> o = new ArrayList<>();
                    o.addAll(p.getOficinas());
                    this.inmuebles.addAll(o);
                    r = true;
                } //Para Local
                else if(this.inmuebles.get(i) instanceof Local){
                    Local l = (Local) this.inmuebles.get(i);
                    this.inmuebles.remove(i);
                    r = true;
                } //Para edificio
                else if(this.inmuebles.get(i) instanceof Edificio){
                    Edificio ed = (Edificio) this.inmuebles.get(i);
                    this.inmuebles.remove(i);
                    ArrayList<Local> l = new ArrayList<>();
                    ArrayList<Piso> p = new ArrayList<>();
                    l.addAll(ed.getLocales());
                    p.addAll(ed.getPisos());
                    for(int k = 0; k < p.size(); k++){
                        for(int h = 0; h < p.get(k).getOficinas().size(); h++)
                            p.get(k).getOficinas().get(h).setTipo("En Casa");
                    }
                    
                    this.inmuebles.addAll(l);
                    this.inmuebles.addAll(p);
                    r = true;
                }
            } //Si esta en UN edificio
            else if(this.inmuebles.get(i) instanceof Edificio){
                Edificio ed = (Edificio) this.inmuebles.get(i);
                for(int k = 0; k < ed.getPisos().size(); k++){
                    if(ed.getPisos().get(k).getCode() == code){
                        Piso p = ed.getPisos().get(k);
                        ed.elimPiso(p);
                        this.inmuebles.set(i, ed);
                        ArrayList<Oficina> of = new ArrayList<>();
                        of.addAll(p.getOficinas());
                        this.inmuebles.addAll(of);
                    } else if(ed.getLocales().get(k).getCode() == code){
                        Local l = ed.getLocales().get(k);
                        ed.elimLocal(l);
                        this.inmuebles.set(i, ed);
                    } else{
                        for(int h = 0; h < ed.getPisos().get(k).getOficinas().size(); h++){
                            if(ed.getPisos().get(k).getOficinas().get(h).getCode() == code){
                                Oficina of = ed.getPisos().get(k).getOficinas().get(h);
                                ed.getPisos().get(k).elimOficina(of);
                                this.inmuebles.set(i, ed);
                            }
                        }
                    }
                }
            } //Si esta en un Piso que no esta en un edificio
            else if(this.inmuebles.get(i) instanceof Piso){
                Piso ps = (Piso) this.inmuebles.get(i);
                for(int k = 0; k < ps.getOficinas().size(); k++){
                    if(ps.getOficinas().get(k).getCode() == code){
                        Oficina of = ps.getOficinas().get(k);
                        ps.elimOficina(of);
                        this.inmuebles.set(i, ps);
                    }
                }
            } else r = false;
        }
        return r;
    }
    
    public boolean añadLocalaEdificio(Local local, int codeEdificio){
        boolean r = false;
        for(int i = 0; i < this.inmuebles.size(); i++){
            if(this.inmuebles.get(i).getCode() == codeEdificio){
                Edificio ed = (Edificio) this.inmuebles.get(i);
                ed.añadLocal(local);
                this.inmuebles.set(i, ed);
                for(int k = 0; k < this.inmuebles.size(); k++){
                    if(this.inmuebles.get(k).getCode() == local.getCode()){
                        this.inmuebles.remove(k);
                    }
                }
                r = true;
            } else r = false;
        }
        return r;
    }
    
    public boolean añadPisoaEdificio(Piso piso, int codeEdificio){
        boolean r = false;
        for(int i = 0; i < this.inmuebles.size(); i++){
            if(this.inmuebles.get(i).getCode() == codeEdificio){
                Edificio ed = (Edificio) this.inmuebles.get(i);
                ed.añadPiso(piso);
                this.inmuebles.set(i, ed);
                for(int k = 0; k < this.inmuebles.size(); k++){
                    if(this.inmuebles.get(k).getCode() == piso.getCode()){
                        this.inmuebles.remove(k);
                    }
                }
                r = true;
            } else r = false;
        }
        return r;
    }
    
    public boolean añadOficinaaPiso(Oficina oficina, int codePiso){
        boolean r = false;
        for(int i = 0; i < this.inmuebles.size(); i++){
            if(this.inmuebles.get(i).getCode() == codePiso){
                Piso ps = (Piso) this.inmuebles.get(i);
                ps.añadOficinas(oficina);
                this.inmuebles.set(i, ps);
                for(int k = 0; k < this.inmuebles.size(); k++){
                    if(this.inmuebles.get(k).getCode() == oficina.getCode()){
                        this.inmuebles.remove(k);
                    }
                }
                r = true;
            } else if(this.inmuebles.get(i) instanceof Edificio){
                Edificio ed = (Edificio) this.inmuebles.get(i);
                for(int k = 0; k < ed.getPisos().size(); k++){
                    if(ed.getPisos().get(k).getCode() == codePiso){
                       oficina.setTipo("En Edificio");
                       r = ed.getPisos().get(k).añadOficinas(oficina);
                       this.inmuebles.set(i, ed);
                    }
                }
                for(int l = 0; l < this.inmuebles.size(); l++){
                    if(this.inmuebles.get(l).getCode() == oficina.getCode()){
                        this.inmuebles.remove(l);
                    }
                }
            } else
                r = false;
            }
        return r;
    }
    
    public void registrarCliente(String nombre, int DNI, int edad, String sexo){
        Persona p = new Persona(nombre, DNI, edad, sexo);
        for(int i = 0; i < this.sistema.getClientes().size(); i++){
            if(this.sistema.getClientes().get(i).equals(p));
            else
                this.sistema.añadCliente(nombre, DNI, edad, sexo);
        }
    }
    
    public void verificarPropietarioEdificio(int DNI, int code){
        for(int i = 0; i < this.inmuebles.size(); i++){
            if((this.inmuebles.get(i).getCode() == code) && (this.inmuebles.get(i) instanceof Edificio)){
                Edificio ed = (Edificio) this.inmuebles.get(i);
                if(ed.getPropietario().getDNI() == DNI){
                    sistema.añadPropietario(DNI);
                } 
            } 
        }
    }
    
    public String consultarInmueble(int code){
        String cons = "";
        for(Inmueble i : this.inmuebles){
            if(i.getCode() == code){
                cons = i.darInformacion();
            } //Si es un Local, Piso o Oficina en un Edificio 
            else if(i instanceof Edificio){
                Edificio ed = (Edificio) i;
                for(int k = 0; k < ed.getPisos().size(); k++){
                    if(ed.getPisos().get(k).getCode() == code)
                        cons = ed.getPisos().get(k).darInformacion();
                    else if(ed.getLocales().get(k).getCode() == code)
                        cons = ed.getLocales().get(k).darInformacion();
                    else {
                        for(int h = 0; h < ed.getPisos().get(k).getOficinas().size(); h++){
                            if(ed.getPisos().get(k).getOficinas().get(h).getCode() == code)
                                cons = ed.getPisos().get(k).getOficinas().get(h).darInformacion();
                        }
                    }
                }
            } //Si es una oficina en un Piso que no esta en un Edificio
            else if(i instanceof Piso){
                Piso ps = (Piso) i;
                for(int k = 0; k < ps.getOficinas().size(); k++){
                    if(ps.getOficinas().get(k).getCode() == code)
                        cons = ps.getOficinas().get(k).darInformacion();
                } 
            } else
                cons = "No existe el inmueble";
        }
        return cons;
    }
    
    public String consultarCliente(int DNI){
        String cons = "";
        for(Persona p : this.sistema.getClientes()){
            if(p.getDNI() == DNI){
                cons = p.toString();
            } else cons = "No existe la persona.";
        }
        return cons;
    }
    
    public void cambiarDatosCliente(int DNI, String type, String change){
        for(int i = 0; i < this.sistema.getClientes().size(); i++){
            if(this.sistema.getClientes().get(i).getDNI() == DNI){
                if(this.sistema.modDatosCliente(i, DNI, type, change))
                    System.out.println("Se cambiaron los datos exitosamente.");
            } else
                 System.out.println("No se pudo cambiar los datos, verifique la informacion otorgada.");   
        }
    }
    
    public void elimCliente(int DNI){
        if(this.sistema.elimC(DNI))
            System.out.println("El cliente fue eliminado del sistema");
        else
            System.out.println("No se pudo realizar la acción.");
    }
    
    public boolean alquilarInmueble(int code, int DNI){
        boolean r = false;
        for(int i = 0; i < this.inmuebles.size(); i++){
            if(this.inmuebles.get(i).getCode() == code){
                Inmueble inmueble = this.inmuebles.get(i);
                for(int k = 0; k < this.sistema.getClientes().size(); k++){
                    if(this.sistema.getClientes().get(k).inmueblesAlquilados(inmueble))
                        r = false;
                    else
                        r = this.sistema.clienteAlquiler(DNI, inmueble);
                }
            } else r= false;
        }
        return r;
    }
    
    public boolean dejarInmueble(int code, int DNI){
        boolean r = false;
        for(int i = 0; i < this.inmuebles.size(); i++){
            if(this.inmuebles.get(i).getCode() == code){
                Inmueble in = this.inmuebles.get(i);
                r = this.sistema.clientenoAlquiler(DNI, in);
            } else r = false;
        }
        return r;
    }
    
    public ArrayList<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(ArrayList<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }
    
    
}
