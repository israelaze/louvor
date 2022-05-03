package br.com.novavida.louvor.date;

import java.time.YearMonth;

import br.com.novavida.louvor.exceptions.BadRequestException;

public class CurrentYear {
	
	public void campararAno(Integer anoLancamento) {

		// definindo ano mínimo
		int anoMinimo = 1950;
		// capturando o ano atual
		int anoAtual = YearMonth.now().getYear();
	
		if (anoLancamento != null && anoLancamento < anoMinimo) {
			throw new BadRequestException("Ano inválido. Válido apenas a partir de 1950.");
		} else if ((anoLancamento != null && anoLancamento > anoAtual)) {
			throw new BadRequestException("Ano inválido. Ano atual: " + anoAtual);
		}
	}
}
