package com.projeto.pattern.operacoes;

import com.projeto.pattern.modelo.HistoricoMovimentacoes;
import com.projeto.pattern.modelo.HistoricoMovimentacoesBuilder;
import com.projeto.pattern.modelo.Usuario;
import com.projeto.pattern.modelo.TipoMovimentacao;
import com.projeto.pattern.mensagens.Utils;

import java.math.BigDecimal;

import static com.projeto1.mensagens.MensagensEnum.MENSAGEM_ERRO_SALDO_INSUFICIENTE_SAQUE;
import static com.projeto1.mensagens.MensagensEnum.OPERACAO_CONCLUIDA;

public class Saque {

    public void sacar(Usuario usuario, BigDecimal valorSaque) {

        if (Boolean.TRUE.equals(new Saldo().verificaSaldo(usuario, valorSaque))) {
            BigDecimal saldoAntigo = usuario.getConta().getSaldo();
            usuario.getConta().subtrairSaldo(valorSaque);

            HistoricoMovimentacoes historicoMovimentacao = HistoricoMovimentacoesBuilder.builder()
                    .addTipoMovimentacao(TipoMovimentacao.SAQUE)
                    .addValor(valorSaque)
                    .addSaldoAntes(saldoAntigo)
                    .addSaldoDepois(usuario.getConta().getSaldo())
                    .build();

                    usuario.getConta().setHistoricoMovimentacoes(historicoMovimentacao);
            Utils.printMensagem(OPERACAO_CONCLUIDA.getDescricao());
            Utils.printMensagem(historicoMovimentacao.toString());
        } else {
            Utils.printMensagem(MENSAGEM_ERRO_SALDO_INSUFICIENTE_SAQUE.getDescricao() + usuario.getConta().getSaldo());

        }
    }

}
