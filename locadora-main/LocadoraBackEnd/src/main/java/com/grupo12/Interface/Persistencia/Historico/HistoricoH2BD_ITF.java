package com.grupo12.Interface.Persistencia.Historico;

import java.util.List;

import com.grupo12.Entidades.Dominio.Locacao.Locacao;

import org.springframework.data.repository.CrudRepository;

public interface HistoricoH2BD_ITF extends CrudRepository<Locacao,String> {
    List<Locacao> findByVin(String vin);
    List<Locacao> findAll();   
}

