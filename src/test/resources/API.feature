#language: pt

  Funcionalidade: Verificar se os preços estão corretos

    Cenário: Selecionar um imóvel e validar o valor
      Dado Está na pagina home
      Quando selecionado um imóvel
      Então o valor que aparecer nas telas seguntes tem que ser igual ao "valor" da tela inicial
