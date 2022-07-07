package com.projeto.pattern.modelo;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Cliente {

    private UUID uuid;
    private String nome;
    private String sobrenome;
    private String cpf;
    private LocalDateTime idade;

    public Cliente(UUID uuid, String nome, String sobrenome, String cpf, LocalDateTime idade) {
        this.uuid = uuid;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDateTime getIdade() {
        return idade;
    }

    public void setIdade(LocalDateTime idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(uuid, cliente.uuid) && Objects.equals(nome, cliente.nome) && Objects.equals(sobrenome, cliente.sobrenome) && Objects.equals(cpf, cliente.cpf) && Objects.equals(idade, cliente.idade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, nome, sobrenome, cpf, idade);
    }
}
