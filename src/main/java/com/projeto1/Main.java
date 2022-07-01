package com.projeto1;

import com.projeto1.acesso.Autenticacao;
import com.projeto1.dto.Usuario;
import com.projeto1.mensagens.MensagensUtils;
import com.projeto1.operacoes.*;
import com.projeto1.repository.Repository;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.projeto1.mensagens.MensagensEnum.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Usuario usuario;

    public static void main(String[] args) {
        imprimirMensagemIncial();
        logar();
        iniciarPrograma();
        imprimirMensagemFinal();
    }

    public static void imprimirMensagemIncial(){
        MensagensUtils.printMensagem(MENSAGEM_INICIAL.getDescricao());
        MensagensUtils.printMensagem(PARA_SAIR.getDescricao());
    }

    public static void imprimirMensagemFinal(){
        MensagensUtils.printMensagem(MENSAGEM_FINAL.getDescricao());
    }
    public static void iniciarPrograma() {
        MensagensUtils.printMensagem(OPERACOES.getDescricao());
        while (scanner.hasNext()) {
            if (usuario == null) {
                MensagensUtils.printMensagem(USUARIO_INVALIDO.getDescricao());
                break;
            }
            excecutarOperacoes(usuario);
        }
    }

    public static void logar() {
        MensagensUtils.printMensagem(MENSAGEM_LOGIN.getDescricao());
        String user = scanner.next();
        MensagensUtils.printMensagem(MENSAGEM_SENHA.getDescricao());
        String senha = scanner.next();
        usuario = new Autenticacao().autenticar(user, senha);
    }

    public static void excecutarOperacoes(Usuario usuarioLogado) {
        MensagensUtils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
        while (scanner.hasNext()) {
            String entradaUsario = scanner.next();
            switch (entradaUsario) {
                case "saque": {
                    new Saque().sacar(usuarioLogado, entradaTipoBigDecimal(scanner));
                    MensagensUtils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
                }
                break;
                case "transf": {
                    MensagensUtils.printMensagem(MENSAGEM_TRANSF_DESTINO.getDescricao());
                    String usuarioDestino = scanner.next();
                    new Transferencia().transferir(usuarioLogado, new Repository().getUsuarioPeloNome(usuarioDestino), entradaTipoBigDecimal(scanner));
                    MensagensUtils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
                }
                break;
                case "deposito": {
                    new Deposito().depositar(usuarioLogado, entradaTipoBigDecimal(scanner));
                    MensagensUtils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
                }
                break;
                case "extrato": {
                    new Extrato().imprimir(usuarioLogado);
                    MensagensUtils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
                }
                break;
                case "saldo":
                    MensagensUtils.printMensagem(MENSAGEM_SALDO.getDescricao() + usuarioLogado.getConta().getSaldo());
                    MensagensUtils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
                    break;
                case "exit":
                    scanner.close();
                    break;
                default:
                    MensagensUtils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
            }
        }

    }

    public static BigDecimal entradaTipoBigDecimal(Scanner scanner) {
        MensagensUtils.printMensagem("Insira o valor seprado por .");
        return scanner.nextBigDecimal();
    }

}
