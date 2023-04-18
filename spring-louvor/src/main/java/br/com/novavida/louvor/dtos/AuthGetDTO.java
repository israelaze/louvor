package br.com.novavida.louvor.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthGetDTO {
	
	private Integer id;
	private String nome;
	private String email;
	private String accessToken;
}
