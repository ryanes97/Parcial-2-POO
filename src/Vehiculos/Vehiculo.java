/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

/**
 *
 * @author ryane
 */
public interface Vehiculo {
    void atacar();
    String getNombre();
    int getVida();
    int getFaseEntrenamiento();
    void setVida(int vida);
    void setFaseEntrenamiento(int fase);
    int getCostoOro();
    int getCostoEnergia();
    int getCostoProvisiones();
    void setCostoOro(int oro);
    void setCostoEnergia(int energia);
    void setCostoProvisiones(int provisiones);
    void setFaseCreacion(int fase);
    int getFaseCreacion();
    int getDanio();
    void setDanio(int danio);
}
