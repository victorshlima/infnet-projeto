package mensagens;

import org.junit.jupiter.api.Test;


import static com.projeto1.mensagens.MensagensEnum.MENSAGEM_INICIAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MensagensTest {


    @Test
    public void MensagemInicial(){
        assertEquals("----------------Bem Vindo----------------", MENSAGEM_INICIAL.getDescricao());

    }
}
