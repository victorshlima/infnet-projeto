import com.projeto1.mensagens.MensagensUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MensagensTest {


    @Test
    public void MensagemInicial(){
        assertEquals("----------------Bem Vindo----------------", MensagensUtils.getMensagemIncial());

    }
}
