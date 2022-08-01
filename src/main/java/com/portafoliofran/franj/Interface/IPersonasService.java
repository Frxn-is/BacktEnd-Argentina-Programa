/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafoliofran.franj.Interface;

import com.portafoliofran.franj.Entity.Personas;
import java.util.List;


/**
 *
 * @author franj
 */
public interface IPersonasService {
    //trae´personas
    public List<Personas> getPersonas();
    
    //guardar objeto tipo personas
    public void savePersonas(Personas personas);
    
    //Eliminar personas
    public void deletePersonas(Long id);
    
    //Buscar personas
    public Personas findPersonas(Long id);
    

}
