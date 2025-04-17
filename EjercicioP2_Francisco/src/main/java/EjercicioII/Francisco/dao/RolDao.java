/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EjercicioII.Francisco.dao;

import EjercicioII.Francisco.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Francisco
 */
public interface RolDao extends JpaRepository<Rol, Long> {

}