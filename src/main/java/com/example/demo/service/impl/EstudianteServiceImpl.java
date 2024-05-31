/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.model.dto.Estudiante;
import com.test.cliente.*;
import com.example.demo.model.dto.EstudianteDTO;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.service.EstudianteService;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author ASUS
 */
@Service
public class EstudianteServiceImpl implements EstudianteService {
    
    @Autowired
    EstudianteRepository estudianteRepository;
    
    @Override
    public EstudianteDTO consultarEstudiantePorId(long id) {
     Optional<Estudiante> estudiante;
        estudiante = estudianteRepository.findById(id);
       
      return new EstudianteDTO(estudiante.get().getId(),
                               estudiante.get().getNombre(),
                               estudiante.get().getIdentificacion(),
                               estudiante.get().getFecha(),
                               estudiante.get().getEstado(), estudiante.get().getMaterias());
             
    }

    @Override
    public List<EstudianteDTO> listarEstudiantes() {
    	this.consumirSoap();
         List<Estudiante> lista=(List<Estudiante>)estudianteRepository.findAll();
         
    /*   List<EstudianteDTO> estudiantesDTO=   lista.stream()
                .map(estudiante->new EstudianteDTO(estudiante.getId(),
                               estudiante.getNombre(),
                               estudiante.getIdentificacion(),
                               estudiante.getFecha(),
                               estudiante.getEstado()))
                .collect(Collectors.toList());*/
       List<EstudianteDTO> estudiantesDTO=   lista.stream()
                .map(EstudianteDTO::new)
                .collect(Collectors.toList());
      
       return estudiantesDTO;
    }

    @Override
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDto) {
        Estudiante ent=estudianteDto.mapToEntity();
         Estudiante estudiante= estudianteRepository.save(ent);
         if(estudiante!=null){
            try {
                byte[] decodeBytes= Base64.getDecoder().decode(estudianteDto.getFile());
                Files.write(Paths.get("./fotos/"+estudiante.getId()+".png"),decodeBytes);
            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.getLogger(EstudianteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         return new EstudianteDTO(estudiante.getId(),
                               estudiante.getNombre(),
                               estudiante.getIdentificacion(),
                               estudiante.getFecha(),
                               estudiante.getEstado(), estudiante.getMaterias()); 
         
    }

    @Override
    public EstudianteDTO actualizarEstudiante(EstudianteDTO estudianteDto) {
         Estudiante estudiante= estudianteRepository.save(estudianteDto.mapToEntity());
         
         return new EstudianteDTO(estudiante.getId(),
                               estudiante.getNombre(),
                               estudiante.getIdentificacion(),
                               estudiante.getFecha(),
                               estudiante.getEstado(), estudiante.getMaterias()); 
    }

    @Override
    public boolean borrarEstudiante(long id) {
        try{
         estudianteRepository.deleteById(id);
        }catch(Exception e){
             return false;
        }
        return true;
    }
    
    @Override
  public void uploadFile(InputStream inputStream) {
  }
    
    public void consumirSoap() {
    	Testing srv;
		try {
			System.out.println("consumiendo el servicio");
			srv = new Testing_Service(new URL("http://26.194.54.50:7080/wsPruebas/testing")).getTestingPort();
			System.out.println(srv.hello("Luis"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
}
