package br.com.novavida.louvor.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.novavida.louvor.dtos.MusicaGetDTO;
import br.com.novavida.louvor.dtos.MusicaPostDTO;
import br.com.novavida.louvor.dtos.MusicaPutDTO;
import br.com.novavida.louvor.exceptions.ServiceException;
import br.com.novavida.louvor.services.MusicaServices;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/musicas")
public class MusicaController {
	
	private final MusicaServices service;
	
	@PostMapping
	public ResponseEntity<String> cadastrar(MusicaPostDTO dto){
		
		try {
			String response = service.cadastrar(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<List<MusicaGetDTO>> buscarTodas(){
		
		try {
			List<MusicaGetDTO> lista = service.buscarTodas();
			return ResponseEntity.ok(lista);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MusicaGetDTO> buscarId(@PathVariable("id") Integer id){
		
		try {
			MusicaGetDTO dto = service.buscarId(id);
			return ResponseEntity.ok(dto);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<String> atualizar(MusicaPutDTO dto){
		
		try {
			String response = service.atualizar(dto);
			return ResponseEntity.ok(response);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> excluir(@PathVariable("id") Integer id){
		
		try {
			String response = service.excluir(id);
			return ResponseEntity.ok(response);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
}
