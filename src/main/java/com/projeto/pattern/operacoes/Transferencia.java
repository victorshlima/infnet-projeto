package com.projeto.pattern.operacoes;

import com.projeto.pattern.acesso.Validacao;
import com.projeto.pattern.modelo.HistoricoMovimentacoes;
import com.projeto.pattern.modelo.HistoricoMovimentacoesBuilder;
import com.projeto.pattern.modelo.TipoMovimentacao;
import com.projeto.pattern.modelo.Usuario;
import com.projeto.pattern.mensagens.Utils;

import java.math.BigDecimal;

import static com.projeto1.mensagens.MensagensEnum.*;

public class Transferencia {

    public void transferir(Usuario usuarioOrigen, Usuario usuarioDestino, BigDecimal valorTransferencia) {

        if (!new Validacao().isAtivo(usuarioDestino)) {
            Utils.printMensagem(TRANSFERENCIA_USUARIO_INATIVO_ERRO.getDescricao());
            return;
        }

        if (Boolean.TRUE.equals(new Saldo().verificaSaldo(usuarioOrigen, valorTransferencia))) {

            BigDecimal saldoAntesOrigem = usuarioOrigen.getConta().getSaldo();
            usuarioOrigen.getConta().subtrairSaldo(valorTransferencia);

            HistoricoMovimentacoes historicoMovimentacaoOrigem = HistoricoMovimentacoesBuilder.builder()
                    .addTipoMovimentacao(TipoMovimentacao.TRANSFERENCIA)
                    .addValor(valorTransferencia)
                    .addSaldoAntes(saldoAntesOrigem)
                    .addSaldoDepois(usuarioOrigen.getConta().getSaldo())
                    .addNomeUsuario(usuarioDestino.getNomeUsuario())
                    .build();

            usuarioOrigen.getConta().setHistoricoMovimentacoes(historicoMovimentacaoOrigem);

            BigDecimal saldoAntesDestino = usuarioDestino.getConta().getSaldo();
            usuarioDestino.getConta().somarSaldo(valorTransferencia);

            HistoricoMovimentacoes historicoMovimentacaoDestino = HistoricoMovimentacoesBuilder.builder()
                    .addTipoMovimentacao(TipoMovimentacao.TRANSFERENCIA)
                    .addValor(valorTransferencia)
                    .addSaldoAntes(saldoAntesDestino)
                    .addSaldoDepois(usuarioDestino.getConta().getSaldo())
                    .addNomeUsuario(usuarioOrigen.getNomeUsuario())
                    .build();

            usuarioDestino.getConta().setHistoricoMovimentacoes(historicoMovimentacaoDestino);

            Utils.printMensagem(SUCESSO_TRANSFERENCIA.toString());
            Utils.printMensagem(historicoMovimentacaoOrigem.toStringTransferencia());

        } else {
            Utils.printMensagem(MENSAGEM_ERRO_SALDO_INSUFICIENTE_TRANSFERENCIA.getDescricao() + usuarioOrigen.getConta().getSaldo());
        }
    }

}
