/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.validaciones.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author AndresChila
 */
public class Logica {

    private String mensaje;
    public boolean validarVacio(String algo){
        try{
        if(algo.length()==0){
            this.setMensaje("Debe completar el campo vacio");
            return false;
        }
        }catch(Exception e){
            if(e.getMessage().equals("NullPointerExeption")){
                this.setMensaje("Debe completar el campo vacio");
                return false;
            }
        }
        this.setMensaje("");
        return true;
    }

    public boolean validarTama(String palabra) {
        if (palabra.length() < 5) {
            this.setMensaje("La longitud del valor debe ser mayor o igual a 5");
            return false;
        }
        if (palabra.length() >= 10) {
            this.setMensaje("La longitud del valor debe ser menor a 10");
            return false;
        }
        this.setMensaje("");
        return true;
    }

    public boolean validarCorreo(String correo) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        if (mather.find() == true) {
            this.setMensaje("");
            return true;
        } else {
            this.setMensaje("Debe escribir un correo valido. Ejemplo: nombre@domunio.com");
            return false;
        }
    }

    public boolean validarValores(String valor) {
        if (Integer.parseInt(valor) < -10 || Integer.parseInt(valor) > -10) {
            this.setMensaje("El valor ingresado debe ser mayor a -10 y menor a 10");
            return false;
        }
        this.setMensaje("");
        return true;
    }

    public boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            this.setMensaje("Fecha no valida, el formato es dd/MM/AAAA");
            return false;
        }
        this.setMensaje("");
        return true;
    }
    public boolean validarMoneda(String moneda){
        if(moneda.charAt(0)!= '$'){
            this.setMensaje("Formato de moneda no valido, debe empezar por el signo pesos ($). Ejemplo: $500");
            return false;
        }
        this.setMensaje("");
        return true;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
