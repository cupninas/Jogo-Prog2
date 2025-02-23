package Jogo.Herois;

import Jogo.Monstros.Monstro;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;
import Jogo.enums.TipoMonstro;

public class Guerreiro extends Heroi {
    private boolean furiaAtiva = false; // Ativado após sofrer dano crítico

    // Construtor principal com todos os atributos
    public Guerreiro(String nome, int vida, int ataque, int defesa, int destreza, int velocidade) {
        // TODO - irei fazer uns gets armas especificas para cada heroi aqui
        super(nome, vida, ataque, defesa, destreza, velocidade, TipoHeroi.GUERREIRO, TipoArma.ESPADA_CURTA);
    }

    // Construtor com valores padrão de um Guerreiro típico
    public Guerreiro() {
        // TODO - irei fazer uns gets armas especificas para cada heroi aqui
        super("Guerreiro", 300, 35, 20, 8, 4, TipoHeroi.GUERREIRO, TipoArma.ESPADA_CURTA);
    }

    @Override
    protected void realizarAcao(Monstro monstro) {
        // TODO - colocar uma tentativa de realizar acao
        switch (armaPrincipal) {
            case ESPADA_LONGA:
                golpeDemolidor(monstro);
                break;
            case MACHADO_DE_BATALHA:
                ataquePesado(monstro);
                break;
            case LANCA:
                ataqueComAlcance(monstro);
                break;
            case CLAVA:
                ataqueComAtordoamento(monstro);
                break;
            case KATANA:
                ataqueRapido(monstro);
                break;
        }

    }

    @Override
    public void sofrerDano(int dano) {
        //TODO - Esse metodo só é chamado por outra classe, não por essa aqui
        //aqui nao tem esses atributos escudos, nao precisa fazer a verificacao
        //TODO - se nenhum dos atributos forem true, tenta executar a acao,
        this.vida -= dano;
    }

    private void golpeDemolidor(Monstro monstro) {
        System.out.println(this.getNome() + " desfere um GOLPE DEMOLIDOR com sua " + armaPrincipal.getNome() + "!");

        int danoBase = this.getAtaque();
        int defesaIgnorada = (int) (monstro.getDefesa() * 0.2);
        int danoFinal = (danoBase + (danoBase / 2)) - defesaIgnorada;

        if (danoFinal < 0) danoFinal = 0;
        monstro.sofrerDano(danoFinal);

        System.out.println(monstro.getNome() + " recebeu " + danoFinal + " de dano!");
    }

    private void ataquePesado(Monstro monstro) {
        System.out.println(this.getNome() + " balança seu " + armaPrincipal.getNome() + " com força total!");
        int danoFinal = this.getAtaque() * 2 - monstro.getDefesa();

        if (danoFinal < 0) danoFinal = 0;
        monstro.sofrerDano(danoFinal);

        System.out.println(monstro.getNome() + " sofreu um golpe brutal de " + danoFinal + " de dano!");
    }

    private void ataqueComAlcance(Monstro monstro) {
        System.out.println(this.getNome() + " ataca de longe com sua " + armaPrincipal.getNome() + ", mantendo distância!");
        int danoFinal = this.getAtaque() - (monstro.getDefesa() / 2);

        if (danoFinal < 0) danoFinal = 0;
        monstro.sofrerDano(danoFinal);

        System.out.println(monstro.getNome() + " recebeu " + danoFinal + " de dano!");
    }

    private void ataqueComAtordoamento(Monstro monstro) {
        System.out.println(this.getNome() + " golpeia com sua " + armaPrincipal.getNome() + " e tenta atordoar o inimigo!");
        int danoFinal = this.getAtaque() - monstro.getDefesa();
        if (Math.random() < 0.3) { // 30% de chance de atordoamento
            System.out.println(monstro.getNome() + " foi ATORDOADO!");
        }

        if (danoFinal < 0) danoFinal = 0;
        monstro.sofrerDano(danoFinal);
    }

    private void ataqueRapido(Monstro monstro) {
        System.out.println(this.getNome() + " corta rapidamente com sua " + armaPrincipal.getNome() + "!");
        int danoFinal = (int) (this.getAtaque() * 1.2) - monstro.getDefesa();
        if (Math.random() < 0.4) { // 40% de chance de crítico
            danoFinal *= 2;
            System.out.println("GOLPE CRÍTICO!");
        }

        if (danoFinal < 0) danoFinal = 0;
        monstro.sofrerDano(danoFinal);
    }

}