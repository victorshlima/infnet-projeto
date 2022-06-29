import com.projeto1.autenticacao.Autenticacao;
import com.projeto1.dto.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutenticacaoTest {

    @Test
    public void QUANDO_USUARIO_SENHA_CORRETO_USUARIO_ATIVO_AUTENTICA (){

    Autenticacao autenticacao = new Autenticacao();

    Usuario usuario = autenticacao.autenticar("jasmin", "123");
    assertEquals("jasmin", usuario.getUsuario());

    }


}
