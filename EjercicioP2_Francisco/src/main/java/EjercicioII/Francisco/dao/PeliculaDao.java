/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EjercicioII.Francisco.dao;

/**
 *
 * @author Francisco
 */
import EjercicioII.Francisco.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaDao extends JpaRepository <Pelicula,Long> {
    
}
