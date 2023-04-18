package br.com.novavida.louvor.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.novavida.louvor.dtos.MusicaGetDTO;
import br.com.novavida.louvor.dtos.MusicaPostDTO;
import br.com.novavida.louvor.dtos.MusicaPutDTO;
import br.com.novavida.louvor.exceptions.ServiceException;
import br.com.novavida.louvor.services.MusicaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/musicas")
@Api(tags = "Menu músicas")
@CrossOrigin
public class MusicaController {
	
	private final MusicaService service;
	
	@PostMapping
	@ApiOperation(value = "Cadastrar")
	public ResponseEntity<MusicaGetDTO> cadastrar(@RequestBody @Valid MusicaPostDTO dto){
		
		try {
			MusicaGetDTO getDto = service.cadastrar(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(getDto);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Buscar todas")
	public ResponseEntity<List<MusicaGetDTO>> buscarTodas(){
		
		try {
			List<MusicaGetDTO> lista = service.buscarTodas();
			return ResponseEntity.ok(lista);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Buscar por id")
	public ResponseEntity<MusicaGetDTO> buscarId(@PathVariable("id") Integer id){
		
		try {
			MusicaGetDTO dto = service.buscarId(id);
			return ResponseEntity.ok(dto);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping
	@ApiOperation(value = "Atualizar")
	public ResponseEntity<MusicaGetDTO> atualizar(@RequestBody @Valid MusicaPutDTO dto){
		
		try {
			MusicaGetDTO getDto = service.atualizar(dto);
			return ResponseEntity.ok(getDto);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Excluir")
	public ResponseEntity<String> excluir(@PathVariable("id") Integer id){
		
		try {
			String response = service.excluir(id);
			return ResponseEntity.ok(response);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
}
