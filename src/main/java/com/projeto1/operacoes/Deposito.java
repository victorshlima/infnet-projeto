package com.projeto1.operacoes;

import com.projeto1.dto.HistoricoMovimentacoes;
import com.projeto1.dto.TipoMovimentacao;
import com.projeto1.dto.Usuario;
import com.projeto1.mensagens.MensagensUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import static com.projeto1.mensagens.MensagensEnum.OPERACAO_CONCLUIDA;


public class Deposito {

    public void depositar(Usuario usuario, BigDecimal valorDeposito) {
            usuario.getConta().setHistoricoMovimentacoes(new HistoricoMovimentacoes(UUID.randomUUID(),
                    TipoMovimentacao.DEPOSITO, LocalDateTime.now(), valorDeposito, usuario.getConta().getSaldo(), valorDeposito));
            usuario.getConta().somarSaldo(valorDeposito);
            MensagensUtils.printMensagem(OPERACAO_CONCLUIDA.getDescricao());
    }
}
