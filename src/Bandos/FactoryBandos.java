/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bandos;

import Edificios.Edificios;
import Ejercito.Ejercito;
import Vehiculos.Vehiculo;
import raulyanesworld.AbstractFactory;

/**
 *
 * @author ryane
 */
public class FactoryBandos implements AbstractFactory{
    
    @Override
    public Bando getBando(String type){
        switch(type){
            case "China":
                return new China();
            case "USA":
                return new USA();
            case "Guerrilla":
                return new Guerrilla();
        }
        return null;
    }

    @Override
    public Edificios getEdificios(String type) {
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
