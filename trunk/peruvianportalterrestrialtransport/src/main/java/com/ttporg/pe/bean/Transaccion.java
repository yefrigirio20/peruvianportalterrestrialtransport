package com.ttporg.pe.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Cesar Ricardo.
 * @clase: Transaccion.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class Transaccion implements Serializable{
 
	private static long serialVersionUID = 1790104835598537803L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

	private Integer idT;
	private Pago pago;
	private Empresa  empresa;
	private Cliente cliente;
        private Vehiculo vehiculo;
        private Integer	idAsiento;
        private Double	monto;
        
    //Constructores ...
    public Transaccion(){
        
    }

    /**
     * @return the idT
     */
    public Integer getIdT() {
        return idT;
    }

    /**
     * @param idT the idT to set
     */
    public void setIdT(Integer idT) {
        this.idT = idT;
    }

    /**
     * @return the pago
     */
    public Pago getPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(Pago pago) {
        this.pago = pago;
    }

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return the idAsiento
     */
    public Integer getIdAsiento() {
        return idAsiento;
    }

    /**
     * @param idAsiento the idAsiento to set
     */
    public void setIdAsiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }

    /**
     * @return the monto
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(Double monto) {
        this.monto = monto;
    }
   
}
