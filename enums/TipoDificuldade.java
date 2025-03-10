package Jogo.enums;


public enum TipoDificuldade {
    FACIL(0, 1),
    MEDIO(1, 10),
    DIFICIL(2, 100);

    private final int id;
    private final int dificuldade;

    private TipoDificuldade(int id, int dificuldade){
        this.id = id;
        this.dificuldade = dificuldade;
    }

    public int getId() {
        return id;
    }

    public int getDificuldade() {
        return dificuldade;
    }
}
