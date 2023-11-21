/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproyect.biblioteca.repositorios;

import com.myproyect.biblioteca.entidadas.Editorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sower
 */
@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String> {
    @Query("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
    public List<Editorial>  buscarPorNombre(@Param("nombre") String nombre);
}
