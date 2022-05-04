package br.com.novavida.louvor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.novavida.louvor.dtos.UsuarioGetDTO;
import br.com.novavida.louvor.dtos.UsuarioPostDTO;
import br.com.novavida.louvor.entities.Usuario;
import br.com.novavida.louvor.exceptions.BadRequestException;
import br.com.novavida.louvor.exceptions.EntityNotFoundException;
import br.com.novavida.louvor.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UsuarioService {

	private final UsuarioRepository repository;
	private final ModelMapper mapper;

	public UsuarioGetDTO cadastrar(UsuarioPostDTO dto) {

		Optional<Usuario> result = repository.findByEmail(dto.getEmail());

		if (result.isPresent()) {
			throw new BadRequestException("Erro: Email já cadastrado!");
		}

		Usuario usuario = new Usuario();
		mapper.map(dto, usuario);

		repository.save(usuario);

		UsuarioGetDTO getDto = new UsuarioGetDTO();
		mapper.map(usuario, getDto);

		return getDto;
	}

	public List<UsuarioGetDTO> buscarTodos() {

		List<UsuarioGetDTO> listaGetDto = new ArrayList<UsuarioGetDTO>();
		List<Usuario> listaUsuarios = repository.findAll();

		for (Usuario usuario : listaUsuarios) {

			UsuarioGetDTO getDto = new UsuarioGetDTO();
			mapper.map(usuario, getDto);

			listaGetDto.add(getDto);
		}

		return listaGetDto;
	}

	public UsuarioGetDTO buscarId(Integer id) {

		Optional<Usuario> result = repository.findById(id);

		if (result.isEmpty()) {
			throw new EntityNotFoundException("Usuário não encontrado.");
		}

		Usuario usuario = result.get();

		UsuarioGetDTO getDto = new UsuarioGetDTO();
		mapper.map(usuario, getDto);

		return getDto;
	}

	public String excluir(Integer id) {

		Optional<Usuario> result = repository.findById(id);

		if (result.isEmpty()) {
			throw new EntityNotFoundException("Usuário não encontrado.");
		}

		Usuario usuario = result.get();

		repository.delete(usuario);

		return "Usuário " + result.get().getNome() + " excluído com sucesso.";
	}

}
