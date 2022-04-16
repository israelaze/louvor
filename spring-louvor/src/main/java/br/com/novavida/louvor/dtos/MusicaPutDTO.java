package br.com.novavida.louvor.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicaPutDTO {
	
	private Integer id;
	
	private String nome;
	
	private String artista;
	
	private String album;
	
	private Integer anoLancamento;
	
	private String letra;
	
	private String cifra;
	
	private String youtube;

}
