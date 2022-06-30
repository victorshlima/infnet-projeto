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

    public static void main (String[] args) {
        MensagensUtils.printMensagem(MENSAGEM_INICIAL.getDescricao());
        MensagensUtils.printMensagem(PARA_SAIR.getDescricao());
        login();
        iniciaPrograma();
    }

    public static Scanner scanner = new Scanner(System.in);
    public static Usuario usuario;

    public static void iniciaPrograma(){
        MensagensUtils.printMensagem(OPERACOES.getDescricao());
            while (scanner.hasNext()){
                if (usuario == null){
                    MensagensUtils.printMensagem(USUARIO_INVALIDO.getDescricao());
                    break;
                }
                excecutarOperacoes(usuario);
            }
            MensagensUtils.printMensagem(MENSAGEM_FINAL.getDescricao());
        }

    public static void login(){
        MensagensUtils.printMensagem(MENSAGEM_LOGIN.getDescricao());
        String user =  scanner.next();
        MensagensUtils.printMensagem(MENSAGEM_SENHA.getDescricao());
        String senha =  scanner.next();
         usuario =  new Autenticacao().autenticar(user,senha );

    }

    public static void excecutarOperacoes(Usuario usuarioLogado){
        MensagensUtils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
        while (scanner.hasNext()){
            String entradaUsario =  scanner.next();
            switch (entradaUsario){
                case "saque" :
                {
                    new Saque().sacar(usuarioLogado, entradaBigDecimal(scanner));
                }
                break;
                case "transf": {
                    MensagensUtils.printMensagem(MENSAGEM_TRANSF_DESTINO.getDescricao());
                    String usuarioDestino =  scanner.next();
                    new Transferencia().transferir(usuarioLogado, new Repository().getUsuarioPeloNome(usuarioDestino), entradaBigDecimal(scanner));
                }
                    break;
                case "desposito": {
                    entradaBigDecimal(scanner);
                    new Deposito().depositar(usuarioLogado, entradaBigDecimal(scanner));
                }
                    break;
                case  "extrato" :{
                    new Extrato().imprimir(usuarioLogado);
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

    public static BigDecimal entradaBigDecimal(Scanner scanner) {
        MensagensUtils.printMensagem("Insira o valor seprado por .");
        return  scanner.nextBigDecimal();
    }

}
