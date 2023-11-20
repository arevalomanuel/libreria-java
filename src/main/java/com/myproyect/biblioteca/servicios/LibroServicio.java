package com.myproyect.biblioteca.servicios;

import com.myproyect.biblioteca.entidadas.Autor;
import com.myproyect.biblioteca.entidadas.Editorial;
import com.myproyect.biblioteca.entidadas.Libro;
import com.myproyect.biblioteca.exepciones.MiExepcion;
import com.myproyect.biblioteca.repositorios.AutorRepositorio;
import com.myproyect.biblioteca.repositorios.EditorialRepositorio;
import com.myproyect.biblioteca.repositorios.LibroRepositorio;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sower
 */
@Service
public class LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearLibro(Long ISBN, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiExepcion {

        validar(ISBN, titulo, ejemplares, idAutor, idEditorial);
        
        Autor autor = autorRepositorio.findById(idAutor).get();
        Editorial editorial = editorialRepositorio.findById(idAutor).get();
        Libro libro = new Libro();

        libro.setISBN(ISBN);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAlta(new Date());

        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);

    }

    public List<Libro> listarLibros() {
        List<Libro> libros = new ArrayList();

        libros = libroRepositorio.findAll();

        return libros;
    }

    public void modificarLibro(Long ISBN, String titulo, String idAutor, String idEditorial, Integer ejemplares) throws MiExepcion{

        validar(ISBN, titulo, ejemplares, idAutor, idEditorial);
         
        Optional<Libro> respuestaLibro = libroRepositorio.findById(ISBN);
        Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);

        Autor autor = new Autor();
        Editorial editorial = new Editorial();

        if (respuestaAutor.isPresent()) {
            autor = respuestaAutor.get();
        }
        if (respuestaEditorial.isPresent()) {
            editorial = respuestaEditorial.get();
        }

        if (respuestaLibro.isPresent()) {
            Libro libro = respuestaLibro.get();

            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setEjemplares(ejemplares);

            libroRepositorio.save(libro);
        }
    }

    private void validar(Long ISBN, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiExepcion{
        if (ISBN == null) {
            throw new MiExepcion("no se encontro el ISBN");
        }

        if (titulo == null || titulo.isEmpty()) {
            throw new MiExepcion("titulo nulo o vacio");

        }

        if (ejemplares == null) {
            throw new MiExepcion("la cantidad de ejemplares tiene que tener un valor");

        }

        if (idAutor == null || idAutor.isEmpty()) {
            throw new MiExepcion("el ID de autor no tienen valores");

        }

        if (idEditorial == null || idEditorial.isEmpty()) {
            throw new MiExepcion("el ID de editorial no tienen valores");

        }
    }
}
