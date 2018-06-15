/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificios;

/**
 *
 * @author ryane
 */
public interface Edificios {
    String getNombre();
    int getVida();
    int getFaseConstruccion();
    void setVida(int vida);
    void setFaseconstruccion(int fase);
    int getCostoOro();
    int getCostoEnergia();
    int getCostoProvisiones();
    int getStorageOro();
    int getStorageEnergia();
    int getStorageProvisiones();
    void setStorageOro(int StorageOro);
    void setStorageEnergia(int StorageEnergia);
    void setStorageProvisiones(int StorageProvisiones);
    int getNivel();
    void setNivel(int nivel);
    void setCostoOro(int oro);
    void setCostoEnergia(int energia);
    void setCostoProvisiones(int provisiones);
    void setFaseCreacion(int fase);
    int getFaseCreacion();
    
}
