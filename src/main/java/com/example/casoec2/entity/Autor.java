/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.casoec2.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Juan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autor implements Serializable{
    private int idautor;
    private String nombre;
    private String apellido;
}
