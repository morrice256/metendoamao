# language: pt

Funcionalidade: Cadastro de pessoas fisicas

  Cenario: Cadastrar com sucesso uma pessoa fisica
    Dado tenho não tenho o cpf '74525962003' previamente cadastrado na base
    Quando o cadastro de pessoa fisica for chamado com um o cpf '74525962003' e data de nascimento '01-01-1980'
    Então devo conseguir ter cadastrado uma nova pessoa fisica ativa e com a data de criação now
