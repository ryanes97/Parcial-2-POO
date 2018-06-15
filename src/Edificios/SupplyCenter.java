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
public class SupplyCenter implements Edificios{
    String nombre = "Supply Center";
    private int vida,faseConstruccion,costoOro,costoEnergia,costoProvisiones,faseCreacion;
    
    public SupplyCenter() {
        this.vida = 1200;
        this.faseConstruccion = 2;
        this.costoOro = 50;
        this.costoEnergia = 35;
        this.costoProvisiones = 0;
        this.faseCreacion = 1;
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
    public void setFaseCreacion(int fase) {
        this.faseCreacion = fase;
    }

    @Override
    public int getFaseCreacion() {
        return faseCreacion;
    }
    @Override
    public int getStorageOro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getStorageEnergia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getStorageProvisiones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStorageOro(int StorageOro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStorageEnergia(int StorageEnergia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStorageProvisiones(int StorageProvisiones) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNivel(int nivel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCostoOro(int oro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCostoEnergia(int energia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCostoProvisiones(int provisiones) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
