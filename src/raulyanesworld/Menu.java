/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raulyanesworld;

import java.util.Scanner;

/**
 *
 * @author ryane
 */
public class Menu {
    protected static Menu menu;
    boolean gameover = false;
    
    private Menu(){
    }
    
    public synchronized static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }
    
    public void mostrarBando(){
        int opc;
        Scanner leer = new Scanner(System.in);
        System.out.println("-------Bandos-------");
        System.out.println("1.China");
        System.out.println("2.USA");
        System.out.println("3.Guerrilla");
        System.out.print("Escoge tu bando: ");  
    }
    public int MenuEntrenarTropas(){
        int opc;
        Scanner leer = new Scanner(System.in);
        System.out.println("-------Tropas Disponibels-------");
        System.out.println("1.Soldado");
        System.out.println("2.Soldado Especial");
        System.out.println("3.Tropas Entrenadas");
        System.out.print("Elige una opcion: ");
        opc = leer.nextInt();
        return opc;
    }
    public int MenuEdificios(){
        int opc;
        Scanner leer = new Scanner(System.in);
        System.out.println("--------Administrar Edificios--------");
        System.out.println("1.Mejor Centro de Comando");
        System.out.println("2.Construir Edificaciones");
        System.out.println("3.Ver Edificios Construidos");
        System.out.print("Elige una opcion: ");
        opc=leer.nextInt();
        return opc;
    }
    public int MenuVehiculs(){
        int opc=0;
        Scanner leer = new Scanner(System.in);
        System.out.println("--------Ensamblas Vehiculos--------");
        System.out.println("1.Tanque");
        System.out.println("2.Avion de Combate");
        System.out.println("3.Vehiculos Terminados");
        System.out.print("Elige una opcion: ");
        opc=leer.nextInt();
        return opc;
    }
    public int MenuJugador(){
        int opc;
        Scanner leer = new Scanner(System.in);
        System.out.println("1.Administrar Edificios");
        System.out.println("2.Entrenar Tropas");
        System.out.println("3.Ensamblar Vehiculos");        
        System.out.println("4.Atacar");
        System.out.println("5.Terminar Turno");
        System.out.print("Elige una opcion: ");
        opc=leer.nextInt();
        return opc;
    }
    
    public void MenuAtacar(){
        System.out.println("Mostrar Edificios Enemigos");
    }
    
    public void menu(){ 
        AbstractFactory factoED,factoEJ,factoB,factoV;
        factoB = FactoryProducer.getFactory("Bando");
        factoED = FactoryProducer.getFactory("Edificio");
        factoEJ = FactoryProducer.getFactory("Ejercito");
        factoV = FactoryProducer.getFactory("Vehiculo");
        Scanner leer = new Scanner(System.in);
        
        Jugador j1 = new Jugador();
        Jugador j2 =  new Jugador();
        System.out.println("***************HOLA****************");
        System.out.print("Ingrese el nommbre del jugador 1:");
        j1.setNombre(leer.nextLine());
        mostrarBando();
        j1.setBando(leer.nextLine());
        System.out.println("---------------------------------------------------------");
        
        System.out.print("Ingrese el nommbre del jugador 2:");
        j2.setNombre(leer.nextLine());
        mostrarBando();
        j2.setBando(leer.nextLine());
        
        /*System.out.println("-------------------------------------------\n");
        System.out.println("Info jugador: \n");
        System.out.println("Nombre:"+j1.getNombre() + " Bando:"+j1.getBando() + " Edificaciones:"+j1.getEdificios());
        System.out.println(j2.getNombre() + " Bando: "+j2.getBando());
        */
        
        while(!gameover){
            if(j1.getEdificios().isEmpty() || j2.getEdificios().isEmpty()){
                if(j1.getEdificios().isEmpty()){
                    System.out.println("JUGADOR 2 GANO!!!!");
                }
                else{
                    System.out.println("JUGADOR 1 GANO!!!!");
                }
                gameover = true;
                break;
            }
            j1.RevisarFase();;
            j1.Turno();
            j2.RevisarFase();;
            j2.Turno();
            
            j1.FaseAvanzar();
            j2.FaseAvanzar();
            
        }       
    }
}
