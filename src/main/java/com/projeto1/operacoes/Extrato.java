package com.projeto1.operacoes;

import com.projeto1.dto.HistoricoMovimentacoes;
import com.projeto1.dto.Usuario;
import com.projeto1.mensagens.MensagensUtils;

import java.util.List;

public class Extrato {


    public Extrato() {
    }

    public void imprimir(Usuario usuario, Integer dias){

       List<HistoricoMovimentacoes> historicoMovimentacoes = usuario.getConta().getHistoricoMovimentacoes();

        historicoMovimentacoes.stream().forEach(h -> {

            MensagensUtils.printMensagem(
                    "--------------Extrato---------" + "\n"
                    +"  getDataMovimentacao:  "
                    +h.getDataMovimentacao()
                    +" getSaldoAntes: "
                    +h.getSaldoAntes()
                    +" getSaldoDepois: "
                    +h.getSaldoDepois()
                    +" getValor: "
                    +h.getValor()
            );
        });



    }
}
