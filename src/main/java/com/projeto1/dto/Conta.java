package com.projeto1.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Conta {

    private LocalDateTime dataAbertura;
    private LocalDateTime dataEncerramento;
    private BigDecimal saldo;
    private List<HistoricoMovimentacoes> HistoricoMovimentacoes;

    public Conta(LocalDateTime dataAbertura, LocalDateTime dataEncerramento, BigDecimal saldo, List<HistoricoMovimentacoes> historicoMovimentacoes) {
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
        this.saldo = saldo;
        this.HistoricoMovimentacoes = historicoMovimentacoes;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDateTime dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<com.projeto1.dto.HistoricoMovimentacoes> getHistoricoMovimentacoes() {
        return HistoricoMovimentacoes;
    }

    public void setHistoricoMovimentacoes(List<com.projeto1.dto.HistoricoMovimentacoes> historicoMovimentacoes) {
        HistoricoMovimentacoes = historicoMovimentacoes;
    }
}
