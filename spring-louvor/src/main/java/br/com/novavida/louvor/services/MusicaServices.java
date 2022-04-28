package br.com.novavida.louvor.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.novavida.louvor.controllers.MusicaController;
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
	
	public MusicaPostDTO cadastrar(MusicaPostDTO dto) {
		
		Optional<Musica> result = repository.findByNomeAndfindByArtista(dto.getNome(), dto.getArtista());
		
		if(result.isPresent()) {
			throw new BadRequestException("Música já cadastrada!");
		}
		
		//capturando o ano atual
		int anoAtual = YearMonth.now().getYear();
		Integer anoLancamento = dto.getAnoLancamento();
		
		if (anoLancamento != null && anoLancamento > anoAtual) {
			throw new BadRequestException("Ano inválido. Ano atual: " + anoAtual);
		}else if (anoLancamento != null && anoLancamento < 1950) {
			throw new BadRequestException("Ano inválido. Válido apenas a partir de 1950!");
		}else {
			
			Musica musica = new Musica();
			mapper.map(dto, musica);
			
			repository.save(musica);
			
			return dto;
		}		
	}
	
	public List<MusicaGetDTO> buscarTodas(){
		
		List<MusicaGetDTO> listaGetDto = new ArrayList<MusicaGetDTO>();
		List<Musica> listaMusica = repository.findAll();
		
		for(Musica musica : listaMusica) {
			
			MusicaGetDTO dto = new MusicaGetDTO();
			mapper.map(musica, dto);
			
			//adicionando link HATEOAS
			dto.add(linkTo(methodOn(MusicaController.class).buscarId(musica.getId())).withSelfRel());
			
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
		
		//adicionando link HATEOAS
		dto.add(linkTo(methodOn(MusicaController.class).buscarTodas()).withRel("Lista de Músicas"));

		return dto;
	}
	
	public String atualizar(MusicaPutDTO dto) {
		
		Optional<Musica> result = repository.findById(dto.getId());

		if (result.isEmpty()) {
			throw new EntityNotFoundException("Não encontrada!");
		}

		Optional<Musica> result2 = repository.findByNomeAndfindByArtista(dto.getNome(), dto.getArtista());

		if (result2.isPresent()) {
			throw new BadRequestException("Não permitido. Música já cadastrada!");
		}

		//capturando o ano atual
		int anoAtual = YearMonth.now().getYear();
		Integer anoLancamento = dto.getAnoLancamento();
		
		if (anoLancamento != null && anoLancamento > anoAtual) {
			throw new BadRequestException("Ano inválido. Ano atual: " + anoAtual);
		}else if (anoLancamento != null && anoLancamento < 1950) {
			throw new BadRequestException("Ano inválido. Válido apenas a partir de 1950!");
		}else {
			
			Musica musica = result.get();

			mapper.map(dto, musica);
			repository.save(musica);

			return "Atualizada com sucesso.";	
		}
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
