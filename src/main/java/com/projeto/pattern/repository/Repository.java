package com.projeto.pattern.repository;

import com.projeto.pattern.modelo.*;
import com.projeto.pattern.mensagens.Utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.projeto1.mensagens.MensagensEnum.USUARIO_DESTINO_NAO_EXISTE;

public final class Repository {

    private static Repository instance;
    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }


    private Repository() {
        if (instance == null){
        inicializaBase();
        }
    }
    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }


    public void inicializaBase() {
        HistoricoMovimentacoes historicoMovimentacaoJasmin = HistoricoMovimentacoesBuilder.builder()
                .addTipoMovimentacao(TipoMovimentacao.ENTRADA)
                .addValor(BigDecimal.valueOf(1000.00))
                .addSaldoAntes( BigDecimal.valueOf(0))
                .addSaldoDepois(BigDecimal.valueOf(1000.00))
                .build();

        List<HistoricoMovimentacoes> historicoMovimentacoesJasmin = new ArrayList();
        historicoMovimentacoesJasmin.add(historicoMovimentacaoJasmin);

        getUsuarios().add(new Usuario(UUID.randomUUID(), "jasmin", "123", Status.ATIVO,
                new Pessoa(UUID.randomUUID(), "Jasmin", "Flores", "123.321.456-01", LocalDateTime.of(1990, 01, 01, 12, 12)),
                new ContaBancaria(LocalDateTime.now(), LocalDateTime.now(), BigDecimal.valueOf(1000.00), historicoMovimentacoesJasmin)));

        HistoricoMovimentacoes historicoMovimentacaoJoao = HistoricoMovimentacoesBuilder.builder()
                .addTipoMovimentacao(TipoMovimentacao.ENTRADA)
                .addValor(BigDecimal.valueOf(2000.00))
                .addSaldoAntes( BigDecimal.valueOf(0))
                .addSaldoDepois(BigDecimal.valueOf(2000.00))
                .build();


        List<HistoricoMovimentacoes> historicoMovimentacoesJoao = new ArrayList();
        historicoMovimentacoesJoao.add(historicoMovimentacaoJoao);

        getUsuarios().add(new Usuario(UUID.randomUUID(), "joao", "123", Status.ATIVO,
                new Pessoa(UUID.randomUUID(), "Joao", "Alfredo", "321.123.456-02", LocalDateTime.of(1990, 02, 02, 12, 12)),
                new ContaBancaria(LocalDateTime.now(), LocalDateTime.now(), BigDecimal.valueOf(2000.00), historicoMovimentacoesJoao)));

       HistoricoMovimentacoes historicoMovimentacaoMaria = HistoricoMovimentacoesBuilder.builder()
                .addTipoMovimentacao(TipoMovimentacao.ENTRADA)
                .addValor(BigDecimal.valueOf(3000.00))
                .addSaldoAntes( BigDecimal.valueOf(0))
                .addSaldoDepois(BigDecimal.valueOf(3000.00))
                .build();

        List<HistoricoMovimentacoes> historicoMovimentacoesMaria = new ArrayList();
        historicoMovimentacoesMaria.add(historicoMovimentacaoMaria);

        getUsuarios().add(new Usuario(UUID.randomUUID(), "maria", "123", Status.BLOQUEADO,
                new Pessoa(UUID.randomUUID(), "maria", "Pereira", "213.321.456-02", LocalDateTime.of(1990, 03, 03, 12, 12)),
                new ContaBancaria(LocalDateTime.now(), LocalDateTime.now(), BigDecimal.valueOf(3000.00), historicoMovimentacoesMaria)));
    }

    public Usuario getUsuarioPeloNome(String nomeUsuario) {
        try {
            return getUsuarios().stream()
                    .filter(u -> u.getNomeUsuario().equals(nomeUsuario))
                    .collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            Utils.printMensagem(USUARIO_DESTINO_NAO_EXISTE.getDescricao());
            return null;
        }
   }


}
