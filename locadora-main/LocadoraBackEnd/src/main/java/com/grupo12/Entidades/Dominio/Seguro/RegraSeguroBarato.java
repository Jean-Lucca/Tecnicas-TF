package com.grupo12.Entidades.Dominio.Seguro;

import com.grupo12.Entidades.Dominio.Locacao.Locacao;
import com.grupo12.Interface.DTO.FiltroDTO;

public class RegraSeguroBarato implements RegraSeguro {

    @Override
    public double calcular(FiltroDTO filtro) {
        double total = 100;
        return total;
    }
}
