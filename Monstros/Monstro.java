package Jogo.Monstros;

import Jogo.Herois.Heroi;
import Jogo.Personagem;

public abstract class Monstro extends Personagem {
    public Monstro(String nome, int vida, int ataque, int defesa, int destreza, int velocidade) {
        super(nome, vida, ataque, defesa, destreza, velocidade);
    }

    protected abstract void realizarAcao(Heroi heroi);

    public abstract void sofrerDano();

}
