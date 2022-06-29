import com.projeto1.autenticacao.Autenticacao;
import com.projeto1.dto.Usuario;
import com.projeto1.operacoes.Extrato;
import org.junit.jupiter.api.Test;

public class ExtratoTest {


    @Test
    public void QUANDO_USUARIO_ATIVO_IMPRIME_EXTRATO(){

        Usuario usuario = new Autenticacao().autenticar("jasmin", "123");
        Extrato extrato = new Extrato();
        extrato.imprimir(usuario, 30);

    }
}
