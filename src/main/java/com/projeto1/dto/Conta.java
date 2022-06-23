package com.projeto1.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Conta {

    private LocalDateTime dataAbertura;
    private LocalDateTime dataEncerramento;
    private BigDecimal saldo;
    private List<HistoricoMovimentacoes> HistoricoMovimentacoes;

}
