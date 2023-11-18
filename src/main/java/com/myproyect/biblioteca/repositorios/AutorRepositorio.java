/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproyect.biblioteca.repositorios;

import com.myproyect.biblioteca.entidadas.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sower
 */
@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String> {
    
}
