/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica.Francisco.service.impl;

import Practica.Francisco.domain.Pelicula;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Practica.Francisco.service.PeliculaService;
import Practica.Francisco.dao.PeliculaDao;

/**
 *
 * @author Francisco
 */
@Service
public class PeliculaServiceImpl implements PeliculaService {
      @Autowired
    private PeliculaDao peliculaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Pelicula> getPelicula(boolean activos) {
        var lista=peliculaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Pelicula getPelicula(Pelicula pelicula){
        return peliculaDao.findById(pelicula.getIdPelicula()).orElse(null);
    }
    @Override
    @Transactional
    public void save(Pelicula libro) {
        peliculaDao.save(libro);
    }
    
    @Override
    @Transactional
    public void delete(Pelicula pelicula){
        peliculaDao.delete(pelicula);
    }
}
