package com.grupo12.Interface.Persistencia.Frota;

import java.util.List;

import com.grupo12.Entidades.Dominio.Veiculo.Carro;

import org.springframework.data.repository.CrudRepository;

public interface FrotaH2BD_ITF extends CrudRepository<Carro, String> {
    List<Carro> findByVin(String vin);
    List<Carro> findAll();    
}
