package com.projeto1.dto;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.UUID;

public class HistoricoMovimentacoes {

    private UUID uuid;
    private TipoMovimentacao tipoMovimentacao;
    private LocalDateTime dataMovimentacao;
    private BigDecimal valor;
    private BigDecimal saldoAntes;
    private BigDecimal saldoDepois;

}
