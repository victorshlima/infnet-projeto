package com.projeto1.acesso;

import com.projeto1.dto.Status;
import com.projeto1.dto.Usuario;

public class Validacao {

    public boolean isAtivo(Usuario usuario) {
        return usuario.getStatus().equals(Status.ATIVO);
    }

}
