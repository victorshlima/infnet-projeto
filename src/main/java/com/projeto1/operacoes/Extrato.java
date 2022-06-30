package com.projeto1.operacoes;

import com.projeto1.dto.HistoricoMovimentacoes;
import com.projeto1.dto.Usuario;
import com.projeto1.mensagens.MensagensUtils;
import com.projeto1.repository.Repository;

import java.util.List;

public class Extrato {

    public Extrato() {}

    public void imprimir(Usuario usuario){
    //TODO colocar um filtro de
       List<HistoricoMovimentacoes> historicoMovimentacoes = usuario.getConta().getHistoricoMovimentacoes();
        MensagensUtils.printMensagem("------------------------------------------------------- Extrato ------------------------------------------------------" +"\n");
        historicoMovimentacoes.stream().forEach(h -> {
            MensagensUtils.printMensagem(
                    "  DataMovimentacao:  "  +h.getDataMovimentacao()
                    +" SaldoAntes: " +h.getSaldoAntes()
                    +" SaldoDepois: " +h.getSaldoDepois()
                    +" Valor: " +h.getValor()
                    +" TipoMovimentacao: " +h.getTipoMovimentacao()
                    + exibeUser(h.getNomeUsuario()) +"\n"
                    + "----------------------------------------------------------------------------------------------------------------------");
        });
    }

    private String exibeUser(String nomeUsuario){
        if (nomeUsuario != null)
        return " NomeUsuario: " + (nomeUsuario);
        else return "";
    }

    public void imprimeTodos(List<Usuario> usuarios){
       usuarios.stream().forEach(u -> imprimir(u));
    }
}
