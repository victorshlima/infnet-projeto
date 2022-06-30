package com.projeto1.dto;

import java.util.Objects;
import java.util.UUID;

public class Usuario {

    private UUID uuid;
    private String usuario;
    private String senha;
    private Status status;
    private Pessoa pessoa;
    private ContaBancaria contaBancaria;

    public Usuario(UUID uuid, String usuario, String senha, Status status, Pessoa pessoa, ContaBancaria conta) {
        this.uuid = uuid;
        this.usuario = usuario;
        this.senha = senha;
        this.status = status;
        this.pessoa = pessoa;
        this.contaBancaria = conta;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNomeUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public ContaBancaria getConta() {
        return contaBancaria;
    }

    public void setConta(ContaBancaria conta) {
        this.contaBancaria = conta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario1 = (Usuario) o;
        return Objects.equals(uuid, usuario1.uuid) && Objects.equals(usuario, usuario1.usuario) && Objects.equals(senha, usuario1.senha) && status == usuario1.status && Objects.equals(pessoa, usuario1.pessoa) && Objects.equals(contaBancaria, usuario1.contaBancaria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, usuario, senha, status, pessoa, contaBancaria);
    }
}
