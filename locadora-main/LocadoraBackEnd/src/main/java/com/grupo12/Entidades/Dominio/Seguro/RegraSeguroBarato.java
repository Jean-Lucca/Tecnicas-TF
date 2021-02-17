package com.grupo12.Entidades.Dominio.Seguro;

import com.grupo12.Interface.DTO.FiltroDTO;

public class RegraSeguroBarato implements RegraSeguro {
    @Override
    public double calcular(FiltroDTO filtro) {
        double total = 100;
        if(filtro.getCambio()) {
            total+=50;
        }
        if(filtro.getArcondicionado()) {
            total+=50;
        }
        return total;
    }
}
