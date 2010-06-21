package com.ttporg.pe.util;

import com.ttporg.pe.dto.BeanSingleton;
 
/**
 * UtilSingleton
 * @author cguerraa
 **/
public class UtilSingleton{

   //---- CAMPOS QUE SE GUARDARAN EN MEMORIA. ----//
   private static  BeanSingleton objetoSingleton;
   private boolean estadoActivacion = false;
   //---------------------------------------------//

   private static UtilSingleton INSTANCIA_GUARDADA = null;

    //Private constructor suppresses
    private UtilSingleton(){
    }

    //creador sincronizado para protegerse de posibles problemas multi-hilo
    //otra prueba para evitar instanciación múltiple.
    private synchronized static void creaInstancia(){
        if( INSTANCIA_GUARDADA == null ){
            INSTANCIA_GUARDADA = new UtilSingleton();

            objetoSingleton = new BeanSingleton();
        }
    }

    public static UtilSingleton getInstancia(){

        if( INSTANCIA_GUARDADA == null ){
            creaInstancia();
        }

        return INSTANCIA_GUARDADA;
    }

    public static UtilSingleton getINSTANCIA_GUARDADA() {
        return INSTANCIA_GUARDADA;
    }


    public static void setINSTANCIA_GUARDADA( UtilSingleton INSTANCIA_GUARDADA) {
        UtilSingleton.INSTANCIA_GUARDADA = INSTANCIA_GUARDADA;
    }

    /*********** METODOS DE ACCESO ***********/

    public BeanSingleton getObjetoSingleton() {
        return objetoSingleton;
    }

    public void setObjetoSingleton(BeanSingleton objetoSingleton) {
        this.objetoSingleton = objetoSingleton;
    }

    public boolean isEstadoActivacion() {
        return estadoActivacion;
    }

    public void setEstadoActivacion(boolean estadoActivacion) {
        this.estadoActivacion = estadoActivacion;
    }

}
