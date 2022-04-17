package br.com.novavida.louvor.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicaPostDTO {
	
	@NotBlank(message = "{nome.not.blank}")
	private String nome;
	
	@NotBlank(message = "{artista.not.blank}")
	private String artista;
	
	private String album;
	
	@Max(value = 2050, message = "{anoLancamento.max}")
	@Min(value = 1950, message = "{anoLancamento.min}")
	private Integer anoLancamento;
	
	private String letra;
	
	private String cifra;
	
	private String youtube;

}
