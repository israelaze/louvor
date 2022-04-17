package br.com.novavida.louvor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.novavida.louvor.dtos.MusicaGetDTO;
import br.com.novavida.louvor.dtos.MusicaPostDTO;
import br.com.novavida.louvor.dtos.MusicaPutDTO;
import br.com.novavida.louvor.entities.Musica;
import br.com.novavida.louvor.exceptions.BadRequestException;
import br.com.novavida.louvor.exceptions.EntityNotFoundException;
import br.com.novavida.louvor.repositories.MusicaRepository;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class MusicaServices {
	
	private final MusicaRepository repository;
	private final ModelMapper mapper;
	
	public String cadastrar(MusicaPostDTO dto) {
		
		Optional<Musica> result = repository.findByNomeAndfindByArtista(dto.getNome(), dto.getArtista());
		
		if(result.isPresent()) {
			throw new BadRequestException("Música já cadastrada!");
		}
		
		Musica musica = new Musica();
		mapper.map(dto, musica);
		
		repository.save(musica);
		
		return "Cadastrada com sucesso.";
	}
	
	public List<MusicaGetDTO> buscarTodas(){
		
		List<MusicaGetDTO> listaGetDto = new ArrayList<MusicaGetDTO>();
		List<Musica> listaMusica = repository.findAll();
		
		for(Musica musica : listaMusica) {
			
			MusicaGetDTO dto = new MusicaGetDTO();
			mapper.map(musica, dto);
			
			listaGetDto.add(dto);
		}
		
		return listaGetDto;
	}
	
	public MusicaGetDTO buscarId(Integer id) {
		
		Optional<Musica> result = repository.findById(id);
		
		if(result.isEmpty()) {
			throw new EntityNotFoundException("Não encontrada!");
		}
		
		Musica musica = result.get();
		
		MusicaGetDTO dto = new MusicaGetDTO();
		mapper.map(musica, dto);
		
		return dto;
	}
	
	public String atualizar(MusicaPutDTO dto) {
		
		Optional<Musica> result = repository.findById(dto.getId());
		
		if(result.isEmpty()) {
			throw new EntityNotFoundException("Não encontrada!");
		}
		
		Musica musica = result.get();
		
		mapper.map(dto, musica);
		
		repository.save(musica);
		
		return "Atualizada com sucesso.";
	}
	
	public String excluir(Integer id) {
		
		Optional<Musica> result = repository.findById(id);
		
		if(result.isEmpty()) {
			throw new EntityNotFoundException("Não encontrada!");
		}
		
		Musica musica = result.get();
		
		repository.delete(musica);
		
		return "Excluída com sucesso.";	
	}

}
