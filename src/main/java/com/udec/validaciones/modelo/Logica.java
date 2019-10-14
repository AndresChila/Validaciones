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
    public String validarTodo(String va, String ta, String co, String val, String fe, String mo){
        if(validarVacio(va, ta, co, val, fe, mo)){
            if(validarTama(ta)){
                if(validarCorreo(co)){
                    if(validarValores(val)){
                        if(validarFecha(fe)){
                            if(validarMoneda(mo)){ 
                            }
                            else{
                                return "Formato de moneda no valido, debe empezar por el signo pesos ($). Ejemplo: $500";
                            }
                        }
                        else{
                            return "Fecha no valida, el formato es dd/MM/AAAA";
                        }
                    }
                    else{
                        return "El valor ingresado debe ser mayor a -10 y menor a 10";
                    }
                }
                else{
                   return "Debe escribir un correo valido. Ejemplo: nombre@domunio.com"; 
                }
            }
            else{
                return "La longitud del valor debe ser mayor o igual a 5 y debe ser menor a 10";
            }
        }
        else{
            return "Debe completar el campo vacio";
        }
        return "validaciones completas";
    }
    public boolean validarVacio(String va, String ta, String co, String val,String fe, String mo ){
        try{
        if(va.length()==0 || ta.length() ==0 || co.length() ==0 || val.length() ==0 ||fe.length() ==0 ||mo.length() ==0 ){
            //this.setMensajeVacio("Debe completar el campo vacio");
            return false;
        }
        }catch(Exception e){
            if(e.getMessage().equals("NullPointerExeption")){
                //this.setMensajeVacio("Debe completar el campo vacio");
                return false;
            }
        }
        //this.setMensajeVacio("");
        return true;
    }

    public boolean validarTama(String palabra) {
        if (palabra.length() < 5) {
            //this.setMensajeTama("La longitud del valor debe ser mayor o igual a 5");
            return false;
        }
        if (palabra.length() >= 10) {
            //this.setMensajeTama("La longitud del valor debe ser menor a 10");
            return false;
        }
        //this.setMensajeTama("");
        return true;
    }

    public boolean validarCorreo(String correo) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        if (mather.find() == true) {
            //this.setMensajeCorreo("");
            return true;
        } else {
            //this.setMensajeCorreo("Debe escribir un correo valido. Ejemplo: nombre@domunio.com");
            return false;
        }
    }

    public boolean validarValores(String valor) {
        if (Integer.parseInt(valor) < -10 || Integer.parseInt(valor) > 10) {
            //this.setMensajeValor("El valor ingresado debe ser mayor a -10 y menor a 10");
            return false;
        }
        //this.setMensajeValor("");
        return true;
    }

    public boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            //this.setMensajeFecha("Fecha no valida, el formato es dd/MM/AAAA");
            return false;
        }
        //this.setMensajeFecha("");
        return true;
    }
    public boolean validarMoneda(String moneda){
        if(moneda.charAt(0)!= '$'){
            //this.setMensajeMoneda("Formato de moneda no valido, debe empezar por el signo pesos ($). Ejemplo: $500");
            return false;
        }
        //this.setMensajeMoneda("");
        return true;
    }
}
