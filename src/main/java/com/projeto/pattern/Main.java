package com.projeto.pattern;

import com.projeto.pattern.notificacoes.NotificacaoCelular;
import com.projeto.pattern.notificacoes.NotificacaoEmail;
import com.projeto.pattern.operacoes.Deposito;
import com.projeto.pattern.acesso.Autenticacao;
import com.projeto.pattern.modelo.Usuario;
import com.projeto.pattern.mensagens.Utils;
import com.projeto.pattern.operacoes.Extrato;
import com.projeto.pattern.operacoes.Saque;
import com.projeto.pattern.operacoes.Transferencia;
import com.projeto.pattern.repository.Repository;

import java.util.Scanner;

import static com.projeto1.mensagens.MensagensEnum.*;

public class Main {

    private static Repository repository = Repository.getInstance();
    private static Scanner scanner = new Scanner(System.in);
    private static Usuario usuario;

    public static void main(String[] args) {

        Autenticacao autenticacao =  new Autenticacao();
        autenticacao.gerenciadorEventos.seguir("erro_login", new NotificacaoEmail(SIMULA_NOTIFICACAO.getDescricao()));
        autenticacao.gerenciadorEventos.seguir("erro_login", new NotificacaoCelular(SIMULA_NOTIFICACAO.getDescricao()));
        Utils.imprimirMensagemIncial();
        usuario = autenticacao.logar();
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

                    Usuario usuarioDestinoTransferencia = repository.getUsuarioPeloNome(usuarioDestino);
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
                    new Extrato().imprimir((Usuario) usuarioLogado.clone());
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
