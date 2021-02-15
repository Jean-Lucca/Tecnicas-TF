package com.grupo12.Entidades.Servicos;

import com.grupo12.Entidades.Descontos.FactoryDesconto;
import com.grupo12.Entidades.Dominio.Seguro.RegraSeguro;
import com.grupo12.Entidades.Dominio.Veiculo.Carro;
import com.grupo12.Interface.DTO.FiltroDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Servicos {
  private RegraSeguro regraSeguro;
  private FactoryDesconto factoryDesconto;
  @Autowired
  public Servicos(RegraSeguro regraSeguro, FactoryDesconto factoryDesconto) {
      this.regraSeguro = regraSeguro;
      this.factoryDesconto = factoryDesconto;
  }

  public double calculaDesconto(FiltroDTO filtro){
    return factoryDesconto.getRegraVerificacao(filtro).disconto();
  }

  public  double calculaDiaria(FiltroDTO filtro, Carro carro){
    return calculaDias(filtro) * carro.getPreco();
  }

  public double calculaSeguro(FiltroDTO filtro) {
    return (calculaDias(filtro))
    * regraSeguro.calcular(filtro);
  }

  public double calculaTotal(FiltroDTO filtro, Carro carro) {
    return Math.round((calculaDiaria(filtro, carro) + calculaSeguro(filtro)) * calculaDesconto(filtro));
  }

  public  double calculaDias(FiltroDTO filtro) {
	return ( Math.abs(filtro.getInicioLocacao().getDia() - filtro.getFimLocacao().getDia())) +
         ((Math.abs(filtro.getInicioLocacao().getMes() - filtro.getFimLocacao().getMes())) * 30) +
         ((Math.abs(filtro.getInicioLocacao().getAno() - filtro.getFimLocacao().getAno())) * 365);
  }
}
