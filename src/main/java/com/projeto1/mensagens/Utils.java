package com.projeto1.mensagens;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.projeto1.mensagens.MensagensEnum.*;

public final class Utils {

    private Utils() {
        throw new IllegalStateException("MensagensUtils class - evitar ser instanciada");
    }

    public static void printMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public static void imprimirMensagemIncial(){
        Utils.printMensagem(MENSAGEM_INICIAL.getDescricao());
        Utils.printMensagem(PARA_SAIR.getDescricao());
    }

    public static void imprimirMensagemFinal(){

        Utils.printMensagem(MENSAGEM_FINAL.getDescricao());
    }

    public static BigDecimal entradaTipoBigDecimal(Scanner scanner) {
        try {
            Utils.printMensagem(INPUT_BIGDECIMAL.getDescricao());
            return scanner.nextBigDecimal();
        }catch (Exception e){
            Utils.printMensagem(INPUT_ERRO_BIGDECIMAL.getDescricao());
            scanner = new Scanner(System.in);
            return  scanner.nextBigDecimal();
        }
    }
}
