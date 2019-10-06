/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.validaciones.controlador;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.validation.constraints.NotNull;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;

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
    @NotNull(message = "El campo no puede ir vacio")
    private String campoVacio;
    /**
     * Creates a new instance of ValidacionControlador
     */
    public ValidacionControlador() {
    }

    public String getMensajeVacio() {
        return "Debe ingresar un dato.";
    }

    public void setMensajeVacio(String mensajeVacio) {
        this.mensajeVacio = mensajeVacio;
    }

    public String getMensajeTamaño() {
        return "El tamaño del campo debe ser entre 5 y 10 caracteres.";
    }

    public void setMensajeTamaño(String mensajeTamaño) {
        this.mensajeTamaño = mensajeTamaño;
    }

    public String getMensajeCorreo() {
        return "El mensaje no corresponde a la expresion regular.Ejemplo:tmoreno@gamil.com";
    }

    public void setMensajeCorreo(String mensajeCorreo) {
        this.mensajeCorreo = mensajeCorreo;
    }

    public String getMensajeValores() {
        return "Los datos ingresados no son numeros.";
    }

    public void setMensajeValores(String mensajeValores) {
        this.mensajeValores = mensajeValores;
    }

    public String getMensajeFechas() {
        return "El dato inresado no corresponde a un fecha. Ejemplo 12/12/2012";
    }

    public void setMensajeFechas(String mensajeFechas) {
        this.mensajeFechas = mensajeFechas;
    }

    public String getMensajeMoneda() {
        return "No se reconoce como una divisa.Ejemplo: $99,99";
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
    
    public void validarVacio(){
        if(getCampoVacio().length()>0)
         getMensajeVacio();      
    }
    
    
}
