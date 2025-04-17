/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioII.Francisco.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Francisco
 */
@Data
@Entity
@Table(name="pelicula")
public class Pelicula implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Long idPelicula;
    private String titulo;
    private float precio;
    private String director;
    private String idioma;
    private int existencias;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    Categoria categoria;
    
    public Pelicula(){
        
    }
    
    public Pelicula(String titulo, boolean activo){
        this.titulo = titulo;
        this.activo = activo;
    }
    
}
