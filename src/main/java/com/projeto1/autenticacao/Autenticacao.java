package com.projeto1.autenticacao;

import com.projeto1.dto.*;
import com.projeto1.repository.Repository;
import java.util.stream.Collectors;

public class Autenticacao {

    Repository repository;

    public Autenticacao(){
        this.repository = new Repository();
    }

    public Usuario autenticar(String usuario, String senha) {

        try {
            return repository.getUsuarios().stream()
                    .filter(u -> u.getNomeUsuario().equals(usuario))
                    .filter(u -> u.getSenha().equals(senha))
                    .filter(u -> u.getStatus().equals(Status.ATIVO))
                    .collect(Collectors.toList()).get(0);

        }catch (Exception e ){
            return null;
        }
    }

    public boolean verificaUsuario(Usuario usuario) {
        return usuario.getStatus().equals(Status.ATIVO);
    }

}
