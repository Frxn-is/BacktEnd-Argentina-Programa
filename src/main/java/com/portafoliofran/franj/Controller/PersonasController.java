/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafoliofran.franj.Controller;

import com.portafoliofran.franj.Entity.Personas;
import com.portafoliofran.franj.Interface.IPersonasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author franj
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonasController {
    @Autowired IPersonasService ipersonasService;
    
    @GetMapping("personas/traer")
    public List<Personas> getPersonas(){
        return ipersonasService.getPersonas();
    }
    
    @PostMapping("/personas/crear")
    public String createPersonas(@RequestBody Personas personas){
         ipersonasService.savePersonas(personas);
         return "la persona se creo correctamente";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersonas(@PathVariable Long id){
     ipersonasService.deletePersonas(id);
     return "La personas se borro correctamente";
     }
    
    @PutMapping("/personas/editar/{id}")
    public Personas editPersonas(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevoImg,
            @RequestParam("ubicacion") String nuevoUbicacion,
            @RequestParam("profesion") String nuevoProfesion){
      
        Personas personas =  ipersonasService.findPersonas(id);
        
        personas.setNombre(nuevoNombre);
        personas.setApellido(nuevoApellido);
        personas.setImg(nuevoImg);
        personas.setProfesion(nuevoProfesion);
        personas.setUbicacion(nuevoUbicacion);
        
        ipersonasService.savePersonas(personas);
        return personas;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Personas findPersonas(){
        return ipersonasService.findPersonas((long)1);
    }
}
