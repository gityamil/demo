/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * @author ASUS
 */
public class EstudianteDTO {

    /**
     * @return the file
     */
    public String getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    private long id;
    private String nombre;
    private String identificacion;
    private Date fecha;
    private boolean estado;
    private List<MateriaDTO> materias;
    private String file;

    public EstudianteDTO(long id, String nombre, String identificacion, Date fecha, boolean estado, List<Materia> materias) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.fecha = fecha;
        this.estado = estado;
         this.materias=materias.stream()
                                .map(MateriaDTO::new)
                .collect(Collectors.toList());
    }
public EstudianteDTO(Estudiante estudiante) {
        this.id = estudiante.getId();
        this.nombre = estudiante.getNombre();
        this.identificacion = estudiante.getIdentificacion();
        this.fecha = estudiante.getFecha();
        this.estado = estudiante.getEstado();
        
       this.materias=estudiante.getMaterias().stream()
                                .map(MateriaDTO::new)
                .collect(Collectors.toList());
     
    }
    public EstudianteDTO() {
    }
    
    
    public Estudiante mapToEntity(){
       Estudiante e = new Estudiante();
       e.setEstado(this.isEstado());
       e.setFecha(this.getFecha());
       if(this.getId()>0){
       e.setId(this.getId());
       }
       e.setIdentificacion(this.getIdentificacion());
       e.setNombre(this.getNombre());
      e.setMaterias(
       this.getMaterias().stream().map(m->
         m.mapToEntity(e)
         
       ).collect(Collectors.toList())  
               )   ;
       return e;
    }

    /**
     * @return the materias
     */
    public List<MateriaDTO> getMaterias() {
        return materias;
    }

    /**
     * @param materias the materias to set
     */
    public void setMaterias(List<MateriaDTO> materias) {
        this.materias = materias;
    }
    
    
}
    

