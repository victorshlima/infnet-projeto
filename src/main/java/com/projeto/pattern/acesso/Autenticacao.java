package com.projeto.pattern.acesso;

import com.projeto.pattern.modelo.Usuario;
import com.projeto.pattern.mensagens.Utils;
import com.projeto.pattern.notificaoes.GerenciadorEventos;
import com.projeto.pattern.repository.Repository;

import java.util.Scanner;
import java.util.stream.Collectors;

import static com.projeto1.mensagens.MensagensEnum.*;

public class Autenticacao {

    Repository repository = Repository.getInstance();
    public GerenciadorEventos gerenciadorEventos;
    private static Scanner scanner = new Scanner(System.in);

    public Autenticacao() {
        this.gerenciadorEventos = new GerenciadorEventos("erro_login", "login_sucesso");
    }

    public Usuario autenticar(String nomeUsuario, String senha) {

        Usuario usuario = repository.getUsuarios().stream()
                .filter(u -> u.getNomeUsuario().equals(nomeUsuario))
                .filter(u -> u.getSenha().equals(senha))
                .collect(Collectors.toList()).get(0);

        if (!new Validacao().isAtivo(usuario)) {
            Utils.printMensagem(USUARIO_INATIVO.getDescricao());

            return null;
        }
        return usuario;
    }

    public Usuario logar() {
        try {
            Utils.printMensagem(MENSAGEM_LOGIN.getDescricao());
            String user = scanner.next();
            Utils.printMensagem(MENSAGEM_SENHA.getDescricao());
            String senha = scanner.next();
            return new Autenticacao().autenticar(user, senha);
        } catch (Exception e) {
            Utils.printMensagem(ERRO_AUTENTICACAO.getDescricao());
            this.gerenciadorEventos.notificar("erro_login", SIMULA_NOTIFICACAO.getDescricao());
            return logar();
        }
    }
}
