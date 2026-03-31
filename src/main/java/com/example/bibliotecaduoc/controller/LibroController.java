package com.example.bibliotecaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/v1/libros")

public class LibroController {
    @Autowired
    private LibroService libroService;

      @GetMapping("seed")
    public String getSeed() {
        libroService.datosFake();
        return "Datos cargados!!!";
    }

    @GetMapping
    public List<Libro> getLibros() {
        return libroService.readAll();
    }

    @PostMapping
    public Libro postLibro(@RequestBody Libro libro) {
        return libroService.create(libro);
    }

    @GetMapping("{id}")
    public Libro getLibroporId(@PathVariable int id) {
        return libroService.readById(id);
    }
    
    @GetMapping("isbn/{isbn}")
    public Libro getLibroporIsbn(@PathVariable String isbn) {
        return libroService.readbyIsbn(isbn);
    }

    @PutMapping("{id}")
    public Libro putLibro(@PathVariable int id, @RequestBody Libro libro) {
        return libroService.updateLibro(id,libro);
    }
    
    @DeleteMapping("eliminar/{id}")
    public String deleteLibro(@PathVariable int id){
        if(libroService.delete(id)){
             return "Libro eliminado";
        }
        return "No fue posible eliminar";
       
    }

}
