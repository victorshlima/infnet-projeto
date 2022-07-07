package com.projeto.pattern.modelo;

import java.util.Objects;
import java.util.UUID;

public class Usuario extends Pessoa{

    private UUID uuid;
    private String nomeUsuario;
    private String senha;
    private Status status;
    private Cliente cliente;
    private ContaBancaria contaBancaria;

    public Usuario(Usuario destino) {
        super(destino);
        if (destino != null) {
          //  this.uuid = destino.uuid;
            this.nomeUsuario = destino.nomeUsuario;
            this.senha = destino.senha;
            this.status = destino.status;
            this.cliente = destino.cliente;
            this.contaBancaria = destino.contaBancaria;
        }
    }

    public Usuario(UUID uuid, String nomeUsuario, String senha, Status status, Cliente cliente, ContaBancaria conta) {
        this.uuid = uuid;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.status = status;
        this.cliente = cliente;
        this.contaBancaria = conta;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
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

    public Cliente getPessoa() {
        return cliente;
    }

    public void setPessoa(Cliente cliente) {
        this.cliente = cliente;
    }

    public ContaBancaria getConta() {
        return contaBancaria;
    }

    public void setConta(ContaBancaria conta) {
        this.contaBancaria = conta;
    }

    @Override
    public Pessoa clone() {
        return new Usuario(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(uuid, usuario.uuid) && Objects.equals(nomeUsuario, usuario.nomeUsuario) && Objects.equals(senha, usuario.senha) && status == usuario.status && Objects.equals(cliente, usuario.cliente) && Objects.equals(contaBancaria, usuario.contaBancaria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uuid, nomeUsuario, senha, status, cliente, contaBancaria);
    }
}
