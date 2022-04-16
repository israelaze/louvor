package br.com.novavida.louvor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.novavida.louvor.entities.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer> {
	

}
