package com.projeto1.operacoes;

import com.projeto1.acesso.Validacao;
import com.projeto1.dto.HistoricoMovimentacoes;
import com.projeto1.dto.TipoMovimentacao;
import com.projeto1.dto.Usuario;
import com.projeto1.mensagens.MensagensUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.projeto1.mensagens.MensagensEnum.*;

public class Transferencia {

    public void transferir(Usuario usuarioOrigen, Usuario usuarioDestino, BigDecimal valorTransferencia) {
        if (!new Validacao().isAtivo(usuarioDestino)) {
            MensagensUtils.printMensagem(USUARIO_INATIVO.getDescricao());
            return;
        }

        if (Boolean.TRUE.equals(new Saldo().verificaSaldo(usuarioOrigen, valorTransferencia))) {

            BigDecimal saldoAntesOrigem = usuarioOrigen.getConta().getSaldo();
            usuarioOrigen.getConta().subtrairSaldo(valorTransferencia);
            registraTrasferencia(usuarioOrigen, valorTransferencia, saldoAntesOrigem, usuarioDestino.getNomeUsuario());

            BigDecimal saldoAntesDestino = usuarioDestino.getConta().getSaldo();
            usuarioDestino.getConta().somarSaldo(valorTransferencia);
            registraTrasferencia(usuarioDestino, valorTransferencia, saldoAntesDestino, usuarioOrigen.getNomeUsuario());

            MensagensUtils.printMensagem(OPERACAO_CONCLUIDA.getDescricao());
        } else {
            MensagensUtils.printMensagem(MENSAGEM_ERRO_TRANSFERENCIA.getDescricao());
        }
    }

    private void registraTrasferencia(Usuario usuario, BigDecimal valorTransferencia, BigDecimal saldoAntes, String nomeUsuario) {

        usuario.getConta().setHistoricoMovimentacoes(
                new HistoricoMovimentacoes(UUID.randomUUID(), TipoMovimentacao.TRANSFERENCIA, LocalDateTime.now(),
                        valorTransferencia, saldoAntes, usuario.getConta().getSaldo(), nomeUsuario));
    }

}
