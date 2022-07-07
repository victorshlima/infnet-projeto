package com.projeto1.acesso;

import com.projeto1.modelo.Status;
import com.projeto1.modelo.Usuario;

public class Validacao {

    public boolean isAtivo(Usuario usuario) {
        return usuario.getStatus().equals(Status.ATIVO);
    }

}
