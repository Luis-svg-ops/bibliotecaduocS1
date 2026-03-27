package com.example.bibliotecaduoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> readAll() {
        return libroRepository.leerTodos();
    }

    public Libro create(Libro libro) {
        return libroRepository.guardar(libro);
    }
}
