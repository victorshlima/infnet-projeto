package com.projeto1.mensagens;

public enum MensagensEnum {

    INPUT_BIGDECIMAL("Insira o valor seprado por ."),
    INPUT_ERRO_BIGDECIMAL("Dado de entrada inválido, insira um valor numerico seprado por '.'  exemplo: 1230000000.00, tente novamente"),
    MENSAGEM_LOGIN("----------------Insira o Usuário----------------"),
    ERRO_AUTENTICACAO("Erro ao autenticar, verifique o usuário/senha, caso o erro persista entre em contato com sua agencia"),
    MENSAGEM_SENHA("----------------Insira a Senha----------------"),
    MENSAGEM_INICIAL("----------------Bem Vindo----------------\n"),
    MENSAGEM_FINAL("----------------Encerrando----------------\n"),
    USUARIO_INVALIDO("Usuário invalido, SAINDO!!!\n"),


    SAQUE("Saque\n"),
    DEPOSITO("desposito\n"),
    EXTRATO("extrato \n " ),

    SALDO("saldo \n"),
    MENSAGEM_ERRO_TRANSFERENCIA("Saldo insuficiente \n"),
    MENSAGEM_ERRO_SALDO_INSUFICIENTE_SAQUE("Saldo insuficiente, o valor do saque maior que o saldo de: "),
    MENSAGEM_ERRO_SALDO_INSUFICIENTE_TRANSFERENCIA("Saldo insuficiente, o valor da transferencia maior que o saldo de: "),
    SUCESSO_TRANSFERENCIA("Saldo insuficiente \n"),
    MENSAGEM_SALDO("O saldo da conta é: \n"),

    PARA_SAIR("Para sair digite exit \n"),
    EXIT("exit \n"),
    OPERACAO_CONCLUIDA("Operação concluida \n"),


    OPERACOES("Operações: saldo | saque | deposito | transf| extrato \n"),
    DIGITE_NOVAMENTE_OPERACOES("Digite Novamente - saldo | saque | deposito | transf | extrato \n"),
    MENSAGEM_TRANSF_DESTINO("Informe o usuário Destino \n"),
    USUARIO_INATIVO("Operação cancelada Usuário não está ativo, entre em contato com sua agência \n"),
    USUARIO_DESTINO_NAO_EXISTE("Usuário destino informado não existe, tente novamente informando um usuário ativo \n"),
    TRANSFERENCIA_USUARIO_INATIVO_ERRO("Operação cancelada Usuário destino não está mais ativo \n");
    MensagensEnum(String descricao){
        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao(){
        return descricao;
    }

}
