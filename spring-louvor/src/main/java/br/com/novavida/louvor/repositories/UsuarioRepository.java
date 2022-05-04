package br.com.novavida.louvor.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.novavida.louvor.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	public Optional<Usuario> findByEmailAndSenha(String email, String senha);
	public Optional<Usuario> findByEmail(String email);

}
