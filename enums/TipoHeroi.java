package Jogo.enums;


public enum TipoHeroi {
    GUERREIRO(0, "Guerreiro", "Especialista em combate corpo a corpo, usa força e resistência para vencer seus inimigos.", 5, 20),
    MAGO(1, "Mago", "Mestre das artes arcanas, canaliza energia mágica para lançar feitiços poderosos.", 4, 30),
    ARQUEIRO(2, "Arqueiro", "Exímio atirador, utiliza arcos e flechas para atacar à distância com precisão mortal.", 3, 25),
    LADINO(3, "Ladino", "Ágil e furtivo, prefere ataques rápidos e estratégicos, muitas vezes agindo nas sombras.", 5, 20);

    private final int id;
    private final String nome;
    private final String descricao;
    private final int ataque;
    private final int defesa;

    TipoHeroi(int id, String nome, String descricao, int ataque, int defesa) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }
}
