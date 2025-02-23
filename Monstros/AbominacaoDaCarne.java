package Jogo.Monstros;

import Jogo.Herois.Heroi;
import Jogo.enums.TipoMonstro;

public class AbominacaoDaCarne extends Monstro {
    private int vidaMaxima;

    public AbominacaoDaCarne(String nome, int vida, int ataque, int defesa, int destreza, int velocidade) {
        super(nome, vida, ataque, defesa, destreza, velocidade, TipoMonstro.ABOMINACAO_DA_CARNE);
        this.vidaMaxima = vida;
    }

    public AbominacaoDaCarne() {
        super("Abominação da Carne", 300, 35, 20, 5, 2, TipoMonstro.ABOMINACAO_DA_CARNE);
    }

    @Override
    protected void realizarAcao(Heroi heroi) {
        //TODO - realizar algum dos ataques de forma randomica
    }

    @Override
    public void sofrerDano(int dano) {
        //TODO - Esse metodo só é chamado por outra classe, não por essa aqui - ivan
        //aqui nao tem esses atributos escudos, nao precisa fazer a verificacao - ivan
        //TODO - se nenhum dos atributos forem true, tenta executar a acao, - ivan
        this.vida -= dano;
    }

    private void esmagar(Heroi heroi) {
        System.out.println(this.getNome() + " usa ESMAGAR!");

        // Causa 50% mais dano e ignora 30% da defesa do herói
        int danoBase = this.getAtaque();
        int defesaIgnorada = (int) (heroi.getDefesa() * 0.3);
        int danoFinal = (danoBase + (danoBase / 2)) - defesaIgnorada;

        if (danoFinal < 0) danoFinal = 0; // Evita dano negativo
        heroi.sofrerDano(danoFinal);

        System.out.println(heroi.getNome() + " recebeu " + danoFinal + " de dano!");
    }

    private void regeneracaoProfana() {
        int cura = (int) (this.vidaMaxima * 0.1); // Recupera 10% da vida máxima
        this.setVida(this.getVida() + cura);

        System.out.println(this.getNome() + " ativa REGENERAÇÃO PROFANA e recupera " + cura + " de HP!");
    }

    private void ataqueNormal(Heroi heroi) {
        System.out.println(this.getNome() + " ataca com um soco brutal!");
        heroi.sofrerDano(this.getAtaque());
    }
}
