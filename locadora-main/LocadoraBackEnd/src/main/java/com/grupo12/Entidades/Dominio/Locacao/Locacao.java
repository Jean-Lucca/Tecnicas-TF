package com.grupo12.Entidades.Dominio.Locacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.grupo12.Util.DataLocal;

@Entity
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String vin;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private DataLocal inicioLocacao;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private DataLocal fimLocacao;
    private double valorLocacao;
    
    public Locacao(){}
    public Locacao(String vin, DataLocal inicioLocacao, DataLocal fimLocacao, double valorLocacao){
        this.vin = vin;
        this.inicioLocacao = inicioLocacao;
        this.fimLocacao = fimLocacao;
        this.valorLocacao = valorLocacao;
    }
    public Long getId(){
        return id;
    }
    public double getValorLocacao() {
        return valorLocacao;
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
}
