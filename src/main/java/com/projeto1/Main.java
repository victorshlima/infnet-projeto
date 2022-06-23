package com.projeto1;

import java.util.Scanner;

public class Main {

    public static void main (String[] args){

    // TODO projeto final converter esse sysout em um util, talves usar um oberver, ou status para
    System.out.println("----------------Bem Vindo----------------");
    // criar uma classe para controlar a aplicação
    System.out.println("----------------Para sair digite exit----------------");

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
          String input =  scanner.next();


           if (input.equals("exit")){
               break;
           }
        }

    System.out.println("----------------Encerrando----------------");
    }

}
