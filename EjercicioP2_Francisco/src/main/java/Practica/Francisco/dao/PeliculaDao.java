/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Practica.Francisco.dao;

/**
 *
 * @author Francisco
 */
import Practica.Francisco.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaDao extends JpaRepository <Pelicula,Long> {
    
}
