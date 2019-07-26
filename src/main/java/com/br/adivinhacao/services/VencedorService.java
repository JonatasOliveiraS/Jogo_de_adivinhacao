package com.br.adivinhacao.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adivinhacao.model.VencedorModel;
import com.br.adivinhacao.repositories.VencedorRepository;

@Service
public class VencedorService {

	@Autowired
	private VencedorRepository vencedorRepository;

	public int criarNumero() {
		Random numero = new Random();
		return numero.nextInt(30 +1);
	}

	public String salvarVencedores(VencedorModel vencedor) {
		int number = criarNumero();
		if (vencedor.getNumeroDaSorte() == number) { 
			vencedorRepository.save(vencedor);
			return "Acerto mizeravi, parabéns !" + number;
		} else {
			return "YOU LOSE, tente novamente !";
		}
	}

	public Iterable<VencedorModel> exibirVencedores() {
		return vencedorRepository.findAll();
}
}
