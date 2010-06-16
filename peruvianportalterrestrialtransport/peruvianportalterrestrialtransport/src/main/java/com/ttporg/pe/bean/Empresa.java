package com.ttporg.pe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Cesar Ricardo.
 * @clase: Empresa.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class Empresa implements Serializable{
 
	private static final long serialVersionUID = 1565137007025265225L;
	
	private Integer	    id;
    private String	    razonSocial;
    private String      ruc;
    private String      pais;
    private String      departamento;
    private String      direccion;
    private String      telefono;
    private String      email;
    private String	    usuario;
    private String	    password; 
    private String	    numTarjetaCredito; 
    private Date	    fechaExpiracionTarjeta; 
    private boolean     estado;
        
    //Objetos Relacionados.
    private List<Agencia> listaAgencias;
    private List<Cliente> listaClientes;
    
    //Constructores ...
    public Empresa(){
        this.listaAgencias = new ArrayList<Agencia>();
        this.listaClientes = new ArrayList<Cliente>();
    }

    public Empresa( Integer id, String razonSocial, String ruc, String pais, String departamento, 
                    String direccion, String telefono, String email, String usuario, String password, 
                    String numTarjetaCredito, Date fechaExpiracionTarjeta, boolean estado, 
                    List<Agencia> listaAgencias, List<Cliente> listaClientes) {
        this.id            = id;
        this.razonSocial   = razonSocial;
        this.ruc           = ruc;
        this.pais          = pais;
        this.departamento  = departamento;
        this.direccion     = direccion;
        this.telefono      = telefono;
        this.email         = email;
        this.usuario       = usuario;
        this.password      = password;
        this.numTarjetaCredito      = numTarjetaCredito;
        this.fechaExpiracionTarjeta = fechaExpiracionTarjeta;
        this.estado        = estado;
        this.listaAgencias = listaAgencias;
        this.listaClientes = listaClientes;
    }    
    
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechaExpiracionTarjeta() {
        return fechaExpiracionTarjeta;
    }

    public void setFechaExpiracionTarjeta(Date fechaExpiracionTarjeta) {
        this.fechaExpiracionTarjeta = fechaExpiracionTarjeta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Agencia> getListaAgencias() {
        return listaAgencias;
    }

    public void setListaAgencias(List<Agencia> listaAgencias) {
        this.listaAgencias = listaAgencias;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public String getNumTarjetaCredito() {
        return numTarjetaCredito;
    }

    public void setNumTarjetaCredito(String numTarjetaCredito) {
        this.numTarjetaCredito = numTarjetaCredito;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }    
 
}
