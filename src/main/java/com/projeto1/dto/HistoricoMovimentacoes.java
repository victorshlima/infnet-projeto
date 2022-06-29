package com.projeto1.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class HistoricoMovimentacoes {

    private UUID uuid;
    private TipoMovimentacao tipoMovimentacao;
    private LocalDateTime dataMovimentacao;
    private BigDecimal valor;
    private BigDecimal saldoAntes;
    private BigDecimal saldoDepois;

    public HistoricoMovimentacoes(UUID uuid, TipoMovimentacao tipoMovimentacao, LocalDateTime dataMovimentacao, BigDecimal valor, BigDecimal saldoAntes, BigDecimal saldoDepois) {
        this.uuid = uuid;
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataMovimentacao = dataMovimentacao;
        this.valor = valor;
        this.saldoAntes = saldoAntes;
        this.saldoDepois = saldoDepois;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public LocalDateTime getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getSaldoAntes() {
        return saldoAntes;
    }

    public void setSaldoAntes(BigDecimal saldoAntes) {
        this.saldoAntes = saldoAntes;
    }

    public BigDecimal getSaldoDepois() {
        return saldoDepois;
    }

    public void setSaldoDepois(BigDecimal saldoDepois) {
        this.saldoDepois = saldoDepois;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoMovimentacoes that = (HistoricoMovimentacoes) o;
        return Objects.equals(uuid, that.uuid) && tipoMovimentacao == that.tipoMovimentacao && Objects.equals(dataMovimentacao, that.dataMovimentacao) && Objects.equals(valor, that.valor) && Objects.equals(saldoAntes, that.saldoAntes) && Objects.equals(saldoDepois, that.saldoDepois);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, tipoMovimentacao, dataMovimentacao, valor, saldoAntes, saldoDepois);
    }
}
