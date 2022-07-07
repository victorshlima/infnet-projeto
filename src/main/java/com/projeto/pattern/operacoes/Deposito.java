package com.projeto.pattern.operacoes;

import com.projeto.pattern.modelo.HistoricoMovimentacoes;
import com.projeto.pattern.modelo.HistoricoMovimentacoesBuilder;
import com.projeto.pattern.modelo.TipoMovimentacao;
import com.projeto.pattern.modelo.Usuario;
import com.projeto.pattern.mensagens.Utils;

import java.math.BigDecimal;

import static com.projeto1.mensagens.MensagensEnum.OPERACAO_CONCLUIDA;


public class Deposito {

    public void depositar(Usuario usuario, BigDecimal valorDeposito) {

        BigDecimal saldoAntes = usuario.getConta().getSaldo();
        usuario.getConta().somarSaldo(valorDeposito);

        HistoricoMovimentacoes historicoMovimentacao = HistoricoMovimentacoesBuilder.builder()
                .addTipoMovimentacao(TipoMovimentacao.DEPOSITO)
                .addValor(valorDeposito)
                .addSaldoAntes(saldoAntes)
                .addSaldoDepois(usuario.getConta().getSaldo())
                .build();

        usuario.getConta().setHistoricoMovimentacoes(historicoMovimentacao);
        Utils.printMensagem(OPERACAO_CONCLUIDA.getDescricao());
        Utils.printMensagem(historicoMovimentacao.toString());
    }
}
