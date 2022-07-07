package operacoes;

import com.projeto1.acesso.Autenticacao;
import com.projeto1.modelo.Usuario;
import com.projeto1.operacoes.Saque;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaqueTest {

    @DisplayName("QUANDO_VALOR_SAQUE_MENOR_SALDO_ATUALIZA_SALDO")
    @Test
    public void QUANDO_VALOR_SAQUE_MENOR_SALDO_ATUALIZA_SALDO (){
        Usuario usuario = new Autenticacao().autenticar("jasmin", "123");
        new Saque().sacar(usuario, BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(900.0), usuario.getConta().getSaldo());
    }

    @DisplayName("QUANDO_VALOR_SAQUE_MAIOR_SALDO_NAO_ATUALIZA_SALDO")
    @Test
    public void QUANDO_VALOR_SAQUE_MAIOR_SALDO_NAO_ATUALIZA_SALDO (){
        Usuario usuario = new Autenticacao().autenticar("jasmin", "123");
        new Saque().sacar(usuario, BigDecimal.valueOf(1001));
        assertEquals(BigDecimal.valueOf(1000.0), usuario.getConta().getSaldo());
    }

    @DisplayName("QUANDO_VALOR_SAQUE_MENOR_SALDO_ATUALIZA_EXTRATO")
    @Test
    public void QUANDO_VALOR_SAQUE_MENOR_SALDO_ATUALIZA_EXTRATO (){
        Usuario usuario = new Autenticacao().autenticar("jasmin", "123");
        new Saque().sacar(usuario, BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(900.0), usuario.getConta().getSaldo());
    }



}
