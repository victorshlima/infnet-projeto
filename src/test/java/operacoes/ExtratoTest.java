package operacoes;

import com.projeto1.autenticacao.Autenticacao;
import com.projeto1.dto.Usuario;
import com.projeto1.operacoes.Extrato;
import com.projeto1.operacoes.Saque;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ExtratoTest {

    @Test
    public void QUANDO_USUARIO_ATIVO_IMPRIME_EXTRATO(){

        Usuario usuario = new Autenticacao().autenticar("jasmin", "123");
        Extrato extrato = new Extrato();

        new Saque().sacar(usuario, BigDecimal.valueOf(100));
        new Saque().sacar(usuario, BigDecimal.valueOf(200));

        extrato.imprimir(usuario, 30);

    }
}
