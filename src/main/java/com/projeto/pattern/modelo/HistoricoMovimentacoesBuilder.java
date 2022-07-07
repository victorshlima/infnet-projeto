package com.projeto.pattern.modelo;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class HistoricoMovimentacoesBuilder {

  private HistoricoMovimentacoes historicoMovimentacao;


    public HistoricoMovimentacoesBuilder() {
        this.historicoMovimentacao = new HistoricoMovimentacoes();
        this.historicoMovimentacao.setUuid(UUID.randomUUID());
        this.historicoMovimentacao.setDataMovimentacao(LocalDateTime.now());

    }

    public static HistoricoMovimentacoesBuilder builder (){
        return new HistoricoMovimentacoesBuilder();
    }

    public  HistoricoMovimentacoesBuilder addTipoMovimentacao (TipoMovimentacao tipoMovimentacao){
         this.historicoMovimentacao.setTipoMovimentacao(tipoMovimentacao);
         return this;
    }

    public  HistoricoMovimentacoesBuilder addDataMovimentacao (LocalDateTime dataMovimentacao){
        this.historicoMovimentacao.setDataMovimentacao(dataMovimentacao);
        return this;
    }
    public  HistoricoMovimentacoesBuilder addValor (BigDecimal valor){
        this.historicoMovimentacao.setValor(valor);
        return this;
    }

    public  HistoricoMovimentacoesBuilder addSaldoAntes (BigDecimal saldoAntes){
        this.historicoMovimentacao.setSaldoAntes(saldoAntes);
        return this;
    }

    public  HistoricoMovimentacoesBuilder addSaldoDepois (BigDecimal saldoDepois){
        this.historicoMovimentacao.setSaldoDepois(saldoDepois);
        return this;
    }

    public  HistoricoMovimentacoesBuilder addNomeUsuario(String nomeUsuario){
        this.historicoMovimentacao.setNomeUsuario(nomeUsuario);
        return this;
    }

    public HistoricoMovimentacoes build(){
        return historicoMovimentacao;
    }

}
