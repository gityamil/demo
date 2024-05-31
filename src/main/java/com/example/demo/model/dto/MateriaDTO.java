/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.dto;

/**
 *
 * @author ASUS
 */

public class MateriaDTO {

    public MateriaDTO(Materia materia) {
        this.id = materia.getId();
        this.nombreMateria = materia.getNombreMateria();
        this.creditos =materia.getCreditos();
        
    }
    
    public MateriaDTO(){
    }
    
    
 public Materia mapToEntity(Estudiante e){
       Materia m = new Materia();
       
       if(this.getId()>0){
       m.setId(this.getId());
       }
       m.setNombreMateria(this.getNombreMateria());
       m.setCreditos(this.getCreditos());
       m.setEstudiante(e);
       return m;
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
     * @return the nombreMateria
     */
    public String getNombreMateria() {
        return nombreMateria;
    }

    /**
     * @param nombreMateria the nombreMateria to set
     */
    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    /**
     * @return the creditos
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    private long id;
    private String nombreMateria;
    private int creditos;
    
    
}
