package com.grupo12.Entidades.Dominio.Seguro;

import com.grupo12.Entidades.Dominio.Locacao.Locacao;
import com.grupo12.Interface.DTO.FiltroDTO;

public class RegraSeguroCaro implements RegraSeguro {

    @Override
    public double calcular(FiltroDTO filtro) {
        double total = 200;
        return total;
    }
    
}
