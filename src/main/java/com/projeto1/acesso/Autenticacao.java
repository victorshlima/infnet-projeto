package com.projeto1.acesso;

import com.projeto1.dto.*;
import com.projeto1.mensagens.MensagensUtils;
import com.projeto1.repository.Repository;
import java.util.stream.Collectors;

import static com.projeto1.mensagens.MensagensEnum.USUARIO_INATIVO;

public class Autenticacao {

    Repository repository;

    public Autenticacao(){
        this.repository = new Repository();
    }

    public Usuario autenticar(String nomeUsuario, String senha) {

         Usuario usuario = repository.getUsuarios().stream()
                    .filter(u -> u.getNomeUsuario().equals(nomeUsuario))
                    .filter(u -> u.getSenha().equals(senha))
                    .collect(Collectors.toList()).get(0);

        if (!new Validacao().isAtivo(usuario)) {
            MensagensUtils.printMensagem(USUARIO_INATIVO.getDescricao());
            return null;
        }
        return usuario;
    }
}
