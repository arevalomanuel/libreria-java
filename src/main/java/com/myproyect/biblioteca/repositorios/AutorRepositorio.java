/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproyect.biblioteca.repositorios;

import com.myproyect.biblioteca.entidadas.Autor;
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
public interface AutorRepositorio extends JpaRepository<Autor, String> {  
    @Query("SELECT a FROM Autor a WHERE a.nombre = :nombre")
    public List<Autor>  buscarPorNombre(@Param("nombre") String nombre);
}
