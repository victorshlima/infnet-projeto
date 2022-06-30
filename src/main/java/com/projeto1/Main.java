package com.projeto1;

import com.projeto1.autenticacao.Autenticacao;
import com.projeto1.dto.Usuario;
import com.projeto1.mensagens.MensagensUtils;
import com.projeto1.operacoes.*;
import com.projeto1.repository.Repository;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.projeto1.mensagens.MensagensEnum.*;

public class Main {

    public static void main (String[] args){

    // TODO projeto final converter esse sysout em um util, talves usar um oberver, ou status para

    MensagensUtils.printMensagem(MENSAGEM_INICIAL.getDescricao());
    System.out.println(PARA_SAIR.getDescricao());
        Scanner scanner = new Scanner(System.in);
        MensagensUtils.printMensagem(MENSAGEM_LOGIN.getDescricao());
        while (scanner.hasNext()){

            String user =  scanner.next();
            MensagensUtils.printMensagem(MENSAGEM_SENHA.getDescricao());
            String senha =  scanner.next();
            Usuario usuario = new Autenticacao().autenticar(user,senha );

            if (usuario == null){
                MensagensUtils.printMensagem(USUARIO_INVALIDO.getDescricao());
                break;
            }
            operacoes(scanner, usuario);
        }
     MensagensUtils.printMensagem(MENSAGEM_FINAL.getDescricao());
    }

    public static void operacoes(Scanner scanner, Usuario usuarioLogado){
        MensagensUtils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
        while (scanner.hasNext()){
            String entradaUsario =  scanner.next();
            switch (entradaUsario){
                case "saque" :
                {
                    new Saque().sacar(usuarioLogado, scanValor(scanner));
                }
                break;
                case "transf": {
                    MensagensUtils.printMensagem(MENSAGEM_TRANSF_DESTINO.getDescricao());
                    String usuarioDestino =  scanner.next();
                    new Transferencia().transferir(usuarioLogado, new Repository().getUsuarioPeloNome(usuarioDestino), scanValor(scanner));
                }
                    break;
                case "desposito": {
                    scanValor(scanner);
                    new Deposito().depositar(usuarioLogado, scanValor(scanner));
                }
                    break;
                case  "extrato" :{
                    //TODO filtrat por data
                    new Extrato().imprimir(usuarioLogado, 30);
                }
                break;
                case  "saldo" : MensagensUtils.printMensagem( MENSAGEM_SALDO.getDescricao() + usuarioLogado.getConta().getSaldo());
                    break;
                case  "pagar boleto" :
                    break;
                default: MensagensUtils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
            }
            if (entradaUsario.equals(EXIT.getDescricao())){
                break;
            }

        }

    }

    public static BigDecimal scanValor(Scanner scanner) {
        MensagensUtils.printMensagem("Insira o valor seprado por .");
        return  scanner.nextBigDecimal();
    }

}
