package Jogo.enums;

public enum ResultadoAtaque {
    ERROU(0),
    ACERTOU(1),
    CRITICAL_HIT(2);

    private final int id;

    private ResultadoAtaque(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
