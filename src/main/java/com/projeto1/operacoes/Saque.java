package com.projeto1.operacoes;

import com.projeto1.modelo.HistoricoMovimentacoes;
import com.projeto1.modelo.TipoMovimentacao;
import com.projeto1.modelo.Usuario;
import com.projeto1.mensagens.Utils;

import static com.projeto1.mensagens.MensagensEnum.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Saque {

    public void sacar(Usuario usuario, BigDecimal valorSaque) {

        if (Boolean.TRUE.equals(new Saldo().verificaSaldo(usuario, valorSaque))) {
            BigDecimal saldoAntigo = usuario.getConta().getSaldo();
            usuario.getConta().subtrairSaldo(valorSaque);
            BigDecimal saldoNovo = usuario.getConta().getSaldo();

            HistoricoMovimentacoes historicoMovimentacao =new HistoricoMovimentacoes(UUID.randomUUID(), TipoMovimentacao.SAQUE, LocalDateTime.now(), valorSaque, saldoAntigo, saldoNovo);
                    usuario.getConta().setHistoricoMovimentacoes(historicoMovimentacao);
            Utils.printMensagem(OPERACAO_CONCLUIDA.getDescricao());
            Utils.printMensagem(historicoMovimentacao.toString());
        } else {
            Utils.printMensagem(MENSAGEM_ERRO_SALDO_INSUFICIENTE_SAQUE.getDescricao() + usuario.getConta().getSaldo());

        }
    }

}
