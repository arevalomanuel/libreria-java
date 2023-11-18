package com.myproyect.biblioteca.servicios;

import com.myproyect.biblioteca.entidadas.Autor;
import com.myproyect.biblioteca.repositorios.AutorRepositorio;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sower
 */
@Service
public class AutorServicio {

    @Autowired
    AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre) {
        Autor autor = new Autor();

        autor.setNombre(nombre);

        autorRepositorio.save(autor);
    }

    public List<Autor> listarAutores() {
        List<Autor> autores = new ArrayList();

        autores = autorRepositorio.findAll();

        return autores;
    }

    public void modificarAutor(String nombre, String id) {

        Optional<Autor> respuestaAutor = autorRepositorio.findById(id);
        
        if (respuestaAutor.isPresent()) {
            Autor autor = respuestaAutor.get();
            
            autor.setNombre(nombre);
            
            autorRepositorio.save(autor);
        }

    }
}
