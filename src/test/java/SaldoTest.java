import com.projeto1.autenticacao.Autenticacao;
import com.projeto1.dto.Usuario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaldoTest {

    @Test
    public void  QUANDO_USUARIO_ATIVO_SALDO_RETORNA_SALDO (){
        Autenticacao autenticacao = new Autenticacao();
        Usuario usuario = autenticacao.autenticar("jasmin", "123");
        assertEquals(BigDecimal.valueOf(1000.0), usuario.getConta().getSaldo());

    }

}
