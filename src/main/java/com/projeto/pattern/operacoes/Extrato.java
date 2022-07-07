package com.projeto.pattern.operacoes;

import com.projeto.pattern.modelo.HistoricoMovimentacoes;
import com.projeto.pattern.modelo.Usuario;
import com.projeto.pattern.mensagens.Utils;

import java.util.List;

public class Extrato {

    public void imprimir(Usuario usuario) {
        List<HistoricoMovimentacoes> historicoMovimentacoes = usuario.getConta().getHistoricoMovimentacoes();
        Utils.printMensagem("------------------------------------------------------- Extrato ------------------------------------------------------" + "\n");
        historicoMovimentacoes.stream().forEach(h -> {
            Utils.printMensagem(
                    "  DataMovimentacao:  " + h.getDataMovimentacao()
                            + " SaldoAntes: " + h.getSaldoAntes()
                            + " SaldoDepois: " + h.getSaldoDepois()
                            + " Valor: " + h.getValor()
                            + " TipoMovimentacao: " + h.getTipoMovimentacao()
                            + exibeUser(h.getNomeUsuario()) + "\n"
                            + "----------------------------------------------------------------------------------------------------------------------");
        });
    }

    private String exibeUser(String nomeUsuario) {
        if (nomeUsuario != null)
            return " NomeUsuario: " + (nomeUsuario);
        else return "";
    }

    //Não seria o ideal o usuário ter isso, apenas para auxiliar nos testes
    public void imprimeTodos(List<Usuario> usuarios) {
        usuarios.stream().forEach(u -> imprimir(u));
    }
}
