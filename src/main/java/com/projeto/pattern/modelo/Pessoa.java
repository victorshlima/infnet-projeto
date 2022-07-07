package com.projeto.pattern.modelo;

import java.util.Objects;
import java.util.UUID;

public abstract class Pessoa {

    public UUID uuid;


    public Pessoa() {}

    public Pessoa(Pessoa destino){
        if (destino != null) {
           this.uuid = destino.uuid;
        }

    }
    public abstract Pessoa clone();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(uuid, pessoa.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
