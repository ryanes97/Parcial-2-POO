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
public class Avion implements Vehiculo{
    private String nombre = "Avion de Combate";
    private int vida,faseEntrenamiento,costoOro,costoEnergia,costoProvisiones;
    private int faseCreacion,danio;

    public Avion() {
        this.vida = 600;
        this.faseEntrenamiento = 3;
        this.costoOro = 120;
        this.costoEnergia = 90;
        this.costoProvisiones = 45;
        this.faseCreacion = 0;
        this.danio = 1200;
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
