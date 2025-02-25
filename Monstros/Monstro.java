package Jogo.Monstros;

import Jogo.Herois.Heroi;
import Jogo.Log;
import Jogo.Personagem;
import Jogo.enums.TipoHeroi;
import Jogo.enums.TipoMonstro;

public abstract class Monstro extends Personagem {
    protected TipoMonstro classe;

    public Monstro(String nome, int vida, int ataque, int defesa, int destreza, int velocidade, TipoMonstro classe) {
        super(nome, vida, ataque, defesa, destreza, velocidade);
        this.classe = classe;
    }

    public abstract void realizarAcao(Heroi heroi) throws Exception;

}
