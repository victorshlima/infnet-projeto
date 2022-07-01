package acesso;

import com.projeto1.acesso.Autenticacao;
import com.projeto1.dto.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ControleUsuarioTeste {

    @DisplayName("QUANDO_USUARIO_SENHA_CORRETO_USUARIO_ATIVO_AUTENTICA")
    @Test
    public void QUANDO_USUARIO_SENHA_CORRETO_USUARIO_ATIVO_AUTENTICA (){

    Autenticacao autenticacao = new Autenticacao();
    Usuario usuario = autenticacao.autenticar("jasmin", "123");
    assertEquals("jasmin", usuario.getNomeUsuario());

    }

    @DisplayName("QUANDO_USUARIO_SENHA_INCORRETO_USUARIO_ATIVO_NAO_AUTENTICA")
    @Test
    public void QUANDO_USUARIO_SENHA_INCORRETO_USUARIO_ATIVO_NAO_AUTENTICA (){

        Autenticacao autenticacao = new Autenticacao();

        assertThrows(IndexOutOfBoundsException.class, ( ) ->  {
            autenticacao.autenticar("jasmin", "1111") ;
        } );

    }
}
