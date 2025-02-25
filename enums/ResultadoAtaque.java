package Jogo.enums;

import lombok.Getter;

public enum ResultadoAtaque {
    ERROU(0),
    ACERTOU(1),
    CRITICAL_HIT(2);

    @Getter
    private final int id;

    private ResultadoAtaque(int id){
        this.id = id;
    }

}
