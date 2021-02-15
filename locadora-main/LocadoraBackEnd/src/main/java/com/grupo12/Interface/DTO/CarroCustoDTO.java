package com.grupo12.Interface.DTO;

import com.grupo12.Util.DataLocal;

public class CarroCustoDTO {
    private DataLocal inicioLocacao;
    private DataLocal fimLocacao;
    private String vin;
    private String marca;
    private String modelo;
    private double custoLocacao;
    private double seguro;
    private double desconto;
    private double totalPagar;
    
    public CarroCustoDTO(DataLocal inicioLocacao, DataLocal fimLocacao, String vin, String marca, 
        String modelo,
        double custoLocacao, double seguro,
        double desconto, double totalPagar) {
        this.inicioLocacao = inicioLocacao;
        this.fimLocacao = fimLocacao;
        this.vin = vin;
        this.marca = marca;
        this.modelo = modelo;
        this.custoLocacao = custoLocacao;
        this.seguro = seguro;
        this.desconto = desconto;
        this.totalPagar = totalPagar;
    }

    public DataLocal getInicioLocacao() {
        return inicioLocacao;
    }

    public DataLocal getFimLocacao() {
        return fimLocacao;
    }

    public String getVin() {
        return vin;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getCustoLocacao() {
        return custoLocacao;
    }

    public double getSeguro() {
        return seguro;
    }

    public double getDesconto() {
        return desconto;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    @Override
    public String toString() {
        return "CarroCustoDTO [custoLocacao="
                + custoLocacao + ", desconto=" + desconto + ",fimLocacao=" + fimLocacao
                + ", inicioLocacao=" + inicioLocacao + ", marca=" + marca + ", modelo=" + modelo + ", vin=" + vin
                + ", seguro=" + seguro + ", totalPagar=" + totalPagar + "]";
    }
}
