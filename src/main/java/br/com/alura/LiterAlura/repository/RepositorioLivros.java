package br.com.alura.LiterAlura.repository;

import br.com.alura.LiterAlura.model.Autor;
import br.com.alura.LiterAlura.model.Livro;
import br.com.alura.LiterAlura.model.LivroDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public interface RepositorioLivros extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l WHERE LOWER(l.titulo) = LOWER(:titulo)")
    static List<Livro> findByTitulo(String titulo) {
        return null;
    }

    @Query("SELECT a FROM Autor a WHERE a.anoNascimento <= :ano AND (a.anoFalecimento IS NULL OR a.anoFalecimento >= :ano)")
    static List<Autor> findAutoresVivos(@Param("ano") Year ano) {
        return null;
    }

    @Query("SELECT a FROM Autor a WHERE a.anoNascimento = :ano AND (a.anoFalecimento IS NULL OR a.anoFalecimento >= :ano)")
    static List<Autor> findAutoresVivosRefinado(@Param("ano") Year ano) {
        return null;
    }

    @Query("SELECT a FROM Autor a WHERE a.anoNascimento <= :ano AND a.anoFalecimento = :ano")
    static List<Autor> findAutoresPorAnoDeMorte(@Param("ano") Year ano) {
        return null;
    }

    @Query("SELECT l FROM Livro l WHERE l.idioma LIKE %:idioma%")
    static List<Livro> findByIdioma(@Param("idioma") String idioma) {
        return null;
    }

}