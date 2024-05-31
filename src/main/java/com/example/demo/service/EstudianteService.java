package com.example.demo.service;

import com.example.demo.model.dto.EstudianteDTO;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface EstudianteService {
    
    public EstudianteDTO consultarEstudiantePorId(long id);
    public List<EstudianteDTO> listarEstudiantes();
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDto);
    public EstudianteDTO actualizarEstudiante(EstudianteDTO estudianteDto);
    public boolean borrarEstudiante(long id);
    public void uploadFile(InputStream inputStream);

}
