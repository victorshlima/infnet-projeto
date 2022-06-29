package com.projeto1.mensagens;

public enum MensagensEnum {

    MENSAGEM_LOGIN("----------------Insira o Usuário----------------"),
    MENSAGEM_INICIAL("----------------Bem Vindo----------------"),
    MENSAGEM_FINAL("----------------Encerrando----------------");

    private String descricao;

    MensagensEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

}
