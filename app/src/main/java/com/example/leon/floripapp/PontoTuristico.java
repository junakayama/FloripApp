package com.example.leon.floripapp;

/**
 * Created by julia on 18/11/16.
 */

public class PontoTuristico {
    private String nome;
    private String descricao;
    private boolean pago;
    private String dataFuncionamento;
    private String horarioFuncionamento;
    private boolean favorito;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public boolean getPago(){
        return pago;
    }

    public void setPago(boolean pago){
        this.pago = pago;
    }

    public String getDataFuncionamento(){
        return dataFuncionamento;
    }

    public void setDataFuncionamento(String dataFuncionamento){
        this.dataFuncionamento = dataFuncionamento;
    }

    public String getHorarioFuncionamento(){
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento){
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public boolean getFavorito(){
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

}
