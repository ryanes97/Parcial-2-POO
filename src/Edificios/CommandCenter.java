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
public class CommandCenter implements Edificios{
    String nombre = "Centro de Comando";
    int vida,nivel;
    int faseConstruccion,costoOro,costoEnergia,costoProvisiones,faseCreacion;
    int StorageOro, StorageEnergia,StorageProvisiones;

    public CommandCenter() {
        this.vida = 3000;
        this.faseConstruccion = 0;
        this.faseCreacion = 0;
        this.StorageEnergia = 500;
        this.StorageOro = 500;
        this.StorageProvisiones = 500;
        this.nivel = 1;
        this.costoEnergia = 450;
        this.costoProvisiones = 400;
        this.costoOro = 300;
    }

    @Override
    public int getNivel() {
        return nivel;
    }

    @Override
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
   @Override
    public String getNombre() {
        return this.nombre;
       }

    @Override
    public int getVida() {
        return this.vida;
       }

    @Override
    public int getFaseConstruccion() {
        return this.faseConstruccion;
        }
    
    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }
    
    @Override
    public void setFaseconstruccion(int fase) {
        this.faseConstruccion = fase;
    }

    @Override
    public int getStorageOro() {
        return StorageOro;
    }

    @Override
    public int getStorageEnergia() {
        return StorageEnergia;
    }

    @Override
    public int getStorageProvisiones() {
        return StorageProvisiones;
    }

    @Override
    public void setStorageOro(int StorageOro) {
        this.StorageOro = StorageOro;
    }

    @Override
    public void setStorageEnergia(int StorageEnergia) {
        this.StorageEnergia = StorageEnergia;
    }

    @Override
    public void setStorageProvisiones(int StorageProvisiones) {
        this.StorageProvisiones = StorageProvisiones;
    }

    @Override
    public int getCostoOro() {
        return costoOro;
    }

    @Override
    public int getCostoEnergia() {
        return costoEnergia;
    }

    @Override
    public int getCostoProvisiones() {
        return costoProvisiones;
    }
    
    @Override
    public void setCostoOro(int costoOro) {
        this.costoOro = costoOro;
    }
    @Override
    public void setCostoEnergia(int costoEnergia) {
        this.costoEnergia = costoEnergia;
    }

    @Override
    public void setCostoProvisiones(int costoProvisiones) {
        this.costoProvisiones = costoProvisiones;
    }
        
    @Override
    public void setFaseCreacion(int fase) {
        this.faseCreacion = fase;
    }

    @Override
    public int getFaseCreacion() {
        return faseCreacion;
    }
    
}
