/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CargaData;
import java.io.*;
import java.util.*;
import datos.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Daniel Yara Sepúlveda
 */
public class CargaDatos {
    FincaRaiz fr;

    public CargaDatos() {
        this.fr = new FincaRaiz();
    }
    
    public String listarInmuebles(){
        String listaInmuebles = "";
        for(Inmueble i : this.fr.getInmuebles()){
            listaInmuebles += i.darInformacion();
        }
        return listaInmuebles;
    } 
    
    public void cargarDatos(String ruta){
        File lectura = new File(ruta);
        Scanner input = null;
        if(lectura.exists()){
            try{
                input = new Scanner(lectura);
                input.useDelimiter(",");
                String tipo = null;
                while(input.hasNext()){
                    tipo = input.next().trim();
                    if(tipo.equals("O")){
                        String code = input.next().trim();
                        int cod = Integer.parseInt(code);
                        String barrio = input.next().trim();
                        String estrato = input.next().trim();
                        int e = Integer.parseInt(estrato);
                        String valorArriendo = input.next().trim();
                        int c = Integer.parseInt(valorArriendo);
                        String area = input.next().trim();
                        double a = Double.parseDouble(area);
                        String tip = input.next().trim();
                        Oficina o = new Oficina(cod, barrio, e, c, a, tip);
                        fr.añadInmueble(o);
                    } else if(tipo.equals("P")){
                        String code = input.next().trim();
                        int cod = Integer.parseInt(code);
                        String barrio = input.next().trim();
                        String estrato = input.next().trim();
                        int e = Integer.parseInt(estrato);
                        String valorArriendo = input.next().trim();
                        int c = Integer.parseInt(valorArriendo);
                        String area = input.next().trim();
                        double a = Double.parseDouble(area);
                        String numOficinas = input.next().trim();
                        int numOf = Integer.parseInt(numOficinas);
                        Piso p = new Piso(cod, barrio, e, c, a, numOf);
                        fr.añadInmueble(p);
                    } else if(tipo.equals("E")){
                        String code = input.next().trim();
                        int cod = Integer.parseInt(code);
                        String barrio = input.next().trim();
                        String estrato = input.next().trim();
                        int e = Integer.parseInt(estrato);
                        String valorArriendo = input.next().trim();
                        int c = Integer.parseInt(valorArriendo);
                        String area = input.next().trim();
                        double a = Double.parseDouble(area);
                        String numP = input.next().trim();
                        int p = Integer.parseInt(numP);
                        String numL = input.next().trim();
                        int l = Integer.parseInt(numL);
                        String name = input.next().trim();
                        String id = input.next().trim();
                        int dni = Integer.parseInt(id);
                        String edad = input.next().trim();
                        int edd = Integer.parseInt(edad);
                        String sexo = input.next().trim();
                        fr.registrarCliente(name, dni, edd, sexo);
                        Persona pr = new Persona(name, dni, edd, sexo);
                        Edificio ed = new Edificio(cod, barrio, e, c, a, p, l, pr);
                        fr.añadInmueble(ed);
                        fr.verificarPropietarioEdificio(dni, cod);
                    } else if(tipo.equals("L")){
                        String code = input.next().trim();
                        int cod = Integer.parseInt(code);
                        String barrio = input.next().trim();
                        String estrato = input.next().trim();
                        int e = Integer.parseInt(estrato);
                        String valorArriendo = input.next().trim();
                        int c = Integer.parseInt(valorArriendo);
                        String area = input.next().trim();
                        double a = Double.parseDouble(area);
                        String descrip = input.next().trim();
                        String viaP = input.next().trim();
                        boolean t = Boolean.parseBoolean(viaP);
                        Local l = new Local(cod, barrio, e, c, a, descrip, t);
                        fr.añadInmueble(l);
                    }   else if(tipo.equals("OP")){
                        String code = input.next().trim();
                        int cod = Integer.parseInt(code);
                        String barrio = input.next().trim();
                        String estrato = input.next().trim();
                        int e = Integer.parseInt(estrato);
                        String valorArriendo = input.next().trim();
                        int c = Integer.parseInt(valorArriendo);
                        String area = input.next().trim();
                        double a = Double.parseDouble(area);
                        String tip = input.next().trim();
                        Oficina o = new Oficina(cod, barrio, e, c, a, tip);
                        String codeP = input.next().trim();
                        int coP = Integer.parseInt(codeP);
                        fr.añadOficinaaPiso(o, coP);
                    } else if(tipo.equals("PE")){
                        String code = input.next().trim();
                        int cod = Integer.parseInt(code);
                        String barrio = input.next().trim();
                        String estrato = input.next().trim();
                        int e = Integer.parseInt(estrato);
                        String valorArriendo = input.next().trim();
                        int c = Integer.parseInt(valorArriendo);
                        String area = input.next().trim();
                        double a = Double.parseDouble(area);
                        String numOficinas = input.next().trim();
                        int numOf = Integer.parseInt(numOficinas);
                        Piso p = new Piso(cod, barrio, e, c, a, numOf);
                        String codeE = input.next().trim();
                        int coE = Integer.parseInt(codeE);
                        fr.añadPisoaEdificio(p, coE);
                    } else if(tipo.equals("LE")){
                        String code = input.next().trim();
                        int cod = Integer.parseInt(code);
                        String barrio = input.next().trim();
                        String estrato = input.next().trim();
                        int e = Integer.parseInt(estrato);
                        String valorArriendo = input.next().trim();
                        int c = Integer.parseInt(valorArriendo);
                        String area = input.next().trim();
                        double a = Double.parseDouble(area);
                        String descrip = input.next().trim();
                        String viaP = input.next().trim();
                        boolean t = Boolean.parseBoolean(viaP);
                        Local l = new Local(cod, barrio, e, c, a, descrip, t);
                        String codeE = input.next().trim();
                        int coE = Integer.parseInt(codeE);
                        fr.añadLocalaEdificio(l, coE);
                    }
                }
            } catch(FileNotFoundException e){
                Logger.getLogger(CargaDatos.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
