package com.projeto1.acesso;

import com.projeto1.dto.*;
import com.projeto1.mensagens.Utils;
import com.projeto1.repository.Repository;

import java.util.Scanner;
import java.util.stream.Collectors;

import static com.projeto1.mensagens.MensagensEnum.*;

public class Autenticacao {

    Repository repository;
    private static Scanner scanner = new Scanner(System.in);

    public Autenticacao() {
        this.repository = new Repository();
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

    public static Usuario logar() {
        try {
            Utils.printMensagem(MENSAGEM_LOGIN.getDescricao());
            String user = scanner.next();
            Utils.printMensagem(MENSAGEM_SENHA.getDescricao());
            String senha = scanner.next();
            return new Autenticacao().autenticar(user, senha);
        } catch (Exception e) {
            Utils.printMensagem(ERRO_AUTENTICACAO.getDescricao());
            return logar();
        }
    }
}
