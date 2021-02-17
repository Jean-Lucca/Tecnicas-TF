package com.grupo12.Interface.Persistencia.Frota;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.grupo12.Entidades.Dominio.Veiculo.Carro;
import com.grupo12.Entidades.Repositorio.Frota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FrotaH2BD_IMPL implements Frota {
    private FrotaH2BD_ITF frota;

    @Autowired
    public FrotaH2BD_IMPL(FrotaH2BD_ITF frota) {
        this.frota = frota;
    }

    @Override
    public void carrega() {
        // TODO Auto-generated method stub
    }

    @Override
    public void persiste() {
        // TODO Auto-generated method stub
    }

    @Override
    public void cadastra(Carro elemento) {
        frota.save(elemento);
    }

    @Override
    public Carro recupera(String chave) {
        return frota.findByVin(chave).get(0);
    }

    @Override
    public Collection<Carro> todos() {
        return frota.findAll();
    }

    @Override
    public boolean existente(String chave) {
        return frota.existsById(chave);
    }

    @Override
    public Collection<Carro> pesquisa(Predicate<Carro> pred) {
        return frota.findAll()
                         .stream()
                         .filter(pred)
                         .collect(Collectors.toList());
    }

    @Override
    public void atualiza(Carro elemento) {
        frota.deleteById(elemento.getVIN());
        frota.save(elemento);
    }

    @Override
    public void remove(String chave) {
        frota.deleteById(chave);
    }
}
