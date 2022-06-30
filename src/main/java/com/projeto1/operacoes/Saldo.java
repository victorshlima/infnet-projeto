package com.projeto1.operacoes;

import com.projeto1.dto.Usuario;

import java.math.BigDecimal;

public class Saldo {

    public Saldo() {}

    public Boolean verificaSaldo(Usuario usuario, BigDecimal valor){
        if (usuario.getConta().getSaldo().compareTo(valor) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public BigDecimal getSaldo (Usuario usuario){
        return usuario.getConta().getSaldo();
    }

}
