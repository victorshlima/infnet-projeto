package operacoes;

import com.projeto1.autenticacao.Autenticacao;
import com.projeto1.dto.Usuario;
import com.projeto1.operacoes.Extrato;
import com.projeto1.operacoes.Saque;
import com.projeto1.operacoes.Transferencia;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExtratoTest {

    @Test
    public void QUANDO_USUARIO_ATIVO_IMPRIME_EXTRATO(){

        Usuario usuario = new Autenticacao().autenticar("jasmin", "123");
        Extrato extrato = new Extrato();

        new Saque().sacar(usuario, BigDecimal.valueOf(100));
        new Saque().sacar(usuario, BigDecimal.valueOf(200));

        extrato.imprimir(usuario);

    }

    @Test
    public void QUANDO_USUARIO_TODOS_EXTRATOS(){

        Usuario usuarioJasmin = new Autenticacao().autenticar("jasmin", "123");
        Usuario usuarioJoao = new Autenticacao().autenticar("joao", "123");
        Extrato extrato = new Extrato();

        new Transferencia().transferir(usuarioJasmin, usuarioJoao, BigDecimal.valueOf(1000.00));

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuarioJasmin);
        usuarios.add(usuarioJoao);
        extrato.imprimeTodos(usuarios);

    }

}
