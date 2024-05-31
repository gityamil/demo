/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.example.demo.model.dto.EstudianteDTO;
import com.example.demo.service.EstudianteService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@RestController() 
public class RestContoller {
    @Autowired 
    EstudianteService estudianteService;
    
    @GetMapping(value="/consultar/{id}")
    ResponseEntity<EstudianteDTO> consultarEstudiante(@PathVariable Long id){
       EstudianteDTO e=estudianteService.consultarEstudiantePorId(id);
      return new ResponseEntity<>(e,HttpStatus.OK);
    }
     @GetMapping(value="/listar")
    ResponseEntity<List<EstudianteDTO>> listarEstudiantes(){
       List<EstudianteDTO> e=estudianteService.listarEstudiantes();
      return new ResponseEntity<>(e,HttpStatus.OK);
    }
    
    @PostMapping(value="/actualizar",  produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EstudianteDTO> actualizarEstudiante(@RequestBody EstudianteDTO estudiante){
      EstudianteDTO e=estudianteService.actualizarEstudiante(estudiante);
      return new ResponseEntity<>(e,HttpStatus.OK);
    }
    
    @GetMapping(value="/borrar/{id}")
    ResponseEntity<Boolean> borrarEstudiante(@PathVariable Long id){
       Boolean e=estudianteService.borrarEstudiante(id);
      return new ResponseEntity<>(e,HttpStatus.OK);
    }
    
    @PostMapping(value="/insertar",  produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EstudianteDTO> crearEstudiantes(@RequestBody EstudianteDTO estudiante){
       EstudianteDTO e=estudianteService.crearEstudiante(estudiante);
      return new ResponseEntity<>(e,HttpStatus.OK);
    }
    
    @PostMapping("/upload")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
      estudianteService.uploadFile(file.getInputStream());
    }
}
