package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {
    

    private List<Libro> listaLibros=new ArrayList<>();

    public List<Libro> leerTodos() {
        return listaLibros;
    }

    public Libro guardar(Libro libro) {
        listaLibros.add(libro);
        return libro;
    }

 
}
