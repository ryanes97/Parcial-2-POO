/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercito;

/**
 *
 * @author ryane
 */
public class Soldado implements Ejercito{
    private String nombre = "Soldado";
    private int vida,faseEntrenamiento,costoOro,costoEnergia,costoProvisiones;
    private int faseCreacion,danio;
    
    public Soldado() {
        this.vida = 200;
        this.faseEntrenamiento = 1;
        this.costoOro = 25;
        this.costoEnergia = 30;
        this.costoProvisiones = 20;
        this.faseCreacion = 0;
        this.danio = 500;
    }
     @Override
    public int getDanio() {
        return danio;
    }

    @Override
    public void setDanio(int danio) {
        this.danio = danio;
    }
    
    @Override
    public void atacar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public int getFaseEntrenamiento() {
        return this.faseEntrenamiento;
        }
    
    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }
    
    @Override
    public void setFaseEntrenamiento(int fase) {
        this.faseEntrenamiento= fase;
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
    
    @Override
    public void setFaseCreacion(int fase) {
        this.faseCreacion = fase;
    }

    @Override
    public int getFaseCreacion() {
        return faseCreacion;
    }
    
}
