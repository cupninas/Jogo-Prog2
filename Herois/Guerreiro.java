package Jogo.Herois;

import Jogo.Monstros.Monstro;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;

public class Guerreiro extends Heroi {
    private int stamina;
    private int furia;

    public Guerreiro(String nome, int vida, int ataque, int defesa, int destreza, int velocidade, TipoArma armaPrincipal) {
        super(nome, vida, ataque, defesa, destreza, velocidade, armaPrincipal, TipoHeroi.GUERREIRO);
    }

    public Guerreiro(int stamina, int furia, TipoArma armaPrincipal) {
        super("Arqueiro", 150, 20, 10, 10, 5, armaPrincipal, TipoHeroi.GUERREIRO);
        this.stamina = stamina;
        this.furia = furia;
    }

    public Guerreiro() {
        super("Arqueiro", 150, 20, 10, 10, 5, TipoArma.ESPADA_CURTA, TipoHeroi.GUERREIRO);
        this.stamina = 20;
        this.furia = 0;
    }

    @Override
    protected void realizarAtaque(Monstro montro) {
        //TODO - realizar algum dos ataques de forma randomica
    }



}