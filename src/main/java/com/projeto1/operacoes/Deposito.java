package com.projeto1.operacoes;

import com.projeto1.autenticacao.Autenticacao;
import com.projeto1.dto.HistoricoMovimentacoes;
import com.projeto1.dto.TipoMovimentacao;
import com.projeto1.dto.Usuario;
import com.projeto1.mensagens.MensagensUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.projeto1.mensagens.MensagensEnum.OPERACAO_CONCLUIDA;
import static com.projeto1.mensagens.MensagensEnum.USUARIO_INATIVO;

public class Deposito {

    public Deposito() {}

    public void depositar(Usuario usuario, BigDecimal valorDeposito){

        if(new Autenticacao().verificaUsuario(usuario)){
            BigDecimal novoSaldo =  usuario.getConta().getSaldo().add(valorDeposito);
            usuario.getConta().setHistoricoMovimentacoes(new HistoricoMovimentacoes(UUID.randomUUID(),
                    TipoMovimentacao.DEPOSITO, LocalDateTime.now(), valorDeposito, usuario.getConta().getSaldo(), novoSaldo));
            usuario.getConta().setSaldo(novoSaldo);
            MensagensUtils.printMensagem(OPERACAO_CONCLUIDA.getDescricao());
        }else {
            MensagensUtils.printMensagem(USUARIO_INATIVO.getDescricao());
        }
    }


}
