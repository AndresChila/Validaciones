/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.validaciones.controlador;

import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



/**
 *
 * @author AndresChila
 */
@ManagedBean(name = "validacionControlador")
@ViewScoped
@Dependent
/**
 * Clase controlador que tiene validaciones por anotaciones
 */
public class ValidacionControlador {
    @NotNull(message = "Debe llenar el campo")
    private String mensajeVacio;
    @NotNull(message = "Debe llenar el campo") @Size(min = 5, message = "El tamaño del dato debe ser mayor a 5")
    private String mensajeTamaño;
    @NotNull(message = "Debe llenar el campo") @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "debe escribir un correo valido. ejemplo: nombre@dominio.com")
    private String mensajeCorreo;
    @NotNull(message = "Debe llenar el campo") @Min(-10) @Max(10)
    private String mensajeValores;
    @NotNull(message = "Debe llenar el campo") @Temporal(TemporalType.DATE)
    private String mensajeFechas;
    @NotNull(message = "Debe llenar el campo") @DecimalMin(value = "1.00", message = "debe ingresar un valor positivo")
    private double mensajeMoneda;

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

    public double getMensajeMoneda() {
        return mensajeMoneda;
    }

    public void setMensajeMoneda(double mensajeMoneda) {
        this.mensajeMoneda = mensajeMoneda;
    }
    
}
