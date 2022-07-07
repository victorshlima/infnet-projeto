package com.projeto1;

import com.projeto1.acesso.Autenticacao;
import com.projeto1.dto.Usuario;
import com.projeto1.mensagens.Utils;
import com.projeto1.operacoes.*;
import com.projeto1.repository.Repository;

import java.util.Scanner;

import static com.projeto1.mensagens.MensagensEnum.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Usuario usuario;

    public static void main(String[] args) {
        Utils.imprimirMensagemIncial();
        usuario = Autenticacao.logar();
        iniciarPrograma();
        Utils.imprimirMensagemFinal();
    }

    public static void iniciarPrograma() {
        Utils.printMensagem(OPERACOES.getDescricao());
        while (scanner.hasNext()) {
            if (usuario == null) {
                Utils.printMensagem(USUARIO_INVALIDO.getDescricao());
                break;
            }
            excecutarOperacoes(usuario);
        }
    }

    public static void excecutarOperacoes(Usuario usuarioLogado) {
        Utils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
        while (scanner.hasNext()) {
            String entradaUsario = scanner.next();
            switch (entradaUsario) {
                case "saque": {
                    new Saque().sacar(usuarioLogado, Utils.entradaTipoBigDecimal(scanner));
                    Utils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
                }
                break;
                case "transf": {
                    Utils.printMensagem(MENSAGEM_TRANSF_DESTINO.getDescricao());
                    String usuarioDestino = scanner.next();

                    Usuario usuarioDestinoTransferencia = new Repository().getUsuarioPeloNome(usuarioDestino);
                    if (usuarioDestinoTransferencia != null) {
                        new Transferencia().transferir(usuarioLogado, usuarioDestinoTransferencia, Utils.entradaTipoBigDecimal(scanner));
                    }
                    Utils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
                }
                break;
                case "deposito": {
                    new Deposito().depositar(usuarioLogado, Utils.entradaTipoBigDecimal(scanner));
                    Utils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
                }
                break;
                case "extrato": {
                    new Extrato().imprimir(usuarioLogado);
                    Utils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
                }
                break;
                case "saldo":
                    Utils.printMensagem(MENSAGEM_SALDO.getDescricao() + usuarioLogado.getConta().getSaldo());
                    Utils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
                    break;
                case "exit":
                    scanner.close();
                    break;
                default:
                    Utils.printMensagem(DIGITE_NOVAMENTE_OPERACOES.getDescricao());
            }
        }
    }
}
