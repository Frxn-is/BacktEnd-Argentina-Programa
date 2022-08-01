/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafoliofran.franj.Service;

import com.portafoliofran.franj.Entity.Personas;
import com.portafoliofran.franj.Interface.IPersonasService;
import com.portafoliofran.franj.Repository.IPersonasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franj
 */
@Service
public class ImpPersonasService implements IPersonasService{
    @Autowired IPersonasRepository ipersonasRepository;
    
    @Override
    public List<Personas> getPersonas() {
        List<Personas> personas = ipersonasRepository.findAll();
        return personas;
    }

    @Override
    public void savePersonas(Personas personas) {
        ipersonasRepository.save(personas);
    }

    @Override
    public void deletePersonas(Long id) {
        ipersonasRepository.deleteById(id);
    }

    @Override
    public Personas findPersonas(Long id) {
        Personas personas = ipersonasRepository.findById(id).orElse(null);
        return personas;
        
    }
    
}
