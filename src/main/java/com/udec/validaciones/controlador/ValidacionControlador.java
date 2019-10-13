/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.validaciones.controlador;

import com.udec.validaciones.modelo.Logica;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;


/**
 *
 * @author tmore
 */
@Named(value = "validacionControlador")
@SessionScoped
public class ValidacionControlador implements Serializable{
    private String mensajeVacio;
    private String mensajeTamaño;
    private String mensajeCorreo;
    private String mensajeValores;
    private String mensajeFechas;
    private String mensajeMoneda;
    private String escuchadorBoton;
    Logica logica = new Logica();
    private String campoVacio;
    
    public ValidacionControlador() {
    }
    public void validarVacio(){
        logica.validarVacio(mensajeVacio);
        setMensajeVacio(logica.getMensaje());
    }
    public void validarTama(){
        logica.validarTama(mensajeTamaño);
        setMensajeTamaño(logica.getMensaje());
    }
    public void validarCorreo(){
        logica.validarCorreo(mensajeCorreo);
        setMensajeCorreo(logica.getMensaje());
    }
    public void validarValores(){
        logica.validarValores(mensajeValores);
        setMensajeValores(logica.getMensaje());
    }
    public void validarFechas(){
        logica.validarFecha(mensajeFechas);
        setMensajeFechas(logica.getMensaje());
    }
    public void validarMoneda(){
        logica.validarMoneda(mensajeMoneda);
        setMensajeMoneda(logica.getMensaje());
    }

    public String getEscuchadorBoton() {
        validarVacio();
        validarTama();
        validarValores();
        validarCorreo();
        validarFechas();
        validarMoneda();
        return "";
    }

    public void setEscuchadorBoton(String escuchadorBoton) {
        this.escuchadorBoton = escuchadorBoton;
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

    public String getCampoVacio() {
        return campoVacio;
    }

    public void setCampoVacio(String campoVacio) {
        this.campoVacio = campoVacio;
    }
    
}
