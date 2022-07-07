
   ##### Exercício - 1)

                           Banco Merci -  Caixa eletronico

   Essa aplicação simula as operações de um cliente em um banco com uma interface de terminal para 
   fins estudo do SOLID e Clean Code.

   Necessário "Autenticar" para acessar a aplicação, senhas na classe repository #(jasmin, 123)
   
   *** Tentei não usar nenhuma biblioteca tipo jpa e banco e etc para ficar mais simples e focar no código e não usar coisas prontas.
   
   Java 11
   Gradle
   
   Executar o Main
   Jasmin
   123
   
   após autenticar vc pode executar as operações escrevendo exatamente como aparece na tela.
   
   saldo
   transf
   saque
   deposito
   extrato
   
   Possui um nivel muito basico de tratamentos de erro por conta de simplicidade, siga o caminho feliz que vai dar bom.
   
   Possui teste

   ##### Usuário e senha na Classe Repository

   ##### Autenticação 
   Login
   Verificação de usuário (ativo, inativo)
   
   ##### Informações
   Extrato
   Saldo

   ##### Movimentações
   Saque
   Deposito
   Transferência 


   ##### Execício 3
   
   Pattern Singleton - (criacional) classe Repository - package com.projeto.pattern.repository - (criacional) 
   //Como essa classe simula um banco, é necessário garantir que só exista uma 'banco',  apenas uma instância desta classe

   Patern Builder (criacional)  HistoricoMovimentacoesBuilder

   Patern Prototype (criacional) Enviar objeto clonado apra evitar a exposição dos dados

   Patern Observer (comportamental )com.projeto.pattern.notificacoes.ObservadorEventos


   //observer
  //TODO caso o usuário erre 3 vezes o acesso, o observer é ativado é enviado e-mail


   // talvez o Switt  possa virar um state
   //talvez usar o decorator par notificar via -email e celular as ações
   // talvez o observer possa verificar as execuções e executar o decorator
  /// observer ao executar uma operaçõe envia emial e gera log?
    /// observer ao errar 3 vezes a senha envia email, usuário inativo tentado logar gera ALERTA interno, abre chamado


 


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

