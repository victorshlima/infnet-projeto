package com.projeto.pattern.operacoes;

import com.projeto.pattern.modelo.Usuario;

import java.math.BigDecimal;

public class Saldo {

    public Boolean verificaSaldo(Usuario usuario, BigDecimal valor) {
       return  usuario.getConta().getSaldo().compareTo(valor) >= 0;
    }

    public BigDecimal getSaldo(Usuario usuario) {
        return usuario.getConta().getSaldo();
    }

}
