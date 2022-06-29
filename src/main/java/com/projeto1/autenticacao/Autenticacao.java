package com.projeto1.autenticacao;

import com.projeto1.dto.*;
import com.projeto1.repository.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Autenticacao {

    Repository repository;
    //TODO Design pattern para ter só um repository (singleton)
    public Autenticacao(){
        this.repository = new Repository();
    }

    public Usuario autenticar(String usuario, String senha) {

        try {
            return repository.getUsuarios().stream()
                    .filter(u -> u.getUsuario().equals(usuario))
                    .filter(u -> u.getSenha().equals(senha))
                    .filter(u -> u.getStatus().equals(Status.ATIVO))
                        .collect(Collectors.toList()).get(0);

        }catch (Exception e ){
            return null;
        }
    }



}
