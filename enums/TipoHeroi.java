package Jogo.enums;

import lombok.Getter;

// classe que representa os heróis do jogo 
@Getter
public enum TipoHeroi {
    GUERREIRO(0, "Guerreiro", "Especialista em combate corpo a corpo, usa força e resistência para vencer seus inimigos.", 5),
    MAGO(1, "Mago", "Mestre das artes arcanas, canaliza energia mágica para lançar feitiços poderosos.", 4),
    ARQUEIRO(2, "Arqueiro", "Exímio atirador, utiliza arcos e flechas para atacar à distância com precisão mortal.", 3),
    LADINO(3, "Ladino", "Ágil e furtivo, prefere ataques rápidos e estratégicos, muitas vezes agindo nas sombras.", 5);

    private final int id;
    private final String nome;
    private final String descricao;
    private final int ataque;
    
    TipoHeroi(int id, String nome, String descricao, int ataque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ataque = ataque;
    }

}
