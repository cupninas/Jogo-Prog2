package Jogo.enums;

import lombok.Getter;

@Getter
public enum TipoHeroi {
    GUERREIRO(0, "Guerreiro", "Especialista em combate corpo a corpo, usa força e resistência para vencer seus inimigos."),
    MAGO(1, "Mago", "Mestre das artes arcanas, canaliza energia mágica para lançar feitiços poderosos."),
    ARQUEIRO(2, "Arqueiro", "Exímio atirador, utiliza arcos e flechas para atacar à distância com precisão mortal."),
    LADINO(3, "Ladino", "Ágil e furtivo, prefere ataques rápidos e estratégicos, muitas vezes agindo nas sombras.");

    private final int id;
    private final String nome;
    private final String descricao;

    TipoHeroi(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

}
