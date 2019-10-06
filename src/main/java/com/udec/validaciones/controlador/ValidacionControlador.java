/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.validaciones.controlador;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author tmore
 */
@Named(value = "validacionControlador")
@Dependent

public class ValidacionControlador {

    /**
     * Creates a new instance of ValidacionControlador
     */
    public ValidacionControlador() {
    }
    public String redirigir(){
        return "validacionControlador";
    }
    
}
