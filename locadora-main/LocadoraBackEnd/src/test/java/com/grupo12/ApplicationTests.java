package com.grupo12;

import com.grupo12.CasosDeUso.ControleDeLocacao;
import com.grupo12.Entidades.Repositorio.Frota;
import com.grupo12.Entidades.Repositorio.Historico;
import com.grupo12.Entidades.Servicos.Servicos;
import com.grupo12.Interface.DTO.FiltroDTO;
import com.grupo12.Util.DataLocal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private Historico historico;
	@Autowired
	private Frota frota;
	private ControleDeLocacao ctrl;
	private Servicos servicos;
	DataLocal i1;
	DataLocal i2;
	
	@BeforeEach
	void setUp() {
		ctrl = new ControleDeLocacao(servicos, frota, historico);
		i1 = new DataLocal();
		i2 = new DataLocal();
	}

	private void print(String output) {
		System.out.println("-----------------------------------saida---------------------------------");
		System.out.println(output);
		System.out.println("-----------------------------------saida---------------------------------");
	}

	@Test
	void searchTest() {
		i1.setDia(i1.getDia()+1);
		i1.setDia(i1.getDia()+5);
		ctrl.filtroDisponiveis(new FiltroDTO(true, true, 
        i1, i2)).stream().forEach(c->print(c.getMarca()));
	}
}
