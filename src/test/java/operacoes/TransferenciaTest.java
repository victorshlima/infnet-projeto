package operacoes;

import com.projeto1.Main;
import com.projeto1.acesso.Autenticacao;
import com.projeto1.dto.Usuario;
import com.projeto1.operacoes.Transferencia;
import com.projeto1.repository.Repository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransferenciaTest {

    @DisplayName("SE_USUARIO_DESTINO_ATIVO_TRANSFERE")
    @Test
    public void SE_USUARIO_DESTINO_ATIVO_TRANSFERE(){
        Usuario usuarioJasmin = new Autenticacao().autenticar("jasmin", "123");
        Usuario usuarioJoao =new Repository().getUsuarioPeloNome("joao");

        new Transferencia().transferir(usuarioJasmin, usuarioJoao, BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(900.0), usuarioJasmin.getConta().getSaldo());
        assertEquals(BigDecimal.valueOf(2100.0), usuarioJoao.getConta().getSaldo());
    }

    @DisplayName("SE_USUARIO_DESTINO_ATIVO_TRANSFERE")
    @Test
    public void SE_USUARIO_DESTINO_INATIVO_NAO_TRANSFERE(){
        Usuario usuarioJasmin = new Autenticacao().autenticar("jasmin", "123");
        Usuario usuarioMaria = new Repository().getUsuarioPeloNome("maria");


        new Transferencia().transferir(usuarioJasmin, usuarioMaria, BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(1000.0), usuarioJasmin.getConta().getSaldo());

    }
}
