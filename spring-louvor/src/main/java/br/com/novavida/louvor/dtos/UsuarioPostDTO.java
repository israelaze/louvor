package br.com.novavida.louvor.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioPostDTO {
	
	@NotBlank(message = "{nome.not.blank}")
	private String nome;
	
	@NotBlank(message = "{email.not.blank}")
	@Email(message = "{email.email}")
	private String email;
	
	@NotBlank(message = "{senha.not.blank}")
	private String senha;

}
