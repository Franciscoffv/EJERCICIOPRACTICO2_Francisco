/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EjercicioII.Francisco.service;

import EjercicioII.Francisco.domain.Pelicula;
import java.util.List;

/**
 *
 * @author Francisco
 */
public interface PeliculaService {  
    public List<Pelicula> getPelicula(boolean activos);
 
    public Pelicula getPelicula(Pelicula pelicula);

    public void save(Pelicula pelicula);
  
    public void delete(Pelicula pelicula);
}
