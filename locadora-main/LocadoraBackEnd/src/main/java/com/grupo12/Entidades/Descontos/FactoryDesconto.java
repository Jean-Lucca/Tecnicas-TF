package com.grupo12.Entidades.Descontos;

import com.grupo12.Interface.DTO.FiltroDTO;

import org.springframework.stereotype.Component;


@Component
public class FactoryDesconto {
    public RegraDesconto getRegraVerificacao(FiltroDTO filtro) {
        if (filtro.getInicioLocacao().getMes() == 12 
        || filtro.getInicioLocacao().getMes() == 1 
        || filtro.getInicioLocacao().getMes() == 2)
        {
            return new DescontoEspecial();
        } else {
            return new DescontoNormal();
        }
    }
}
