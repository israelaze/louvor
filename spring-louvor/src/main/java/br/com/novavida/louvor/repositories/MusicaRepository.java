package br.com.novavida.louvor.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.novavida.louvor.entities.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer> {

	@Query("from Musica m where m.nome = :param1 and m.artista = :param2") // JPQL
	public Optional<Musica> findByNomeAndfindByArtista(@Param("param1") String nome, @Param("param2") String artista);
}
