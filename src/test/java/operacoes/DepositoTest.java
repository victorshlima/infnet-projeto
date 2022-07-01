package operacoes;

import com.projeto1.acesso.Autenticacao;
import com.projeto1.dto.Usuario;
import com.projeto1.operacoes.Deposito;
import com.projeto1.operacoes.Saldo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositoTest {

    @DisplayName("")
    @Test
    public void SE_USUARIO_ATIVO_DEPOSITA(){
        Autenticacao autenticacao = new Autenticacao();
        Usuario usuario = autenticacao.autenticar("jasmin", "123");
        new Deposito().depositar(usuario, BigDecimal.valueOf(123));

        assertEquals(BigDecimal.valueOf(1123.0), usuario.getConta().getSaldo());
    }
}
