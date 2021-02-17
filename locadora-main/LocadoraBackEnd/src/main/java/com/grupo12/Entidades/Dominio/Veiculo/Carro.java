package com.grupo12.Entidades.Dominio.Veiculo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {
    @Id
    private String vin;
    private String marca;
    private String modelo;
    private boolean cambio;
    private boolean arcondicionado;
    private String cor;
    private double preco;
    private boolean disponivel;

    public Carro(){}

    public Carro(String vin, String marca, String modelo, boolean cambio, boolean arcondicionado, String cor,
            double preco, boolean disponivel) {
        this.vin = vin;
        this.marca = marca;
        this.modelo = modelo;
        this.cambio = cambio;
        this.arcondicionado = arcondicionado;
        this.cor = cor;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public String getVIN() {
        return vin;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isCambio() {
        return cambio;
    }

    public boolean isArcondicionado() {
        return arcondicionado;
    }

    public String getCor() {
        return cor;
    }

    public double isPreco() {
        return preco;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Carro [Cambio=" + cambio + ", Preco=" + preco + ", Cor="
        + cor + ", marca=" + marca + ", modelo=" + modelo + ", VIN=" + vin + "]";
    } 
}
