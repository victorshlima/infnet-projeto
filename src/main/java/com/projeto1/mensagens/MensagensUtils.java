package com.projeto1.mensagens;

public final class MensagensUtils {


    public static String getMensagemIncial(){
      return  "----------------Bem Vindo----------------";
    }

    public static  String getMesagemFinal() {
       return "----------------Encerrando----------------";
    }

    public static void printMensagem(String mensagem){
        System.out.println(mensagem);
    }

}
