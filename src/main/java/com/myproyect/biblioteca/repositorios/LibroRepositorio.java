/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproyect.biblioteca.repositorios;

import com.myproyect.biblioteca.entidadas.Libro;
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
public interface LibroRepositorio extends JpaRepository<Libro, Long>{
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    public Libro bucarPorTitulo(@Param("titulo") String titulo);
    
    @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre")
    public List<Libro>  buscarPorNombre(@Param("nombre") String nombre);
}
