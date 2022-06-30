package com.projeto1.repository;

import com.projeto1.dto.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Repository {

    public Repository() {
        inicializaBase();
    }

    private List<Usuario> usuarios= new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void inicializaBase(){
        HistoricoMovimentacoes historicoMovimentacaoJasmin = new HistoricoMovimentacoes(UUID.randomUUID(), TipoMovimentacao.ENTRADA, LocalDateTime.now(), BigDecimal.valueOf(1000.00), BigDecimal.valueOf(0),BigDecimal.valueOf(1000.00) );
        List<HistoricoMovimentacoes> historicoMovimentacoesJasmin = new ArrayList();
        historicoMovimentacoesJasmin.add(historicoMovimentacaoJasmin);

        getUsuarios().add(new Usuario(UUID.randomUUID(),"jasmin", "123", Status.ATIVO,
                new Pessoa(UUID.randomUUID(), "Jasmin", "Flores", "123.321.456-01", LocalDateTime.of(1990, 01, 01, 12, 12)),
                new ContaBancaria(LocalDateTime.now(), LocalDateTime.now(), BigDecimal.valueOf(1000.00),  historicoMovimentacoesJasmin  )));

        HistoricoMovimentacoes historicoMovimentacaoJoao = new HistoricoMovimentacoes(UUID.randomUUID(), TipoMovimentacao.ENTRADA, LocalDateTime.now(), BigDecimal.valueOf(2000.00), BigDecimal.valueOf(0),BigDecimal.valueOf(2000.00) );
        List<HistoricoMovimentacoes> historicoMovimentacoesJoao = new ArrayList();
        historicoMovimentacoesJoao.add(historicoMovimentacaoJoao);

        getUsuarios().add(new Usuario(UUID.randomUUID(), "joao", "123", Status.ATIVO,
                new Pessoa(UUID.randomUUID(), "Joao", "Alfredo", "321.123.456-02", LocalDateTime.of(1990, 02, 02, 12, 12)),
                new ContaBancaria(LocalDateTime.now(), LocalDateTime.now(), BigDecimal.valueOf(2000.00), historicoMovimentacoesJoao )));

        HistoricoMovimentacoes historicoMovimentacaoMaria = new HistoricoMovimentacoes(UUID.randomUUID(), TipoMovimentacao.ENTRADA, LocalDateTime.now(), BigDecimal.valueOf(3000.00), BigDecimal.valueOf(0), BigDecimal.valueOf(3000.00) );
        List<HistoricoMovimentacoes> historicoMovimentacoesMaria = new ArrayList();
        historicoMovimentacoesMaria.add(historicoMovimentacaoMaria);

        getUsuarios().add(new Usuario(UUID.randomUUID(), "Maria", "123", Status.BLOQUEADO,
                new Pessoa(UUID.randomUUID(), "maria", "Pereira", "213.321.456-02", LocalDateTime.of(1990, 03, 03, 12, 12)),
                new ContaBancaria(LocalDateTime.now(), LocalDateTime.now(), BigDecimal.valueOf(3000.00), historicoMovimentacoesMaria )));
    }

    public Usuario getUsuarioPeloNome(String nomeUsuario){
       return getUsuarios().stream()
                .filter(u -> u.getNomeUsuario().equals(nomeUsuario))
                .filter(u -> u.getStatus().equals(Status.ATIVO))
                .collect(Collectors.toList()).get(0);
    }


}
