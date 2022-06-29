package com.projeto1;

import com.projeto1.autenticacao.Autenticacao;
import com.projeto1.dto.Usuario;
import com.projeto1.mensagens.MensagensUtils;

import java.util.Scanner;

import static com.projeto1.mensagens.MensagensEnum.*;

public class Main {

    public static void main (String[] args){

    // TODO projeto final converter esse sysout em um util, talves usar um oberver, ou status para

    MensagensUtils.printMensagem(MENSAGEM_INICIAL.getDescricao());
    System.out.println("----------------Para sair digite exit----------------");

    //poderia usar o observer para disparar os eventos na conta
        Scanner scanner = new Scanner(System.in);

        // converter em metodo
        MensagensUtils.printMensagem(MENSAGEM_LOGIN.getDescricao());
        while (scanner.hasNext()){
            String user =  scanner.next();
            MensagensUtils.printMensagem(MENSAGEM_SENHA.getDescricao());
            String senha =  scanner.next();

            Usuario usuario = new Autenticacao().autenticar(user,senha );
            if (usuario == null){
                break;
            }
            // converter em metodo
            while (scanner.hasNext()){
                String dadosEntradaUsuario =  scanner.next();
                if (dadosEntradaUsuario.equals("exit")){
                    break;
                }
            }

        }

     MensagensUtils.printMensagem(MENSAGEM_FINAL.getDescricao());
    }

}
