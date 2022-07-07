package com.projeto1.operacoes;

import com.projeto1.acesso.Validacao;
import com.projeto1.dto.HistoricoMovimentacoes;
import com.projeto1.dto.TipoMovimentacao;
import com.projeto1.dto.Usuario;
import com.projeto1.mensagens.Utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

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
            HistoricoMovimentacoes historicoMovimentacaoOrigem =   new HistoricoMovimentacoes(UUID.randomUUID(), TipoMovimentacao.TRANSFERENCIA, LocalDateTime.now(),
                    valorTransferencia, saldoAntesOrigem, usuarioOrigen.getConta().getSaldo(), usuarioDestino.getNomeUsuario());
            usuarioOrigen.getConta().setHistoricoMovimentacoes(historicoMovimentacaoOrigem);

            BigDecimal saldoAntesDestino = usuarioDestino.getConta().getSaldo();
            usuarioDestino.getConta().somarSaldo(valorTransferencia);


            HistoricoMovimentacoes historicoMovimentacaoDestino =   new HistoricoMovimentacoes(UUID.randomUUID(), TipoMovimentacao.TRANSFERENCIA, LocalDateTime.now(),
                    valorTransferencia, saldoAntesDestino, usuarioDestino.getConta().getSaldo(), usuarioOrigen.getNomeUsuario());
            usuarioDestino.getConta().setHistoricoMovimentacoes(historicoMovimentacaoDestino);

            Utils.printMensagem(SUCESSO_TRANSFERENCIA.toString());
            Utils.printMensagem(historicoMovimentacaoOrigem.toStringTransferencia());

        } else {
            Utils.printMensagem(MENSAGEM_ERRO_SALDO_INSUFICIENTE_TRANSFERENCIA.getDescricao() + usuarioOrigen.getConta().getSaldo());
        }
    }

}
