
# 🏰⚔️ Jogo de Batalha entre Heróis e Monstros

Um jogo de batalha por turnos desenvolvido em Java, onde heróis e monstros com habilidades únicas se enfrentam em combates estratégicos.  
**Destaques**: POO avançada, sistema de logs, geração procedural de personagens e múltiplas dificuldades.

---

## 📌 Índice
- [Funcionalidades](#✨-funcionalidades)
- [Tecnologias e Conceitos](#🛠️-tecnologias-e-conceitos)
- [Estrutura do Projeto](#📂-estrutura-do-projeto)
- [Como Executar](#🚀-como-executar)
- [Classes Principais](#🏗️-classes-principais)
- [Contribuição](#🤝-contribuição)
- [Licença](#📜-licença)
- [Roadmap](#🗺️-roadmap)

---

## ✨ Funcionalidades

### **Sistema de Batalha**
- **Turnos Dinâmicos**: Personagens agem com base em velocidade e destreza.
- **Habilidades Únicas**:
  - *Heróis*: Flechas carregadas (Arqueiro), Fúria (Guerreiro), Furtividade (Ladino), Magia (Mago).
  - *Monstros*: Regeneração (Abominação), Intangibilidade (Espectro), Ataques em área (Hidra).
- **Dificuldades**: `FÁCIL`, `MÉDIO`, `DIFÍCIL` (afetam atributos dos monstros).

### **Geração de Personagens**
- **Heróis Aleatórios**: Classes e atributos gerados proceduralmente.
- **Monstros Adaptativos**: Atributos escalonam com a dificuldade escolhida.

### **Logs Detalhados**
- Registro em tempo real de todas as ações (`log.txt`).
- Timestamp em cada evento para análise pós-batalha.

### **Extensibilidade**
- Facilidade para adicionar novos heróis, monstros, armas e mecânicas.

---

## 🛠️ Tecnologias e Conceitos
- **Java 17**: Linguagem base.
- **POO**: Herança, polimorfismo, classes abstratas, enums.
- **Design Patterns**: Factory Method (geração de personagens), Singleton (Log).
- **Manipulação de Arquivos**: Persistência de logs.
- **Concorrência**: Uso de `Collections.synchronizedList` para threads.

---

## 📂 Estrutura do Projeto

```
src/
├── Jogo/
│   ├── Herois/            # Classes de heróis
│   │   ├── Arqueiro.java
│   │   ├── Guerreiro.java
│   │   ├── Ladino.java
│   │   └── Mago.java
│   ├── Monstros/          # Classes de monstros
│   │   ├── AbominacaoDaCarne.java
│   │   ├── CavaleiroDoVazio.java
│   │   └── ...
│   ├── enums/             # Enums para tipos e armas
│   │   ├── TipoHeroi.java
│   │   ├── TipoArma.java
│   │   └── ...
│   ├── Jogo.java          # Classe main
│   ├── Log.java           # Sistema de registro
│   ├── Personagem.java    # Classe base
│   └── Turno.java         # Lógica de turnos
```

---

## 🚀 Como Executar

### Pré-requisitos
- JDK 17+ instalado.
- Terminal/CMD.

### Passo a Passo
1. **Compilar**:
   ```bash
   javac Jogo/*.java Jogo/Herois/*.java Jogo/Monstros/*.java Jogo/enums/*.java
   ```

2. **Executar** (escolha a dificuldade):
   ```bash
   java Jogo.Jogo FACIL    # Ou MEDIO/DIFICIL
   ```

3. **Ver Logs**:
   - Logs são salvos em `log.txt` e exibidos no console.

---

## 🏗️ Classes Principais

### `Personagem.java`
- **Atributos**: `vida`, `ataque`, `defesa`, `destreza`, `velocidade`.
- **Métodos**: `sofrerDano()`, `estaVivo()`.

### `Turno.java`
- Gerencia a sequência de turnos.
- **Lógica de Prioridade**: Personagem com menor vida ataca primeiro.
- **Métodos**: `executarTurnos()`, `gerarHeroiAleatorio()`, `gerarMonstroAleatorio()`.

### `Log.java`
- **Thread-safe**: Garante escrita segura em arquivo.
- **Limite de Registros**: Mantém até 1000 logs em memória.

### Exemplo de Heroi: `Arqueiro.java`
- **Habilidades**: 
  - `disparoComFlecha()` (dano crítico aleatório).
  - `carregarFlecha()` (dano aumentado no próximo turno).

### Exemplo de Monstro: `CavaleiroDoVazio.java`
- **Habilidades**:
  - `laminaDoAbismo()` (ignora 20% da defesa).
  - `vazioEterno()` (imunidade temporária).

---

## 🤝 Contribuição

1. **Faça um Fork** do repositório.
2. Siga o padrão de código:
   - Nomes em português, mas código em inglês (ex: `TipoHeroi`).
   - Documente novas habilidades com `JavaDoc`.
3. **Teste suas mudanças**:
   ```bash
   java Jogo.Jogo MEDIO
   ```
4. Envie um **Pull Request** com descrição detalhada.


--- 
🌟 Contribuições são bem-vindas! 🌟
