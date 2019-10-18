/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.validaciones.controlador;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

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
public class OtrasValidaciones implements Serializable {

    private String mensajeVacio = "";
    private String mensajeTamaño = "";
    private String mensajeCorreo = "";
    private String mensajeValores = "";
    private String mensajeFechas = "";
    private String mensajeMoneda = "";
    private String mensajeError = "";

    //Logica logica = new Logica();
    /**
     * metodo el cual llama a la logica e invoca todos los metodos de
     * validaciones
     *
     * @param context
     * @param toValidate
     * @param value
     */
    public void validarVacio(FacesContext context, UIComponent toValidate, Object value) {
        //setMensajeError(logica.validarTodo(mensajeVacio, mensajeTamaño, mensajeCorreo, mensajeValores, mensajeFechas, mensajeMoneda));
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (texto.equals("")) {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Debe llenar el campo"));
        }
    }

    public void validarTama(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;

        if (!texto.equals("")) {
            if (texto.length() < 5 || texto.length() > 10) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(toValidate.getClientId(context), new FacesMessage("la longitud del texto debe ser mayor a 5 y menor a 10 caracteres"));
            } else {

            }
        } else {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Debe llenar el campo"));
        }
    }

    public void validarEmail(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (!texto.equals("")) {
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(texto);
            if (mather.find() == false) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(toValidate.getClientId(context), new FacesMessage("debe escribir un correo valido. ejemplo: nombre@dominio.com"));
            }
        } else {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Debe llenar el campo"));
        }
    }

    public void validarValores(FacesContext context, UIComponent toValidate, Object value) {
        //setMensajeError(logica.validarTodo(mensajeVacio, mensajeTamaño, mensajeCorreo, mensajeValores, mensajeFechas, mensajeMoneda));
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (!texto.equals("")) {
            if (Integer.parseInt(texto) < -10 || Integer.parseInt(texto) > 10) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(toValidate.getClientId(context), new FacesMessage("El valor debe estar entre -10 y 10"));
            }
        } else {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Debe llenar el campo"));
        }
    }

    public void validarFecha(FacesContext context, UIComponent toValidate, Object value) {
        //setMensajeError(logica.validarTodo(mensajeVacio, mensajeTamaño, mensajeCorreo, mensajeValores, mensajeFechas, mensajeMoneda));
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (!texto.equals("")) {
            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                formatoFecha.setLenient(false);
                formatoFecha.parse(texto);
            } catch (ParseException e) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(toValidate.getClientId(context), new FacesMessage("Fecha no valida, el formato es dd/MM/AAAA"));
            }
        } else {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Debe llenar el campo"));
        }
    }

    public void validarMoneda(FacesContext context, UIComponent toValidate, Object value) {
        //setMensajeError(logica.validarTodo(mensajeVacio, mensajeTamaño, mensajeCorreo, mensajeValores, mensajeFechas, mensajeMoneda));
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (!texto.equals("")) {
            if (texto.charAt(0) != '$') {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(toValidate.getClientId(context), new FacesMessage("Formato de moneda no valido, debe empezar por el signo pesos ($). Ejemplo: $500"));
            }
        } else {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Debe llenar el campo"));
        }
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
