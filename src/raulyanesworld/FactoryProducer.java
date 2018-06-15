/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raulyanesworld;

import Bandos.FactoryBandos;
import Ejercito.FactoryEjercito;
import Edificios.FactoryEdificios;
import Vehiculos.FactoryVehiculo;

/**
 *
 * @author ryane
 */
public class FactoryProducer {
    
    public static AbstractFactory getFactory(String type){
     switch(type){
         case "Bando":
             return new FactoryBandos();
         case "Edificios":
             return new FactoryEdificios();
         case "Ejercito":
             return new FactoryEjercito();
         case "Vehiculo":
             return new FactoryVehiculo();
     }   
     return null;   
    }
}
