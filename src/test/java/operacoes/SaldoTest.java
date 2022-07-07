package operacoes;

import com.projeto1.acesso.Autenticacao;
import com.projeto1.modelo.Usuario;
import com.projeto1.operacoes.Saldo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaldoTest {



    @DisplayName("QUANDO_USUARIO_ATIVO_SALDO_RETORNA_SALDO")
    @Test
    public void  QUANDO_USUARIO_ATIVO_SALDO_RETORNA_SALDO (){
        Autenticacao autenticacao = new Autenticacao();
        Usuario usuario = autenticacao.autenticar("jasmin", "123");
        assertEquals(BigDecimal.valueOf(1000.0), new Saldo().getSaldo(usuario));
    }

}
