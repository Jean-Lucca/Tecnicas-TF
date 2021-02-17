package com.grupo12.Controller;

import java.util.List;

import com.grupo12.CasosDeUso.ControleDeLocacao;
import com.grupo12.Entidades.Dominio.Locacao.Locacao;
import com.grupo12.Entidades.Dominio.Seguro.RegraSeguro;
import com.grupo12.Entidades.Dominio.Veiculo.Carro;
import com.grupo12.Interface.DTO.CarroCustoDTO;
import com.grupo12.Interface.DTO.FiltroDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locadora")
public class LocadoraController {

	private ControleDeLocacao ctrlLocacao;
	public LocadoraController(RegraSeguro regraSeguro, ControleDeLocacao ctrlLocacao) {
		this.ctrlLocacao = ctrlLocacao;
	}
	
	@GetMapping("/carrosDisponiveis")
	@CrossOrigin(origins = "*")
	public List<CarroCustoDTO> carrosDisponiveis(FiltroDTO filtro) {
		return ctrlLocacao.listaCarrosDisponiveis(filtro);
	}
	
	@PostMapping("/confirmaLocacao")
	@CrossOrigin(origins = "*")
	public boolean confirmaLocacao(@RequestBody final CarroCustoDTO carro) {
		return ctrlLocacao.confirmaLocacao(carro);
	}
	//Listar todo o historico
	@GetMapping("/historico")
	@CrossOrigin(origins = "*")
	public List<Locacao> historicoCarros() {
		return (List<Locacao>) ctrlLocacao.historicoCarros();
	}
	//Devolver um carro
	@GetMapping("/dev")
	@CrossOrigin(origins = "*")
	public boolean devolveCarro(@RequestParam final String vin) {
		return ctrlLocacao.devolveCarro(vin);
	}
	//Listar todos os carros 
	@GetMapping
	public List<Carro> returnFrota() {
		return (List<Carro>) ctrlLocacao.frotaDeCarros();
	}
	//Obter um carro específico pelo VIN
	@GetMapping(path = {"/{vin}"})
	public ResponseEntity findById(@PathVariable String vin){
		return ctrlLocacao.retornaCarro(vin);
	}
	//Remover um carro pelo VIN
	@DeleteMapping(path = {"/{vin}"})
	public ResponseEntity deletaCarro(@PathVariable String vin){
		return ctrlLocacao.deletaCarro(vin);
	}
	//Criar um novo carro 
	@PostMapping
	public ResponseEntity criarCarro(@RequestBody Carro carro){
		return ctrlLocacao.criarCarro(carro);
	}
	//Atualizar detalhes de um carro
	@PutMapping(value="/{vin}")
	public ResponseEntity update(@PathVariable("vin") String vin,
	@RequestBody Carro carro) {
		return ctrlLocacao.atualizaCarro(vin, carro);
	}

}
