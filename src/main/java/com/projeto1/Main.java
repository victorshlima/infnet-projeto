package com.projeto1;

import com.projeto1.mensagens.MensagensUtils;

import java.util.Scanner;

public class Main {

    public static void main (String[] args){


    // TODO projeto final converter esse sysout em um util, talves usar um oberver, ou status para


        MensagensUtils.printMensagem(MensagensUtils.getMensagemIncial());

    System.out.println("----------------Para sair digite exit----------------");
    
    
    //poderia usar o observer para disparar os eventos na conta

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
          String dadosEntradaUsuario =  scanner.next();


           if (dadosEntradaUsuario.equals("exit")){
               break;
           }

        }

     MensagensUtils.printMensagem(MensagensUtils.getMesagemFinal());

    }



}
