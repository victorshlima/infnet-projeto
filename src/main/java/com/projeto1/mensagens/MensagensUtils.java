package com.projeto1.mensagens;

public final class MensagensUtils {

    private MensagensUtils() {
        throw new IllegalStateException("MensagensUtils class - evitar ser instanciada");
    }

    public static void printMensagem(String mensagem) {
        System.out.println(mensagem);
    }

}
