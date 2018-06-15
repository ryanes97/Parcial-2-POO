/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

import Bandos.Bando;
import Edificios.Edificios;
import Ejercito.Ejercito;
import raulyanesworld.AbstractFactory;
/**
 *
 * @author ryane
 */
public class FactoryVehiculo implements AbstractFactory{

    @Override
    public Vehiculo getVehiculo(String type) {
        switch(type){
            case "Tanque":
                return new Tanque();
            case "Avion de Combate":
                return new Avion();
        }
        return null;
    }
    
    @Override
    public Bando getBando(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Edificios getEdificios(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ejercito getEjercito(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
