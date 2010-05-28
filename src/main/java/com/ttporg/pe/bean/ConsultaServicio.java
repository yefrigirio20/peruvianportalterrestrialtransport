package com.ttporg.pe.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Monica
 * @clase: ConsultaServicio.java  
 */
public class ConsultaServicio implements Serializable{

	private static final long	serialVersionUID	= 3369677465651442809L;
	
	private String  departamento;
	private Integer	idEmpresa;
	private String	transporte;
	private Date	fechaConsulta;
	private String	origen;
	private String	destino;
	private String	salida;
	private String	duracion;
	private Double  duracionMinutos;
	private Integer nroAsientos;

	//Constructores ...
	public ConsultaServicio(){
	}

	public ConsultaServicio(  String departamento, Integer idEmpresa, String transporte, Date fechaConsulta, String origen,
			        String destino, String salida, String duracion, Double duracionMinutos, Integer nroAsientos ){
		super();
		this.departamento         = departamento;
		this.idEmpresa    = idEmpresa;
		this.transporte  = transporte;
		this.fechaConsulta = fechaConsulta;
		this.origen  = origen;
		this.destino       = destino;
		this.salida    = salida;
		this.duracion  = duracion;
		this.duracionMinutos      = duracionMinutos;
		this.nroAsientos     = nroAsientos;
	}

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the idEmpresa
     */
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * @return the transporte
     */
    public String getTransporte() {
        return transporte;
    }

    /**
     * @param transporte the transporte to set
     */
    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    /**
     * @return the fechaConsulta
     */
    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    /**
     * @param fechaConsulta the fechaConsulta to set
     */
    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the salida
     */
    public String getSalida() {
        return salida;
    }

    /**
     * @param salida the salida to set
     */
    public void setSalida(String salida) {
        this.salida = salida;
    }

    /**
     * @return the duracion
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the duracionMinutos
     */
    public Double getDuracionMinutos() {
        return duracionMinutos;
    }

    /**
     * @param duracionMinutos the duracionMinutos to set
     */
    public void setDuracionMinutos(Double duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    /**
     * @return the nroAsientos
     */
    public Integer getNroAsientos() {
        return nroAsientos;
    }

    /**
     * @param nroAsientos the nroAsientos to set
     */
    public void setNroAsientos(Integer nroAsientos) {
        this.nroAsientos = nroAsientos;
    }
}