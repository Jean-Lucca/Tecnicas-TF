package com.grupo12.Entidades.Dominio.Seguro;

import com.grupo12.Interface.DTO.FiltroDTO;

public class RegraSeguroCaro implements RegraSeguro {

    @Override
    public double calcular(FiltroDTO filtro) {
        double total = 200;
        if(filtro.getCambio()) {
            total+=100;
        }
        if(filtro.getArcondicionado()) {
            total+=100;
        }
        return total;
    }
}
