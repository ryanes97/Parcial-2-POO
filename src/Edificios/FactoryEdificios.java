/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificios;

import Bandos.Bando;
import Ejercito.Ejercito;
import Vehiculos.Vehiculo;
import raulyanesworld.AbstractFactory;

/**
 *
 * @author ryane
 */
public class FactoryEdificios implements AbstractFactory{
    
    @Override
    public Edificios getEdificios(String type){
        switch(type){
            case "Command Center":
                return new CommandCenter();
            case "Barracks":
                return new Barracks();
            case "Aeropuerto":
                return new Aeropuerto();
            case "Fabrica de Guerra":
                return new GuerraFabrica();
            case "Planta Electrica":
                return new PlantaElectrica();
            case "Mina":
                return new Mina();
            case "Supply Center":
                return new SupplyCenter();
        }
        return null;
    }

    @Override
    public Bando getBando(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ejercito getEjercito(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vehiculo getVehiculo(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
