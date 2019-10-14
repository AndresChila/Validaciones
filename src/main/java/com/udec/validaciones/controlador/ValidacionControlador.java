/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.validaciones.controlador;

import com.udec.validaciones.modelo.Logica;
import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author tmore
 */
@ManagedBean(name = "validacionControlador")
@ViewScoped
@Dependent
/**
 * Clase controlador de la vista "validacionControlador"
 */
public class ValidacionControlador implements Serializable{
    private String mensajeVacio="";
    private String mensajeTamaño="";
    private String mensajeCorreo="";
    private String mensajeValores="";
    private String mensajeFechas="";
    private String mensajeMoneda="";
    private String mensajeError="";
    Logica logica = new Logica();
    /**
     * metodo el cual llama a la logica e invoca todos los metodos de validaciones
     */
    public void escuchadorBoton() {
        setMensajeError(logica.validarTodo(mensajeVacio, mensajeTamaño, mensajeCorreo, mensajeValores, mensajeFechas, mensajeMoneda));
    }
    
    public String getMensajeVacio() {
        return mensajeVacio;
    }

    public void setMensajeVacio(String mensajeVacio) {
        this.mensajeVacio = mensajeVacio;
    }

    public String getMensajeTamaño() {
        return mensajeTamaño;
    }

    public void setMensajeTamaño(String mensajeTamaño) {
        this.mensajeTamaño = mensajeTamaño;
    }

    public String getMensajeCorreo() {
        return mensajeCorreo;
    }

    public void setMensajeCorreo(String mensajeCorreo) {
        this.mensajeCorreo = mensajeCorreo;
    }

    public String getMensajeValores() {
        return mensajeValores;
    }

    public void setMensajeValores(String mensajeValores) {
        this.mensajeValores = mensajeValores;
    }

    public String getMensajeFechas() {
        return mensajeFechas;
    }

    public void setMensajeFechas(String mensajeFechas) {
        this.mensajeFechas = mensajeFechas;
    }

    public String getMensajeMoneda() {
        return mensajeMoneda;
    }

    public void setMensajeMoneda(String mensajeMoneda) {
        this.mensajeMoneda = mensajeMoneda;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
    
}
