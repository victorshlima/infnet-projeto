package com.projeto1.operacoes;

import com.projeto1.dto.HistoricoMovimentacoes;
import com.projeto1.dto.TipoMovimentacao;
import com.projeto1.dto.Usuario;
import com.projeto1.mensagens.MensagensUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Saque {

    public Saque() {}

    public void sacar(Usuario usuario, BigDecimal valorSaque){

        if(usuario.getConta().getSaldo().compareTo(valorSaque) >= 0){
          BigDecimal  novoSaldo =  usuario.getConta().getSaldo().subtract(valorSaque);
            usuario.getConta().setHistoricoMovimentacoes(new HistoricoMovimentacoes(UUID.randomUUID(), TipoMovimentacao.SAQUE, LocalDateTime.now(), valorSaque, usuario.getConta().getSaldo(), novoSaldo));
            usuario.getConta().setSaldo(novoSaldo);
        }else {
            MensagensUtils.printMensagem("Saldo insuficiente");
        }
    }

}
