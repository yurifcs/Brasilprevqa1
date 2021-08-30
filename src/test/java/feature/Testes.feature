Feature: Testes API Brasilprev

  Scenario: Deve ser possível procurar pessoa pelo DDD e telefone
    Given Consulto com telefone com cadastro na base
    Then Retorna codigo 201 e dados da pessoa consultada

  Scenario: Deve retornar erro quando buscar pessoa por telefone inexistente
    Given Consulto com teleone sem cadastrado  na base
    Then Retorna codigo 404 e mensagem "Não existe pessoa com o telefone..."

  Scenario: Deve salvar nova pessoa no sistema
    Given Informo no Body do Request valores não cadastrados no banco
    Then Retorna codigo 201

  Scenario: Não deve ser possível salvar duas pessoas com o mesmo CPF
    Given  Informo no Body do Request valor de CPF já cadastrado no banco
    Then Retorna codigo 400 e mensagem "Já existe pessoa cadastrada com o CPF..."

  Scenario: Não deve ser possível salvar duas pessoas com o mesmo telefone
    Given Informo no Body do Request valor de Telegone já cadastrados no bancoC
    Then Retorna codigo 400 e mensagem ""Já existe pessoa cadastrada com o Telefone..."

  Scenario: Não deve ser possível salvar pessoas informando valores maiores que parametrizado
    Given  Informo no Body do Request nos campos valores maiores que o parametrizado
    Then Retorna codigo 500

  Scenario: Não deve ser possível salvar pessoas informando valores de caracteres especiais
    Given  Informo no Body do Request nos campos valores de caracteres especiais
    Then Retorna codigo 500