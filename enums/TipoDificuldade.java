package Jogo.enums;

import lombok.Getter;

public enum TipoDificuldade {
    FACIL(0, 1),
    MEDIO(1, 10),
    DIFICIL(2, 100);

    @Getter
    private final int id;

    @Getter
    private final int dificuldade;

    private TipoDificuldade(int id, int dificuldade){
        this.id = id;
        this.dificuldade = dificuldade;
    }
}
