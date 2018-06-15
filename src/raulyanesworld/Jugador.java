/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raulyanesworld;

import Edificios.Edificios;
import Edificios.FactoryEdificios;
import Ejercito.Ejercito;
import Ejercito.Soldado;
import Ejercito.SoldadoEspecial;
import Vehiculos.Avion;
import Vehiculos.Tanque;
import Vehiculos.Vehiculo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


/**
 *
 * @author ryane
 */
public class Jugador { 
    private AbstractFactory factoEdi = FactoryProducer.getFactory("Edificios");
    private AbstractFactory factoEj = FactoryProducer.getFactory("Ejercito");
    private AbstractFactory factoVeh = FactoryProducer.getFactory("Vehiculo");
    private Ejercito soldado;
    private Ejercito soldadoEsp;
    private Vehiculo avion;
    private Vehiculo tanque;
    private String nombre, bando;
    private int fase;
    private Menu menus;
    private int Oro,Energia,Provisiones;//Comenzar en un valor predeterminado
    private ArrayList<Edificios> Edificios;
    private ArrayList<Ejercito> Ejercito;
    private ArrayList<Vehiculo> Vehiculos;
    
    public Jugador() {
        this.Edificios = new ArrayList<>();
        this.Ejercito = new ArrayList<>();
        this.Vehiculos = new ArrayList<>();
        this.Oro = 100;
        this.Energia = 100;
        this.Provisiones = 100;
        
        
        Edificios.add(factoEdi.getEdificios("Command Center"));
        this.fase = 1;
    }

    public Jugador(String nombre, String bando) {
        this.nombre = nombre;
        this.bando = bando;
    }

    public String getNombre() {
        return nombre;
    }

    public String getBando() {
        return bando;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBando(String bando) {
        this.bando = bando;
    }

    public ArrayList<Edificios> getEdificios() {
        return Edificios;
    }

    public ArrayList<Ejercito> getEjercito() {
        return Ejercito;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return Vehiculos;
    }

    public void setEdificios(ArrayList<Edificios> Edificios) {
        this.Edificios = Edificios;
    }

    public void setEjercito(ArrayList<Ejercito> Ejercito) {
        this.Ejercito = Ejercito;
    }

    public void setVehiculos(ArrayList<Vehiculo> Vehiculos) {
        this.Vehiculos = Vehiculos;
    }

    public int getFase() {
        return fase;
    }

    public int getOro() {
        return Oro;
    }

    public int getEnergia() {
        return Energia;
    }

    public int getProvisiones() {
        return Provisiones;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public void setOro(int Oro) {
        this.Oro = Oro;
    }

    public void setEnergia(int Energia) {
        this.Energia = Energia;
    }

    public void setProvisiones(int Provisiones) {
        this.Provisiones = Provisiones;
    }
    
    public void FaseAvanzar(){
        this.fase += 1;
    }
    
    public void Turno(Jugador j1){
        int opcion=0, opc1=0;
        Menu menus = Menu.getInstance();
        Scanner leer = new Scanner(System.in);
        
        while(opcion!=6){
            System.out.println("******************Fase "+this.fase+"*********************");
            System.out.println("--------------Turno de "+this.getNombre()+"---------------");
            System.out.println("Recursos -> Oro:"+this.Oro+" Energia:"+this.Energia+" Provisiones:"+this.Provisiones);
            opcion=menus.MenuJugador();
            switch(opcion){
                case 1:
                    int opc=menus.MenuEdificios();
                    switch(opc){
                        case 1:
                            MejorarCC();
                            break;
                        case 2:
                            ConstruirEdificios();
                            break;
                        case 3:
                            MostrarEdificios();
                            break;
                    }
                    break;
                case 2:
                    int opc2 = menus.MenuEntrenarTropas();
                    switch(opc2){
                        case 1:
                            if(verifacarCostoEJ(factoEj.getEjercito("Soldado"))!=false){
                                soldado = factoEj.getEjercito("Soldado");
                                Ejercito.add(soldado);
                                //System.out.println(this.fase);
                                soldado.setFaseCreacion(this.fase);
                                //System.out.println("SET FASE: "+soldado.getFaseCreacion());
                                System.out.println("Soldado terminara entranamiento en "+soldado.getFaseEntrenamiento()+" fases");
                                DescontarCostoEJ(factoEj.getEjercito("Soldado"));
                            }else{
                                System.out.println("No tienes suficientes recurso");
                            }
                            break;
                        case 2:
                            if(verifacarCostoEJ(factoEj.getEjercito("Soldado Especial"))!=false){
                                soldadoEsp = factoEj.getEjercito("Soldado Especial");
                                Ejercito.add(soldadoEsp);
                                soldadoEsp.setFaseCreacion(this.fase);
                                System.out.println("Soldado terminara entranamiento en "+soldadoEsp.getFaseEntrenamiento()+" fases");
                                DescontarCostoEJ(factoEj.getEjercito("Soldado Especial"));
                            }else{
                                System.out.println("No tienes suficientes recurso");
                            } 
                            break;
                        case 3:
                            MostrarTropas();
                            break;
                    }
                    break;
                case 3:
                    int opc3=menus.MenuVehiculs();
                    switch(opc3){
                        case 1:
                            if(verifacarCostoVEH(factoVeh.getVehiculo("Tanque"))!=false){
                                tanque = factoVeh.getVehiculo("Tanque");
                                Vehiculos.add(tanque);
                                //System.out.println(this.fase);
                                tanque.setFaseCreacion(this.fase);
                                //System.out.println("SET FASE"+factoVeh.getVehiculo("Tanque").getFaseCreacion());
                                System.out.println("El vehiculo sera ensamblado en "+tanque.getFaseEntrenamiento()+" fase");
                                DescontarCostoVEH(factoVeh.getVehiculo("Tanque"));
                            }else{
                                System.out.println("No tienes suficientes recurso");
                            }
                            break;
                        case 2:
                            if(verifacarCostoVEH(factoVeh.getVehiculo("Avion"))!=false){
                                avion = factoVeh.getVehiculo("Avion");
                                Vehiculos.add(avion);
                                avion.setFaseCreacion(this.fase);
                                System.out.println("El vehiculo sera ensamblado en "+avion.getFaseEntrenamiento()+" fase");
                                DescontarCostoVEH(factoVeh.getVehiculo("Avion"));
                            }else{
                                System.out.println("No tienes suficientes recurso");
                            }
                            break;
                        case 3:    
                            MostrarVehiculos();
                            break;
                    }
                    break;
                case 4:
                    Recolectores();
                    break;
                case 5:
                    
                    elegirTropa();
                    break;
            }
        }
    }
    
    public void ConstruirEdificios(){
        int opc;
        Scanner leer = new Scanner(System.in);
        System.out.println("--------Edificios Disponibles---------");
        System.out.println("1.Barracks");
        System.out.println("2.Aeropuerto");
        System.out.println("3.Fabrica de Guerra");
        System.out.println("4.Planta Electrica");
        System.out.println("5.Mina");
        System.out.println("6.Supply Center");
        System.out.print("Elige una opcion: ");
        opc=leer.nextInt();
        switch(opc){
            case 1:
                //verificarCosto
                if(verifacarCosto(factoEdi.getEdificios("Barracks"))!=false){
                    Edificios.add(factoEdi.getEdificios("Barracks"));
                    factoEdi.getEdificios("Barracks").setFaseCreacion(this.fase);
                    System.out.println("Edificacion sera construida en "+factoEdi.getEdificios("Barracks").getFaseConstruccion()+" fase");
                
                    DescontarCosto(factoEdi.getEdificios("Barracks"));
                }else{
                    System.out.println("No tienes suficientes recurso");
                }
                
                break;
            case 2:
                //verificarCosto
                if(verifacarCosto(factoEdi.getEdificios("Aeropuerto"))!=false){
                    Edificios.add(factoEdi.getEdificios("Aeropuerto"));
                    factoEdi.getEdificios("Aeropuerto").setFaseCreacion(this.fase);
                    System.out.println("Edificacion sera construida en "+factoEdi.getEdificios("Aeropuerto").getFaseConstruccion()+" fase");
                    
                    DescontarCosto(factoEdi.getEdificios("Aeropuerto"));
                }else{
                    System.out.println("No tienes suficientes recurso");
                }
                
                break;
            case 3:
                //verificarCosto
                if(verifacarCosto(factoEdi.getEdificios("Fabrica de Guerra"))!=false){
                    Edificios.add(factoEdi.getEdificios("Fabrica de Guerra"));
                    factoEdi.getEdificios("Fabrica de Guerra").setFaseCreacion(this.fase);
                    System.out.println("Edificacion sera construida en "+factoEdi.getEdificios("Fabrica de Guerra").getFaseConstruccion()+" fase");
                    
                    DescontarCosto(factoEdi.getEdificios("Fabrica de Guerra"));
                }else{
                    System.out.println("No tienes suficientes recurso");
                }
                
                break;
            case 4:
                //verificarCosto
                if(verifacarCosto(factoEdi.getEdificios("Planta Electrica"))!=false){
                    Edificios.add(factoEdi.getEdificios("Planta Electrica"));
                    factoEdi.getEdificios("Planta Electrica").setFaseCreacion(this.fase);
                    System.out.println("Edificacion sera construida en "+factoEdi.getEdificios("Planta Electrica").getFaseConstruccion()+" fase");
                    
                    DescontarCosto(factoEdi.getEdificios("Planta Electrica"));
                }else{
                    System.out.println("No tienes suficientes recurso");
                }
                
                break;
            case 5:
                //verificarCosto
                if(verifacarCosto(factoEdi.getEdificios("Mina"))!=false){
                    Edificios.add(factoEdi.getEdificios("Mina"));
                    factoEdi.getEdificios("Mina").setFaseCreacion(this.fase);
                    System.out.println("Edificacion sera construida en "+factoEdi.getEdificios("Mina").getFaseConstruccion()+" fase");
                    
                    DescontarCosto(factoEdi.getEdificios("Mina"));
                }else{
                    System.out.println("No tienes suficientes recurso");
                }
                
                break;
            case 6:
                //verificarCosto
                if(verifacarCosto(factoEdi.getEdificios("Supply Center"))!=false){
                    Edificios.add(factoEdi.getEdificios("Supply Center"));
                    factoEdi.getEdificios("Supply Center").setFaseCreacion(this.fase);
                    System.out.println("Edificacion sera construida en "+factoEdi.getEdificios("Supply Center").getFaseConstruccion()+" fase");
                    
                    DescontarCosto(factoEdi.getEdificios("Supply Center"));
                }else{
                    System.out.println("No tienes suficientes recurso");
                }
                
                break;
        }
    }
    //Mostrar bien el arraylist
    public void MostrarEdificios(){
        Iterator<Edificios> nombreIt = Edificios.iterator();
        while(nombreIt.hasNext()){
            Edificios edi = nombreIt.next();
            System.out.println(edi.getNombre()+" Vida: "+edi.getVida()+" , ");
        }
    }
    
    public void MostrarTropas(){
        Iterator<Ejercito> nombreIt = Ejercito.iterator();
        while(nombreIt.hasNext()){
            Ejercito edi = nombreIt.next();
            System.out.println(edi.getNombre() +" , ");
        }
    }
    
    public void MostrarVehiculos(){
        Iterator<Vehiculo> nombreIt = Vehiculos.iterator();
        while(nombreIt.hasNext()){
            Vehiculo edi = nombreIt.next();
            System.out.println(edi.getNombre() +" , ");
        }
    }
    public boolean verifacarCosto(Edificios edi){
        boolean revision=false;
        if(edi.getCostoOro()<=this.getOro() && edi.getCostoEnergia()<=this.Energia  && edi.getCostoProvisiones()<=this.Provisiones){
            revision = true;
        } else {
            revision = false;
        }
        return revision;
    }
    
    public boolean verifacarCostoEJ(Ejercito edi){
        boolean revision=false;
        if(edi.getCostoOro()<=this.getOro() && edi.getCostoEnergia()<=this.Energia  && edi.getCostoProvisiones()<=this.Provisiones){
            revision = true;
        } else {
            revision = false;
        }
        return revision;
    }
    
    public boolean verifacarCostoVEH(Vehiculo edi){
        boolean revision=false;
        if(edi.getCostoOro()<=this.getOro() && edi.getCostoEnergia()<=this.Energia  && edi.getCostoProvisiones()<=this.Provisiones){
            revision = true;
        } else {
            revision = false;
        }
        return revision;
    }
    
    public void DescontarCosto(Edificios edi){
        this.Oro -= edi.getCostoOro();
        this.Energia -= edi.getCostoEnergia();
        this.Provisiones -= edi.getCostoProvisiones();
    }
    
    public void DescontarCostoEJ(Ejercito edi){
        this.Oro -= edi.getCostoOro();
        this.Energia -= edi.getCostoEnergia();
        this.Provisiones -= edi.getCostoProvisiones();
    }
    
    public void DescontarCostoVEH(Vehiculo edi){
        this.Oro -= edi.getCostoOro();
        this.Energia -= edi.getCostoEnergia();
        this.Provisiones -= edi.getCostoProvisiones();
    }
    
    public void MejorarCC(){
        int opc;
        Scanner leer = new Scanner(System.in);
        Edificios CC = factoEdi.getEdificios("Command Center");
        System.out.println("-----Mejoras Disponibles--------");
        System.out.println("1. Nivel 2");
        System.out.println("2. Nivel 3");
        System.out.println("3. Nivel 4");
        System.out.println("Revisar nivel actual");
        System.out.println("Elige una opcion: ");
        opc=leer.nextInt();
        switch(opc){
            case 1:
                if(verifacarCosto(CC)){
                    factoEdi.getEdificios("Command Center").setStorageOro(1200);
                    factoEdi.getEdificios("Command Center").setStorageEnergia(1200);
                    factoEdi.getEdificios("Command Center").setStorageProvisiones(1200);
                    CC.setNivel(2);
                    DescontarCosto(CC);
                    CC.setCostoEnergia(1000);
                    CC.setCostoOro(900);
                    CC.setCostoProvisiones(1100);
                }else{
                    System.out.println("No tienes suficientes recurso");
                }
                break;
            case 2:
                if(verifacarCosto(CC)){
                    factoEdi.getEdificios("Command Center").setStorageOro(2100);
                    factoEdi.getEdificios("Command Center").setStorageEnergia(2100);
                    factoEdi.getEdificios("Command Center").setStorageProvisiones(2100);
                    CC.setNivel(3);
                    DescontarCosto(CC);
                    CC.setCostoEnergia(2000);
                    CC.setCostoOro(1900);
                    CC.setCostoProvisiones(2100);
                }else{
                    System.out.println("No tienes suficientes recurso");
                }
                break;
            case 3:
                if(verifacarCosto(CC)){
                    factoEdi.getEdificios("Command Center").setStorageOro(3500);
                    factoEdi.getEdificios("Command Center").setStorageEnergia(3500);
                    factoEdi.getEdificios("Command Center").setStorageProvisiones(3500);
                    CC.setNivel(4);
                    DescontarCosto(CC);
                    CC.setCostoEnergia(3000);
                    CC.setCostoOro(2900);
                    CC.setCostoProvisiones(3100);
                }else{
                    System.out.println("No tienes suficientes recurso");
                }
                break;
            case 4:
                int a=factoEdi.getEdificios("Command Center").getStorageOro();
                int b=factoEdi.getEdificios("Command Center").getStorageEnergia();
                int c=factoEdi.getEdificios("Command Center").getStorageProvisiones();
                System.out.println("--------Centro de Comando"+CC.getNivel()+"----------");
                System.out.println("Almacenamiento Oro: "+CC.getStorageOro());
                System.out.println("Almacenamiento Energia: "+CC.getStorageEnergia());
                System.out.println("Almacenamiento Provisiones: "+CC.getStorageProvisiones());
        }
    }
    
    public void RevisarFase(){
        for(Edificios Edificios : this.Edificios){
            if(Edificios.getFaseConstruccion()+Edificios.getFaseCreacion() == this.fase){
                System.out.println("**********************************************");
                System.out.println("Edificacion Construida y lista para ser usada");
            }
        }
        for(Ejercito Ejercito : this.Ejercito){
            if(Ejercito.getFaseEntrenamiento()+Ejercito.getFaseCreacion() == this.fase){
                System.out.println("**********************************************");
                System.out.println("Tropa Entrenada y lista");
            }
        }
        
        for(Vehiculo Vehiculos : this.Vehiculos){
        if(Vehiculos.getFaseEntrenamiento()+Vehiculos.getFaseCreacion() == this.fase){
                System.out.println("**********************************************");
                System.out.println("Vehiculo Ensamblado y listo");
            }
        }  
    }
    
    public void Recolectores(){
        int opc;
        System.out.println("-------Recolectores---------");
        System.out.println("1.Mina(Oro)");
        System.out.println("2.Planta Electrica(Energia)");
        System.out.println("3.Supply Center(Provisiones)");
        System.out.print("Eliga una opcion: ");
        Scanner leer = new Scanner(System.in);
        opc=leer.nextInt();
        switch(opc){
            case 1:
                for(Edificios Edificios : this.Edificios){
                    if("Mina".equals(Edificios.getNombre())){
                        this.Oro += factoEdi.getEdificios("Mina").getRecolectPorFase();
                        System.out.println("*******Recurso Recolectado*********");
                        System.out.println("Mina: "+this.Oro);
                    }else{
                        System.out.println("Tienes que construir una Mina antes");
                    }
                }
                break;
            case 2:
                for(Edificios Edificios : this.Edificios){
                    if("Planta Electrica".equals(Edificios.getNombre())){
                        this.Oro += factoEdi.getEdificios("PlantaElectrica").getRecolectPorFase();
                        System.out.println("*******Recurso Recolectado*********");
                        System.out.println("Energia: "+this.Energia);
                    }else{
                        System.out.println("Tienes que construir una Planta Electrica antes");
                    }
                }
                break;
            case 3:
                for(Edificios Edificios : this.Edificios){
                    if("Supply Center".equals(Edificios.getNombre())){
                        this.Oro += factoEdi.getEdificios("SupplyCenter").getRecolectPorFase();
                        System.out.println("*******Recurso Recolectado*********");
                        System.out.println("Provisiones: "+this.Provisiones);
                    }else{
                        System.out.println("Tienes que construir un Supply Center antes");
                    }
                }
                break;
        }
    }
    
    public void Atacar(Ejercito tropa){
        Edificios EdiAtacado = Edificios.get(Edificios.size()-1);
        int atk = factoEj.getEjercito(tropa.getNombre()).getDanio();
        int edi = EdiAtacado.getVida();
        edi -= atk;
    }
    
    public void AtacarVEH(Vehiculo tropa){
        Edificios EdiAtacado = Edificios.get(Edificios.size()-1);
        int atk = factoVeh.getEjercito(tropa.getNombre()).getDanio();
        int edi = EdiAtacado.getVida();
        edi -= atk;
    }
    
    
    public void elegirTropa(){
        String opc;
        Scanner leer = new Scanner(System.in);
        Iterator<Ejercito> nombreIt = Ejercito.iterator();
        while(nombreIt.hasNext()){
            Ejercito edi = nombreIt.next();
            System.out.println(edi.getNombre());
            //for(int i=1 ; i <=Ejercito.size();i++){
                
            }
        System.out.print("Elige una tropa para atacar: ");
        opc=leer.nextLine();
        switch(opc){
            case "Soldado":
                Atacar(soldado);
                System.out.println("Soldado Ataco");
                break;
            case "Soldado Especial":
                Atacar(soldadoEsp);
                System.out.println("Soldado Especial Ataco");
                break;
            case "Avion de Combate":
                AtacarVEH(avion);
                System.out.println("Avion de Combate Ataco");
                break;
            case "Tanque":
                AtacarVEH(tanque);
                System.out.println("Tanque Ataco");
                break;
        }
    }
    
    
    
    }
    
   
    
    
