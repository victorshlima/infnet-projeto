package com.projeto1.operacoes;

import com.projeto1.dto.HistoricoMovimentacoes;
import com.projeto1.dto.TipoMovimentacao;
import com.projeto1.dto.Usuario;
import com.projeto1.mensagens.MensagensUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.projeto1.mensagens.MensagensEnum.MENSAGEM_ERRO_TRANSFERENCIA;
import static com.projeto1.mensagens.MensagensEnum.OPERACAO_CONCLUIDA;

public class Transferencia {


    public Transferencia() {}

    public void transferir(Usuario usuarioOrigen , Usuario usuarioDestino, BigDecimal valorTransferencia){
        if (new Saldo().verificaSaldo(usuarioOrigen, valorTransferencia)){

            BigDecimal  novoSaldo =  usuarioOrigen.getConta().getSaldo().subtract(valorTransferencia);
            usuarioOrigen.getConta().setHistoricoMovimentacoes(
                    new HistoricoMovimentacoes(UUID.randomUUID(), TipoMovimentacao.TRANSFERENCIA, LocalDateTime.now(),
                    valorTransferencia, usuarioOrigen.getConta().getSaldo(), novoSaldo, usuarioDestino.getNomeUsuario()));
            usuarioOrigen.getConta().setSaldo(novoSaldo);

            BigDecimal novoSaldoDestino =  usuarioDestino.getConta().getSaldo().add(valorTransferencia);
            usuarioDestino.getConta().setHistoricoMovimentacoes(new HistoricoMovimentacoes(UUID.randomUUID(),
                    TipoMovimentacao.TRANSFERENCIA, LocalDateTime.now(), valorTransferencia, usuarioDestino.getConta().getSaldo(), novoSaldoDestino, usuarioOrigen.getNomeUsuario()));
            usuarioDestino.getConta().setSaldo(novoSaldo);

            MensagensUtils.printMensagem(OPERACAO_CONCLUIDA.getDescricao());
        } else {
            MensagensUtils.printMensagem(MENSAGEM_ERRO_TRANSFERENCIA.getDescricao());
        }
    }
}
