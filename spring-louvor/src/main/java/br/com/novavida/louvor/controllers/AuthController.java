package br.com.novavida.louvor.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.novavida.louvor.dtos.AuthGetDTO;
import br.com.novavida.louvor.dtos.AuthPostDTO;
import br.com.novavida.louvor.exceptions.ServiceException;
import br.com.novavida.louvor.services.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/auth")
@AllArgsConstructor
@Api(tags = "Autenticação")
public class AuthController {
	
	private final AuthService service;
	
	@PostMapping
	@ApiOperation(value = "autenticar usuário")
	public ResponseEntity<AuthGetDTO> autenticar(@Valid @RequestBody AuthPostDTO dto) {
		
		try {
			AuthGetDTO getDto = service.autenticar(dto);
			return ResponseEntity.ok(getDto);
			
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
}
