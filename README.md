
   ###Exercício - 1)
   
   ##################################################################################
                           Banco Merci -  Caixa eletronico
   ###################################################################################
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
 

  ##########################################################################################################

### Exemplo de execução


----------------Bem Vindo----------------

Para sair digite exit

----------------Insira o Usuário----------------
jasmin
----------------Insira a Senha----------------
123
Operações: saldo | saque | deposito | transf| extrato

saldo
Digite Novamente - saldo | saque | deposito | transf | extrato

O saldo da conta é:
1000.0
Digite Novamente - saldo | saque | deposito | transf | extrato

saque
Insira o valor seprado por .
100
Operação concluida

Digite Novamente - saldo | saque | deposito | transf | extrato

saldo
O saldo da conta é:
900.0
Digite Novamente - saldo | saque | deposito | transf | extrato

deposito
Insira o valor seprado por .
50
Operação concluida

Digite Novamente - saldo | saque | deposito | transf | extrato

teste
Digite Novamente - saldo | saque | deposito | transf | extrato

saldo
O saldo da conta é:
950.0
Digite Novamente - saldo | saque | deposito | transf | extrato

deposito
Insira o valor seprado por .
15
Operação concluida

Digite Novamente - saldo | saque | deposito | transf | extrato

transf
Informe o usuário Destino

joao
Insira o valor seprado por .
65
Operação concluida

Digite Novamente - saldo | saque | deposito | transf | extrato

saldo
O saldo da conta é:
900.0
Digite Novamente - saldo | saque | deposito | transf | extrato

transf
Informe o usuário Destino

maria
Insira o valor seprado por .
12
Operação cancelada Usuário não está ativo, entre em contato com sua agencia

Digite Novamente - saldo | saque | deposito | transf | extrato

saldo
O saldo da conta é:
900.0
Digite Novamente - saldo | saque | deposito | transf | extrato

extrato

------------------------------------------------------- Extrato ------------------------------------------------------
DataMovimentacao:  2022-06-30T23:45:21.062749 SaldoAntes: 0 SaldoDepois: 1000.0 Valor: 1000.0 TipoMovimentacao: ENTRADA
----------------------------------------------------------------------------------------------------------------------
DataMovimentacao:  2022-06-30T23:45:28.047996 SaldoAntes: 1000.0 SaldoDepois: 900.0 Valor: 100 TipoMovimentacao: SAQUE
----------------------------------------------------------------------------------------------------------------------
DataMovimentacao:  2022-06-30T23:45:42.049133 SaldoAntes: 900.0 SaldoDepois: 50 Valor: 50 TipoMovimentacao: DEPOSITO
----------------------------------------------------------------------------------------------------------------------
DataMovimentacao:  2022-06-30T23:45:58.051377 SaldoAntes: 950.0 SaldoDepois: 15 Valor: 15 TipoMovimentacao: DEPOSITO
----------------------------------------------------------------------------------------------------------------------
DataMovimentacao:  2022-06-30T23:46:26.055073 SaldoAntes: 965.0 SaldoDepois: 900.0 Valor: 65 TipoMovimentacao: TRANSFERENCIA NomeUsuario: joao
----------------------------------------------------------------------------------------------------------------------
Digite Novamente - saldo | saque | deposito | transf | extrato 

