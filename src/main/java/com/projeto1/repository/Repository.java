package com.projeto1.repository;

import com.projeto1.dto.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Repository {

    public Repository() {
        inicializaBase();
    }

    private List<Usuario> usuarios= new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void inicializaBase(){
        HistoricoMovimentacoes historicoMovimentacao = new HistoricoMovimentacoes(UUID.randomUUID(), TipoMovimentacao.ENTRADA, LocalDateTime.now(), BigDecimal.valueOf(1000.00), BigDecimal.valueOf(0),BigDecimal.valueOf(1000.00) );
        List<HistoricoMovimentacoes> historicoMovimentacoes = new ArrayList();
        historicoMovimentacoes.add(historicoMovimentacao);

        getUsuarios().add(new Usuario(UUID.randomUUID(),"jasmin", "123", Status.ATIVO,
                new Pessoa(UUID.randomUUID(), "Jasmin", "Flores", "123.321.456-01", LocalDateTime.of(1990, 01, 01, 12, 12)),
                new ContaBancaria(LocalDateTime.now(), LocalDateTime.now(), BigDecimal.valueOf(1000.00),  historicoMovimentacoes )));

        HistoricoMovimentacoes historicoMovimentacao2 = new HistoricoMovimentacoes(UUID.randomUUID(), TipoMovimentacao.ENTRADA, LocalDateTime.now(), BigDecimal.valueOf(2000.00), BigDecimal.valueOf(0),BigDecimal.valueOf(2000.00) );
        List<HistoricoMovimentacoes> historicoMovimentacoesJoao = new ArrayList();
        historicoMovimentacoes.add(historicoMovimentacao2);

        getUsuarios().add(new Usuario(UUID.randomUUID(), "joao", "123", Status.ATIVO,
                new Pessoa(UUID.randomUUID(), "Joao", "Alfredo", "321.123.456-02", LocalDateTime.of(1990, 02, 02, 12, 12)),
                new ContaBancaria(LocalDateTime.now(), LocalDateTime.now(), BigDecimal.valueOf(2000.00), historicoMovimentacoesJoao )));

        HistoricoMovimentacoes historicoMovimentacao3 = new HistoricoMovimentacoes(UUID.randomUUID(), TipoMovimentacao.ENTRADA, LocalDateTime.now(), BigDecimal.valueOf(3000.00), BigDecimal.valueOf(0), BigDecimal.valueOf(3000.00) );
        List<HistoricoMovimentacoes> historicoMovimentacoes3 = new ArrayList();
        historicoMovimentacoes.add(historicoMovimentacao3);

        getUsuarios().add(new Usuario(UUID.randomUUID(), "Maria", "123", Status.BLOQUEADO,
                new Pessoa(UUID.randomUUID(), "maria", "Pereira", "213.321.456-02", LocalDateTime.of(1990, 03, 03, 12, 12)),
                new ContaBancaria(LocalDateTime.now(), LocalDateTime.now(), BigDecimal.valueOf(3000.00), historicoMovimentacoes3 )));
    }

}
