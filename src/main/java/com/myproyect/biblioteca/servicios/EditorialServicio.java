package com.myproyect.biblioteca.servicios;

import com.myproyect.biblioteca.entidadas.Editorial;
import com.myproyect.biblioteca.repositorios.EditorialRepositorio;
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
public class EditorialServicio {

    @Autowired
    EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre) {
        Editorial editorial = new Editorial();

        editorial.setNombre(nombre);

        editorialRepositorio.save(editorial);
    }

    public List<Editorial> listarEditoriales() {
        List<Editorial> editoriales = new ArrayList();

        editoriales = editorialRepositorio.findAll();

        return editoriales;
    }
    
        public void modificarAutor(String nombre, String id) {

        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(id);
        
        if (respuestaEditorial.isPresent()) {
            Editorial editorial = respuestaEditorial.get();
            
            editorial.setNombre(nombre);
            
            editorialRepositorio.save(editorial);
        }

    }
}
