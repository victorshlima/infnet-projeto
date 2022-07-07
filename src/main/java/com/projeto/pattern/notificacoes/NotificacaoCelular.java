package com.projeto.pattern.notificacoes;

import com.projeto.pattern.mensagens.Utils;

public class NotificacaoCelular implements ObservadorEventos {

    private String mensagem;

    public NotificacaoCelular(String mensagem) {
        this.mensagem = "CELULAR";
    }

    @Override
    public void update(String eventType, String mensagem) {
        Utils.printMensagem(mensagem + this.mensagem);
    }


}
