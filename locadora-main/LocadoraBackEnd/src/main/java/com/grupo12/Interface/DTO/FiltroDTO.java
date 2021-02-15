package com.grupo12.Interface.DTO;


import com.grupo12.Util.DataLocal;

public class FiltroDTO {
    private boolean cambio;
    private boolean arcondicionado;
    private DataLocal inicioLocacao = new DataLocal();
    private DataLocal fimLocacao = new DataLocal();
    
    public FiltroDTO(boolean cambio, boolean arcondicionado,
        DataLocal inicioLocacao, DataLocal fimLocacao) {
        this.cambio = cambio;
        this.arcondicionado = arcondicionado;
        this.inicioLocacao = inicioLocacao;
        this.fimLocacao = fimLocacao;
    }

    public boolean getCambio(){
        return cambio;
    }
    public boolean getArcondicionado(){
        return arcondicionado;
    }
    public DataLocal getInicioLocacao() {
        return inicioLocacao;
    }

    public void setInicioLocacao(DataLocal inicioLocacao) {
        this.inicioLocacao = inicioLocacao;
    }

    public DataLocal getFimLocacao() {
        return fimLocacao;
    }

    public void setFimLocacao(DataLocal fimLocacao) {
        this.fimLocacao = fimLocacao;
    }

    @Override
    public String toString() {
        return "FiltroDTO ["+ ", fimLocacao=" + fimLocacao + ", inicioLocacao=" + inicioLocacao + 
        ", cambio=" + cambio + ", arcondicionado="+arcondicionado+"]";
    }
}
