/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercito;

import Bandos.Bando;
import Edificios.Edificios;
import Vehiculos.Vehiculo;
import raulyanesworld.AbstractFactory;

/**
 *
 * @author ryane
 */
public class FactoryEjercito implements AbstractFactory{
 
    @Override
    public Ejercito getEjercito(String type){
        switch(type){
            case "Soldado":
                return new Soldado();
            case "Soldado Especial":
                return new SoldadoEspecial();
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
    public Vehiculo getVehiculo(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
