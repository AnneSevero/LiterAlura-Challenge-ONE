package br.com.alura.LiterAlura.model;

import br.com.alura.LiterAlura.model.DadosAutor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(@JsonAlias("title") String titulo,
                       @JsonAlias("download_count") Double numeroDownload,
                       @JsonAlias("languages") List<String> idioma,
                       @JsonAlias("authors") List<DadosAutor> autores) {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("Autor(es): \n");
        for (DadosAutor autor : autores) {
            sb.append("  - ").append(autor.autor()).append("\n");
        }
        sb.append("Idioma(s): ").append(String.join(", ", idioma)).append("\n");
        sb.append("Downloads: ").append(numeroDownload).append("\n");
        sb.append("----------------------------------------");
        return sb.toString();
    }

}
