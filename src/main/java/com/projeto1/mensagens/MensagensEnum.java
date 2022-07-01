package com.projeto1.mensagens;

public enum MensagensEnum {

    MENSAGEM_LOGIN("----------------Insira o Usuário----------------"),
    MENSAGEM_SENHA("----------------Insira a Senha----------------"),
    MENSAGEM_INICIAL("----------------Bem Vindo----------------\n"),
    MENSAGEM_FINAL("----------------Encerrando----------------\n"),
    USUARIO_INVALIDO("Usuário invalido, SAINDO!!!\n"),


    SAQUE("Saque\n"),
    DEPOSITO("desposito\n"),
    EXTRATO("extrato \n " ),

    SALDO("saldo \n"),
    MENSAGEM_ERRO_TRANSFERENCIA("Saldo insuficiente \n"),
    MENSAGEM_SALDO("O saldo da conta é: \n"),

    PARA_SAIR("Para sair digite exit \n"),
    EXIT("exit \n"),
    OPERACAO_CONCLUIDA("Operação concluida \n"),


    OPERACOES("Operações: saldo | saque | deposito | transf| extrato \n"),
    DIGITE_NOVAMENTE_OPERACOES("Digite Novamente - saldo | saque | deposito | transf | extrato \n"),
    MENSAGEM_TRANSF_DESTINO("Informe o usuário Destino \n"),
    USUARIO_INATIVO("Operação cancelada Usuário não está ativo, entre em contato com sua agencia \n");

    MensagensEnum(String descricao){
        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao(){
        return descricao;
    }

}
