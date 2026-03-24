package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {
    

    private List<Libro> listaLibros=new ArrayList<>();

    public List<Libro> obteneLibros(){
        return listaLibros;
    }

    //  Método que busca el libro por id, retorna libro: buscarPorId
    public Libro buscarPorId(int id){
        for (Libro libro : listaLibros) {
            if(libro.getId()==id){
                return libro;
            }
        }
        return null;
    }

    // Método que busca el libro por isbn, retorna libro: buscarPorIsbn
    public Libro buscarPorIsbn(String isbn){
        for (Libro libro : listaLibros) {
            if(libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    //Método que guarda el libro en el arreglo y retorna libro: guardar

    public Libro guardar(Libro book){
        listaLibros.add(book);
        return book;
    }

    //Método que actualiza el libro por el id, retorna libro actualizado: actualizar
    public Libro actualizar(Libro book){
        Libro libroBuscado=buscarPorId(book.getId());
        if(libroBuscado!=null){
            libroBuscado.setIsbn(book.getIsbn());
            libroBuscado.setAutor(book.getAutor());
            libroBuscado.setEditorial(book.getEditorial());
            libroBuscado.setFechaPublicacion(book.getFechaPublicacion());
            libroBuscado.setTitulo(book.getTitulo());
            return libroBuscado;
        }
        return null;
    }

    //eliminar
    public void eliminar(int id){
        listaLibros.removeIf(book->book.getId()==id);
    }
}
