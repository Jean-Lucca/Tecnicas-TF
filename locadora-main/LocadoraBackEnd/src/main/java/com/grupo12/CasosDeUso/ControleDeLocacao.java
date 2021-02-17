package com.grupo12.CasosDeUso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.grupo12.Entidades.Dominio.Locacao.Locacao;
import com.grupo12.Entidades.Dominio.Veiculo.Carro;
import com.grupo12.Entidades.Repositorio.Frota;
import com.grupo12.Entidades.Repositorio.Historico;
import com.grupo12.Entidades.Servicos.Servicos;
import com.grupo12.Interface.DTO.CarroCustoDTO;
import com.grupo12.Interface.DTO.FiltroDTO;
import com.grupo12.Validacoes.ValidaData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ControleDeLocacao {
	private Frota frota;
	private Historico historico;
	private Servicos servicos;

	@Autowired
	public ControleDeLocacao(Servicos servicos, Frota frota, Historico historico) {
		this.frota = frota;
		this.historico = historico;
		this.servicos = servicos;
	}

	public Collection<Carro> frotaDeCarros() {
		return frota.todos();
	}

	public Collection<Locacao> historicoCarros() {
		return historico.todos();
	}

	public List<Carro> filtroDisponiveis(FiltroDTO filtro) {
		List<Carro> disponiveis = (List<Carro>) frota.todos().stream()
		.filter(c -> c.isDisponivel())
		.filter(c->c.isCambio() == filtro.getCambio())
    	.filter(c->c.isArcondicionado() == filtro.getArcondicionado())
    	.collect(Collectors.toList());
		System.out.println(filtro);
		return disponiveis;
	}

	public List<CarroCustoDTO> listaCarrosDisponiveis(FiltroDTO filtro) {

		if (ValidaData.validaData(filtro)) {
			return new ArrayList<>();
		}

	List<Carro> disponiveis = filtroDisponiveis(filtro);

	List<CarroCustoDTO> informacoes = new ArrayList<>(disponiveis.size());
	disponiveis.forEach(carro->{
			informacoes.add(new CarroCustoDTO(filtro.getInicioLocacao(),
			filtro.getFimLocacao(),
			carro.getVIN(),
			carro.getMarca(),
			carro.getModelo(),
			carro.getPreco(),
			servicos.calculaSeguro(filtro),
			servicos.calculaDesconto(filtro),
        	servicos.calculaTotal(filtro, carro.getPreco())));
		});
		return informacoes;
	}

	public void criaLocacao(CarroCustoDTO carro) {
		System.out.println(carro.getInicioLocacao());
		Locacao locacao = new Locacao(
			carro.getVin(),
			carro.getInicioLocacao(),
			carro.getFimLocacao(),
			carro.getTotalPagar());
		historico.cadastra(locacao);
	}

	public boolean confirmaLocacao(CarroCustoDTO carro) {
		if(frota.existente(carro.getVin())){
			criaLocacao(carro);
			Carro c = frota.recupera(carro.getVin());
			c.setDisponivel(false);
			frota.atualiza(c);
			return true;
		} else {
			return false;
		}
	}

	public boolean devolveCarro(String vin) {
		if(frota.existente(vin)){
			Carro c = frota.recupera(vin);
			c.setDisponivel(true);
			frota.atualiza(c);
			return true;
		} else {
			return false;
		}
	}

	public ResponseEntity deletaCarro(String vin) {
		if(frota.existente(vin)) {
			Carro aux = frota.recupera(vin);
			frota.remove(vin);
			return ResponseEntity.ok().body(aux);
		} else {
			return ResponseEntity.notFound().build();
		} 
	}

	public ResponseEntity retornaCarro(String vin) {
		return ResponseEntity.ok().body(frota.recupera(vin));
	}

	public List<CarroCustoDTO> listaIndisponiveis(FiltroDTO filtro) {
		List<Carro> indisponiveis = (List<Carro>) frota.pesquisa(c -> !c.isDisponivel());
		List<CarroCustoDTO> informacoes = new ArrayList<>(indisponiveis.size());
		indisponiveis.forEach(c->{
			informacoes.add(new CarroCustoDTO(filtro.getInicioLocacao(),
			filtro.getFimLocacao(),
            c.getVIN(),
            c.getMarca(),
            c.getModelo(),
            c.getPreco(),
            servicos.calculaSeguro(filtro),
            servicos.calculaDesconto(filtro),
            servicos.calculaTotal(filtro, c.getPreco())));
		});
		return informacoes;
	}

	public ResponseEntity criarCarro(Carro carro) {
		frota.cadastra(carro);
		return ResponseEntity.ok().body(carro);
	}

	public ResponseEntity atualizaCarro(String vin, Carro carro) {
		if(frota.existente(vin)){
			frota.atualiza(carro);
			return ResponseEntity.ok().body(carro);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}