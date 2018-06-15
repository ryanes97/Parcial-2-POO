/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raulyanesworld;

import Bandos.Bando;
import Edificios.Edificios;
import Ejercito.Ejercito;
import Vehiculos.Vehiculo;

/**
 *
 * @author ryane
 */
public interface AbstractFactory {
    Bando getBando(String type);
    Edificios getEdificios(String type);//hacer fabricaedificios
    Ejercito getEjercito(String type);//hacer fabricaejercito
    Vehiculo getVehiculo(String type);
    
}
