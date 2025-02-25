# Jogo de Batalha entre Heróis e Monstros

## Descrição
Este é um jogo de batalhas entre heróis e monstros, implementado em Java. O jogo permite que diferentes heróis enfrentem monstros em turnos, onde cada personagem tem habilidades e ataques distintos.

## Funcionalidades
- Escolha aleatória de heróis e monstros.
- Sistema de turnos onde os personagens atacam e sofrem dano.
- Registro de eventos do jogo para acompanhar a batalha.
- Habilidades e ataques variados para cada herói.
- Diferentes dificuldades de jogo.

## Estrutura do Projeto
```
Directory structure:
└── cupninas-jogo-prog2/
    ├── README.md
    ├── Jogo-Prog2.iml
    ├── Jogo.java
    ├── Log.java
    ├── Personagem.java
    ├── Turno.java
    ├── log.txt
    ├── Herois/
    │   ├── Arqueiro.java
    │   ├── Guerreiro.java
    │   ├── Heroi.java
    │   ├── Ladino.java
    │   └── Mago.java
    ├── Monstros/
    │   ├── AbominacaoDaCarne.java
    │   ├── CavaleiroDoVazio.java
    │   ├── ColossoDePedraViva.java
    │   ├── EspectroDaAgonia.java
    │   ├── HidraDeSangue.java
    │   └── Monstro.java
    └── enums/
        ├── ResultadoAtaque.java
        ├── TipoArma.java
        ├── TipoDificuldade.java
        ├── TipoHeroi.java
        └── TipoMonstro.java

```

## Como Jogar
1. Compile o projeto utilizando `javac`:
   ```sh
   javac Jogo/*.java Jogo/Herois/*.java Jogo/Monstros/*.java Jogo/enums/*.java
   ```
2. Execute o jogo especificando a dificuldade:
   ```sh
   java Jogo.Jogo FACIL
   ```

## Classes Principais

### `Jogo.java`
Gerencia a execução do jogo, incluindo a criação de heróis e monstros aleatoriamente e a execução dos turnos de batalha.

### `Heroi.java`
Classe abstrata base para todos os heróis. Define atributos como vida, defesa, destreza e velocidade.

### `Ladino.java`
Herói com habilidades furtivas e ataques rápidos.

### `Arqueiro.java`
Herói que utiliza ataques à distância e pode carregar flechas para causar dano extra.

### `Monstro.java`
Classe base para todos os monstros do jogo.

## Melhorias Futuras
- Implementar um sistema de inventário.
- Criar um modo multiplayer.
- Adicionar mais classes de heróis e monstros.
- Melhorar a interface gráfica do jogo.

## Contribuição
Sinta-se à vontade para contribuir com melhorias! Faça um fork do repositório, implemente suas mudanças e envie um Pull Request.

## Licença
Este projeto está licenciado sob a MIT License - veja o arquivo `LICENSE` para mais detalhes.

