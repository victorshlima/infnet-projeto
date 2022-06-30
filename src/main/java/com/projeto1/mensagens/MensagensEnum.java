package com.projeto1.mensagens;

public enum MensagensEnum {

    MENSAGEM_LOGIN("----------------Insira o Usuário----------------"),
    MENSAGEM_SENHA("----------------Insira a Senha----------------"),
    MENSAGEM_INICIAL("----------------Bem Vindo----------------"),
    MENSAGEM_FINAL("----------------Encerrando----------------"),
    USUARIO_INVALIDO("Usuário invalido, SAINDO!!!"),
    OPERACOES("Operações: saldo | saque | deposito | transferencia | extrato | pagar boleto"),
    SAQUE("Saque"),
    DEPOSITO("desposito"),
    EXTRATO("extrato"),
    SALDO("saldo"),
    MENSAGEM_SALDO("O saldo da conta é: "),
    PAGAR_BOLETO("pagar boleto"),
    DIGITE_NOVAMENTE_OPERACOES("Digite Novamente - saldo | saque | deposito | transferencia Z extrato | pagar boleto"),
    PARA_SAIR("Para sair digite exit"),
    EXIT("exit"),
    MENSAGEM_ERRO_TRANSFERENCIA("Saldo insuficiente"),
    OPERACAO_CONCLUIDA("Operação concluida"),
    MENSAGEM_TRANSF_DESTINO("Informe o usuário Destino"),
    USUARIO_INATIVO("Operação cancelada Usuário não está ativo, entre em contato com sua agencia");

    MensagensEnum(String descricao){
        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao(){
        return descricao;
    }

}
