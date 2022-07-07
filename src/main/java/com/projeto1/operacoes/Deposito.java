package com.projeto1.operacoes;

import com.projeto1.modelo.HistoricoMovimentacoes;
import com.projeto1.modelo.TipoMovimentacao;
import com.projeto1.modelo.Usuario;
import com.projeto1.mensagens.Utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import static com.projeto1.mensagens.MensagensEnum.OPERACAO_CONCLUIDA;


public class Deposito {

    public void depositar(Usuario usuario, BigDecimal valorDeposito) {

        BigDecimal saldoAntes = usuario.getConta().getSaldo();
        usuario.getConta().somarSaldo(valorDeposito);

        HistoricoMovimentacoes historicoMovimentacao = new HistoricoMovimentacoes(UUID.randomUUID(),
                TipoMovimentacao.DEPOSITO, LocalDateTime.now(), valorDeposito, saldoAntes, usuario.getConta().getSaldo());
        usuario.getConta().setHistoricoMovimentacoes(historicoMovimentacao);
        Utils.printMensagem(OPERACAO_CONCLUIDA.getDescricao());
        Utils.printMensagem(historicoMovimentacao.toString());
    }
}
