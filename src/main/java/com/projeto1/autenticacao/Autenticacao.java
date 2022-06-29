package com.projeto1.autenticacao;

import com.projeto1.dto.Conta;
import com.projeto1.dto.Pessoa;
import com.projeto1.dto.Status;
import com.projeto1.dto.Usuario;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Autenticacao {

    private List<Usuario> usuarios;

    public Autenticacao(){

    getUsuarios().add(new Usuario(UUID.randomUUID(), "Jasmin", "J@smin!23", Status.ATIVO,
       new Pessoa(UUID.randomUUID(), "Jasmin", "Flores", "123.321.456-01", LocalDateTime.of(1990, 01, 01, 12, 12)),
       new Conta(LocalDateTime.now(), LocalDateTime.now(), new BigDecimal(1000.00), null )));

    getUsuarios().add(new Usuario(UUID.randomUUID(), "Joao", "Jo@a!23", Status.ATIVO,
                new Pessoa(UUID.randomUUID(), "Joao", "Alfredo", "321.123.456-02", LocalDateTime.of(1990, 02, 02, 12, 12)),
                new Conta(LocalDateTime.now(), LocalDateTime.now(), new BigDecimal(2000.00), null )));

    getUsuarios().add(new Usuario(UUID.randomUUID(), "Maria", "M@ria!23", Status.BLOQUEADO,
                new Pessoa(UUID.randomUUID(), "Maria", "Pereira", "213.321.456-02", LocalDateTime.of(1990, 03, 03, 12, 12)),
                new Conta(LocalDateTime.now(), LocalDateTime.now(), new BigDecimal(1000.00), null )));

    }

    private List<Usuario> getUsuarios() {
        return usuarios;
    }


    public Usuario Autenticar(String usuario, String Senha){
        return getUsuarios().stream()
                .filter(u -> u.getUsuario().equals(usuario))
                .filter(u -> u.getStatus().equals(Status.ATIVO))
                .collect(Collectors.toList()).get(0);
    }


}
