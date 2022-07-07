package com.projeto.pattern.notificacoes;

import com.projeto.pattern.mensagens.Utils;

public class NotificacaoEmail implements ObservadorEventos {

    private String mensagem;

    public NotificacaoEmail(String mensagem) {
        this.mensagem = "EMAIL";

    }

    @Override
    public void update(String eventType, String mensagem) {
        Utils.printMensagem(mensagem + this.mensagem);
    }


}
