package com.projeto1.operacoes;

import com.projeto1.dto.HistoricoMovimentacoes;
import com.projeto1.dto.Usuario;
import com.projeto1.mensagens.MensagensUtils;

import java.util.List;

public class Extrato {

    public Extrato() {}

    public void imprimir(Usuario usuario, Integer dias){
    //TODO colocar um filtro de
       List<HistoricoMovimentacoes> historicoMovimentacoes = usuario.getConta().getHistoricoMovimentacoes();
        MensagensUtils.printMensagem("------------------------------------------------------- Extrato ------------------------------------------------------" +"\n");
        historicoMovimentacoes.stream().forEach(h -> {
            MensagensUtils.printMensagem(
                    "  getDataMovimentacao:  "
                    +h.getDataMovimentacao()
                    +" getSaldoAntes: "
                    +h.getSaldoAntes()
                    +" getSaldoDepois: "
                    +h.getSaldoDepois()
                    +" getValor: "
                    +h.getValor()
                    +" getTipoMovimentacao: "
                    +h.getTipoMovimentacao()
                    + exibeUser(h.getNomeUsuario())
                    +"\n"
                    + "----------------------------------------------------------------------------------------------------------------------"
            );
        });
    }

    private String exibeUser(String nomeUsuario){
        if (nomeUsuario != null)
        return " getNomeUsuario: " + (nomeUsuario
        );
        else
        return "";
    }


}
