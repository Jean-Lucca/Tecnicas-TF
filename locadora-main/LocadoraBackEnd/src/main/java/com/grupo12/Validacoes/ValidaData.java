package com.grupo12.Validacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.grupo12.Interface.DTO.FiltroDTO;
import com.grupo12.Util.DataLocal;

public class ValidaData {
    public static boolean validaDataAtual(DataLocal dataLocal) throws ParseException {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        DataLocal atual = new DataLocal();
        Date d1 = sdformat.parse(atual.getAno() + "-" + atual.getMes() + "-" + atual.getDia());
        Date d2 = sdformat.parse(dataLocal.getAno() + "-" + dataLocal.getMes() + "-" + dataLocal.getDia());
        if (d1.compareTo(d2) > 0) {
            return false;
        } else if (d1.compareTo(d2) < 0) {
            return true;
        } else {
            return true;
        }
    }
    public static boolean validaDataPeriodo(DataLocal dataLocal, DataLocal dataLocal2) throws ParseException {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdformat
            .parse(dataLocal2.getAno() + "-" + dataLocal2.getMes() + "-" + dataLocal2.getDia());
        Date d2 = sdformat.parse(dataLocal.getAno() + "-" + dataLocal.getMes() + "-" + dataLocal.getDia());
        if (d1.compareTo(d2) > 0) {
            return true;
        } else if (d1.compareTo(d2) < 0) {
            return false;
        } else {
            return false;
        }
    }
    public static boolean validaData(FiltroDTO filtro) {
        try {
            if (!(validaDataPeriodo(filtro.getInicioLocacao(), filtro.getFimLocacao())
            && validaDataAtual(filtro.getInicioLocacao()))) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
