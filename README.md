
Exercício - 1)

   ##########################################################################################################
                                       Banco Merci -  Caixa eletronico
   ##########################################################################################################
   Essa aplicação simula as operações de um cliente em uma banco com uma interface de terminal para 
   fins estudo do SOLID e Clean Code.

   Necessário "Autenticar" para acessar a aplicação

   ###   Usuário e senha na Classe Repository

   ### Autenticação 
   Login
   ### 
   Atualizar dados de usuário
   
   ### Informações
   Extrato
   Saldo

   ### Movimentações
   Saque
   Deposito
   Transferência
   Pagar boleto 



    Execício 3
   
    //TODO Design pattern para ter só um repository (singleton)
    //TODO notificar as movimentações observer
   //TODO builder para o usuário
   //TODO factory
   //TODO swith substituir por design patern
 

   ###TODO
   - Adicionar regra para valisar se o usuário está ativo nas "operações"
   - Limpar o código



  ##########################################################################################################

exemplo de execução

----------------Bem Vindo----------------
Para sair digite exit
----------------Insira o Usuário----------------
jasmin
----------------Insira a Senha----------------
123
Digite Novamente - saldo | saque | deposito | transferencia Z extrato | pagar boleto
trasnf
Digite Novamente - saldo | saque | deposito | transferencia Z extrato | pagar boleto
transf
Informe o usuário Destino
joao
Insira o valor seprado por .
100
Operação concluida
saldo
O saldo da conta é: 900.0
extrato
------------------------------------------------------- Extrato ------------------------------------------------------

getDataMovimentacao:  2022-06-30T00:43:18.715779 getSaldoAntes: 0 getSaldoDepois: 1000.0 getValor: 1000.0 getTipoMovimentacao: ENTRADA
----------------------------------------------------------------------------------------------------------------------
getDataMovimentacao:  2022-06-30T00:43:42.778144 getSaldoAntes: 1000.0 getSaldoDepois: 900.0 getValor: 100 getTipoMovimentacao: TRANSFERENCIA getNomeUsuario: joao
----------------------------------------------------------------------------------------------------------------------
