package com.grupo12.Interface.Persistencia.Historico;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.grupo12.Entidades.Dominio.Locacao.Locacao;
import com.grupo12.Entidades.Repositorio.Historico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoricoH2BD_IMPL implements Historico {
    private HistoricoH2BD_ITF historico;

    @Autowired
    public HistoricoH2BD_IMPL(HistoricoH2BD_ITF historico) {
        this.historico = historico;
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
    public void cadastra(Locacao elemento) {
        historico.save(elemento);
    }

    @Override
    public Locacao recupera(String chave) {
        return historico.findByVin(chave).get(0);
    }

    @Override
    public Collection<Locacao> todos() {
        return historico.findAll();
    }

    @Override
    public boolean existente(String chave) {
        return historico.existsById(chave);
    }

    @Override
    public Collection<Locacao> pesquisa(Predicate<Locacao> pred) {
        return historico.findAll()
                         .stream()
                         .filter(pred)
                         .collect(Collectors.toList());
    }

    @Override
    public void atualiza(Locacao elemento) {
        historico.save(elemento);
    }

    @Override
    public void remove(String chave) {
        historico.deleteById(chave);
    }
}
