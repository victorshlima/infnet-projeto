package com.projeto.pattern.acesso;

import com.projeto.pattern.modelo.Usuario;
import com.projeto.pattern.modelo.Status;

public class Validacao {

    public boolean isAtivo(Usuario usuario) {
        return usuario.getStatus().equals(Status.ATIVO);
    }

}
